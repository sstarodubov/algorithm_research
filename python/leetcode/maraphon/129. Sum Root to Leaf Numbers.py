# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.ret = 0

        def dfs(n: TreeNode, cur_val=0, d=0):
            if not n:
                return
            new_val = (cur_val * 10) + n.val
            if not n.left and not n.right:
                self.ret += new_val
            else:
                dfs(n.left, new_val)
                dfs(n.right, new_val)

        dfs(root)
        return self.ret


assert 1026 == Solution().sumNumbers(TreeNode.build_tree([4, 9, 0, 5, 1]))
node = TreeNode.build_tree([1, 2, 3])
assert 25 == Solution().sumNumbers(node)
