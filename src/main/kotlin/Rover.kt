import Direction.*

class Rover {
    private var direction = NORTH
    private var coordinate = Coordinate()
    fun execute(command: String): String{
        command.forEach {
            when (it) {
                'L' -> direction = direction.turnLeft()
                'R' -> direction = direction.turnRight()
                'F' -> coordinate = forward()
                'B' -> coordinate = backward()
            }
        }
        return "${coordinate.x}:${coordinate.y}:${direction.value}"
    }

    private fun backward(): Coordinate {
        var y = coordinate.y
        var x = coordinate.x

        if (direction == NORTH)
            if (y == 0) {
                y = 9
            }else {
                y = (y - 1) % 10
            }
        return Coordinate(x,y)
    }

    private fun forward(): Coordinate {
        var y = coordinate.y
        var x = coordinate.x
        if (direction == NORTH)
            y = (y + 1) % 10

        if(direction == EAST)
            x = (x + 1) % 10

        return Coordinate(x,y)
    }

}

enum class Direction(val value: String, val left: String, val right: String) {
    NORTH("N", "W", "E"),
    SOUTH("S", "E", "W"),
    EAST("E","N","S"),
    WEST("W", "S", "N");

    fun turnLeft(): Direction {
        return values().first { it.value == left }
    }

    fun turnRight(): Direction {
        return values().first { it.value == right }
    }
}
data class Coordinate(val x: Int = 0, val y: Int = 0)