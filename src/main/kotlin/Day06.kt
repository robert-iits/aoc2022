import java.lang.IllegalArgumentException

class Day06 {

    fun part1(input: List<String>): Int {
        return lineMarker(input.first(), 4)
    }

    fun part2(input: List<String>): Int {
        return lineMarker(input.first(), 14)
    }

    fun lineMarker(line: String, sequenceLength: Int): Int {
        line.forEachIndexed { index, char ->
            if (line.subSequence(index, index + sequenceLength).toSet().size == sequenceLength) return index + sequenceLength
        }
        throw IllegalArgumentException("input string does not contain a unique sequence")
    }
}

fun main() {
    println("part 1:")
    println(Day06().part1(readInput("Day06")))
    println("part 2:")
    println(Day06().part2(readInput("Day06")))
}