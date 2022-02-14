from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        m = set()

        def dfs(node: TreeNode):
            if not node:
                return False

            if k - node.val in m:
                return True

            m.add(node.val)

            return dfs(node.left) or dfs(node.right)

        return dfs(root)

assert Solution().findTarget(root=TreeNode.build_tree([5, 3, 6, 2, 4, None, 7]), k=9)
