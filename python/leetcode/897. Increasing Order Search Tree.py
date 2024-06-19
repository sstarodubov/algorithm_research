from neetcode_all_course.leetcode import TreeNode


class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        def dfs(node: TreeNode, arr):
            if not node:
                return arr

            dfs(node.left, arr)
            arr.append(node)
            dfs(node.right, arr)
            return arr

        arr = dfs(root, [])

        for i in range(1, len(arr)):
            prev, cur = arr[i - 1], arr[i]
            prev.left = None
            prev.right = cur
            if i == len(arr) - 1:
                cur.left = None
                cur.right = None

        return arr[0]


Solution().increasingBST(TreeNode.build_tree([2, 1, 4, None, None, 3]))
Solution().increasingBST(TreeNode.build_tree([5, 3, 6, 2, 4, None, 8, 1, None, None, None, 7, 9]))
