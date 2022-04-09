from collections import deque
from typing import List, Optional

from leetcode.tree_node import TreeNode


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        cur_depth, cur_node = 0, root
        xq = deque([(cur_depth, cur_node)])
        ans, cur_order = [], []
        while xq:
            d, n = xq.popleft()

            if d == cur_depth:
                cur_order.append(n.val)
            else:
                ans.append(cur_order)
                cur_order = []
                cur_order.append(n.val)
                cur_depth = d

            if n.left:
                xq.append((d + 1, n.left))
            if n.right:
                xq.append((d + 1, n.right))

        ans.append(cur_order)
        return ans


assert Solution().levelOrder(TreeNode.build_tree([3, 9, 20, None, None, 15, 7])) == [[3], [9, 20], [15, 7]]
