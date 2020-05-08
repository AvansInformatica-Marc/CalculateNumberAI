package nl.marc.ai

import nl.marc.game.GameSolution
import nl.marc.game.GameWithChosenNumbers
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class DepthFirstSearchAITests {
    @Test
    fun testGetResults() {
        // Arrange
        val game = GameWithChosenNumbers(listOf(4, 3, 3, 2), 18)

        // Act
        val result = DepthFirstSearchAI.findResult(game)

        // Assert
        assertNotNull(result)
        assertEquals(result.result, 18)
        assertTrue(game.checkResult(result) is GameSolution.CorrectSolution)
    }
}