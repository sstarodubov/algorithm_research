from collections import deque
from typing import List, Optional

from leetcode.tree_node import TreeNode


class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        dq = deque()
        dq.append((0, root))
        paths = deque()
        cur_depth = 0
        while dq:
            depth, node = dq.popleft()
            paths.appendleft((depth, node))
            cur_depth = depth
            if node.left:
                dq.append((depth + 1, node.left))
            if node.right:
                dq.append((depth + 1, node.right))

        ans, arr = [], []
        for depth, node in paths:
            if cur_depth == depth:
                arr.append(node.val)
            else:
                cur_depth -= 1
                arr.reverse()
                ans.append(arr)
                arr = [node.val]

        ans.append(arr)

        return ans


Solution().levelOrderBottom(TreeNode.build_tree([3, 9, 20, None, None, 15, 7]))
