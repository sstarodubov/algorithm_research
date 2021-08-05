"""
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

"""
from utils.ListNode import ListNode


class Solution:

    # cpu O(n) and ram O(1)
    def middleNode(self, head: ListNode) -> ListNode:
        slow = fast = head
        while True:
            if not fast.next:
                return slow
            slow = slow.next
            if fast.next and not fast.next.next:
                return slow
            fast = fast.next.next


s = Solution()

assert ListNode(3) == s.middleNode(ListNode.build([1, 2, 3, 4, 5])), 2
assert ListNode(4) == s.middleNode(ListNode.build([1, 2, 3, 4, 5, 6])), 1
print("tests passed")
