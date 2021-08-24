import Direction.*

class Rover {
    var y = 0
    var direction = NORTH
    fun execute(command: String): String{
        command.forEach {
            when (it) {
                'L' -> direction = direction.turnLeft()
                'R' -> direction = direction.turnRight()
                'F' -> y = forward()
                'B' -> y = backward()
            }
        }
        return "0:$y:${direction.value}"
    }

    private fun backward(): Int {
        if (direction == NORTH)
            if (y == 0) {
                return 9
            }else {
                return (y - 1) % 10
            }
        return y
    }

    private fun forward(): Int {
        if (direction == NORTH)
            return (y + 1) % 10
        return y
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