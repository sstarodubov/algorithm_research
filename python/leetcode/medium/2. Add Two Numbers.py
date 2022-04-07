from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        def list_to_num(xn: ListNode):
            p, cur, num = 0, xn, 0
            while cur:
                num += cur.val * (10 ** p)
                cur = cur.next
                p += 1
            return num

        n1 = list_to_num(l1)
        n2 = list_to_num(l2)
        r = n1 + n2

        if r == 0:
            return ListNode(0)
        dummy = ListNode(-1)
        cur = dummy
        while r:
            lv = r % 10
            cur.next = ListNode(lv)
            r = r // 10
            cur = cur.next

        return dummy.next


Solution().addTwoNumbers(ListNode.build([0]), ListNode.build([0]))
Solution().addTwoNumbers(l1=ListNode.build([2, 4, 3]), l2=ListNode.build([5, 6, 4]))
