fun main() {

    fun part1(input: List<String>): Int {
        return Submarine().apply {
            movePart1(MovementInstructions(input))
        }.multiplyDepthByHorizontalPosition()
    }

    fun part2(input: List<String>): Int {
        return Submarine().apply {
            movePart2(MovementInstructions(input))
        }.multiplyDepthByHorizontalPosition()
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput(("Day02"))
    println("part1: ${part1(input)}")
    println("part2: ${part2(input)}")
}

class MovementInstructions(
    rawData: List<String>
): Iterable<Instruction> {

    private val instructions: List<Instruction> = rawData.map { Instruction.fromString(it) }

    override fun iterator(): Iterator<Instruction> {
        return instructions.iterator()
    }
}

class Submarine {
    private var depth = 0
    private var horizontal = 0
    private var aim = 0

    fun movePart1(movementInstructions: MovementInstructions) {
        movementInstructions.forEach { instruction ->
            when (instruction.direction) {
                "forward" -> horizontal += instruction.amount
                "up" -> depth -= instruction.amount
                "down" -> depth += instruction.amount
            }
        }
    }

    fun movePart2(movementInstructions: MovementInstructions) {
        movementInstructions.forEach { instruction ->
            when (instruction.direction) {
                "up" -> aim -= instruction.amount
                "down" -> aim += instruction.amount
                "forward" -> {
                    horizontal += instruction.amount
                    depth += aim * instruction.amount
                }
            }
        }
    }

    fun multiplyDepthByHorizontalPosition(): Int {
        return depth * horizontal
    }
}

data class Instruction(
    val direction: String,
    val amount: Int
) {
    companion object {
        fun fromString(input: String): Instruction {
            val (direction, amount) = input.split(" ")
            return Instruction(direction, amount.toInt())
        }
    }
}
