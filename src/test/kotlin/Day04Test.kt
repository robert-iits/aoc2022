import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day04Test {

    private val sut = Day04()

    @ParameterizedTest
    @MethodSource("fullOverlapInput")
    fun countFullOverlap(range1: IntRange, range2: IntRange, expected: Int) {
        sut.countFullOverlap(range1, range2) shouldBe expected
    }

    @ParameterizedTest
    @MethodSource("overlapInput")
    fun isOverlap(range1: IntRange, range2: IntRange, expected: Int) {
        sut.countOverlap(range1, range2) shouldBe expected
    }

    private val testInput = listOf(
        "2-4,6-8",
        "2-3,4-5",
        "5-7,7-9",
        "2-8,3-7",
        "6-6,4-6",
        "2-6,4-8",
    )

    @Test
    fun part1() {
        sut.part1(testInput) shouldBe 2
    }

    @Test
    fun part2() {
        sut.part2(testInput) shouldBe 4
    }

    companion object {
        @JvmStatic
        private fun fullOverlapInput(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1..3, 1..5, 1),
                Arguments.of(3..5, 4..6, 0),
                Arguments.of(1..3, 4..6, 0),
                Arguments.of(5..6, 4..7, 1),
                Arguments.of(4..6, 4..7, 1),
            )
        }

        @JvmStatic
        private fun overlapInput(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1..3, 1..5, 1),
                Arguments.of(3..5, 4..6, 1),
                Arguments.of(1..3, 4..6, 0),
                Arguments.of(5..6, 4..7, 1),
                Arguments.of(4..6, 4..7, 1),
                Arguments.of(4..6, 1..2, 0),
            )
        }
    }
}