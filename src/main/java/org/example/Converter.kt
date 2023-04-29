package org.example

abstract class Converter {
    abstract fun convertToSprings(binary: String): String

    fun computeOscillations(
        expr: String,
        springs: Array<Spring>,
        t0: Double,
        t1: Double,
        dt: Double,
        x0: Double,
        v0: Double
    ): DoubleArray {
        val spring = SpringArray.equivalentSpring(expr, springs)
        return spring.move(t0, t1, dt, x0, v0)
    }

    fun computeFreqAmplitudes(
        expr: String,
        springs: Array<Spring>,
        t0: Double,
        t1: Double,
        dt: Double,
        x0: Double,
        v0: Double
    ): DoubleArray {
        val oscillations = computeOscillations(expr, springs, t0, t1, dt, x0, v0)
        val ft = FT(oscillations)
        return ft.amplitudes()
    }

    abstract fun evaluateBinary(ampls: DoubleArray, freqs: DoubleArray): Double
}