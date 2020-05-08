package nl.marc

import nl.marc.ai.AStarSearchAI
import nl.marc.ai.DepthFirstSearchAI
import nl.marc.ai.GreedySearchAI
import nl.marc.game.Game
import nl.marc.game.GameWithRandomNumbers
import java.text.SimpleDateFormat
import java.util.*


typealias AI = (game: Game) -> MathOp?

val currentTime: String
    get() = SimpleDateFormat("HH:mm.ss.SSS").format(Date())

tailrec fun main() {
    println()
    val game: Game = GameWithRandomNumbers()
    // GameWithRandomNumbers()
    // GameWithChosenNumbers(listOf(4, 3, 3, 2), 18)
    // GameWithChosenNumbers(listOf(6, 10, 25, 75, 5, 50), 728)
    println("Numbers: ${game.numbers.joinToString()}")
    println("Result: ${game.result}")
    println()

    val aiList = mapOf<String, AI>(
        "Greedy" to GreedySearchAI::findResult,
        "A*" to AStarSearchAI::findResult,
        "DFS" to DepthFirstSearchAI::findResult
    )

    for((name, findResult) in aiList) {
        println("$currentTime) $name: start searching...")
        val solution = findResult(game)
        println("$currentTime) $name: ${if(solution == null) "No solution found" else game.checkResult(solution).toString()}")
    }

    println()

    if(!shouldExit()) {
        println()
        println("-----")
        println()

        main()
    }
}

tailrec fun shouldExit(): Boolean {
    println("Exit? (y/n): ")
    return when(readLine()?.toLowerCase()?.trim()) {
        "n", "no" -> false
        "y", "yes" -> true
        else -> shouldExit()
    }
}
