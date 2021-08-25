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

        if (direction.isNorth())
            y = decrease(y)

        if(direction.isEast())
            x = decrease(x)

        if(direction.isWest())
            x = increase(x)

        if(direction.isSouth())
            y = increase(y)

        return Coordinate(x,y)
    }

    private fun forward(): Coordinate {
        var y = coordinate.y
        var x = coordinate.x

        if (direction.isNorth())
            y = increase(y)

        if(direction.isEast())
            x = increase(x)

        if (direction.isWest())
            x =  decrease(x)

        if(direction.isSouth())
            y = decrease(y)

        return Coordinate(x,y)
    }

    private fun increase(a: Int): Int = (a + 1) % 10
    private fun decrease(a: Int): Int = when (a) {
        0 -> 9
        else -> (a - 1) % 10
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

    fun isNorth(): Boolean = this == NORTH

    fun isSouth(): Boolean = this == SOUTH

    fun isEast(): Boolean = this == EAST

    fun isWest(): Boolean = this == WEST


}
class Coordinate(val x: Int = 0, val y: Int = 0)