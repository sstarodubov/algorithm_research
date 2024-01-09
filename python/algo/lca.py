from typing import Optional

from leetcode.tree_node import TreeNode

tree = TreeNode.build_tree([3, 6, 8, 2, 4, None, 13, None, None, 9, 5, 7])


def lca(node: Optional[TreeNode], n1: int, n2: int) -> Optional[TreeNode]:
    if not node: return None
    if node.val == n1 or node.val == n2: return node
    left: Optional[TreeNode] = lca(node.left, n1, n2)
    right: Optional[TreeNode] = lca(node.right, n1, n2)
    if left and right: return node
    if not left and not right: return None
    return right if right else left


print(lca(tree, 9, 5).val)
