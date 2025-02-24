from leetcode.tree_node import TreeNode


class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        self.target = target
        self.result = None

        def dfs(origin, cloned):
            if not origin or self.result:
                return

            if origin.val == target.val:
                self.result = cloned
                return
            dfs(origin.left, cloned.left)
            dfs(origin.right, cloned.right)

        dfs(original, cloned)
        return self.result
