class Grid(private val obstacles: List<Coordinate> = emptyList()) {

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

        val c = Coordinate(x, y)

        return when {
            obstacles.contains(c) -> coordinate
            else -> c
        }
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

        val c = Coordinate(x, y)

        return when {
            obstacles.contains(c) -> coordinate
            else -> c
        }

    }

    private val maxSquares = 10
    private fun increase(a: Int): Int = (a + 1) % maxSquares
    private fun decrease(a: Int): Int = when (a) {
        0 -> 9
        else -> (a - 1) % maxSquares
    }
}

data class Coordinate(val x: Int = 0, val y: Int = 0)