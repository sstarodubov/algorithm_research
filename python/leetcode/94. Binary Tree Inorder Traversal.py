from typing import Optional, List

from neetcode_all_course.leetcode import TreeNode


class Solution:

    # ram (log n) and cpu O(n)
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        if not root:
            return ans

        def helper(node: TreeNode, arr):
            match node:
                case None:
                    pass
                case _:
                    helper(node.left, arr)
                    arr.append(node.val)
                    helper(node.right, arr)

        helper(root, ans)
        return ans


assert Solution().inorderTraversal(TreeNode.build_tree([1, None, 2, 3])) == [1, 3, 2]

print("tests passed")
