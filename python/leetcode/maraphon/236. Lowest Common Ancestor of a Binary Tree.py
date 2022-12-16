from leetcode.tree_node import TreeNode


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or not p or not q:
            return None

        def path(n, arr, t):
            if not n:
                return False
            arr.append(n)
            if n == t:
                return True
            f = path(n.left, arr, t)
            h = False
            if not f:
                h = path(n.right, arr, t)
            if not h and not f:
                arr.pop()
            return h or f

        pp = []
        path(root, pp, p)

        qp = []
        path(root, qp, q)

        i = 0
        while i < len(pp) and i < len(qp):
            if pp[i] != qp[i]:
                return pp[i - 1]
            i += 1

        if i == 0:
            return None

        return pp[i - 1]


ans = Solution().lowestCommonAncestor(TreeNode.build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]), TreeNode(5),
                                      TreeNode(4))
print(ans.val)
