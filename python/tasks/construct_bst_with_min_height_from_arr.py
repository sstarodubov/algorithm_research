from binarytree import Node

numbers = [1, 2, 5, 7, 10, 13, 14, 15, 22]


# time O(n) Space O(n)
def build_bst(arr: [int]):
    if not arr:
        return None
    if len(arr) == 1:
        return Node(arr[0])
    else:
        root_idx = len(arr) // 2
        root = Node(arr[root_idx])
        left_arr = arr[: root_idx]
        right_arr = arr[root_idx + 1:]
        root.left = build_bst(left_arr)
        root.right = build_bst(right_arr)
        return root

# time O(n) Space O(n)
def min_height_bst_helper(array, start_idx, end_idx):
    if end_idx < start_idx:
        return None
    mid_idx = (start_idx + end_idx) // 2
    node = Node(array[mid_idx])
    node.left = min_height_bst_helper(array, start_idx, mid_idx - 1)
    node.right = min_height_bst_helper(array, mid_idx + 1, end_idx)
    return node


def min_height_bst(array):
    return min_height_bst_helper(array, 0, len(array) - 1)
