# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def to_num(self, arr) -> int:
        if not arr:
            return 0
        ret, p = 0, 0
        for i in range(len(arr) - 1, -1, -1):
            ret += arr[i] * pow(10, p)
            p += 1
        return ret

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.ret = 0

        def dfs(n: TreeNode, arr=[]):
            if not n:
                return
            arr.append(n.val)
            if not n.left and not n.right:
                self.ret += self.to_num(arr)
            else:
                dfs(n.left)
                dfs(n.right)
            arr.pop()

        dfs(root)
        return self.ret


node = TreeNode.build_tree([1, 2, 3])
assert 25 == Solution().sumNumbers(node)
assert 1026 == Solution().sumNumbers(TreeNode.build_tree([4, 9, 0, 5, 1]))
