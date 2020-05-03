package nl.marc

sealed class MathematicOperation(val result: Int) : Comparable<MathematicOperation> {
    abstract override fun toString(): String

    data class Plus(val first: MathematicOperation, val second: MathematicOperation)
        : MathematicOperation(first.result + second.result) {
        override fun toString() = "($first + $second)"

        override val numbers = first.numbers + second.numbers
    }

    data class Minus(val first: MathematicOperation, val second: MathematicOperation)
        : MathematicOperation(first.result - second.result) {
        override fun toString() = "($first - $second)"

        override val numbers = first.numbers + second.numbers
    }

    data class Multiplication(val first: MathematicOperation, val second: MathematicOperation)
        : MathematicOperation(first.result * second.result) {
        override fun toString() = "$first × $second"

        override val numbers = first.numbers + second.numbers
    }

    data class Division(val first: MathematicOperation, val second: MathematicOperation)
        : MathematicOperation(first.result / second.result) {
        override fun toString() = "$first ÷ $second"

        override val numbers = first.numbers + second.numbers
    }

    class Number(number: Int) : MathematicOperation(number) {
        override fun toString() = result.toString()

        override val numbers = listOf(result)
    }

    abstract val numbers: List<Int>

    override fun compareTo(other: MathematicOperation) = result.compareTo(other.result)

    operator fun plus(other: MathematicOperation) = Plus(this, other)

    operator fun minus(other: MathematicOperation) = Minus(this, other)

    operator fun times(other: MathematicOperation) = Multiplication(this, other)

    operator fun div(other: MathematicOperation) = Division(this, other)
}