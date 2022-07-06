from collections import OrderedDict


class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.map = OrderedDict({})

    def get(self, key: int) -> int:
        if key in self.map:
            self.map.move_to_end(key)
            return self.map[key]
        return -1

    def put(self, key: int, value: int) -> None:
        if len(self.map.keys()) < self.cap:
            self.map[key] = value
        else:
            if key in self.map:
                self.map[key] = value
            else:
                self.map.popitem(last=False)
                self.map[key] = value
        self.map.move_to_end(key)



lRUCache = LRUCache(2)
lRUCache.put(1, 1)
lRUCache.put(2, 2)
assert 1 == lRUCache.get(1)
lRUCache.put(3, 3)
assert -1 == lRUCache.get(2)
lRUCache.put(4, 4)
assert -1 == lRUCache.get(1)
assert 3 == lRUCache.get(3)
assert 4 == lRUCache.get(4)

l = LRUCache(2)
assert l.get(2) == -1
l.put(2, 6)
assert -1 == l.get(1)
l.put(1, 5)
l.put(1, 2)
assert l.get(1) == 2
assert l.get(2) == 6
