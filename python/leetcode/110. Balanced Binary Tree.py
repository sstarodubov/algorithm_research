from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.ans = True

        def dfs(node):
            if not node:
                return 0
            ld = dfs(node.left)
            rd = dfs(node.right)

            if abs(ld - rd) > 1:
                self.ans = False

            return max(ld, rd) + 1

        dfs(root)

        return self.ans


assert Solution().isBalanced(TreeNode.build_tree([1, 2, 3, 4, 5, 6, None, 8]))
assert not Solution().isBalanced(TreeNode.build_tree([1, None, 2, None, 3]))
assert Solution().isBalanced(TreeNode.build_tree([3, 9, 20, None, None, 15, 7]))
assert not Solution().isBalanced(TreeNode.build_tree([1, 2, 2, 3, 3, None, None, 4, 4]))
