from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(n:TreeNode):
            if not n:
                return

            tmp = n.left
            n.left = n.right
            n.right = tmp

            dfs(n.left)
            dfs(n.right)

        dfs(root)
        return root




Solution().invertTree(TreeNode.build_tree([4, 2, 7, 1, 3, 6, 9]))
