import kotlin.math.max
import kotlin.math.min


class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var newInt = newInterval
        val result: MutableList<IntArray> = ArrayList()

        for (slot in intervals) {

            if (newInt[1] < slot[0]) {
                result.add(newInt)
                newInt = slot
            } else if (slot[1] < newInt[0]) {
                result.add(slot)
            } else {
                newInt[0] = min(newInt[0], slot[0])
                newInt[1] = max(newInt[1], slot[1])
            }
        }


        // insert the last newInterval
        result.add(newInt)


        // convert to int[][] array
        return result.toTypedArray<IntArray>()
    }
}