from binarytree import build
from binarytree import Node
from typing import List

tree = {
    0: [1],
    1: [0, 3, 4],
    2: [3],
    3: [1, 2, 6, 7],
    4: [5, 8],
    5: [4],
    6: [3, 9],
    7: [3],
    8: [4],
    9: [6],
}


def center(tree: {int, int}) -> List[int]:
    def removeLeaf(tree: {}) -> List[int]:
        nodesToRemove: {} = {}
        for node in tree:
            if len(tree[node]) == 1:
                nodesToRemove[node] = True
                tree[node] = []

        for node in tree:
            for child in tree[node]:
                if child in nodesToRemove:
                    tree[node].remove(child)
        return list(nodesToRemove.keys())

    size = len(tree)
    while True:

        removedNodes = removeLeaf(tree)
        size -= len(removedNodes)
        if size == 0:
            return removedNodes


print(center(tree))


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
