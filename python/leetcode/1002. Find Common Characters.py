from collections import defaultdict
from typing import List


class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        arr = []
        for n in words:
            arr.append(defaultdict(lambda: 0))
        for i in range(len(words)):
            for letter in words[i]:
                arr[i][letter] += 1
        ans = []
        for k in arr[0]:
            counter = arr[0][k]
            for i in range(1, len(arr)):
                counter = min(counter, arr[i][k])
            for i in range(counter):
                ans.append(k)
        return ans


Solution().commonChars(["dadaabaa", "bdaaabcc", "abccddbb", "bbaacdba", "ababbbab", "ccddbbba", "bbdabbda", "bdabaacb"])
Solution().commonChars(["bella", "label", "roller"])
