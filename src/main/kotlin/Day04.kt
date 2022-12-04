class Day04 {

    fun part1(input: List<String>): Int {
        return input.sumOf { sectionPair ->
            stringToRanges(sectionPair.split(','))
                .let { ranges -> countFullOverlap(ranges.first(), ranges.last()) }
        }
    }

    private fun stringToRanges(listOfStrings: List<String>): List<IntRange> {
        return listOfStrings.map { IntRange(it.split('-').first().toInt(), it.split('-').last().toInt()) }
    }

    fun countFullOverlap(range1: IntRange, range2: IntRange): Int {
        return if ((range1.minus(range2).isEmpty() || range2.minus(range1).isEmpty())) 1 else 0
    }

    fun countOverlap(range1: IntRange, range2: IntRange): Int {
        return if (range1.count() + range2.count() > range1.plus(range2).toSet().size) 1 else 0
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { sectionPair ->
            stringToRanges(sectionPair.split(','))
                .let { ranges -> countOverlap(ranges.first(), ranges.last()) }
        }
    }

}


fun main() {
    println("part 1:")
    println(Day04().part1(readInput("Day04")))
    println("part 2:")
    println(Day04().part2(readInput("Day04")))
}