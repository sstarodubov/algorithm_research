from binarytree import build
from binarytree import Node
from typing import List

tree = {
    5: [4, 3],
    4: [1, -6],
    3: [0, 7, -4],
    1: [2, 9],
    7: [8],
    -4: [],
    0: [],
    2: [],
    9: [],
    8: [],
    -6: []
}


def findLeafSum(tree, curNode, sum= [0]):
    if curNode is None: return
    if not tree[curNode]:
        sum[0] += curNode
        return

    children = tree[curNode]
    for child in children:
        findLeafSum(tree, child, sum)

    return sum[0]


print(findLeafSum(tree, 5))
