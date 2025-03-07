from collections import deque
from typing import List

class Person:
    def __init__(self, tickets, is_target = False):
       self.count = tickets
       self.isTarget = is_target

class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        dq = deque()
        for i in range(len(tickets)):
            if i == k:
               dq.append(Person(tickets[i], True))
            else:
                dq.append(Person(tickets[i]))
        time = 0

        while dq:
            time += 1
            first = dq.popleft()
            first.count -= 1

            if first.count == 0:
                if first.isTarget:
                    break
            else:
                dq.append(first)


        return time