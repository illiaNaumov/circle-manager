data class Circle(
    val id: Int,
    val name: String,
) {

    val memberCount: Int
        get() = members.count()

    private val members: MutableMap<Int, Member> = mutableMapOf()

    fun addMember(member: Member) {
        members[member.id] = member
    }

    fun removeMember(memberId: Int) {
        members.remove(memberId)
    }

    fun getMemberById(memberId: Int): Member? {
        return members[memberId]
    }

    fun getMemberByDistance(distance: Double, location: Location): List<Member> {
        return members.values
            .filter { member -> member.lastLocation.distanceTo(location) <= distance }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder("$id $name")
        members.values.forEach {
            stringBuilder.appendLine(" $it,")
        }
        if (stringBuilder.last() == ',') {
            stringBuilder.dropLast(1)
        }
        return stringBuilder.toString()
    }

    companion object {
        const val NO_NAME = ""
    }
}