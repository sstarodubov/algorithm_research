from collections import deque
from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def connect(self, root: 'Optional[TreeNode]') -> 'Optional[TreeNode]':
        if not root:
            return None
        dq = deque([(0, root)])
        xs = []
        while dq:
            t = dq.popleft()
            xs.append(t)
            d, n = t
            if n.left:
                dq.append((d + 1, n.left))
            if n.right:
                dq.append((d + 1, n.right))

        for i in range(1, len(xs)):
            prev_d, prev_n = xs[i - 1]
            cur_d, cur_n = xs[i]

            if prev_d == cur_d:
                prev_n.next = cur_n

        return root


Solution().connect(TreeNode.build_tree([1, 2, 3, 4, 5, 6, 7]))
