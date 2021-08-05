"""
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.next = next
        self.val = val

    def __eq__(self, other):
        return self.val == other.val

    def __str__(self):
        return f"Node({self.val})"


class Solution:

    #cpu O(n) and ram O(1)
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

node = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))

assert ListNode(3) == s.middleNode(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))), 2
assert ListNode(4) == s.middleNode(node), 1
print("tests passed")
