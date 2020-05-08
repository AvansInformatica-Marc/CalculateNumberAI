package nl.marc

import nl.marc.game.Game

data class Node(val game: Game, val value: MathOp? = null) {
    val children by lazy {
        val list = mutableListOf<Node>()

        val numbersLeft = game.numbers.toMutableList()

        for (number in value?.numbers ?: emptyList())
            numbersLeft -= number

        for (number in numbersLeft.map { MathOp.Number(it) }) {
            if(value == null) {
                list += Node(game, number)
            } else {
                list += Node(game, value * number)
                list += Node(game, value + number)
                list += Node(game, value - number)
                if(number.result != 0)
                    list += Node(game, value / number)
            }
        }

        list
    }
}