class Grid(private val obstacles: List<Pair<Int,Int>> = emptyList()) {

    fun move(direction: Char, position: Pair<Int,Int>, orientation: Orientation): Pair<Int,Int>{
        when (direction) {
            'F' -> return moveForwardTo(position, orientation)
            else -> return moveBackwardTo(position, orientation)
        }
    }

    private fun moveForwardTo(position: Pair<Int,Int>, orientation: Orientation): Pair<Int,Int>{
        var (x, y) = position

        if (orientation.isNorth())
            y = increase(y)

        if(orientation.isEast())
            x = increase(x)

        if (orientation.isWest())
            x =  decrease(x)

        if(orientation.isSouth())
            y = decrease(y)

        val p = Pair(x,y)

        return when {
            obstacles.contains(p) -> position
            else -> p
        }
    }


    private fun moveBackwardTo(position: Pair<Int,Int>, orientation: Orientation): Pair<Int,Int>{
        var (x, y) = position

        if (orientation.isNorth())
            y = decrease(y)

        if(orientation.isEast())
            x = decrease(x)

        if(orientation.isWest())
            x = increase(x)

        if(orientation.isSouth())
            y = increase(y)


        val p = Pair(x,y)

        return when {
            obstacles.contains(p) -> position
            else -> p
        }

    }

    private val maxSquares = 10
    private fun increase(a: Int): Int = (a + 1) % maxSquares
    private fun decrease(a: Int): Int = when (a) {
        0 -> 9
        else -> (a - 1) % maxSquares
    }
}