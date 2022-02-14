from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def findSecondMinimumValue(self, root: Optional[TreeNode]) -> int:
        if not root.left and not root.right:
            return -1
        self.mn1 = min(root.val, root.left.val)
        self.mn2 = max(root.val, root.left.val)

        def dfs(node: TreeNode):
            if not node:
                return

            if node.val < self.mn1:
                self.mn2 = self.mn1
                self.mn1 = node.val
            elif node.val < self.mn2 and self.mn1 != self.mn2 and node.val > self.mn1:
                self.mn2 = node.val
            elif node.val > self.mn2 and self.mn2 == self.mn1:
                self.mn2 = node.val

            dfs(node.left)
            dfs(node.right)

        dfs(root)

        if self.mn1 == self.mn2:
            return -1

        return self.mn2


assert 8 == Solution().findSecondMinimumValue(TreeNode.build_tree([5, 8, 5]))
assert 5 == Solution().findSecondMinimumValue(TreeNode.build_tree([2, 2, 5, None, None, 5, 5]))
assert 5 == Solution().findSecondMinimumValue(TreeNode.build_tree([2, 2, 5, None, None, 5, 7]))
assert -1 == Solution().findSecondMinimumValue(TreeNode.build_tree([2, 2, 2]))
