package org.example

import kotlin.math.*

/**
 * k - Stiffness, default value 1
 *
 * */
class Spring() {
    var k: Double = 1.0
        private set

    constructor(k: Double) : this() {
        this.k = k
    }

    fun move(t: Double, dt: Double, x0: Double, v0: Double): DoubleArray = move(0.0, t, dt, x0, v0, 1.0)
    fun move(t: Double, dt: Double, x0: Double): DoubleArray = move(0.0, t, dt, x0, 0.0, 1.0)
    fun move(t0: Double, t1: Double, dt: Double, x0: Double, v0: Double): DoubleArray = move(t0, t1, dt, x0, v0, 1.0)
    fun move(t0: Double, t1: Double, dt: Double, x0: Double, v0: Double, m: Double): DoubleArray {
        val omega = sqrt(k / m)

        val a = x0
        val b = v0 / omega
        val c = sqrt(a.pow(2) + b.pow(2))
        val phi = atan(b / a)

        val coordinates = mutableListOf<Double>()
        var t = t0
        while (t <= t1) {
            coordinates.add(c * cos(omega * t + phi))
            t += dt
        }

        return coordinates.toDoubleArray()
    }
}