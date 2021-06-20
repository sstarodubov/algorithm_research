import kotlin.math.roundToInt
import kotlin.math.sqrt

// Euclid Algorithm
// Time O(log (b))
fun greatestCommonDelimiter(a: Int, b: Int): Int {
    var a: Int = a
    var b: Int = b
    while (b != 0) {
        val reminder: Int = a % b
        a = b
        b = reminder
    }
    return a
}

fun main() {
    print(findFactors(88))
}

fun findFactors(number: Int): MutableSet<Int> {
    val factors = mutableSetOf<Int>()
    var number = number
    while (number % 2 == 0) {
        factors.add(2)
        number /= 2
    }
    var i: Int = 3
    var maxFactor: Int = sqrt(number.toDouble()).toInt()
    while (i <= maxFactor) {
        while (number % i == 0) {
            factors.add(i)
            number /= i
            maxFactor = sqrt(number.toDouble()).toInt()
        }
        i += 2
    }
    if (number > 1) factors.add(number)
    return factors
}

