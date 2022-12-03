import java.lang.IllegalArgumentException

class Day03 {

    private fun splitRucksackInHalf(rucksack: String): Pair<String, String> {
        return Pair(rucksack.take(rucksack.length/2), rucksack.takeLast(rucksack.length/2))
    }

    fun getPriority(item: Char): Int {
        return if (item.code >= 'a'.code) {
            item.code - 'a'.code + 1
        } else {
            item.code - 'A'.code + 27
        }
    }

    fun findCommonItem(rucksack: String): Char {
        splitRucksackInHalf(rucksack).let { (firstHalf, secondHalf) ->
            firstHalf.onEach {char ->
                if (secondHalf.contains(char)) return char
            }
        }
        throw IllegalArgumentException()
    }

    fun part1(listOfRucksacks: List<String>): Int {
        return listOfRucksacks.sumOf { rucksack ->
            getPriority(findCommonItem(rucksack))
        }
    }

    fun part2(listOfRucksacks: List<String>) {
        val rucksacks = listOfRucksacks.toMutableList()
        while(rucksacks.isNotEmpty()) {
            rucksacks.take(3).forEach {  }
            rucksacks.drop(3)
        }
    }
}

fun main () {
    println("part 1:")
    println(Day03().part1(readInput("Day03")))
    println("part 2:")
    println(Day03().part2(readInput("Day03")))
}