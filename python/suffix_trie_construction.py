class Node:

    def __init__(self, name: str):
        self.name: str = name
        self.children: {Node} = {}

    def __eq__(self, other):
        return self.name == other.name

    def __str__(self):
        return f"Node({self.name})"

root = Node("root")

# Space O(a1 + a2 + n.. ) n -  suffix length and Time O(n^2)
def add_element(suffix:str, node:Node):
    cur_str = suffix
    while cur_str:
        add_element_helper(cur_str, node)
        cur_str = cur_str[1:]


def add_element_helper(suffix:str, node:Node):
    if not suffix:
        return node
    head, *tail = suffix
    str_tail = "".join(tail)
    new_node = Node(head)
    existed_node = node.children.get(new_node.name)
    if existed_node:
        return add_element_helper(str_tail, existed_node)
    else:
        node.children[new_node.name] = new_node
        return add_element_helper(str_tail, new_node)