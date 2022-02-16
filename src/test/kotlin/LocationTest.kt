import Location.Companion.KYIV_CENTER
import Location.Companion.KYIV_WEST
import Location.Companion.WASHINGTON
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LocationTest {

    @Test
    fun `calculate correct distance from center to west`() {
        val distance = KYIV_CENTER.distanceTo(KYIV_WEST)
        assertEquals(DISTANCE_KYIV_CENTER_TO_WESTERN_PART, distance, 1.0)
    }

    @Test
    fun `calculate correct distance between locations from different hemispheres`() {
        val distance = KYIV_CENTER.distanceTo(WASHINGTON)
        assertEquals(DISTANCE_KYIV_TO_WASHINGTON, distance, 1.0)
    }

    private companion object {
        private const val DISTANCE_KYIV_CENTER_TO_WESTERN_PART = 12_222.0
        private const val DISTANCE_KYIV_TO_WASHINGTON = 7_831_066.0
    }
}