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


def findLeafSum(tree, curNode):
    if curNode is None: return
    if not tree[curNode]:
        return curNode
    total = 0
    children = tree[curNode]
    for child in children:
        total += findLeafSum(tree, child)

    return total


def findHeight(tree, node, depth, ans=0):
    if node is not None:
        children = tree[node]
        if not children:
            return depth
        else:
            for child in children:
                curDepth = findHeight(tree, child, depth + 1, ans)
                ans = max(curDepth, ans)
    return ans


print(findHeight(tree, 5, 1))
