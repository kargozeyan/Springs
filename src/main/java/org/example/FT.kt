package org.example

import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt


class FT(x: DoubleArray) {
    private val x: DoubleArray
    private val yR: DoubleArray
    private val yI: DoubleArray

    init {
        this.x = x.copyOf()
        val n = x.size
        this.yR = DoubleArray(n)
        this.yI = DoubleArray(n)

        for (k in 0 until n) {
            for (j in 0 until n) {
                val angle = 2 * Math.PI * k * j / n
                yR[k] += x[j] * cos(angle)
                yI[k] -= x[j] * sin(angle)
            }
        }
    }

    fun amplitudes() = (0..x.lastIndex).map {
        (yR[it].pow(2) + yI[it].pow(2))
    }.toDoubleArray()
}
