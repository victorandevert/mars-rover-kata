import Direction.*

class Rover(private val grid: Grid) {
    private var direction = NORTH
    private var coordinate = Coordinate()


    fun execute(command: String): String{
        command.forEach {
            when (it) {
                'L' -> direction = direction.turnLeft()
                'R' -> direction = direction.turnRight()
                'F' -> coordinate = grid.moveForwardTo(coordinate, direction)
                'B' -> coordinate = grid.moveBackwardTo(coordinate, direction)
            }
        }
        return "${coordinate.x}:${coordinate.y}:${direction.value}"
    }
}