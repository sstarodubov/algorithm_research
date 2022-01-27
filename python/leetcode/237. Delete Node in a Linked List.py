from utils.ListNode import ListNode


class Solution:
    def deleteNode(self, node):
        prev = None
        cur = node
        while cur.next:
            tmp = cur.val
            cur.val = cur.next.val
            cur.next.val = tmp
            prev = cur
            cur = cur.next
            if not cur.next:
                prev.next = None


ll = ListNode.build([4, 5, 1, 9])

Solution().deleteNode(ll.next)

print(ll)
