from neetcode_all_course.leetcode import TreeNode


class Solution:
    def lowestCommonAncestor(self, node: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not node:
            return None
        if node.val == p.val:
            return p
        if node.val == q.val:
            return q
        lr = self.lowestCommonAncestor(node.left, p, q)
        rr = self.lowestCommonAncestor(node.right, p, q)
        if lr and rr:
            return node
        if lr:
            return lr
        if rr:
            return rr
        return None


assert Solution().lowestCommonAncestor(node=TreeNode.build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]), p=TreeNode(5),
                                       q=TreeNode(1)).val == 3

assert Solution().lowestCommonAncestor(node=TreeNode.build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]), p=TreeNode(4),
                                       q=TreeNode(6)).val == 5

print("tests passed")
