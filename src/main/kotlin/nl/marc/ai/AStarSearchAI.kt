package nl.marc.ai

import nl.marc.MathOp
import nl.marc.Node
import nl.marc.game.Game
import java.util.*
import kotlin.math.abs

object AStarSearchAI {
    fun findResult(game: Game) = findResult(Node(game)) { abs(it.result - game.result) }

    private inline fun findResult(node: Node, crossinline proximity: (MathOp) -> Int): MathOp {
        val queue = PriorityQueue<Node> { first, second ->
            proximity(first.value!!).compareTo(proximity(second.value!!))
        }

        queue += node

        var bestResultSoFar: MathOp? = null
        var iterations = 0

        while(queue.isNotEmpty()) {
            iterations++
            val currentNode = queue.poll()

            when {
                currentNode.children.isNotEmpty() -> queue += currentNode.children
                proximity(currentNode.value!!) == 0 -> return currentNode.value
                bestResultSoFar == null || proximity(currentNode.value) < proximity(bestResultSoFar) ->
                    bestResultSoFar = currentNode.value
            }
        }

        return bestResultSoFar!!
    }
}