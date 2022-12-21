import io.kotest.matchers.maps.shouldHaveSize
import org.junit.jupiter.api.Test
import io.kotest.matchers.shouldBe

internal class Day21Test {

    private val sut = Day21()

    private val testInput = listOf(
        "root: pppw + sjmn",
        "dbpl: 5",
        "cczh: sllz + lgvd",
        "zczc: 2",
        "ptdq: humn - dvpt",
        "dvpt: 3",
        "lfqf: 4",
        "humn: 5",
        "ljgn: 2",
        "sjmn: drzm * dbpl",
        "sllz: 4",
        "pppw: cczh / lfqf",
        "lgvd: ljgn * ptdq",
        "drzm: hmdt - zczc",
        "hmdt: 32",
    )

    @Test
    fun inputLineToMonkey__operation() {
        val parsedMonkey = sut.parseInputLineToMonkey("root: pppw + sjmn")

        with(parsedMonkey["root"]!!) {
            number shouldBe null
            monkey1name shouldBe "pppw"
            monkey2name shouldBe "sjmn"
            operator shouldBe '+'
        }
    }


    @Test
    fun inputLineToMonkey__value() {
        val parsedMonkey = sut.parseInputLineToMonkey("hmdt: 32")

        with(parsedMonkey["hmdt"]!!) {
            number shouldBe 32.toBigInteger()
            monkey1name shouldBe null
            monkey2name shouldBe null
            operator shouldBe null
        }
    }

    @Test
    fun parseInputToMonkeys() {
        val monkeys = sut.parseInputToMonkeys(testInput)

        monkeys shouldHaveSize 15
        monkeys.containsKey("root") shouldBe true
    }

    @Test
    fun part1() {
        sut.part1(testInput) shouldBe 152.toBigInteger()
    }

    @Test
    fun part2() {
        sut.part2(testInput) shouldBe 301.toBigInteger()
    }
}