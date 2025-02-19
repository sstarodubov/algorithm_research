from collections import deque
from typing import Optional, List

from leetcode.tree_node import TreeNode


class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        if not root:
            return []

        dq = deque()
        avg, level, cur_sum, cur_count = [], 0, 0, 0
        dq.append((root, level))

        while dq:
           node, cur_level = dq.popleft()
           if cur_level == level:
               cur_sum += node.val
               cur_count += 1
           else:
               avg.append(cur_sum / cur_count)
               cur_count = 1
               cur_sum = node.val
               level += 1
           if node.left:
               dq.append((node.left, cur_level + 1))
           if node.right:
               dq.append((node.right , cur_level + 1))

        if cur_count != 0:
            avg.append(cur_sum / cur_count)
        return avg

print(Solution().averageOfLevels(TreeNode.build_tree([5,14,None,1])))