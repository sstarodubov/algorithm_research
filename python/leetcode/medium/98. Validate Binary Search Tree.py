from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(node: TreeNode, mx, mn):
            if not node:
                return True
            if node.val >= mx:
                return False
            if node.val <= mn:
                return False

            return dfs(node.left, node.val, mn) and dfs(node.right, mx, node.val)

        return dfs(root, float("inf"), float("-inf"))


assert Solution().isValidBST(TreeNode.build_tree([2, 1, 3]))
