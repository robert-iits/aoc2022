import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream


class Day03Test {

    val sut = Day03()

    @Test
    fun findCommonItem() {
        val result = sut.findCommonItem("vJrwpWtwJgWrhcsFMMfFFhFp")

        result shouldBe 'p'
    }

    @ParameterizedTest
    @MethodSource("priorityTestInput")
    fun getPriority(item: Char, expectedPriority: Int) {
        sut.getPriority(item) shouldBe expectedPriority
    }

    companion object {
        @JvmStatic
        private fun priorityTestInput(): Stream<Arguments> {
                return Stream.of(
                    Arguments.of('a', 1),
                    Arguments.of('A', 27),
                    Arguments.of('z', 26),
                    Arguments.of('Z', 52)
                )
        }
    }
}