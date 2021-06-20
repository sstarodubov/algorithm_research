import kotlin.math.abs


// Time O(n^3) and Space O(1)
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