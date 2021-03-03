class Node:
    prev = None
    val: int

    def __init__(self, _val):
        self.val = _val


class LinkedList:
    head: Node = None

    def add(self, val: int):
        new_node: Node = Node(val)
        new_node.prev = self.head
        self.head = new_node

    def display(self):
        cur_node = self.head
        while cur_node is not None:
            print(cur_node.val)
            cur_node: Node = cur_node.prev

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