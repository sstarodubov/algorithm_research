package codeforces.t58

fun main() {
    val s = readln()
    val t = "hello"
    var ptr = 0

    for (i in s.indices) {
        if (ptr == t.length) {
            println("YES")
            return
        }
        if (s[i] == t[ptr]) {
            ptr++
        }
    }

    if (ptr == t.length) {
        println("YES")
    } else {
        println("NO")
    }
}