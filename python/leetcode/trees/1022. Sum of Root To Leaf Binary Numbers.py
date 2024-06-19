from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        def dfs(n: TreeNode, i=0):
            if not n:
                return
            t = i << 1
            i = t | n.val
            if not n.left and not n.right:
                self.ans += i
                return

            dfs(n.left, i)
            dfs(n.right, i)

        dfs(root)

        return self.ans


assert 22 == Solution().sumRootToLeaf(TreeNode.build_tree([1, 0, 1, 0, 1, 0, 1]))
