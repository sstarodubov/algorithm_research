package codeforces.t58

import kotlin.math.min

fun down(arr: IntArray, n: Int, idx: Int): Int {
    var ret = 0
    var lt = if (n and 1 == 0)  {
        (n / 2) - 1
    } else {
        n / 2
    }
    var rt = n / 2

    var cur = arr[idx]

   while (lt >= 0 && rt < n) {
       if (cur == 0) return Int.MAX_VALUE
       if (arr[lt] != cur) {
           ret++;
       }
       if (arr[rt] != cur) {
           ret++
       }

       cur--
       lt -= 1
       rt += 1
   }

    return ret
}

fun up(arr: IntArray, n: Int, k: Int): Int {
    var ret = 0
    var lt = 0
    var rt = n - 1
    var cur = k
    while (lt < rt) {
        if (arr[lt] != cur) {
            ret++;
        }
        if (arr[rt] != cur) {
            ret++
        }

        cur++
        lt++
        rt--
    }

    if (n and 1 == 1 && arr[lt] - arr[lt - 1] != 1) {
        ret++
    }

    return ret
}

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    if (n == 1) {
        println(0)
        return
    }
    val ret1 = min(up(arr, n, arr[0]), up(arr, n, arr[n - 1]))
    if (n and 1 == 1) {
        println(min(ret1, down(arr, n, n / 2)))
    } else {
        val ret2 = min(down(arr, n, n / 2), down(arr, n, (n / 2) - 1))
        println(min(ret1, ret2))
    }
}
