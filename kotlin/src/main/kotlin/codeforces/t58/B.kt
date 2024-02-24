package codeforces.t58

fun main() {
    var n = readln().toInt()

    while (n != 1) {
        print("$n ")
        n = nextDev(n)
    }

    print(1)
}

fun nextDev(n:Int):Int  {
   for (i in n- 1 downTo 0) {
      if ( n % i == 0) {
          return i
      }
   }

   return 1
}