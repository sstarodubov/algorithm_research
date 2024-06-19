from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        def dfs(n: TreeNode):
            if not n:
                return 0

            lv = dfs(n.left)
            rv = dfs(n.right)

            self.ans = max(self.ans, lv + rv)

            return max(lv, rv) + 1

        dfs(root)

        return self.ans


assert 1 == Solution().diameterOfBinaryTree(TreeNode.build_tree([1, 2]))
assert 3 == Solution().diameterOfBinaryTree(TreeNode.build_tree([1, 2, 3, 4, 5]))
