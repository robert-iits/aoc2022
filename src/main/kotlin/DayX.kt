import kotlin.system.measureTimeMillis

class DayX {

    fun part1(input: List<String>): Int {
        return input.size
    }
    fun part2(input: List<String>): Int {
        return input.size
    }
}

fun main() {
    val input = readInput("DayX")
    println("duration (ms): " + measureTimeMillis { println("part 1: " + DayX().part1(input))  })
    println("duration (ms): " + measureTimeMillis { println("part 2: " + DayX().part2(input))  })
}