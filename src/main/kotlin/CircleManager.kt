/**
 * A Circle manager that can add and remove members based on a circle ID.
 * Also able to query the number of circles with a given number of members
 */
class CircleManager {

    private val circles: MutableMap<Int, Circle> = mutableMapOf()

    /**
     * Creates a new circle with 1 member and the provided ID
     */
    @Synchronized
    fun createCircle(circleId: Int, name: String, member: Member) {
        val circle = Circle(circleId, name).apply {
            addMember(member)
        }
        circles[circleId] = circle
    }

    /**
     * Deletes a circle by given id
     */
    @Synchronized
    fun deleteCircle(circleId: Int) {
        circles.remove(circleId)
    }

    /**
     * Returns the number of circles with members of size n passed
     * into the function.
     */
    fun query(memberCount: Int): Int {
        return circles.values
            .filter { it.memberCount == memberCount }
            .count()
    }

    /**
     * Adds a member to a circle of the id passed in to the signature.
     * Creates circle in the case that the circle does not exist.
     */
    @Synchronized
    fun addMember(circleId: Int, member: Member) {
        val circle = circles[circleId]
        if (circle != null) {
            circle.addMember(member)
        } else {
            createCircle(circleId, Circle.NO_NAME, member)
        }
    }

    /**
     * Removes a member from the circle of the circleId and memberId passed in to
     * the signature. Removes circles with no members
     */
    @Synchronized
    fun removeMember(circleId: Int, memberId: Int) {
        val circle = circles[circleId] ?: return
        circle.removeMember(memberId)
        if (circle.memberCount == 0) {
            circles.remove(circleId)
        }
    }

    /**
     * Prints all circles and members to console
     */
    fun printAllCircles() {
        circles.values.forEach { circle ->
            println(circle)
        }
    }


}