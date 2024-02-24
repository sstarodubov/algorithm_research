package algo

class WNode(var set: DisjointSet? = null, val name: String) {
    override fun toString(): String = name
}

class DisjointSet(var nodeList: MutableList<WNode> = mutableListOf())

fun makeSet(nodeList: MutableList<WNode>) {
    for (node in nodeList) {
        val set = DisjointSet()
        node.set = set
        node.set!!.nodeList.add(node)
    }
}

fun findSet(node: WNode): DisjointSet = node.set!!

fun union(node1: WNode, node2: WNode) {

    if (node1.set == node2.set) return

    val s1: DisjointSet = node1.set!!
    val s2: DisjointSet = node2.set!!

    if (s1.nodeList.size > s2.nodeList.size) {
        for (node in s2.nodeList) {
            node.set = s1
            s1.nodeList.add(node)
        }
        return
    }

    for (node in s1.nodeList) {
        node.set = s2
        s2.nodeList.add(node)
    }
}

fun printSet(set: DisjointSet) {
    for (node in set.nodeList) {
        print("${node.name},")
    }
}

// test

fun main() {
    val A = WNode(name = "A")
    val B = WNode(name = "B")
    val C = WNode(name = "C")
    val D = WNode(name = "D")

    val nodeList = mutableListOf(A, B, C, D)

    makeSet(nodeList)
    union(A, B)
    union(A, C)
    union(A, D)
    printSet(A.set!!)
}