

class Stack:
    values:[int] = []
    max_size:int
    cur_size = -1
    def __init__(self, _max_size):
        self.max_size = _max_size

    def push(self, val:int):
        if self.max_size <= self.cur_size:
            raise ValueError("StackOverflow")
        self.cur_size += 1
        self.values.append(val)

    def pop(self):
        if self.cur_size == -1:
            raise ValueError("Stack is empty")
        result = self.values[self.cur_size]
        self.cur_size -= 1
        return result

    def peek(self):
        if self.cur_size == -1:
            raise ValueError("Stack is empty")
        return self.values[self.cur_size]

