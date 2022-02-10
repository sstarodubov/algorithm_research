from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def tree2str(self, root: Optional[TreeNode]) -> str:
        self.ans = []

        def dfs(node: TreeNode):
            if not node:
                return

            self.ans.append(f"{node.val}")

            if node.left and node.right:
                self.ans.append("(")
                dfs(node.left)
                self.ans.append(")(")
                dfs(node.right)
                self.ans.append(")")
            elif node.left and not node.right:
                self.ans.append("(")
                dfs(node.left)
                self.ans.append(")")
            elif not node.left and node.right:
                self.ans.append("()(")
                dfs(node.right)
                self.ans.append(")")
            else:
                return


        dfs(root)


        return "".join(self.ans)


assert Solution().tree2str(TreeNode.build_tree([1, 2, 3, 4])) == "1(2(4))(3)"
assert Solution().tree2str(TreeNode.build_tree([1, 2, 3, None, 4])) == "1(2()(4))(3)"
