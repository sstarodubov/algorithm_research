from collections import deque
from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def isCousins(self, node: Optional[TreeNode], x: int, y: int) -> bool:
        xd, yd, xp, yp = -1, -2, None, None
        dq = deque()
        dq.append((node, 0, None))

        while dq:
            if xd != -1 and yd != -2:
                break
            cur_n, cur_d, cur_p = dq.popleft()
            if cur_n.val == x:
                xp = cur_p
                xd = cur_d
            if cur_n.val == y:
                yd = cur_d
                yp = cur_p

            if cur_n.left:
                dq.append((cur_n.left, cur_d + 1, cur_n))
            if cur_n.right:
                dq.append((cur_n.right, cur_d + 1, cur_n))

        return yd == xd and xp != yp


assert not Solution().isCousins(TreeNode.build_tree([1, 2, 3, None, 4]), 2, 3)
assert Solution().isCousins(TreeNode.build_tree([1, 2, 3, None, 4, None, 5]), 5, 4)
assert not Solution().isCousins(TreeNode.build_tree([1, 2, 3, 4]), 4, 3)
