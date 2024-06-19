from collections import deque
from typing import Optional, List

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.roots = deque(preorder)

        def merge(itree: List[int]) -> Optional[TreeNode]:
            if not itree:
                return None
            if self.roots[0] in itree:
                idx = itree.index(self.roots[0])
                self.roots.popleft()
                if len(itree) == 1:
                    return TreeNode(itree[0])
                node = TreeNode(itree[idx])
                ltree = itree[:idx]
                rtree = itree[idx + 1:]
                node.left = merge(ltree)
                node.right = merge(rtree)
                return node
            else:
                return None

        ans = merge(inorder)

        return ans


xn = Solution().buildTree(preorder=[3, 9, 20, 15, 7], inorder=[9, 3, 15, 20, 7])
xxn = Solution().buildTree(preorder=[1, 2, 4, 5, 3, 6, 7], inorder=[4, 2, 5, 1, 6, 3, 7])
