from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        cur = head
        while cur:
            tmp = cur
            cur = cur.next
            nxt = dummy.next
            tmp.next = nxt
            dummy.next = tmp
        return dummy.next

    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if not head:
            return None

        dummy, cur, lp, idx = ListNode(0), head, head, 1
        dummy.next = head
        prev, idx = dummy, 1
        m, r = None, None
        while cur:
            if idx == left == right:
                prev.next = None
                m = cur
                r = cur.next
                m.next = None
                break
            elif idx == left:
                prev.next = None
                m = cur
            elif idx == right:
                r = cur.next
                cur.next = None
                break
            prev = cur
            cur = cur.next
            idx += 1
        l = dummy.next

        reversed = self.reverseList(m)

        cur = l
        if l:
            while cur.next:
                cur = cur.next
            cur.next = reversed
        cur = reversed
        while cur.next:
            cur = cur.next
        cur.next = r
        if not l:
            return reversed
        return l


Solution().reverseBetween(ListNode.build([1, 2, 3]), 3, 3)
Solution().reverseBetween(ListNode.build([3, 5]), 1, 1)
Solution().reverseBetween(ListNode.build([5]), 1, 1)
Solution().reverseBetween(ListNode.build([1, 2, 3, 4, 5]), 2, 4)
