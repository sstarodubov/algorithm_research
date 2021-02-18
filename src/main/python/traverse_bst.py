from binarytree import Node
from binarytree import build

# Дано бинарное дерево
#         ____10__
#        /        \
#     __5___       15
#    /      \       \
#   2        1       22
#  /
# 1
# валидировать что это BST
nodes = [10, 5, 15, 2, 5, None, 22, 1]

# Building the tree
tree: Node = build(nodes)
print('Binary tree from list :\n', tree)

# Time O(n) and Space O(n)
def in_order_traverse(node: Node, arr: [] = []):
    if node is None:
        return arr
    in_order_traverse(node.left)
    arr.append(node.value)
    in_order_traverse(node.right)
    return arr

print(in_order_traverse(tree))