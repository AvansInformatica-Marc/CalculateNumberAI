package nl.marc.game

class GameWithRandomNumbers(amountOfNumbers: Int = 6) : Game() {
    private val numberArray = Array(amountOfNumbers) {
        ((0..9).toList() + (25..75 step 25).toList()).random()
    }

    override val numbers = numberArray.asList()

    override val result = (0..9).random() * 100 + (0..9).random() * 10 + (0..9).random()
}