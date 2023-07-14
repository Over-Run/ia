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

import org.lwjgl.glfw.Callbacks
import org.lwjgl.glfw.GLFW.glfwCreateWindow
import org.lwjgl.glfw.GLFW.glfwDestroyWindow
import org.overrun.ia.core.Window

/**
 * @author squid233
 * @since 0.1.0
 */
class LWJGL3Window : Window {
    internal var address: Long = 0L
    override var width: Int = 0
        internal set
    override var height: Int = 0
        internal set
    override var title: String = "Animation"
        private set

    override fun create(width: Int, height: Int, title: String) {
        address = glfwCreateWindow(width, height, title, 0L, 0L)
        check(address != 0L) { "Failed to create the GLFW window" }
        this.width = width
        this.height = height
        this.title = title
    }

    override fun dispose() {
        Callbacks.glfwFreeCallbacks(address)
        glfwDestroyWindow(address)
    }

    internal inline fun <T> setCallback(caller: (Long, T) -> T, callback: T) {
        caller(address, callback)
    }
}
