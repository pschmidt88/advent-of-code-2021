fun main() {
    fun part1(input: List<String>): Int {
        var lastScan: Int? = null
        var counter = 0

        input
            .map { it.toInt() }
            .forEach { currentScan ->
                lastScan?.let {
                if (currentScan > it) {
                    counter++
                }
            }

            lastScan = currentScan
        }

        return counter
    }

    fun part2(input: List<String>): Int {
        val sumList: MutableList<String> = mutableListOf()
        val intList = input.map(String::toInt)

        intList.mapIndexed { index, currentScan ->
            if (intList.size > index+2) {
                sumList.add((currentScan + intList[index+1] + intList[index+2]).toString())
            }
        }

        return part1(sumList)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
