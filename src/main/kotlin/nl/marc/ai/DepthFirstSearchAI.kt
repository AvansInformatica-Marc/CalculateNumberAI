package nl.marc.ai

import nl.marc.MathOp
import nl.marc.Node
import nl.marc.game.Game
import nl.marc.game.GameSolution

object DepthFirstSearchAI {
    fun findResult(game: Game): MathOp? {
        var closestApproach: GameSolution.DifferentResult? = null

        return findResult(Node(game)) {
            val solution = game.checkResult(it)

            if (
                solution is GameSolution.DifferentResult &&
                (closestApproach == null || solution.difference < closestApproach!!.difference)
            ) {
                closestApproach = solution
            }

            solution is GameSolution.CorrectSolution
        } ?: closestApproach?.mathOp
    }

    private fun findResult(node: Node, isSolution: (MathOp) -> Boolean): MathOp? = when {
        node.children.isNotEmpty() -> node.children.asSequence().map { findResult(it, isSolution) }.firstOrNull { it != null }
        node.value != null && isSolution(node.value) -> node.value
        else -> null
    }
}