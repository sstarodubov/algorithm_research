from typing import Optional, Set, List

from leetcode.tree_node import TreeNode


class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        def dfs(node: TreeNode, arr: List[TreeNode]):
            if not node:
                return
            dfs(node.left, arr)
            arr.append(node)
            dfs(node.right, arr)

        arr = []
        dfs(root, arr)

        xs = None
        for i in range(len(arr)):
            if arr[i].val > arr[i + 1].val:
                xs = arr[i]
                break

        ys = None
        for i in range(len(arr) - 1, -1, -1):
            if arr[i].val < arr[i - 1].val:
                ys = arr[i]
                break

        ys.val , xs.val = xs.val, ys.val

xxt = TreeNode.build_tree([3, 1, 2])

Solution().recoverTree(xxt)

print(xxt)
