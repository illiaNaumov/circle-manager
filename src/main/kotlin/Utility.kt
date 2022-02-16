/**
 * Takes a list of [Circle]s objects and returns a count of how many [Circle]s are duplicated in the list
 */
fun countDuplicates(circles: List<Circle>): Int {
    return circles.groupBy { it }
        .filter { it.value.size > 1 }
        .flatMap { it.value }
        .size
}

/**
 * Removes all duplicates and return a list with unique [Circle]s.
 * If multiple [Circle]s exist with the same id, keeps the one with the most members
 */
fun filterUniqueByMaxCount(circles: List<Circle>): List<Circle> {
    return circles.groupBy { it }
        .map { it.value.maxByOrNull { it.memberCount }!! }
}