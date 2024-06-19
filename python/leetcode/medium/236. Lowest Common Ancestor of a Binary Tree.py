from neetcode_all_course.leetcode import TreeNode


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        def build_path(target: TreeNode, path, node: TreeNode = root):
            if self.found: return

            if not node: return

            path.append(node)

            if node.val == target.val:
                self.found = True
                if not self.qp:
                    self.qp = path[:]
                else:
                    self.pp = path[:]
                return

            if node.left:
                build_path(target, path, node.left)
            if node.right:
                build_path(target, path, node.right)
            path.pop()

        self.pp, self.qp = [], []

        self.found = False
        build_path(q, [], root)

        self.found = False
        build_path(p, [], root)

        if len(self.qp) > len(self.pp):
            while len(self.qp) != len(self.pp):
                self.qp.pop()
        elif len(self.pp) > len(self.qp):
            while len(self.qp) != len(self.pp):
                self.pp.pop()

        while self.qp[-1].val != self.pp[-1].val:
            self.qp.pop()
            self.pp.pop()

        return self.qp[-1]


assert 5 == Solution().lowestCommonAncestor(root=TreeNode.build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]),
                                            p=TreeNode(5),
                                            q=TreeNode(4)).val

assert 3 == Solution().lowestCommonAncestor(root=TreeNode.build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]),
                                            p=TreeNode(5),
                                            q=TreeNode(1)).val
assert 1 == Solution().lowestCommonAncestor(root=TreeNode.build_tree([1, 2]), p=TreeNode(1), q=TreeNode(2)).val
