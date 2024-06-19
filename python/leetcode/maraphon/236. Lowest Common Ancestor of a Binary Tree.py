from neetcode_all_course.leetcode import TreeNode


class Solution:

    def path(self, n, arr, t):
        if not n:
            return False
        arr.append(n)
        if n == t:
            return True
        f = self.path(n.left, arr, t)
        h = False
        if not f:
            h = self.path(n.right, arr, t)
        if not h and not f:
            arr.pop()
        return h or f

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or not p or not q:
            return None

        pp, qp = [], []

        self.path(root, pp, p)
        self.path(root, qp, q)

        i = 0
        while i < len(pp) and i < len(qp):
            if pp[i] != qp[i]:
                return pp[i - 1]
            i += 1

        return pp[i - 1]


ans = Solution().lowestCommonAncestor(TreeNode.build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]), TreeNode(5),
                                      TreeNode(4))
print(ans.val)
