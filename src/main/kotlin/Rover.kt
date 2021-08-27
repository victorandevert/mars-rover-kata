import Orientation.*

class Rover(private val grid: Grid) {
    private var orientation = NORTH
    private var currentPosition = Pair(0,0)

    fun execute(command: String): String{
        var output = ""
        command.forEach {
            when (it) {
                'L' -> orientation = orientation.turnLeft()
                'R' -> orientation = orientation.turnRight()
                else -> {
                    grid.move(it, currentPosition, orientation).fold(
                        { obstaclePosition() },
                        { currentPosition(it)}
                    ).also { output = it }
                }
            }
        }
        return reportPosition(output)
    }

    private fun currentPosition(it: Pair<Int, Int>): String {
        currentPosition = it
        return "${it.first}:${it.second}:${orientation.value}"
    }
    private fun obstaclePosition() = "O:${currentPosition.first}:${currentPosition.second}:${orientation.value}"

    private fun reportPosition(output: String) = output.ifEmpty {
        "${currentPosition.first}:${currentPosition.second}:${orientation.value}"
    }
}