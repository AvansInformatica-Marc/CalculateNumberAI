package nl.marc.game

import nl.marc.MathOp

sealed class GameSolution(open val mathOp: MathOp) {
    data class CorrectSolution(override val mathOp: MathOp) : GameSolution(mathOp) {
        override fun toString() = "Correct solution: ${mathOp.toString().removeSurrounding("(", ")")} = ${mathOp.result}"
    }

    data class DifferentResult(override val mathOp: MathOp, val difference: Int) : GameSolution(mathOp) {
        override fun toString() = "Possible solution: ${mathOp.toString().removeSurrounding("(", ")")} = ${mathOp.result} (difference of ${difference})"
    }

    data class WrongNumberUsed(override val mathOp: MathOp) : GameSolution(mathOp) {
        override fun toString() = "Wrong solution: ${mathOp.toString().removeSurrounding("(", ")")} = ${mathOp.result}"
    }

    data class NotAllNumbersUsed(override val mathOp: MathOp) : GameSolution(mathOp) {
        override fun toString() = "Wrong solution: ${mathOp.toString().removeSurrounding("(", ")")} = ${mathOp.result}"
    }

    abstract override fun toString(): String
}