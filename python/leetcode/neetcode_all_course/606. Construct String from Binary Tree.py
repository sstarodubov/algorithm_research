# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from tree_node import TreeNode


class Solution:
    def tree2str(self, root: Optional[TreeNode]) -> str:
        self.ret = ""

        def dfs(n: TreeNode):
            if not n:
                return ""
            if not n.left and not n.right:
                return f"{n.val}"

            s = f"{n.val}"

            l = dfs(n.left)
            r = dfs(n.right)

            if l and r:
                s += f"({l})({r})"
            elif l and not r:
                s += f"({l})"
            elif r and not l:
                s += f"()({r})"

            return s

        return dfs(root)


assert Solution().tree2str(TreeNode.build_tree([1, 2, 3, 4])) == "1(2(4))(3)"
assert Solution().tree2str(TreeNode.build_tree([1, 2, 3, None, 4])) == "1(2()(4))(3)"
