
# time O(n) and space O(n)
def shortest_path(url: str) -> str:
    paths = url.split("/")
    paths[0] = "/" if paths[0] == "" else paths[0]
    stack = []
    for path in paths:
        if path == "..":
            stack.pop()
        elif path == "." or path == "": continue
        else: stack.append(path)
    print(stack)
    out = ""
    for p in range(len(stack)):
        if p != 0 and p != len(stack) - 1: out += f"{stack[p]}/"
        else: out += stack[p]
    return out


assert "/foo/bar/baz" == shortest_path("/foo/../test/../test/../foo//bar/./baz"), "1"

print("tests passed")