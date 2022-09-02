package geometry

data class Interval(val low: Int, val high: Int)
data class Node(val interval: Interval, var left: Node? = null, var right: Node? = null, var max: Int)

fun insert(root: Node?, interval: Interval): Node {
    if (root == null) return Node(interval = interval, max = interval.high)
    if (interval.low < root.interval.low) root.left = insert(root.left, interval)
    else root.right = insert(root.right, interval)
    if (root.max < interval.high) root.max = interval.high
    return root
}

fun overlap(root: Node?, interval: Interval): Interval {
    if (root == null) return Interval(-1, -1)
    return if ((interval.low > root.interval.low
                    && interval.low < root.interval.high)
            || (interval.high > root.interval.low
                    && interval.high < root.interval.high)) {
        root.interval
    } else if (root.left != null && root.left!!.max > interval.low) overlap(root.left, interval)
    else overlap(root.right, interval)
}