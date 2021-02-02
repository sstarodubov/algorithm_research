# дано бинарное дерево и число, нужно найти
# ближайшее значение этого числа в бинарном дереве

from binarytree import Node
import sys

# create BST
#          ___10
#      /           \
#     5             15
#   /  \           /  \
#  2    5          13  22
# /                /
# 1                14

root = Node(10)
n5 = Node(5)
n55 = Node(5)
n2 = Node(2)
n1 = Node(1)
n15 = Node(15)
n13 = Node(13)
n14 = Node(14)
n22 = Node(22)

root.left = n5
root.right = n15
n5.left = n2
n5.right = n55
n15.left = n13
n15.right = n22
n2.left = n1
n13.left = n14
############################

def find_closest(node: Node, target: int, closest: (int, Node) = (sys.maxsize, None)):
    if node is None:
        return closest if closest[0] != sys.maxsize else None

    if node.value == target:
        return node.value, node

    if target > node.value:
        diff = target - node.value
        if diff < closest[0]:
            closest = (diff, node)
        return find_closest(node.right, target, closest)

    diff = node.value - target
    if diff < closest[0]:
        closest = (diff, node)
    return find_closest(node.left, target, closest)


result = find_closest(root, 21)
print(result)
