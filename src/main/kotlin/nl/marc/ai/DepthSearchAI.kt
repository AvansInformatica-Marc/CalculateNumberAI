package nl.marc.ai

import nl.marc.MathematicOperation
import nl.marc.game.Game
import nl.marc.game.GameSolution

object DepthSearchAI {
    fun findBestResult(game: Game, emitResult: (MathematicOperation) -> Unit) {
        var closestApproach: GameSolution.DifferentResult? = null

        val numbers = game.numbers.map {
            MathematicOperation.Number(it)
        }.sorted().asReversed()

        var result = 0

        val res = getResults(null, numbers) {
            result++
            val solution = game.checkResult(it)
            when (solution) {
                is GameSolution.CorrectSolution -> {
                    println("> $result. $solution")
                    emitResult(it)
                }
                is GameSolution.DifferentResult -> {
                    if (closestApproach == null || solution.difference < closestApproach!!.difference) {
                        println("> $result. $solution")
                        closestApproach = solution
                    }
                }
                else -> {}
            }

            solution is GameSolution.CorrectSolution
        }

        if(!res)
            emitResult(closestApproach!!.mathematicOperation)
    }

    private fun getResults(previousResult: MathematicOperation?, numbersLeft: List<MathematicOperation.Number>, emitResult: (MathematicOperation) -> Boolean): Boolean {
        if (numbersLeft.isEmpty())
            return emitResult(previousResult!!)

        for (number in numbersLeft) {
            when {
                previousResult == null -> {
                    if(getResults(number, numbersLeft - number, emitResult))
                        return true
                }
                getResults(
                    previousResult * number,
                    numbersLeft - number,
                    emitResult
                ) -> return true
                getResults(
                    previousResult + number,
                    numbersLeft - number,
                    emitResult
                ) -> return true
                number.result != 0 && getResults(
                    previousResult - number,
                    numbersLeft - number,
                    emitResult
                ) -> return true
                number.result != 0 && getResults(
                    previousResult / number,
                    numbersLeft - number,
                    emitResult
                ) -> return true
            }
        }

        return false
    }
}