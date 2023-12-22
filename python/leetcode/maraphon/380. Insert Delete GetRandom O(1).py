import random


class RandomizedSet:

    def __init__(self):
        self.set = set()

    def insert(self, val: int) -> bool:
        if val in self.set:
            self.set.add(val)
            return False
        else:
            self.set.add(val)
            return True

    def remove(self, val: int) -> bool:
        if val in self.set:
            self.set.remove(val)
            return True
        else:
            return False

    def getRandom(self) -> int:
        l = len(self.set)
        r = random.randint(0, l - 1)
        c = 0
        for v in self.set:
            if c == r:
                return v
            c += 1
        return -1


s = RandomizedSet()
s.insert(1)
s.insert(2)
for i in range(10):
    print(s.getRandom())
