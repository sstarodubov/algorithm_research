# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.ans = []

        def dfs(n):
            if not n:
                return
            dfs(n.left)
            self.ans.append(n.val)
            dfs(n.right)

            self.ans

        dfs(root)
        return self.ans