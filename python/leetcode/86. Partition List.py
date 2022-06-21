from utils.ListNode import ListNode


class Solution(object):

    def partition(self, head, x):
        head_lp = lp = ListNode(0)
        head_gp = gp = ListNode(0)

        cur = head

        while cur:
            if cur.val < x:
                lp.next = cur
                lp = cur
            else:
                gp.next = cur
                gp = cur

            cur = cur.next
        gp.next = None
        lp.next = head_gp.next


        ans = head_lp.next
        return ans




Solution().partition(ListNode.build([1, 4, 3, 2, 5, 2]), 3)
