import kotlin.math.abs

fun main() {
    val countGoodTriplets = countGoodTriplets(intArrayOf(3, 0, 1, 1, 9, 7), 7, 2, 3)
    assert(countGoodTriplets == 4)
    println("tests passed")
}

fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    var ans = 0
    for (i in 0 until arr.size) {
        for (j in i + 1 until arr.size) {
            for (k in j + 1 until arr.size) {
                if (
                    abs(arr[i] - arr[j]) <= a
                    && abs(arr[j] - arr[k]) <= b
                    && abs(arr[i] - arr[k]) <= c
                ) {
                    ans++
                }
            }
        }
    }
    return ans;
}