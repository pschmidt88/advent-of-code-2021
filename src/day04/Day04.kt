package day04

import readInput


fun main() {
    val testInput = readInput("day04/input_test")
    val input = readInput("day04/input")

    check(part1(testInput) == 4512)
    println("Part 1 Answer: ${part1(input)}")

}

fun part1(testInput: List<String>): Int {

    return 0
}

class Numbers(val numbers: List<Int>) {

}

class BingoBoard(
    val rows: List<Numbers>,
    val columns: List<Numbers>
) {

    fun markNumber(number: Int) {
    }
}