from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root:
            return

        arr = []
        def dfs(n: TreeNode):
            if not n:
                return
            arr.append(n)
            dfs(n.left)
            dfs(n.right)

        dfs(root)
        for i, n in enumerate(arr):
            if i == 0:
                continue
            arr[i - 1].left = None
            arr[i - 1].right = n

        arr[-1].left = None
        arr[-1].right = None




Solution().flatten(TreeNode.build_tree([1, 2, 5, 3, 4, None, 6]))
