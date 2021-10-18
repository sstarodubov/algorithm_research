class Node:
    prev = None
    val: int

    def __init__(self, _val):
        self.val = _val


class LinkedList:
    head: Node = None
    size:int = 0

    def add(self, val: int):
        new_node: Node = Node(val)
        new_node.prev = self.head
        self.head = new_node
        self.size += 1

    def display(self):
        cur_node = self.head
        while cur_node is not None:
            print(cur_node.val)
            cur_node: Node = cur_node.prev

    def remove_from_end(self, index):
        new_inx = (self.size - index) - 1
        if new_inx >=0:
            self.remove_at(new_inx)

    def remove_at(self, index):
        behind_node = None
        cur_node = self.head
        cur_ind = 0

        while cur_ind != index:
            behind_node = cur_node
            cur_node = cur_node.prev
            cur_ind += 1

        if cur_node is not None:
            behind_node.prev = cur_node.prev
