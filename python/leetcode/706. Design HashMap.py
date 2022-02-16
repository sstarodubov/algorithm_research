class MyHashMap:

    def __init__(self):

        self.arr = []
        for i in range(1000):
            self.arr.append(set())

    def put(self, key: int, value: int) -> None:
        idx = key % 1000
        ir = False
        r = 0
        for k, v in self.arr[idx]:
            if k == key:
                r = (k, v)
                ir = True
        if ir:
            self.arr[idx].remove(r)
        self.arr[idx].add((key, value))

    def get(self, key: int) -> int:
        idx = key % 1000
        for k, v in self.arr[idx]:
            if k == key:
                return v
        return -1

    def remove(self, key: int) -> None:
        r = (-1, -1)
        ir = False
        idx = key % 1000
        for k, v in self.arr[idx]:
            if k == key:
                r = (key, v)
                ir = True
                break
        if ir:
            self.arr[idx].remove(r)


mm = MyHashMap()

mm.put(1, 1)
mm.put(2, 2)
print(mm.get(1))
mm.put(1, 2)
mm.put(2, 1)
mm.remove(1)
print(mm.get(1))
