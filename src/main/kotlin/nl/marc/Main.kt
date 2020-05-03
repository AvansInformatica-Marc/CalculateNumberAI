package nl.marc

import nl.marc.ai.DepthSearchAI
import nl.marc.ai.SimpleReduce
import nl.marc.game.Game

typealias AI = (game: Game, emitResult: (MathematicOperation) -> Unit) -> Unit

fun main() {
    println()
    println("Choose solution finding method: ")
    println("> Type 'depth' for DepthSearchAI")
    println("> Type 'simple' for SimpleReduce")
    println()

    val ai: AI = when(readLine()?.toLowerCase()) {
        "depth" -> DepthSearchAI::findBestResult
        "simple" -> SimpleReduce::findResult
        else -> {
            println("None chosen")
            return
        }
    }

    println()

    val game = Game()
    println("Numbers: ${game.numbers.joinToString()}")
    println("Result: ${game.result}")

    ai(game) {
        println()
        println("Solution found!")
        println(game.checkResult(it))
        println()

        println("----------")

        main()
    }
}
