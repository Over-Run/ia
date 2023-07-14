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
import org.lwjgl.opengl.GL11C
import org.lwjgl.system.MemoryStack
import org.overrun.ia.core.graphics.Graphics
import org.overrun.timer.Timer

/**
 * @author squid233
 * @since 0.1.0
 */
class LWJGL3Graphics : Graphics {
    override var width: Int = 0
        private set
    override var height: Int = 0
        private set
    override val deltaTime: Double
        get() = timer!!.deltaTime()
    override var framesPerSecond: Int = 0
        internal set
    private var timer: Timer? = null

    fun setup(window: LWJGL3Window) {
        MemoryStack.stackPush().use { stack ->
            val pw = stack.callocInt(1)
            val ph = stack.callocInt(1)
            glfwGetFramebufferSize(window.address, pw, ph)
            this.width = pw[0]
            this.height = ph[0]
        }
        glfwSetFramebufferSizeCallback(window.address) { _, width, height ->
            this.width = width
            this.height = height
            GL11C.glViewport(0, 0, width, height)
        }
        glfwSetWindowSizeCallback(window.address) { _, width, height ->
            window.width = width
            window.height = height
        }
    }

    fun setup(timer: Timer?) {
        this.timer = timer
    }
}
