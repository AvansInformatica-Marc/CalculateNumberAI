package nl.marc

sealed class MathOp(val result: Int) : Comparable<MathOp> {
    abstract override fun toString(): String

    data class Plus(val first: MathOp, val second: MathOp) : MathOp(first.result + second.result) {
        override fun toString() = "($first + $second)"

        override val numbers = first.numbers + second.numbers
    }

    data class Minus(val first: MathOp, val second: MathOp) : MathOp(first.result - second.result) {
        override fun toString() = "($first - $second)"

        override val numbers = first.numbers + second.numbers
    }

    data class Multiplication(val first: MathOp, val second: MathOp) : MathOp(first.result * second.result) {
        override fun toString() = "$first × $second"

        override val numbers = first.numbers + second.numbers
    }

    data class Division(val first: MathOp, val second: MathOp) : MathOp(first.result / second.result) {
        override fun toString() = "$first ÷ $second"

        override val numbers = first.numbers + second.numbers
    }

    class Number(number: Int) : MathOp(number) {
        override fun toString() = result.toString()

        override val numbers = listOf(result)
    }

    abstract val numbers: List<Int>

    override fun compareTo(other: MathOp) = result.compareTo(other.result)

    operator fun plus(other: MathOp) = Plus(this, other)

    operator fun minus(other: MathOp) = Minus(this, other)

    operator fun times(other: MathOp) = Multiplication(this, other)

    operator fun div(other: MathOp) = Division(this, other)
}