package org.example

import java.lang.IllegalArgumentException
import kotlin.math.PI
import kotlin.math.max
import kotlin.math.pow

class Converter8Bit : ConverterInt() {
    override fun convertToSprings(binary: String): String {
        if (binary.length != 8) {
            throw IllegalArgumentException("8 bit required")
        }

        return super.convertToSprings(binary)
    }

    override fun evaluateBinary(ampls: DoubleArray, freqs: DoubleArray): Double {
        return super.evaluateBinary(ampls, freqs)
    }
}