from collections import deque
from typing import List, Optional

from leetcode.tree_node import TreeNode


class Solution:

    # cpu O(nodes) and ram O(log depth)
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        modes = []
        mx = {}
        maximum = 0
        queue = deque()
        queue.append(root)

        while queue:
            cur: TreeNode = queue.popleft()
            cur_amount = mx.get(cur.val, 0)
            mx[cur.val] = cur_amount + 1
            maximum = max(maximum, mx[cur.val])

            if cur.left:
                queue.append(cur.left)
            if cur.right:
                queue.append(cur.right)
        for k in mx:
            if mx[k] == maximum:
                modes.append(k)
        return modes


assert Solution().findMode(TreeNode.build_tree([0])) == [0]
assert Solution().findMode(TreeNode.build_tree([1, None, 2, 2])) == [2]
print("tests passed")
