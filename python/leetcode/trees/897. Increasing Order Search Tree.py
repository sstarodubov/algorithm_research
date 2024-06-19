from neetcode_all_course.leetcode import TreeNode


class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        self.prev = None
        self.ans = None

        def dfs(n: TreeNode):
            if not n:
                return

            dfs(n.left)
            if self.prev is None:
                self.prev = n
                self.ans = n
            else:
                self.prev.left = None
                self.prev.right = n
                self.prev = n

            dfs(n.right)

        dfs(root)
        self.prev.left = None
        return self.ans


reulst = Solution().increasingBST(TreeNode.build_tree([2, 1, 4, None, None, 3]))
print(reulst)
