from typing import List, Optional

from leetcode.tree_node import TreeNode


class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        o = []
        def dfs(n:TreeNode):
            if not n:
                return
            o.append(n.val)
            dfs(n.left)
            dfs(n.right)
        dfs(root)
        return o