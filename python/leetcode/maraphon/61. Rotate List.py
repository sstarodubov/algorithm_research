from typing import Optional

from utils.ListNode import ListNode


class Solution:

    def len(self, node: ListNode) -> int:
        cur, L = node, 0
        while cur:
            cur = cur.next
            L += 1
        return L

    def rotate(self, node: ListNode) -> ListNode:
        dummy = ListNode(-1)
        cur = node

        while cur:
            p = cur
            cur = cur.next
            dn = dummy.next
            dummy.next = p
            p.next = dn

        return dummy.next

    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:
            return head

        L = self.len(head)
        k = k % L
        if k == 0 or k == L:
            return head
        rh = self.rotate(head)
        dummy = ListNode(-1)
        dummy.next = rh

        cur = rh
        while cur:
            if not cur.next:
                tail = cur
            cur = cur.next

        while k > 0:
            n = dummy.next
            dummy.next = n.next
            n.next = None
            tail.next = n
            tail = tail.next
            k -= 1

        ans = self.rotate(dummy.next)
        return ans


assert Solution().rotateRight(ListNode.build([1, 2, 3, 4, 5]), 2)
