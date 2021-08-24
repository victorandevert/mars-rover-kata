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

    @ParameterizedTest
    @CsvSource(
        "F, 0:1:N",
        "FFFFFF, 0:6:N"
    )
    fun `move forward`(command: String, expected: String){
        val rover = Rover()
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "FFFFFFFFFF, 0:0:N",
        "FFFFFFFFFFFFF, 0:3:N",
    )
    fun `wrap from top to bottom when moving forward`(command: String, expected: String){
        val rover = Rover()
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "B, 0:9:N",
        "BBB, 0:7:N",
        "BBBBB, 0:5:N",
    )
    fun `move backward`(command: String, expected: String){
        val rover = Rover()
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "RF, 1:0:E",
        "RFFFF, 4:0:E",
    )
    fun `move right`(command: String, expected: String){
        val rover = Rover()
        assertThat(rover.execute(command)).isEqualTo(expected)
    }
}