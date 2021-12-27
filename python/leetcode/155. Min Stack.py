class MinStack:

    def __init__(self):
        self.mins = []
        self.arr = []

    def push(self, val: int) -> None:
        cur_min = self.mins[len(self.mins) - 1] if self.mins else float("inf")
        self.mins.append(min(cur_min, val))
        self.arr.append(val)

    def pop(self) -> None:
        self.mins.pop()
        self.arr.pop()

    def top(self) -> int:
        return self.arr[len(self.arr) - 1]

    def getMin(self) -> int:
        return self.mins[len(self.mins) - 1]
