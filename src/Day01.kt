import org.junit.jupiter.api.Assertions.assertEquals
import java.util.Collections.max

fun main() {
    fun sumCaloriesPerElf(input: List<String>): MutableList<Int> {
        val elves = mutableListOf<Int>()
        var currentElvesCalories = 0
        input.forEach {
            if (it != "") {
                currentElvesCalories += it.toInt()
            } else {
                elves.add(currentElvesCalories)
                currentElvesCalories = 0
            }
        }
        elves.add(currentElvesCalories)
        return elves
    }

    fun part1(input: List<String>): Int {
        val elves = sumCaloriesPerElf(input)
        return max(elves)
    }

    fun part2(input: List<String>): Int {
        return sumCaloriesPerElf(input).sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    assertEquals(24000, part1(testInput))
    assertEquals(45000, part2(testInput))

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}