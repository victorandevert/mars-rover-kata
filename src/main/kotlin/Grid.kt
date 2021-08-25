class Grid {
    private val max_squares = 10

    fun moveForwardTo(coordinate: Coordinate, direction: Direction): Coordinate{
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

    fun moveBackwardTo(coordinate: Coordinate, direction: Direction): Coordinate {
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

    private fun increase(a: Int): Int = (a + 1) % max_squares
    private fun decrease(a: Int): Int = when (a) {
        0 -> 9
        else -> (a - 1) % max_squares
    }
}
class Coordinate(val x: Int = 0, val y: Int = 0)