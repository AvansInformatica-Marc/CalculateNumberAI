package nl.marc.ai

import nl.marc.MathOp
import nl.marc.Node
import nl.marc.game.Game
import kotlin.math.abs

object GreedySearchAI {
    fun findResult(game: Game) = findResult(Node(game)) { abs(it.result - game.result) }

    private tailrec fun findResult(currentNode: Node, proximity: (MathOp) -> Int): MathOp {
        if(currentNode.children.isEmpty())
            return currentNode.value!!

        var bestResult = currentNode.children.first()

        for(node in currentNode.children)
            if(proximity(node.value!!) < proximity(bestResult.value!!))
                bestResult = node

        return findResult(bestResult, proximity)
    }
}