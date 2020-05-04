package nl.marc.ai

import nl.marc.MathematicOperation
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DepthSearchAITests {
    @Test
    fun testGetResults() {
        // Arrange
        val operation = MathematicOperation.Number(4)
        var emittedResult: MathematicOperation? = null

        // Act
        val result = DepthSearchAI.getResults(operation, emptyList()) {
            emittedResult = it
            true
        }

        // Assert
        assertTrue(result)
        assertEquals(operation, emittedResult)
    }
}