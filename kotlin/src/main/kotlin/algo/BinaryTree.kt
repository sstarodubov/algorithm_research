package algo

import java.util.*

class Node(
    val value: Int,
    var left: Node? = null,
    var right: Node? = null
) {
    override fun toString(): String {
        return "Node($value)"
    }
}


fun main() {

    val n3 = Node(3)
    val n4 = Node(4)
    val n5 = Node(5)
    val n6 = Node(6)
    val n1 = Node(1, n3, n4)
    val n2 = Node(2, n5, n6)
    val root = Node(0, n1, n2)

    val breadthFirstTraverse = breadthFirstTraverse(root)
    print(breadthFirstTraverse)
}


fun breadthFirstTraverse(node: Node): MutableList<Node> {
    val list = mutableListOf<Node>()
    val q = LinkedList<Node>()
    q.push(node)

    while (!q.isEmpty()) {
        val cur: Node = q.pollFirst()
        list.add(cur)
        cur.left?.let { q.addLast(it) }
        cur.right?.let { q.addLast(it) }
    }
    return list
}