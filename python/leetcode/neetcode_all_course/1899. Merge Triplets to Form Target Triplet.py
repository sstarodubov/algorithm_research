from typing import List


class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
       s =set()
       for t in triplets:
           if t[0] > target[0] or t[1] > target[1] or t[2] > target[2]:
               continue

           for i , v in enumerate(t):
               if v == target[i]:
                   s.add(i)

       return len(s) == 3

