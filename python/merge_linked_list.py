from build_ll_from_array import buildLinkedList, Node


l1:Node = buildLinkedList([1,6,7,8])
l2:Node = buildLinkedList([2,3,4,5,9,10])

# Space O(1) and Time O(n)
def mergeLinkedList(l1:Node, l2:Node):
    cur = l1 if l1.val <= l2.val else l2
    prev = None
    br = l2 if l1.val <= l2.val else l1
    head = cur
    while True:
        if br is None:
            return head
        if cur is None:
           while br is not None:
               prev.next = br
               prev = br
               br = br.next
           return head
        if cur.val < br.val:
            prev = cur
            cur = cur.next
        else:
            tmp = br.next
            prev.next = br
            br.next = cur
            prev = br
            br = tmp

r = mergeLinkedList(l1, l2)
print(r)