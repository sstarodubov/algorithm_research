class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import Optional


class Solution:
    def maxDepth(self, node: Optional[TreeNode]) -> int:
        if not node:
            return 0
        if not node.left and not node.right:
            return 0

        return max(self.maxDepth(node.left), self.maxDepth(node.right)) + 1
