class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        st = set()

        cur = head

        while cur:
            if cur in st:
                return True

            st.add(cur)

            cur = cur.next
        return False
