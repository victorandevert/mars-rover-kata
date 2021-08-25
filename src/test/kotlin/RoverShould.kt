import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RoverShould {

    private lateinit var rover: Rover

    @BeforeEach
    fun setup() {
        rover = Rover(Grid())
    }

    @ParameterizedTest
    @CsvSource(
        "L, 0:0:W",
        "LL, 0:0:S",
        "LLL, 0:0:E",
        "LLLL, 0:0:N"
    )
    fun `turn left`(command: String, expected: String) {
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
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "F, 0:1:N",
        "FFFFFF, 0:6:N"
    )
    fun `move forward`(command: String, expected: String){
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "FFFFFFFFFF, 0:0:N",
        "FFFFFFFFFFFFF, 0:3:N",
    )
    fun `wrap from top to bottom when moving forward`(command: String, expected: String){
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "B, 0:9:N",
        "BBB, 0:7:N",
        "BBBBB, 0:5:N",
    )
    fun `move backward`(command: String, expected: String){
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "RF, 1:0:E",
        "RFFFF, 4:0:E",
        "RB, 9:0:E",
        "RBBBB, 6:0:E"
    )
    fun `move right`(command: String, expected: String){
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "RFFFFFFFFFF, 0:0:E",
        "RFFFFFFFFFFFFFFFFF, 7:0:E"
    )
    fun `wrap from right to left when moving forwawrd`(command: String, expected: String){
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "LF, 9:0:W",
        "LFFF, 7:0:W",
        "LB, 1:0:W",
        "LBBBBBBBBBBBBBBBBB, 7:0:W"
    )
    fun `move left`(command: String, expected: String){
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "RRF, 0:9:S",
        "RRFFF, 0:7:S",
        "RRB, 0:1:S",
        "RRBBBBBBBBBBBBB, 0:3:S",
        "RRFFFFFFFFFFFF, 0:8:S"
    )
    fun `move south`(command: String, expected: String){
        assertThat(rover.execute(command)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "FFF, 0:2:N",
        "BBBB, 0:7:N"
    )
    fun `stop when find an obstacle`(command: String, expected: String){
        val obstacles = arrayListOf(Coordinate(0,3), Coordinate(0,6))
        val grid = Grid(obstacles)
        val rover = Rover(grid)
        assertThat(rover.execute(command)).isEqualTo(expected)
    }
}