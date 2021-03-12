class Node:

    def __init__(self, name: str):
        self.name: str = name
        self.children: [Node] = []

    def __eq__(self, other):
        return self.name == other.name

    def __str__(self):
        return f"Node({self.name})"

root = Node("root")

# Space O(n) and Time O(n^2 * lg n)
def add_element(suffix:str, node:Node):
    cur_str = suffix
    while cur_str:
        add_element_helper(cur_str, node)
        cur_str = cur_str[1:]


def add_element_helper(suffix:str, node:Node):
    if not suffix:
        return node
    head, *tail = suffix
    new_node = Node(head)
    if new_node in node.children:
        idx_existed_node = node.children.index(new_node)
        return add_element_helper("".join(tail), node.children[idx_existed_node])
    else:
        node.children.append(new_node)
        return add_element_helper("".join(tail), new_node)