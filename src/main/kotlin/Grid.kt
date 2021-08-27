import arrow.core.None
import arrow.core.Option
import arrow.core.Some


class Grid(private val obstacles: List<Pair<Int,Int>> = emptyList()) {

    fun move(direction: Char, position: Pair<Int,Int>, orientation: Orientation) =
        when (direction) {
            'F' -> moveForwardTo(position, orientation)
            else -> moveBackwardTo(position, orientation)
        }

    private fun moveForwardTo(position: Pair<Int,Int>, orientation: Orientation): Option<Pair<Int,Int>>{
        var (x, y) = position
        when {
            orientation.isNorth() -> increase(y).also { y = it }
            orientation.isSouth() -> decrease(y).also { y = it }
            orientation.isEast() -> increase(x).also { x = it }
            orientation.isWest() -> decrease(x).also { x = it }
        }
        return findObstacles(x to y)
    }


    private fun moveBackwardTo(position: Pair<Int,Int>, orientation: Orientation): Option<Pair<Int,Int>>{
        var (x, y) = position
        when {
            orientation.isNorth() -> decrease(y).also { y = it }
            orientation.isSouth() -> increase(y).also { y = it }
            orientation.isEast() -> decrease(x).also { x = it }
            orientation.isWest() -> increase(x).also { x = it }
        }
        return findObstacles(x to y)
    }

    private fun findObstacles(position: Pair<Int,Int>) = when (position) {
        in obstacles -> None
        else -> Some(position)
    }

    private val maxSquares = 10
    private fun increase(a: Int): Int = (a + 1) % maxSquares
    private fun decrease(a: Int): Int = when (a) {
        0 -> 9
        else -> (a - 1) % maxSquares
    }
}