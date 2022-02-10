from collections import deque, defaultdict
from typing import List, Optional

from leetcode.tree_node import TreeNode


class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        deq = deque([])
        mp = defaultdict(lambda: [0, 0])
        deq.append((root, 1))
        while deq:
            node, depth = deq.popleft()

            mp[depth][0] += node.val
            mp[depth][1] += 1

            if node.left:
                deq.append((node.left, depth + 1))
            if node.right:
                deq.append((node.right, depth + 1))
        ans = [0] * len(mp.keys())
        for i in range(len(mp.keys())):
            ans[i] = mp[i + 1][0] / mp[i + 1][1]

        return ans


assert Solution().averageOfLevels(TreeNode.build_tree([3, 9, 20, None, None, 15, 7])) == [3.00000, 14.50000, 11.00000]
