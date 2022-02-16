class MyHashSet:

    def __init__(self):
        self.set = {}

    def add(self, key: int) -> None:
        self.set[key] = 0

    def remove(self, key: int) -> None:
        if key in self.set:
            del self.set[key]

    def contains(self, key: int) -> bool:
        return key in self.set
