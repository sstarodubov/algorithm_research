class ListNode(
    var `val`: Int,
    var next: ListNode? = null
) {

    override fun toString(): String {
        return "Node($`val`)"
    }

    companion object {
        fun buildLinkedList(values: IntArray): ListNode {
            if (values.isEmpty()) return ListNode(0)
            val root = ListNode(values[0])
            var cur = root
            var i = 1
            while (i < values.size) {
                val nn = ListNode(values[i])
                cur.next = nn
                cur = nn
                i++
            }
            return root
        }
    }
}