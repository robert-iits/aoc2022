class Day21 {

    fun part1(input: List<String>): Int {
        return input.size
    }
    fun part2(input: List<String>): Int {
        return input.size
    }

    fun parseInputToMonkeys(input: List<String>): Map<String, Monkey> {
        val monkeyMap = mutableMapOf<String, Monkey>()
        input.forEach { monkey ->
            monkeyMap += parseInputLineToMonkey(monkey)
        }
        return monkeyMap
    }

    fun parseInputLineToMonkey(line: String): Map<String, Monkey> {
        line.split(": ").let { split ->
            val name = split.first()
            val valueOrMonkeys = split.last()
            var value: Int? = null
            var monkey1name: String? = null
            var monkey2name: String? = null
            var operator: Char? = null
            if (valueOrMonkeys.toIntOrNull() == null) {
                valueOrMonkeys.split(" ").let { splitOperation ->
                    require(splitOperation.size == 3) { "unknown operation format!" }
                    monkey1name = splitOperation.first()
                    operator = splitOperation[1].first()
                    monkey2name = splitOperation.last()
                }
            } else {
                value = valueOrMonkeys.toInt()
            }
            return mapOf(name to Monkey(value, monkey1name, monkey2name, operator))
        }
    }
}

class Monkey(
    val value: Int? = null,
    val monkey1name: String? = null,
    val monkey2name: String? = null,
    val operator: Char? = null,
)

fun main() {
    println("part 1:")
    println(Day21().part1(readInput("Day21")))
    println("part 2:")
    println(Day21().part2(readInput("Day21")))
}