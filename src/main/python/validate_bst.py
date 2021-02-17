from binarytree import Node
from binarytree import build

# Дано бинарное дерево
#         ____10__
#        /        \
#     __5___       15
#    /      \     / \
#   2       6    13  22
#  /             / \
# 1             12  14
# валидировать что это BST
nodes = [10, 5, 15, 2, 6, 13, 22, 1, None, None, None, 12, 14]

# Building the tree
tree: Node = build(nodes)
print('Binary tree from list :\n', tree)


def collect_nodes(node: Node, nodes: []):
    if node is not None:
        collect_nodes(node.left, nodes)
        nodes.append(node.value)
        collect_nodes(node.right, nodes)
    return nodes


# Time O(n) Space(n)
def is_bst(tree: Node):
    nodes = collect_nodes(tree, [])
    left, right = 0, 1

    while right < len(nodes):
        if nodes[left] > nodes[right]:
            return False
        left += 1
        right += 1
    return True


# Time O (n) Space (d) where d - is height of tree
def valid_bst(tree: Node):
    return validate_bst_helper(tree, float("-inf"), float("inf"))


def validate_bst_helper(tree, min_value, max_value):
    if tree is None:
        return True
    if tree.value < min_value or tree.value >= max_value:
        return False
    left_is_valid = validate_bst_helper(tree.left, min_value, tree.value)
    return left_is_valid and validate_bst_helper(tree.right, tree.value, max_value)
