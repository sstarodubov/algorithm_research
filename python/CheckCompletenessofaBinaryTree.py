# Definition for a binary tree node.
from typing import Union

from binarytree import Node
from binarytree import build

#
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

TreeNode = Node


class Solution:

    # CPU O(n) and Space O(n)
    def isCompleteTree(self, root: TreeNode) -> bool:
        treeValues: [Union[int, None]] = []
        q: [Union[TreeNode, None]] = [root]

        while q:
            curTreeNode: TreeNode = q.pop(0)
            value = curTreeNode.val if curTreeNode is not None else None
            treeValues.append(value)
            if curTreeNode:
                q.append(curTreeNode.left)
                q.append(curTreeNode.right)

        flag = False
        for v in treeValues:
            if v is None and not flag:
                flag = True
                continue
            if v is not None and flag:
                return False
        return True


s = Solution()

assert s.isCompleteTree(build([1, 2, 3, 4, 5, 6]))
assert not s.isCompleteTree(build([1, 2, 3, 4, 5, None, 7]))

print("tests passed")
