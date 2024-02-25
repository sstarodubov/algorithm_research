package codeforces.t58

import java.util.*


fun main() {
    val n: Int = readln().toInt()
    var len = 0
    val s = Array(n) { "" }
    for (i in 0 until n) {
        s[i] = readln()
        len += s[i].length
    }
    val d: String = readln()

    val set = TreeSet<String>()
    len = len / (n / 2) + 2
    for (a in s) {
        set.add(a + d)
    }
    for (i in n / 2 downTo 1) {
        val a: String = set.pollFirst()!!
        for (b in set) if (b.length + a.length == len) {
            println(a + b.substring(0, b.length - 1))
            set.remove(b)
            break
        }
    }
}
