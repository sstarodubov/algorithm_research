# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    # time O(n), space O(h)
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        ldq = deque([root.left])
        rdq = deque([root.right])
        while ldq and rdq:
            lnode: TreeNode = ldq.popleft()
            rnode: TreeNode = rdq.popleft()

            if not lnode and not rnode:
                continue
            if not lnode:
                return False
            if not rnode:
                return False
            if lnode.val == rnode.val:
                ldq.append(lnode.right)
                ldq.append(lnode.left)
                rdq.append(rnode.left)
                rdq.append(rnode.right)
            else:
                return False
        return True


assert not Solution().isSymmetric(TreeNode.build_tree([1, 2, 3]))
assert not Solution().isSymmetric(TreeNode.build_tree([1, 2, 2, 2, None, 2]))
assert not Solution().isSymmetric(TreeNode.build_tree([1, 2, 2, None, 3, None, 3]))
assert Solution().isSymmetric(TreeNode.build_tree([1, 2, 2, 3, 4, 4, 3]))
print("tests passed")
