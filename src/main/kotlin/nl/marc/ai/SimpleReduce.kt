package nl.marc.ai

import nl.marc.MathematicOperation
import nl.marc.game.Game

object SimpleReduce {
    inline fun findResult(game: Game, emitResult: (MathematicOperation) -> Unit) {
        val numbers = game.numbers.map { MathematicOperation.Number(it) }.sorted().asReversed()
        emitResult(numbers.reduce<MathematicOperation, MathematicOperation.Number> { acc, number ->
            when {
                number.result != 0 && (acc * number).result <= game.result -> acc * number
                (acc + number).result <= game.result -> acc + number
                else -> acc - number
            }
        })
    }
}