enum class Orientation(val value: String, val left: String, val right: String) {
    NORTH("N", "W", "E"),
    SOUTH("S", "E", "W"),
    EAST("E","N","S"),
    WEST("W", "S", "N");

    fun turnLeft(): Orientation {
        return values().first { it.value == left }
    }

    fun turnRight(): Orientation {
        return values().first { it.value == right }
    }

    fun isNorth(): Boolean = this == NORTH

    fun isSouth(): Boolean = this == SOUTH

    fun isEast(): Boolean = this == EAST

    fun isWest(): Boolean = this == WEST
}