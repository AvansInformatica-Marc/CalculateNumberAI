package nl.marc.game

import nl.marc.MathematicOperation
import kotlin.math.abs

class Game(amountOfNumbers: Int = 6) {
    private val numberArray = Array(amountOfNumbers) {
        ((0..9).toList() + (25..75 step 25).toList()).random()
    }

    val numbers = numberArray.asList()

    val result = (0..9).random() * 100 + (0..9).random() * 10 + (0..9).random()

    fun checkResult(operation: MathematicOperation): GameSolution {
        val difference = abs(operation.result - result)

        val nums = numberArray.toMutableList()

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