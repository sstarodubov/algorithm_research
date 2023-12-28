from typing import Optional, List

from leetcode.tree_node import TreeNode


class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root:
            return
        xs: List[TreeNode] = []

        def dfs(n: Optional[TreeNode]):
            if not n:
                return
            xs.append(n)
            dfs(n.left)
            dfs(n.right)

        dfs(root)
        xs[-1].right = None
        xs[-1].left = None
        for i in range(len(xs) - 1):
            xs[i].left = None
            xs[i].right = xs[i + 1]


tree = TreeNode.build_tree([1, 2, 5, 3, 4, None, 6])
Solution().flatten(tree)
print(tree)
