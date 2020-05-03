package nl.marc.game

import nl.marc.MathematicOperation

sealed class GameSolution(open val mathematicOperation: MathematicOperation) {
    data class CorrectSolution(override val mathematicOperation: MathematicOperation) : GameSolution(mathematicOperation) {
        override fun toString() = "Correct solution: ${mathematicOperation.toString().removeSurrounding("(", ")")} = ${mathematicOperation.result}"
    }

    data class DifferentResult(override val mathematicOperation: MathematicOperation, val difference: Int) : GameSolution(mathematicOperation) {
        override fun toString() = "Possible solution: ${mathematicOperation.toString().removeSurrounding("(", ")")} = ${mathematicOperation.result} (difference of ${difference})"
    }

    data class WrongNumberUsed(override val mathematicOperation: MathematicOperation) : GameSolution(mathematicOperation) {
        override fun toString() = "Wrong solution: ${mathematicOperation.toString().removeSurrounding("(", ")")} = ${mathematicOperation.result}"
    }

    data class NotAllNumbersUsed(override val mathematicOperation: MathematicOperation) : GameSolution(mathematicOperation) {
        override fun toString() = "Wrong solution: ${mathematicOperation.toString().removeSurrounding("(", ")")} = ${mathematicOperation.result}"
    }

    abstract override fun toString(): String
}