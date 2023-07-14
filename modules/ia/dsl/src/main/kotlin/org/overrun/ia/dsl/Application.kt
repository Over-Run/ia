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

package org.overrun.ia.dsl

import org.overrun.ia.core.ApplicationConfig
import org.overrun.ia.core.startApplication

/**
 * @since 0.1.0
 */
fun application(config: ApplicationConfig, builder: ApplicationAdapterBuilder.() -> Unit) {
    startApplication(config, ApplicationAdapterBuilder().also(builder).build())
}
