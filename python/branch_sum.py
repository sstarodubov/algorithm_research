from binarytree import build
from binarytree import Node
from typing import List

# Дано бинарное дерево
#         _____1__
#        /        \
#     __2___       3
#    /      \     / \
#   4       _5   6   7
#  / \     /
# 8   9   10
# нужно посчитать сумму каждой ветки
nodes = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# Building the tree
tree: Node = build(nodes)
print('Binary tree from list :\n',
      tree)


def sum_branches_rec(root: Node):
    sums = []
    calculate(node=root, sums=sums)
    return sums


def calculate(node: Node, sums: List[int], running_sum: int = 0):
    new_running_sum = running_sum + node.val

    if node.left is None and node.right is None:
        sums.append(new_running_sum)
        return
    if node.left is None:
        calculate(node.right, sums, new_running_sum)
        return
    if node.right is None:
        calculate(node.left, sums, new_running_sum)
        return
    calculate(node.left, sums, new_running_sum)
    calculate(node.right, sums, new_running_sum)

