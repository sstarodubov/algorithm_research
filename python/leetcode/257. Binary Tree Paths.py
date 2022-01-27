from typing import List, Optional

from leetcode.tree_node import TreeNode


class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        self.paths = []

        def dfs(node: TreeNode, cur_path):
            if not node:
                return
            if not node.left and not node.right:
                cur_path += str(node.val)
                self.paths.append(cur_path)
                return

            cur_path += f"{node.val}->"
            dfs(node.left, cur_path)
            dfs(node.right, cur_path)

        dfs(root, "")
        return self.paths


Solution().binaryTreePaths(TreeNode.build_tree([1, 2, 3, None, 5]))
