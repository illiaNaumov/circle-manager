data class Location(
    val lat: Double,
    val lng: Double
) {
    /**
     * Calculates distance to given location in meters
     */
    fun distanceTo(other: Location): Double {
        var dist = Math.sin(Math.toRadians(lat)) * Math.sin(Math.toRadians(other.lat)) +
                Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(other.lat)) *
                Math.cos(Math.toRadians(lng - other.lng))
        dist = Math.acos(dist)
        dist = Math.toDegrees(dist)
        return dist * 60.0 * 1.1515 * 1609.34
    }

    companion object {
        val KYIV_CENTER = Location(50.450001, 30.523333) // Center
        val KYIV_WEST = Location(50.45464547389742, 30.350847291243003) //
        val KYIV_EAST = Location(50.48838167672901, 30.726987111763425)
        val ODESSA = Location(46.48331401861002, 30.722962693879523)
        val WASHINGTON = Location(38.9586528839175, -77.09422770086816)
    }
}