from collections import deque
from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def connect(self, root: 'Optional[TreeNode]') -> 'Optional[TreeNode]':
        if not root:
            return None
        dq = deque([(0, root)])
        prev = (-1, None)
        while dq:
            t = dq.popleft()

            d, n = t
            prev_d, prev_n = prev
            if prev_d == d:
                prev_n.next = n
            prev = t
            if n.left:
                dq.append((d + 1, n.left))
            if n.right:
                dq.append((d + 1, n.right))

        return root


Solution().connect(TreeNode.build_tree([1, 2, 3, 4, 5, 6, 7]))
