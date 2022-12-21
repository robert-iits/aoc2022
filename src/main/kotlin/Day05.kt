import java.util.Stack
import kotlin.system.measureTimeMillis

typealias StackList = List<Stack<Char>>
typealias CommandList = List<Command>

class Day05 {

    fun part1(input: List<String>): String {
        val (stacks, commands) = splitInputIntoStackAndCommand(input)
        val movedStacks = craneAction(stacks, commands)

        return getTopItems(movedStacks)
    }

    fun part2(input: List<String>): String {
        val (stacks, commands) = splitInputIntoStackAndCommand(input)
        val movedStacks = craneAction9001(stacks, commands)

        return getTopItems(movedStacks)
    }

    private fun getTopItems(movedStacks: List<Stack<Char>>): String {
        var topStack = ""
        movedStacks.forEach { stack ->
            topStack += stack.pop()
        }
        return topStack
    }

    private fun splitInputIntoStackAndCommand(input: List<String>): Pair<StackList, CommandList> {
        val stackData = input.take(8)
        val commandData = input.drop(10)
        val stacks = stackParser(stackData)
        val commands = commandParser(commandData)
        return Pair(stacks, commands)
    }

    private fun craneAction(stacks: List<Stack<Char>>, commands: List<Command>): List<Stack<Char>> {
        commands.forEach { command ->
            repeat(command.quantity) {
                stacks[command.toStack].push(stacks[command.fromStack].pop())
            }
        }
        return stacks
    }

    private fun craneAction9001(stacks: List<Stack<Char>>, commands: List<Command>): List<Stack<Char>> {
        commands.forEach { command ->
            val craneContainer = Stack<Char>()
            repeat(command.quantity) {
                craneContainer.push(stacks[command.fromStack].pop())
            }
            repeat(command.quantity) {
                stacks[command.toStack].push(craneContainer.pop())
            }
        }
        return stacks
    }

    private fun stackParser(stackData: List<String>): List<Stack<Char>> {
        val charPosition = mutableListOf<Int>()
        stackData.last().forEachIndexed { index, c -> if (c in 'A'..'Z') charPosition.add(index) }
        val stackList = mutableListOf<Stack<Char>>()
        charPosition.toList().forEach { charpos ->
            val newStack = Stack<Char>()
            stackData.forEach { stringLine ->
                stringLine[charpos].let { if (it != ' ') newStack.push(it) }
            }
            newStack.reverse()
            stackList.add(newStack)
        }
        return stackList
    }

    private fun commandParser(commandData: List<String>): MutableList<Command> {
        val commandList = mutableListOf<Command>()
        commandData.forEach { commandline ->
            commandline.filter { it.isDigit() }
                .let {
                    if (it.length == 4) {
                        commandList.add(Command(it.take(2).toInt(), it[2].digitToInt() - 1, it[3].digitToInt() - 1))
                    } else {
                        commandList.add(Command(it[0].digitToInt(), it[1].digitToInt() - 1, it[2].digitToInt() - 1))
                    }
                }
        }
        return commandList
    }
}

data class Command(val quantity: Int, val fromStack: Int, val toStack: Int)

fun main() {
    val input = readInput("Day05")
    println("duration (ms): " + measureTimeMillis { println("part 1: " + Day05().part1(input))  })
    println("duration (ms): " + measureTimeMillis { println("part 2: " + Day05().part2(input))  })
}