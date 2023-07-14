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

import org.overrun.ia.core.ApplicationAdapter

/**
 * @author squid233
 * @since 0.1.0
 */
class ApplicationAdapterBuilder {
    private var start: (() -> Unit)? = null
    private var fixedUpdate: (() -> Unit)? = null
    private var update: (() -> Unit)? = null
    private var lateUpdate: (() -> Unit)? = null
    private var render: ((Double) -> Unit)? = null
    private var exit: (() -> Unit)? = null

    /**
     * @since 0.1.0
     */
    fun onStart(action: () -> Unit) {
        start = action
    }

    /**
     * @since 0.1.0
     */
    fun onFixedUpdate(action: () -> Unit) {
        fixedUpdate = action
    }

    /**
     * @since 0.1.0
     */
    fun onUpdate(action: () -> Unit) {
        update = action
    }

    /**
     * @since 0.1.0
     */
    fun onLateUpdate(action: () -> Unit) {
        lateUpdate = action
    }

    /**
     * @since 0.1.0
     */
    fun onRender(action: (partialTick: Double) -> Unit) {
        render = action
    }

    /**
     * @since 0.1.0
     */
    fun onExit(action: () -> Unit) {
        exit = action
    }

    /**
     * @since 0.1.0
     */
    fun build(): ApplicationAdapter = object : ApplicationAdapter {
        override fun start() {
            start?.invoke()
        }

        override fun fixedUpdate() {
            fixedUpdate?.invoke()
        }

        override fun update() {
            update?.invoke()
        }

        override fun lateUpdate() {
            lateUpdate?.invoke()
        }

        override fun render(partialTick: Double) {
            render?.invoke(partialTick)
        }

        override fun exit() {
            exit?.invoke()
        }
    }
}
