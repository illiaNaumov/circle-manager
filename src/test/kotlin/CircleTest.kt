import Location.Companion.KYIV_CENTER
import Location.Companion.KYIV_EAST
import Location.Companion.KYIV_WEST
import Location.Companion.WASHINGTON
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CircleTest {

    @Test
    fun `ensure circle adds member`() {
        val circle = Circle(1, "family")
        val member = Member(1, "Mark", KYIV_CENTER)
        circle.addMember(member)
        assertEquals(member, circle.getMemberById(1))
    }

    @Test
    fun `ensure circle removes member`() {
        val circle = Circle(1, "family")
        val member = Member(1, "Mark", KYIV_CENTER)
        circle.addMember(member)
        circle.removeMember(member.id)
        assertEquals(null, circle.getMemberById(1))
    }

    @Test
    fun `ensure returns correct nearest members`() {
        val circle = Circle(1, "family")
        circle.addMember(Member(1, "Mark", KYIV_CENTER))
        circle.addMember(Member(2, "mother", KYIV_WEST))
        circle.addMember(Member(3, "father", KYIV_EAST))
        val farAwayMember = Member(4, "Loren", WASHINGTON)
        circle.addMember(farAwayMember)

        val nearestMembers = circle.getMemberByDistance(20_000.0, KYIV_CENTER)
        assertEquals(3, nearestMembers.size)
        assertFalse { nearestMembers.contains(farAwayMember) }
    }
}