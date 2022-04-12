from typing import Optional, List

from tree_node import TreeNode


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        def merge(itree: List[int]) -> Optional[TreeNode]:
            if not itree:
                return None
            if postorder[-1] in itree:
                idx = itree.index(postorder.pop())
                if len(itree) == 1:
                    return TreeNode(itree[idx])
                rtree = itree[idx + 1:]
                ltree = itree[:idx]

                rn = merge(rtree)
                ln = merge(ltree)

                node = TreeNode(itree[idx])
                node.left = ln
                node.right = rn

                return node

            else:
                return None

        ans = merge(inorder)

        return ans


print([i for i, x in enumerate([1, 2, 3, 2]) if x == 2])

xn = Solution().buildTree(inorder=[9, 3, 15, 20, 7], postorder=[9, 15, 7, 20, 3])
