from binarytree import Node
numbers = [1, 2, 5, 7, 10, 13, 14, 15, 22]

# time O(n) Space O(n)
def build_bst(arr: [int]):
    if not arr:
        return None
    if len(arr) == 1:
        return Node(arr[0])

    if len(arr) == 2:
        tmp_root = Node(arr[0])
        tmp_root.right = Node(arr[1])
        return tmp_root
    else:
        root_idx = len(arr) // 2
        root = Node(arr[root_idx])
        left_arr = arr[: root_idx ]
        right_arr = arr[root_idx + 1:]
        l_node = build_bst(left_arr)
        r_node = build_bst(right_arr)
        root.left = l_node
        root.right = r_node
        return root

