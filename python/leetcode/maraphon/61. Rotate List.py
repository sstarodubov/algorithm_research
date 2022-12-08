from typing import Optional

from utils.ListNode import ListNode


class Solution:

    def len(self, node: ListNode) -> int:
        cur, L = node, 0
        while cur:
            cur = cur.next
            L += 1
        return L

    def rotate(self, node: ListNode) -> [ListNode, ListNode]:
        dummy = ListNode(-1)
        cur, tail = node, node

        while cur:
            p = cur
            cur = cur.next
            dn = dummy.next
            dummy.next = p
            p.next = dn

        return dummy.next, tail

    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:
            return head

        L = self.len(head)
        k = k % L
        if k == 0 or k == L:
            return head
        rh, tail = self.rotate(head)
        dummy = ListNode(-1)
        dummy.next = rh

        while k > 0:
            n = dummy.next
            dummy.next = n.next
            n.next = None
            tail.next = n
            tail = tail.next
            k -= 1

        ans, tail = self.rotate(dummy.next)
        return ans
