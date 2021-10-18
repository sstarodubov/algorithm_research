from binarytree import Node
from binarytree import build

"""
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node 
of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. 
You can return any of them.
"""

TreeNode = Node


class Solution:

    # CPU O(log n) and RAM O(log n)
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        if root is None:
            return TreeNode(val)

        def insertHelper(curNode: TreeNode, parent: TreeNode = None):
            if curNode is not None:
                if val < curNode.val: return insertHelper(curNode.left, curNode)
                if val > curNode.val: return insertHelper(curNode.right, curNode)
                if val == curNode.val: return
            else:
                newNode = TreeNode(val)
                if val > parent.val:
                    parent.right = newNode
                elif val < parent.val:
                    parent.left = newNode
                return

        insertHelper(root)
        return root
