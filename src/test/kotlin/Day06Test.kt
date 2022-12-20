import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day06Test {

    private val sut = Day06()

    @ParameterizedTest
    @MethodSource("expectedMarkerPart1")
    fun part1(input: String, markerPosition: Int) {
        sut.lineMarker(input, 4) shouldBe markerPosition
    }

    @ParameterizedTest
    @MethodSource("expectedMarkerPart2")
    fun part2(input: String, markerPosition: Int) {
        sut.lineMarker(input, 14) shouldBe markerPosition
    }

    companion object {

        @JvmStatic
        private fun expectedMarkerPart1(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 7),
                Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 5),
                Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 6),
                Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 10),
                Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 11)
            )
        }

        @JvmStatic
        private fun expectedMarkerPart2(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 19),
                Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 23),
                Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 23),
                Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 29),
                Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 26)
            )
        }
    }
}