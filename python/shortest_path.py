# time O(n) and space O(n)
def shortest_path(url: str) -> str:
    is_absolute = False
    tokens = url.split("/")
    tokens[0] = "/" if tokens[0] == "" else tokens[0]
    if tokens[0] == "/": is_absolute = True
    stack = []
    for token in tokens:
        if token == "..":
            stack.pop()
        elif token == "." or token == "":
            continue
        else:
            stack.append(token)
    out = ""
    for p in range(len(stack)):
        if p != 0 and p != len(stack) - 1 and is_absolute:
            out += f"{stack[p]}/"
        elif p != len(stack) - 1 and not is_absolute:
            out += f"{stack[p]}/"
        elif p == 0 and not is_absolute:
            out += f"/{stack[p]}"
        else:
            out += stack[p]
    return out


assert "/foo/bar/baz" == shortest_path("/foo/../test/../test/../foo//bar/./baz"), "1"
assert "foo/bar/baz" == shortest_path("./foo/../test/../test/../foo//bar/./baz"), "2"

print("tests passed")
