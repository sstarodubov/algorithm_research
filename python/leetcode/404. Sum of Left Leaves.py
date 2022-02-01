from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:

        def dfs(node, parent):
            if not node:
                return 0

            if not node.left and not node.right:
                if parent and parent.left == node:
                    return parent.left.val
                else:
                    return 0

            ls = dfs(node.left, node)
            rs = dfs(node.right, node)
            return ls + rs

        ans = dfs(root, None)
        return ans


assert 0 == Solution().sumOfLeftLeaves(TreeNode.build_tree([1]))
assert 24 == Solution().sumOfLeftLeaves(TreeNode.build_tree([3, 9, 20, None, None, 15, 7]))
assert 25 == Solution().sumOfLeftLeaves(TreeNode.build_tree([3, 9, 20, None, None, 15, 7, None, None, 1]))
