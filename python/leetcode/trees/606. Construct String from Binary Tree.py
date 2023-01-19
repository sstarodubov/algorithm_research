from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def tree2str(self, root: Optional[TreeNode]) -> str:
        p = []

        def dfs(n: TreeNode):
            if not n:
                return

            if n != root:
                p.append("(")
            p.append(str(n.val))
            if n.left:
                dfs(n.left)
            else:
                if n.right:
                    p.append("()")
            dfs(n.right)

            if n != root:
                p.append(")")

        dfs(root)
        return "".join(p)


print(Solution().tree2str(TreeNode.build_tree([1, 2, 3, None, 4])))
print(Solution().tree2str(TreeNode.build_tree([1, 2, 3, 4])))
