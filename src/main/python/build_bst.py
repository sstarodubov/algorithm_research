from binarytree import Node
from binarytree import build

# Дано бинарное дерево
#         ____10__
#        /        \
#     __5___       15
#    /      \     / \
#   2       6    13  22
#  /             / \
# 1             12  14
# вставка, поиск и удаление нод
nodes = [10, 5, 15, 2, 6, 13, 22, 1, None, None, None, 12, 14]

# Building the tree
tree: Node = build(nodes)
print('Binary tree from list :\n', tree)


def insert_node(node: Node, cur_node: Node):
    if node.value >= cur_node.value:
        if cur_node.right is None:
            cur_node.right = node
            return Node
        return insert_node(node, cur_node.right)

    if node.value < cur_node.value:
        if cur_node.left is None:
            cur_node.left = node
            return Node
        return insert_node(node, cur_node.left)


def search_node(node: Node, tree: Node):
    if tree is None: return None
    if node.value == tree.value:
        return node
    if node.value > tree.value:
        return search_node(node, tree.right)
    return search_node(node, tree.left)


def delete_node(remove_node: Node, tree_node: Node):
    if tree_node is None: return None
    if tree_node.value == remove_node.value and tree_node.right is not None and tree_node.left is not None:
        min_node: Node = find_min_node(tree_node.right)
        tmp = min_node.value
        delete_node(min_node, tree_node.right)
        tree_node.value = tmp
        return tree_node
    if remove_node.value == tree_node.value and tree_node.left is None and tree_node.right is None:
        parent: Node = find_parent(tree, tree_node)
        if parent.left is not None and parent.left.value == tree_node.value:
            parent.left = None
            return remove_node
        if parent.right is not None and parent.right.value == tree_node.value:
            parent.right = None
            return remove_node
    if remove_node.value == tree_node.value and tree_node.left is not None:
        tmp = tree_node.left.value
        tree_node.value = tmp
        tree_node.left = None
        return remove_node
    if remove_node.value == tree_node.value and tree_node.right is not None:
        tmp = tree_node.right.value
        tree_node.value = tmp
        tree_node.right = None
        return remove_node
    if remove_node.value > tree_node.value:
        return delete_node(remove_node, tree_node.right)
    return delete_node(remove_node, tree_node.left)


def find_min_node(cur_node: Node):
    if cur_node.left is None:
        return cur_node
    return find_min_node(cur_node.left)


def find_parent(cur_node: Node, find_parent_node: Node):
    if cur_node is None:
        return None
    if cur_node is not None and cur_node.left is not None and cur_node.left.value == find_parent_node.value:
        return cur_node
    if cur_node is not None and cur_node.right is not None and cur_node.right.value == find_parent_node.value:
        return cur_node
    if cur_node.value < find_parent_node.value:
        return find_parent(cur_node.right, find_parent_node)
    return find_parent(cur_node.left, find_parent_node)
