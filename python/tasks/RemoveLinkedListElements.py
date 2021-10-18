from typing import Optional

from utils.ListNode import ListNode

"""
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has
Node.val == val, and return the new head.
"""


class Solution:

    # cpu O(n) ram O(1)
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        prev: Optional[ListNode] = None
        cur = head
        while cur is not None:
            if cur.val == val:
                if prev is None:
                    head = cur.next
                    cur = cur.next
                else:
                    prev.next = cur.next
                    cur = cur.next
            else:
                prev = cur
                cur = cur.next

        return head


s = Solution()

node2 = s.removeElements(ListNode.build([1, 2, 3]), 1)
node = s.removeElements(head=ListNode.build([1, 2, 6, 3, 4, 5, 6]), val=6)

assert node2.val == 2, 1
assert node2.next.val == 3, 1

assert node.val == 1
assert node.next.val == 2
assert node.next.next.val == 3
assert node.next.next.next.val == 4
assert node.next.next.next.next.val == 5

print("tests passed")
