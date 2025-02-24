from collections import deque
from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        dq, d = deque(), 0
        dq.append((root, d, None))
        x_info, y_info = None, None
        while dq:
            cur_node, cur_depth, parent = dq.popleft()

            if cur_node.val == x:
                x_info = (cur_node, cur_depth, parent)
            if cur_node.val == y:
                y_info = (cur_node, cur_depth, parent)

            if x_info and y_info:
                return x_info[1] == y_info[1] and x_info[2] != y_info[2]

            if cur_node.left:
                dq.append((cur_node.left, cur_depth + 1, cur_node))
            if cur_node.right:
                dq.append((cur_node.right, cur_depth + 1, cur_node))

        return False