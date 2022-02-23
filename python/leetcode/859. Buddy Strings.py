from collections import defaultdict


class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False
        if s == goal:
            m = defaultdict(lambda: 0)
            for l in s:
                m[l] += 1
                if m[l] == 2:
                    return True
            return False

        arr = []
        for a, b in zip(s, goal):
            if b != a:
                arr.append((a, b))
            if len(arr) >= 3:
                return False
        return len(arr) == 2 and arr[0][1] == arr[1][0] and arr[0][0] == arr[1][1]


assert Solution().buddyStrings("aaaaaaabc", "aaaaaaacb")
assert Solution().buddyStrings(s="aa", goal="aa")
assert Solution().buddyStrings(s="ab", goal="ba")
assert not Solution().buddyStrings(s="ab", goal="ab")
