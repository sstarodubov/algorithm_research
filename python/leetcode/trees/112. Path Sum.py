from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        self.ans = False

        def dfs(n: TreeNode, s: int):
            if not n:
                return
            s += n.val
            if not n.left and not n.right:
                if s == targetSum:
                    self.ans = True
                return

            dfs(n.left, s)
            dfs(n.right, s)

        dfs(root, 0)
        return self.ans


assert not Solution().hasPathSum(TreeNode.build_tree([1, 2]), 1)
assert Solution().hasPathSum(TreeNode.build_tree([1]), 1)
assert not Solution().hasPathSum(None, 0)
assert Solution().hasPathSum(root=
                             TreeNode.build_tree([5, 4, 8, 11, None, 13, 4, 7, 2, None, None, None, 1]), targetSum=22)
