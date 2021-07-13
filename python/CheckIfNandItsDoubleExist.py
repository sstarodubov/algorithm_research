from typing import List

"""Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N 
= 2 * M). 

More formally check if there exists two indices i and j such that :
    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]
"""


class Solution:
    # CPU O(n) and Space O(n)
    def checkIfExist(self, arr: List[int]) -> bool:
        d = {}
        for x in arr:
            if x * 2 in d or (x / 2) in d:
                return True
            d[x] = True
        return False


s = Solution()

assert s.checkIfExist([10, 2, 5, 3]) == True, "1"
assert s.checkIfExist([7, 1, 14, 11]) == True, "2"
assert s.checkIfExist([3, 1, 7, 11]) == False, "3"

print("tests passed")
