class Solution:
    def simplifyPath(self, path: str) -> str:

        stack = []
        for p in path.split("/"):
            match p:
                case "/" | "." | "":
                    continue
                case "..":
                    if stack:
                        stack.pop()
                case _:
                    stack.append(p)

        ans = "/" + "/".join(stack)

        return ans


assert "/" == Solution().simplifyPath("/../")
assert "/home" == Solution().simplifyPath("/home/")
assert "/home/foo" == Solution().simplifyPath("/home//foo/")
