from typing import List, Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        ans = []

        def dfs(path: List[int], node: TreeNode):
            if not node:
                return
            path.append(node.val)
            if not node.left and not node.right:
                if sum(path) == targetSum:
                    ans.append(path[:])
                path.pop()
                return

            dfs(path, node.left)
            dfs(path, node.right)
            path.pop()
        dfs([], root)

        return ans


Solution().pathSum(root=TreeNode.build_tree([5, 4, 8, 11, None, 13, 4, 7, 2, None, None, 5, 1]), targetSum=22)
