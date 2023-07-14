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

package org.overrun.ia.core

import org.overrun.ia.core.graphics.Graphics

/**
 * The basic things in IA.
 *
 * @author squid233
 * @since 0.1.0
 */
object IA {
    /**
     * @since 0.1.0
     */
    var applicationInfo: ApplicationInfo? = null

    /**
     * @since 0.1.0
     */
    var graphics: Graphics? = null
}
