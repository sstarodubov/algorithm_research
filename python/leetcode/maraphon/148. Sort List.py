# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def merge(self, n1: ListNode, n2: ListNode) -> ListNode:
        if not n1: return n2
        if not n2: return n1

        dummy = ListNode(-1)
        ptr = dummy
        while n1 and n2:
            if n1.val <= n2.val:
                ptr.next = n1
                n1 = n1.next
            else:
                ptr.next = n2
                n2 = n2.next
            ptr = ptr.next

        while n1:
            ptr.next = n1
            ptr = ptr.next
            n1 = n1.next
        while n2:
            ptr.next = n2
            ptr = ptr.next
            n2 = n2.next

        return dummy.next

    def split(self, node: ListNode) -> (ListNode, ListNode):
        if not node: return None, None
        if not node.next: return node, None
        lt = node
        sl, fast = node, node
        while fast and fast.next and fast.next.next:
            fast = fast.next.next
            sl = sl.next
        rt = sl.next
        sl.next = None
        return lt, rt

    def sortList(self, node: Optional[ListNode]) -> Optional[ListNode]:
        if not node:
            return None
        if not node.next:
            return node

        l, r = self.split(node)
        lNode = self.sortList(l)
        rNode = self.sortList(r)
        return self.merge(lNode, rNode)


res = Solution().sortList(ListNode.build([4, 2, 1, 3]))

assert res.val == 1
assert res.next.val == 2
assert res.next.next.val == 3
assert res.next.next.next.val == 4
