from typing import List


class Node:
    def __init__(self, val: int, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return f"Node({self.val})"


def build_linked_list(values: [int]) -> Node:
    head: Node = Node(values[0])
    cur: Node = head

    for v in range(1, len(values)):
        new_node = Node(values[v])
        cur.next = new_node
        cur = new_node

    return head


def shift_left(arr: List[int], k: int) -> List[int]:
    match k:
        case k if k <= 0 or k >= len(arr):
            return arr
        case _:
            head, *tail = arr
            tail.append(head)
            return shift_left(tail, k - 1)


def reverse_linked_list_boring_version(head: Node) -> Node:
    dummy_head = Node(-1, None)
    cur_node = head

    while cur_node:
        child = dummy_head.next
        next_node = cur_node.next
        cur_node.next = child
        dummy_head.next = cur_node
        cur_node = next_node

    return dummy_head.next


def reverse_linked_list_funny_version(cur_node: Node, dummy_head: Node = Node(-1)) -> Node:
    match cur_node:
        case None:
            return dummy_head.next
        case Node(val=_, next=next_node):
            child = dummy_head.next
            cur_node.next = child
            dummy_head.next = cur_node
            return reverse_linked_list_funny_version(next_node, dummy_head)
