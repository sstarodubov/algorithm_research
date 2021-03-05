from binarytree import Node
from binarytree import build

# Дано бинарное дерево
#         _____1__
#        /        \
#     __2___       3
#    /      \     / \
#   4       _5   6   7
#  / \
# 8   9
# нужно посчитать сумму каждой ветки
nodes = [1, 2, 3, 4, 5, 6, 7, 8, 9]

# Building the tree
tree: Node = build(nodes)
print('Binary tree from list :\n',
      tree)


# time O(n) and Space O(lg d) d - height of tree
def invert_tree(node:Node):
    if node is not None:
        tmp = node.right
        node.right = node.left
        node.left = tmp

        invert_tree(node.left)
        invert_tree(node.right)

invert_tree(tree)
print(tree)
