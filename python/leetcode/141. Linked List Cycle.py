from typing import Optional

from utils import ListNode


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        visit = set()
        cur: ListNode = head
        while cur:
            cur = cur.next
            if cur in visit:
                return True
            visit.add(cur)
        return False



