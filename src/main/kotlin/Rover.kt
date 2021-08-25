import Orientation.*

class Rover(private val grid: Grid) {
    private var orientation = NORTH
    private var position = Pair(0,0)

    fun execute(command: String): String{
        command.forEach {
            when (it) {
                'L' -> orientation = orientation.turnLeft()
                'R' -> orientation = orientation.turnRight()
                else -> position = grid.move(it, position, orientation)
            }
        }
        val (x, y) = position
        return "${x}:${y}:${orientation.value}"
    }
}