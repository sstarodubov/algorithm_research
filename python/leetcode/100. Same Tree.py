# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    # time O(n) - node amount, space O(h) h - tree height
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        pq = deque([p])
        qq = deque([q])

        while pq and qq:
            p_node: TreeNode = pq.popleft()
            q_node: TreeNode = qq.popleft()
            if not p_node and not q_node:
                continue
            if not p_node:
                return False
            if not q_node:
                return False
            if p_node.val == q_node.val:
                pq.append(p_node.left)
                qq.append(q_node.left)
                pq.append(p_node.right)
                qq.append(q_node.right)
            else:
                return False
        return True


assert Solution().isSameTree(TreeNode.build_tree([1, 2, 3]), TreeNode.build_tree([1, 2, 3]))
assert not Solution().isSameTree(TreeNode.build_tree([1, 2, 3]), TreeNode.build_tree([1, 2, 1]))
print("tests passed")
