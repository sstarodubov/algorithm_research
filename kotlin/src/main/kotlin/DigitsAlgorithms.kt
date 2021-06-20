import kotlin.math.pow

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