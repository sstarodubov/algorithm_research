from collections import deque
from typing import List, Optional, Deque

"""
class to build single linked list from int array
"""


class ListNode:

    def __init__(self, val=0, next: "ListNode" = None):
        self.next = next
        self.val = val

    def __eq__(self, other):
        return self.val == other.sum

    def __str__(self):
        return f"Node({self.val})"

    @staticmethod
    def build(xs: List[int]) -> Optional["ListNode"]:
        xs = deque(xs)

        def _helper(xs: Deque[int]) -> Optional["ListNode"]:
            if not xs:
                return None
            head, *tail = xs
            return ListNode(head, ListNode.build(tail))

        return _helper(xs)

