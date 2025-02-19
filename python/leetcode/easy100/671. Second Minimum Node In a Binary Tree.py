from collections import deque
from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def findSecondMinimumValue(self, root: Optional[TreeNode]) -> int:
        if not root:
            return -1
        self.base = root.val
        self.ret = float("inf")

        def dfs(node):
            if not node:
                return

            if node.val == self.base:
                if node.left and node.left.val != self.base:
                    self.ret = min(self.ret, node.left.val)
                if node.right and node.right.val != self.base:
                    self.ret = min(self.ret, node.right.val)
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        if self.ret == float("inf"):
            return -1
        else:
            return self.ret


print(Solution().findSecondMinimumValue(TreeNode.build_tree([2, 2, 2])))
