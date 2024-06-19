from typing import Optional, List
from collections import deque

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        res = []
        prevp = (-1, TreeNode(-101))
        dq = deque()
        dq.append((0, root))

        while dq:
            dep, cur = dq.popleft()
            pdep, prev = prevp
            if dep != pdep and prev.val != -101:
                res.append(prev.val)
            prevp = (dep, cur)
            if cur.left:
                dq.append((dep + 1, cur.left))
            if cur.right:
                dq.append((dep + 1, cur.right))
        res.append(prevp[1].val)
        return res


print(Solution().rightSideView(TreeNode.build_tree([1, 2, 3, None, 5, None, 4])))
print(Solution().rightSideView(TreeNode.build_tree([1, None, 3])))
print(Solution().rightSideView(None))
