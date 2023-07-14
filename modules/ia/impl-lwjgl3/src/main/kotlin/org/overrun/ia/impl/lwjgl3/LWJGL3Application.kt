/*
 * ia - Interactive Animation
 * Copyright (C) 2023  Overrun Organization
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.overrun.ia.impl.lwjgl3

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11C.*
import org.overrun.ia.core.*
import org.overrun.timer.Timer

/**
 * @author squid233
 * @since 0.1.0
 */
class LWJGL3Application : Application {
    private var adapter: ApplicationAdapter? = null
    private val window = LWJGL3Window()
    private val graphics = LWJGL3Graphics()
    private var timer: Timer? = null

    override fun start(config: ApplicationConfig, adapter: ApplicationAdapter) {
        try {
            this.adapter = adapter
            IA.applicationInfo = ApplicationInfo(title = config.title)
            IA.graphics = graphics
            GLFWErrorCallback.createPrint(System.err).set()
            check(glfwInit()) { "Failed to initialize GLFW" }
            glfwDefaultWindowHints()
            window.create(config.width, config.height, config.title)
            graphics.setup(window)

            glfwGetVideoMode(glfwGetPrimaryMonitor())?.also { vidMode ->
                glfwSetWindowPos(
                    window.address,
                    (vidMode.width() - window.width) / 2,
                    (vidMode.height() - window.height) / 2
                )
            }

            glfwMakeContextCurrent(window.address)
            glfwSwapInterval(1)

            GL.createCapabilities()
            config.clearColor.apply {
                glClearColor(red.normalize(), green.normalize(), blue.normalize(), alpha.normalize())
            }
            adapter.start()

            timer = Timer.ofGetter(config.ticksPerSecond, ::glfwGetTime)
            graphics.setup(timer)

            run()
        } finally {
            exit()
        }
    }

    override fun run() {
        adapter!!.also {
            timer!!.also { timer ->
                while (!glfwWindowShouldClose(window.address)) {
                    timer.advanceTime()
                    glfwPollEvents()
                    timer.performTicks(it::fixedUpdate)
                    it.update()
                    it.lateUpdate()

                    glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)
                    it.render(timer.partialTick())
                    glfwSwapBuffers(window.address)

                    timer.calcFPS { graphics.framesPerSecond = it }
                }
            }
        }
    }

    override fun exit() {
        adapter?.exit()
        glfwTerminate()
        glfwSetErrorCallback(null)?.free()
    }
}
