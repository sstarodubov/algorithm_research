from neetcode_all_course.leetcode import TreeNode


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val <= root.val <= q.val:
            return root
        if q.val <= root.val <= p.val:
            return root

        if q.val < root.val and p.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        if q.val > root.val and p.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)


assert Solution().lowestCommonAncestor(root=TreeNode.build_tree([6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]), p=TreeNode(2),
                                       q=TreeNode(8)).val == 6
print("Tests passed")
