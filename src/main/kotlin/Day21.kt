import java.lang.IllegalArgumentException
import java.math.BigInteger
import kotlin.system.measureTimeMillis

class Day21 {

    fun part1(input: List<String>): BigInteger {
        val monkeys = parseInputToMonkeys(input)
        val root = getMonkey("root", monkeys)
        while (root.number == null) {
            monkeys
                .filter { it.value.number == null }
                .forEach { calculateIfPossible(it.key, monkeys) }
        }
        return root.number!!
    }

    fun part2(input: List<String>): BigInteger {
        val monkeys = parseInputToMonkeys(input)
        val root = getMonkey("root", monkeys)

        while (monkeys[root.monkey1name]?.number != monkeys[root.monkey2name]?.number) {

        }
        return getMonkey("humn", monkeys).number!!
    }

    private fun calculateIfPossible(monkeyName: String, mapOfMonkeys: Map<String, Monkey>) {
        val monkey = getMonkey(monkeyName, mapOfMonkeys)
        if (monkey.number != null) {

            return
        } else {
            val monkey1value = mapOfMonkeys[monkey.monkey1name]?.number
            val monkey2value = mapOfMonkeys[monkey.monkey2name]?.number
            if (monkey1value != null && monkey2value != null) {
                monkey.apply { number = calculate(monkey1value, monkey2value, monkey.operator!!) }
                //println("applied value ${monkey.number} to $monkeyName")
            }
        }
    }

    private fun calculate(value1: BigInteger, value2: BigInteger, operator: Char): BigInteger {
        return when(operator) {
            '+' -> value1 + value2
            '-' -> value1 - value2
            '*' -> value1 * value2
            '/' -> value1 / value2
            else -> throw IllegalArgumentException("unknown operator type: $operator")
        }
    }

    private fun getMonkey(monkeyName: String, mapOfMonkeys: Map<String, Monkey>): Monkey {
        return mapOfMonkeys[monkeyName] ?: throw IllegalArgumentException("monkey not found: $monkeyName")
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
            var value: BigInteger? = null
            var monkey1name: String? = null
            var monkey2name: String? = null
            var operator: Char? = null
            if (valueOrMonkeys.toBigIntegerOrNull() == null) {
                valueOrMonkeys.split(" ").let { splitOperation ->
                    require(splitOperation.size == 3) { "unknown operation format!" }
                    monkey1name = splitOperation.first()
                    operator = splitOperation[1].first()
                    monkey2name = splitOperation.last()
                }
            } else {
                value = valueOrMonkeys.toBigInteger()
            }
            return mapOf(name to Monkey(monkey1name, monkey2name, operator).apply { this.number = value })
        }
    }
}

class Monkey(
    val monkey1name: String? = null,
    val monkey2name: String? = null,
    val operator: Char? = null,
) {
    var number: BigInteger? = null
}

fun main() {
    val input = readInput("Day21")
    println("duration (ms): " + measureTimeMillis { println("part 1: " + Day21().part1(input))  })
    println("duration (ms): " + measureTimeMillis { println("part 2: " + Day21().part2(input))  })
}