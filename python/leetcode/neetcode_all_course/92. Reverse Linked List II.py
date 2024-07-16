from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def reverse(self, n:ListNode):
        if not n:
            return n
        if not n.next :
            return n

        d = ListNode(-1)
        cur = n
        while cur:
            t = cur
            cur = cur.next
            t.next = d.next
            d.next = t

        return d.next

    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if not head:
            return None

        idx = 0
        d = ListNode(-1)
        d.next = head
        cur = d
        while cur:
            if idx == left - 1:
                begin = cur
            if idx == left:
                ll = cur
            if idx == right:
                rr = cur
                r = cur.next
            cur = cur.next
            idx += 1
        rr.next = None
        begin.next = None

        begin.next = self.reverse(ll)
        ll.next = r
        if begin == d:
            return begin.next
        return head


res = Solution().reverseBetween(head = ListNode.build([1,2,3,4,5]), left = 4, right = 5)

print(res)



