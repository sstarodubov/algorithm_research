from build_ll_from_array import buildLinkedList, Node

lHead: Node = buildLinkedList([0, 1, 2, 3, 4, 5])


# time O(n) and Space O(1)
def shiftLinkedList(node: Node, k: int):
    l = 0
    cur = node
    while cur is not None:
        l += 1
        cur = cur.next
    b = k if k < l else k % l
    if b % l == 0:
        return node
    lNIdx = l - b
    c = 0
    p = node
    while c != (lNIdx - 1):
        c += 1
        p = p.next

    r = p.next
    nx: Node = p.next
    while nx.next is not None:
        nx = nx.next
    nx.next = node
    p.next = None
    return r
