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
# нужно посчитать глубину каждой ноды
nodes = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# Building the tree
tree: Node = build(nodes)
print('Binary tree from list :\n',
      tree)


def find_each_node_depth(root: Node):
    records = {}
    depth_count = 0
    dive(root, records, depth_count)
    return records


def dive(node: Node, records: {}, depth_count: int):
    if node is None:
        return
    records[f"Node({node.value})"] = depth_count
    depth_count += 1
    dive(node.left, records, depth_count)
    dive(node.right, records, depth_count)

