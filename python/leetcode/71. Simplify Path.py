class Solution:

    # time O(n), space O(n)
    def simplifyPath(self, path: str) -> str:
        tokens = path.split("/")
        stack = []
        for token in tokens:
            if token == "..":
                if stack:
                    stack.pop()
            elif token == "." or token == "":
                continue
            else:
                stack.append(token)
        ans = "/".join(stack)
        return f"/{ans}"


assert Solution().simplifyPath("/a/../../b/../c//.//") == "/c"
assert Solution().simplifyPath("/foo/bar/../bar//hello/./world/") == "/foo/bar/hello/world"
assert Solution().simplifyPath("/../") == "/"
assert Solution().simplifyPath("/home/") == "/home"
assert Solution().simplifyPath("/home//foo/") == "/home/foo"
print("tests passed")
