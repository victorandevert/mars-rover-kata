import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RoverShould {

    @ParameterizedTest
    @CsvSource(
        "L, 0:0:W",
        "LL, 0:0:S",
        "LLL, 0:0:E",
        "LLLL, 0:0:N"
    )
    fun `turn left`(command: String, expected: String) {
        val rover = Rover()
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "R, 0:0:E",
        "RR, 0:0:S",
        "RRR, 0:0:W",
        "RRRR, 0:0:N"
    )
    fun `turn right`(command: String, expected: String) {
        val rover = Rover()
        assertThat(rover.execute(command)).isEqualTo(expected)
    }
}