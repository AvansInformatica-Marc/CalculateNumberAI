package nl.marc.game

import nl.marc.MathOp
import kotlin.math.abs

abstract class Game {
    abstract val numbers: List<Int>

    abstract val result: Int

    fun checkResult(operation: MathOp): GameSolution {
        val difference = abs(operation.result - result)

        val nums = numbers.toMutableList()

        for (number in operation.numbers) {
            if(number !in numbers)
                return GameSolution.WrongNumberUsed(operation)

            nums -= number
        }

        return when {
            nums.isNotEmpty() -> GameSolution.NotAllNumbersUsed(operation)
            difference == 0 -> GameSolution.CorrectSolution(operation)
            else -> GameSolution.DifferentResult(operation, difference)
        }
    }
}
