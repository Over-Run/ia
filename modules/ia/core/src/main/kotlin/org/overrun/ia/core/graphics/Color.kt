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

package org.overrun.ia.core.graphics

import kotlin.math.floor
import kotlin.math.min

private const val INV_NORMALIZE = 1.0f / 255.0f

/**
 * white
 *
 * @since 0.1.0
 */
val WHITE = Color(0xffffffffU)

/**
 * light gray
 *
 * @since 0.1.0
 */
val LIGHT_GRAY = Color(0xbfbfbfffU)

/**
 * gray
 *
 * @since 0.1.0
 */
val GRAY = Color(0x7f7f7fffU)

/**
 * dark gray
 *
 * @since 0.1.0
 */
val DARK_GRAY = Color(0x3f3f3fffU)

/**
 * black
 *
 * @since 0.1.0
 */
val BLACK = Color(0x000000ffU)

/**
 * The packed white color bits.
 *
 * @since 0.1.0
 */
val WHITE_BITS = rgbaPackABGR(1f, 1f, 1f, 1f)

/**
 * clear
 *
 * @since 0.1.0
 */
val CLEAR = Color(0x00000000U)

/**
 * blue
 *
 * @since 0.1.0
 */
val BLUE = Color(0x0000ffffU)

/**
 * navy
 *
 * @since 0.1.0
 */
val NAVY = Color(0x000080ffU)

/**
 * royal
 *
 * @since 0.1.0
 */
val ROYAL = Color(0x4169e1ffU)

/**
 * slate
 *
 * @since 0.1.0
 */
val SLATE = Color(0x708090ffU)

/**
 * sky
 *
 * @since 0.1.0
 */
val SKY = Color(0x87ceebffU)

/**
 * cyan
 *
 * @since 0.1.0
 */
val CYAN = Color(0x00ffffffU)

/**
 * teal
 *
 * @since 0.1.0
 */
val TEAL = Color(0x008080ffU)

/**
 * green
 *
 * @since 0.1.0
 */
val GREEN = Color(0x00ff00ffU)

/**
 * chartreuse
 *
 * @since 0.1.0
 */
val CHARTREUSE = Color(0x7fff00ffU)

/**
 * lime
 *
 * @since 0.1.0
 */
val LIME = Color(0x32cd32ffU)

/**
 * forest
 *
 * @since 0.1.0
 */
val FOREST = Color(0x228b22ffU)

/**
 * olive
 *
 * @since 0.1.0
 */
val OLIVE = Color(0x6b8e23ffU)

/**
 * yellow
 *
 * @since 0.1.0
 */
val YELLOW = Color(0xffff00ffU)

/**
 * gold
 *
 * @since 0.1.0
 */
val GOLD = Color(0xffd700ffU)

/**
 * goldenrod
 *
 * @since 0.1.0
 */
val GOLDENROD = Color(0xdaa520ffU)

/**
 * orange
 *
 * @since 0.1.0
 */
val ORANGE = Color(0xffa500ffU)

/**
 * brown
 *
 * @since 0.1.0
 */
val BROWN = Color(0x8b4513ffU)

/**
 * tan
 *
 * @since 0.1.0
 */
val TAN = Color(0xd2b48cffU)

/**
 * firebrick
 *
 * @since 0.1.0
 */
val FIREBRICK = Color(0xb22222ffU)

/**
 * red
 *
 * @since 0.1.0
 */
val RED = Color(0xff0000ffU)

/**
 * scarlet
 *
 * @since 0.1.0
 */
val SCARLET = Color(0xff341cffU)

/**
 * coral
 *
 * @since 0.1.0
 */
val CORAL = Color(0xff7f50ffU)

/**
 * salmon
 *
 * @since 0.1.0
 */
val SALMON = Color(0xfa8072ffU)

/**
 * pink
 *
 * @since 0.1.0
 */
val PINK = Color(0xff69b4ffU)

/**
 * magenta
 *
 * @since 0.1.0
 */
val MAGENTA = Color(0xff00ffffU)

/**
 * purple
 *
 * @since 0.1.0
 */
val PURPLE = Color(0xa020f0ffU)

/**
 * violet
 *
 * @since 0.1.0
 */
val VIOLET = Color(0xee82eeffU)

/**
 * maroon
 *
 * @since 0.1.0
 */
val MAROON = Color(0xb03060ffU)

/**
 * @since 0.1.0
 */
fun colorNormalize(color: UByte): Float = color.toUInt().toFloat() * INV_NORMALIZE

/**
 * @since 0.1.0
 */
fun colorDenormalize(color: Float): UByte = min(floor(color * 256f), 255f).toUInt().toUByte()


/**
 * Packs the RGBA color into an integer.
 *
 * @since 0.1.0
 * @param r the red value.
 * @param g the green value.
 * @param b the blue value.
 * @param a the alpha value.
 * @return the packed value.
 */
fun rgbaPackABGR(r: UByte, g: UByte, b: UByte, a: UByte): UInt {
    return (a.toUInt() shl 24) or
        (b.toUInt() shl 16) or
        (g.toUInt() shl 8) or
        r.toUInt()
}

/**
 * Packs the RGBA color into an integer.
 *
 * @since 0.1.0
 * @param r the red value.
 * @param g the green value.
 * @param b the blue value.
 * @param a the alpha value.
 * @return the packed value.
 */
fun rgbaPackABGR(r: Float, g: Float, b: Float, a: Float): UInt {
    return rgbaPackABGR(
        colorDenormalize(r),
        colorDenormalize(g),
        colorDenormalize(b),
        colorDenormalize(a)
    )
}

/**
 * @author squid233
 * @since 0.1.0
 */
data class Color(val red: UByte, val green: UByte, val blue: UByte, val alpha: UByte) {
    /**
     * @since 0.1.0
     */
    constructor(rgba: UInt) : this(
        (rgba shr 24).toUByte(),
        (rgba shr 16).toUByte(),
        (rgba shr 8).toUByte(),
        rgba.toUByte()
    )

    /**
     * @since 0.1.0
     */
    constructor(red: Float, green: Float, blue: Float, alpha: Float) : this(
        colorDenormalize(red),
        colorDenormalize(green),
        colorDenormalize(blue),
        colorDenormalize(alpha)
    )

    /**
     * @since 0.1.0
     */
    fun packABGR(): UInt = rgbaPackABGR(red, green, blue, alpha)

    /**
     * @since 0.1.0
     */
    fun UByte.normalize(): Float = colorNormalize(this)
}
