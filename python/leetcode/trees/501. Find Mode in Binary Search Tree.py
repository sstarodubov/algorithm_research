from typing import List, Optional

from leetcode.tree_node import TreeNode

class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        self.m = 1
        self.k = 1
        self.p = TreeNode(-1)
        def dfs(cur, d = ""):
            if not cur:
                return

            dfs(cur.left, d)

            if self.p.val == cur.val:
                self.k += 1
                self.m = max(self.k, self.m)
            else:
                self.k = 1
            self.p = cur

            if d and self.k == self.m:
                ans.append(cur.val)

            dfs(cur.right, d)


        dfs(root)
        self.k = 1
        self.p = TreeNode(-1)

        dfs(root, "hello")
        return ans


assert [2, 6] == Solution().findMode(TreeNode.build_tree([6, 2, 8, 0, 4, 7, 9, None, None, 2, 6]))
Solution().findMode(TreeNode.build_tree([1, 0, 1, 0, 0, 1, 1, 0]))
Solution().findMode(TreeNode.build_tree([1, None, 2]))
Solution().findMode(TreeNode.build_tree([0]))
Solution().findMode(TreeNode.build_tree([1, None, 2, 2, 3, None, None, 3, None, None, 3]))
Solution().findMode(TreeNode.build_tree([1, None, 2, 2, 3, None, None, 3]))
Solution().findMode(TreeNode.build_tree([1, None, 2, 2]))
