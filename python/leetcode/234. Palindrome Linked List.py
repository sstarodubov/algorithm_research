# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional

from utils.ListNode import ListNode


class Solution:

    # time O(n), space O(1)
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        S = 0
        if not head.next:
            return True
        while fast and fast.next:
            slow = slow.next
            if fast.next:
                S += 1
                if fast.next.next:
                    S += 1
            fast = fast.next.next

        dummy = ListNode(-1)
        if slow and slow.next is None:
            return head.val == slow.val
        if S & 1 == 0 and slow:
            slow = slow.next

        cur = slow

        while cur:
            nxt = cur.next
            tmp = dummy.next
            dummy.next = cur
            cur.next = tmp
            cur = nxt

        left = head
        right = dummy.next
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next

        return True


assert not Solution().isPalindrome(ListNode.build([1, 1, 2, 1]))
assert not Solution().isPalindrome(ListNode.build([1, 0, 3, 4, 0, 1]))
assert not Solution().isPalindrome(ListNode.build([1, 2]))
assert Solution().isPalindrome(ListNode.build([1, 2, 2, 1]))
assert not Solution().isPalindrome(ListNode.build([1, 0, 0]))
assert Solution().isPalindrome(ListNode.build([0, 0]))
assert Solution().isPalindrome(ListNode.build([1, 0, 1]))
assert Solution().isPalindrome(ListNode.build(
    [0, 4, 8, 2, 0, 5, 0, 1, 6, 3, 0, 9, 0, 6, 5, 3, 4, 2, 7, 3, 8, 8, 1, 0, 6, 0, 1, 0, 4, 0, 6, 3, 2, 6, 0, 2, 0, 9,
     0, 5, 5, 5, 7, 9, 7, 7, 0, 6, 2, 8, 0, 6, 7, 4, 1, 7, 5, 0, 8, 1, 2, 3, 9, 1, 5, 9, 8, 3, 9, 2, 0, 0, 4, 0, 2, 8,
     7, 4, 9, 6, 8, 9, 3, 8, 8, 3, 9, 8, 6, 9, 4, 7, 8, 2, 0, 4, 0, 0, 2, 9, 3, 8, 9, 5, 1, 9, 3, 2, 1, 8, 0, 5, 7, 1,
     4, 7, 6, 0, 8, 2, 6, 0, 7, 7, 9, 7, 5, 5, 5, 0, 9, 0, 2, 0, 6, 2, 3, 6, 0, 4, 0, 1, 0, 6, 0, 1, 8, 8, 3, 7, 2, 4,
     3, 5, 6, 0, 9, 0, 3, 6, 1, 0, 5, 0, 2, 8, 4, 0]))
assert not Solution().isPalindrome(ListNode.build([1, 2, 3]))
