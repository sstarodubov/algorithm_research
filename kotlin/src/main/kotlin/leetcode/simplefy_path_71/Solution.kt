package leetcode.simplefy_path_71


fun main() {
    assert(Solution().simplifyPath("/home//test/./..//foo/") == "/home/foo")
    assert(Solution().simplifyPath("/") == "/")
}

class Solution {
    fun simplifyPath(path: String): String {
        val ps = path.split("/")
        val stack = ArrayDeque<String>()

        for (p in ps) {
            when (p) {
                ".", " ", "" -> {}
                ".." -> {
                    if (stack.isNotEmpty()) {
                        stack.removeFirst()
                    }
                }

                else -> stack.addFirst(p)
            }

        }

        val sb = StringBuilder("/")

        for (i in stack.size - 1 downTo 0) {
           sb.append(stack[i])
            if (i != 0) {
                sb.append("/")
            }
        }

        return sb.toString()
    }
}