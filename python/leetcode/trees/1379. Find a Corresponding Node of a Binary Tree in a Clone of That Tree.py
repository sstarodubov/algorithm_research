from leetcode.tree_node import TreeNode


class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        self.ans = None

        def dfs(n: TreeNode):
            if not n: return

            if target.val == n.val:
                self.ans = n
            dfs(n.left)
            dfs(n.right)

        dfs(cloned)

        return self.ans
