from typing import List, Optional

from leetcode.tree_node import TreeNode


class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        ans = []

        def dfs(n: TreeNode, p):
            if not n:
                return
            p.append(str(n.val))
            if not n.left and not n.right:
                ans.append("->".join(p))
                return
            if n.left:
                dfs(n.left, p)
                p.pop()
            if n.right:
                dfs(n.right, p)
                p.pop()
        p = []
        dfs(root, p)
        return ans


print(Solution().binaryTreePaths(root=TreeNode.build_tree([1, 2, 3, None, 5])))
