import random


class RandomizedSet:

    def __init__(self):
        self.m = {}
        self.xs = []

    def insert(self, val: int) -> bool:
        ret = val not in self.m
        if ret:
            self.m[val] = len(self.xs)
            self.xs.append(val)
        return ret

    def remove(self, val: int) -> bool:
        ret: bool = val in self.m
        if ret:
            i = self.m[val]
            last = self.xs[-1]
            self.xs[i] = last
            self.xs.pop()
            self.m[last] = i
            del self.m[val]
        return ret

    def getRandom(self) -> int:
        l = len(self.xs)
        r = random.randint(0, l - 1)
        return self.xs[r]


s = RandomizedSet()
s.insert(1)
s.insert(2)
for i in range(10):
    print(s.getRandom())
