object Solution {

    @JvmStatic
    fun main(args: Array<String>) {
        val circleManager = CircleManager()

        circleManager.createCircle(
            circleId = 1,
            name = "family",
            Member(1, "Mark", Location.KYIV_CENTER)
        )
        circleManager.addMember(
            circleId = 1,
            Member(2, "father", Location.KYIV_WEST)
        )
        circleManager.addMember(
            circleId = 1,
            member = Member(3, "Lora", Location.KYIV_EAST)
        )

        circleManager.createCircle(
            circleId = 2,
            name = "gang",
            Member(1, "Mark", Location.ODESSA)
        )

        circleManager.createCircle(
            circleId = 2,
            name = "friends",
            Member(1, "Mark", Location.ODESSA)
        )

        circleManager.printAllCircles()
    }
}