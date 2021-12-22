fun main() {
    val input = readInput("Day03")

    val testInput = readInput("Day03_test")

    check(part1(testInput) == 198) {
        "part 1 for test data is not correct"
    }
    println("part1: ${part1(input)}")

    val part2 = part2(testInput)
    check(part2 == 230) {
        "part2 for test data is not correct. should be: 230 - actual: $part2"
    }
    println("part2: ${part2(input)}")
}

fun part2(input: List<String>): Int {

}

fun List<String>.mostCommonBit(): Boolean {

    val countZeros = this.count { it == "0" }
    val countOnes = this.count { it == "1" }

    return countOnes > countZeros
}

val Boolean.stringValue
    get() = if (this) "1" else "0"

fun part1(diagnosticReport: List<String>): Int {
    val gammaRateBinary = mutableListOf<String>()
    val epsilonRateBinary = mutableListOf<String>()

    for (i in 0 until diagnosticReport.first().length) {
        val column = diagnosticReport.map { it[i].toString() }
        gammaRateBinary.add(column.mostCommonBit().stringValue)
        epsilonRateBinary.add((!column.mostCommonBit()).stringValue)
    }

    val gammaRate = Integer.parseInt(gammaRateBinary.joinToString(""), 2)
    val epsilonRate = Integer.parseInt(epsilonRateBinary.joinToString(""), 2)

    return gammaRate * epsilonRate
}



