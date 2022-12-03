import org.junit.jupiter.api.Assertions.assertEquals

// ROCK PAPER SCISSOR
// A, B, C
// X, Y, Z
// 0  1  2
// win draw loss

// PAPER (1) -> ROCK (0)
// ROCK (0) -> SCISSOR (2)
// SCISSOR (2) -> PAPER (1)


fun main() {

    fun normalize(char: Char): Int {
        return if (char.code >= 'X'.code) {
            char.code - 'X'.code
        } else {
            char.code - 'A'.code
        }
    }

    fun previous(n: Int) = (n + 2) % 3
    fun next(n: Int) = (n + 1) % 3

    fun score(game: Game): Int =
        game.self + 1 + 3 * (if (game.self == next(game.opponent)) 2 else if (game.self == game.opponent) 1 else 0)

    fun correctRound(round: String): Game {
        return when (round.last()) {
            'X' -> Game(normalize(round.first()), previous(normalize(round.first())))
            'Y' -> Game(normalize(round.first()), normalize(round.first()))
            'Z' -> Game(normalize(round.first()), next(normalize(round.first())))
            else -> throw IllegalAccessException()
        }
    }

    fun part1(input: List<String>): Int {
        return input.map { Game(normalize(it.first()), normalize(it.last())) }.sumOf { score(it) }
    }

    fun part2(input: List<String>): Int {
        return input.map { correctRound(it) }.sumOf { score(it) }
    }


    // test if implementation meets criteria from the description, like:
    val testInput = listOf("A Y", "B X", "C Z")
    assertEquals(15, part1(testInput))
    assertEquals(12, part2(testInput))

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

class Game(val opponent: Int, val self: Int)