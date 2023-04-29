package org.example

import kotlin.math.PI
import kotlin.math.pow

open class ConverterInt : Converter() {
    override fun convertToSprings(binary: String): String {
        validate(binary)

        return binary.map {
            if (it == '1') "{}" else "[]"
        }.joinToString(separator = "", prefix = "{", postfix = "}")
    }

    override fun evaluateBinary(ampls: DoubleArray, freqs: DoubleArray): Double {
        val maxIndex = ampls.indexOfFirst { it == ampls.max() }
        return freqs[maxIndex].times(2).times(PI).pow(2)
    }

    protected fun validate(binary: String) {
        if (binary.any { it == '0' || it == '1' }) {
            throw IllegalArgumentException("not a binary number")
        }
    }
}