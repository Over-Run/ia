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

/**
 * @author squid233
 * @since 0.1.0
 */
module org.overrun.ia.impl.lwjgl {
    requires org.overrun.ia.core;
    requires org.lwjgl;
    requires org.lwjgl.glfw;
    requires org.lwjgl.opengl;
    requires org.lwjgl.stb;

    provides org.overrun.ia.core.Application
        with org.overrun.ia.impl.lwjgl3.LWJGL3Application;
    provides org.overrun.ia.core.graphics.Graphics
        with org.overrun.ia.impl.lwjgl3.LWJGL3Graphics;
    provides org.overrun.ia.core.Window
        with org.overrun.ia.impl.lwjgl3.LWJGL3Window;
}