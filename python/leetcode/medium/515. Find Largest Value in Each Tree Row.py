from collections import deque
from typing import Optional, List

from leetcode.tree_node import TreeNode


class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        dq = deque([(0, root)])
        prev_d = 0
        ans = [float("-inf")]

        while dq:
            d, v = dq.popleft()

            if prev_d == d:
                ans[-1] = max(ans[-1], v.val)
            else:
                prev_d = d
                ans.append(v.val)

            if v.left:
                dq.append((d + 1, v.left))
            if v.right:
                dq.append((d + 1, v.right))

        return ans


assert Solution().largestValues(TreeNode.build_tree([1, 2, 3])) == [1, 3]
assert Solution().largestValues(TreeNode.build_tree([1, 3, 2, 5, 3, None, 9])) == [1, 3, 9]
