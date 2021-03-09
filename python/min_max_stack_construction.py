class Stack:
    values: [int] = []
    max_size: int
    cur_size = -1

    def __init__(self, _max_size):
        self.max_size = _max_size
        self.min_max_stack = []

    def push(self, val: int):
        if self.max_size <= self.cur_size:
            raise ValueError("StackOverflow")
        self.cur_size += 1
        new_min_max = {"max": val, "min": val}
        if self.cur_size > 0:
            old_min_max = self.min_max_stack[self.cur_size]
            new_min_max["max"] = max(old_min_max["max"], new_min_max["max"])
            new_min_max["min"] = min(old_min_max["min"], new_min_max["max"])
        self.min_max_stack.append(new_min_max)
        self.values.append(val)

    def pop(self):
        if self.cur_size == -1:
            raise ValueError("Stack is empty")
        result = self.values[self.cur_size]
        self.min_max_stack.pop()
        self.cur_size -= 1
        return result

    def peek(self):
        if self.cur_size == -1:
            raise ValueError("Stack is empty")
        return self.values[self.cur_size]
