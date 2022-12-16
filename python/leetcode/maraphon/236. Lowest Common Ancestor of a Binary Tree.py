from leetcode.tree_node import TreeNode


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or not p or not q:
            return None

        self.found: bool
        self.t: TreeNode

        def upd(n):
            self.found = False
            self.t = n

        def path(n, arr):
            if self.found:
                return
            if not n:
                return

            arr.append(n)
            if n == self.t:
                self.found = True
                return

            if not self.found:
                path(n.left, arr)
            if not self.found:
                path(n.right, arr)

            if not self.found:
                arr.pop()

        upd(p)
        pp = []
        path(root, pp)

        qp = []
        upd(q)
        path(root, qp)

        i = 0

        while i < len(pp) and i < len(qp):
            if pp[i] != qp[i]:
                return pp[i - 1]
            i += 1

        if i == 0:
            return None

        return pp[i - 1]


ans = Solution().lowestCommonAncestor(TreeNode.build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]), TreeNode(5), TreeNode(4))
print(ans.val)
