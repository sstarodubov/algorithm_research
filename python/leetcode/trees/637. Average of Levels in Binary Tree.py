from collections import defaultdict
from typing import List, Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:

        m = defaultdict(lambda: [0, 0])

        def dfs(n: TreeNode, d: int):
            if not n:
                return
            m[d][0] += n.val
            m[d][1] += 1
            dfs(n.left, d + 1)
            dfs(n.right, d + 1)
        dfs(root, 0)
        a = [0] * len(m)
        for k in m:
            a[k] = m[k][0] / m[k][1]

        return a


print(Solution().averageOfLevels(TreeNode.build_tree([3, 9, 20, None, None, 15, 7])))
