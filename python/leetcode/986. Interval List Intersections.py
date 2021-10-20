from typing import List


class Solution:

    # cpu O(len(fist) + len(second)) and ram O(n)
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        ans = []
        ptr_first, ptr_second = 0, 0
        while ptr_second < len(secondList) and ptr_first < len(firstList):
            cur_first = firstList[ptr_first]
            cur_second = secondList[ptr_second]
            if cur_first[0] > cur_second[1]:
                ptr_second += 1
                continue

            if cur_second[0] > cur_first[1]:
                ptr_first += 1
                continue

            if cur_first[1] < cur_second[1]:
                tmp = max(cur_first[0], cur_second[0])
                ans.append([tmp, cur_first[1]])
                ptr_first += 1
            elif cur_first[1] > cur_second[1]:
                tmp = max(cur_first[0], cur_second[0])
                ans.append([tmp, cur_second[1]])
                ptr_second += 1
            elif cur_first[1] == cur_second[1]:
                tmp = max(cur_first[0], cur_second[0])
                ans.append([tmp, cur_second[1]])
                ptr_second += 1
                ptr_first += 1
        return ans


assert Solution().intervalIntersection(firstList=[[0, 2], [5, 10], [13, 23], [24, 25]],
                                       secondList=[[1, 5], [8, 12], [15, 24], [25, 26]]) == [[1, 2], [5, 5], [8, 10],
                                                                                             [15, 23], [24, 24],
                                                                                             [25, 25]]
assert Solution().intervalIntersection(firstList=[[1, 3], [5, 9]], secondList=[]) == []
assert Solution().intervalIntersection(firstList=[], secondList=[[4, 8], [10, 12]]) == []
assert Solution().intervalIntersection(firstList=[[1, 7]], secondList=[[3, 10]]) == [[3, 7]]
print("tests passed")
