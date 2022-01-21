from collections import deque


class Solution:

    #time O(letters), space O(1)
    def romanToInt(self, s: str) -> int:
        map = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,
        }
        ans = 0

        tokens = deque(s)
        while tokens:
            if tokens[0] == "I":
                if len(tokens) >= 2:
                    if tokens[1] == "V":
                        tokens.popleft()
                        tokens.popleft()
                        ans += 4
                    elif tokens[1] == "X":
                        tokens.popleft()
                        tokens.popleft()
                        ans += 9
                    else:
                        tokens.popleft()
                        ans += 1
                else:
                    tokens.popleft()
                    ans += 1
            elif tokens[0] == "X":
                if len(tokens) >= 2:
                    if tokens[1] == "L":
                        tokens.popleft()
                        tokens.popleft()
                        ans += 40
                    elif tokens[1] == "C":
                        tokens.popleft()
                        tokens.popleft()
                        ans += 90
                    else:
                        tokens.popleft()
                        ans += 10
                else:
                    tokens.popleft()
                    ans += 10
            elif tokens[0] == "C":
                if len(tokens) >= 2:
                    if tokens[1] == "D":
                        tokens.popleft()
                        tokens.popleft()
                        ans += 400
                    elif tokens[1] == "M":
                        tokens.popleft()
                        tokens.popleft()
                        ans += 900
                    else:
                        tokens.popleft()
                        ans += 100
                else:
                    tokens.popleft()
                    ans += 100
            else:
                ans += map[tokens[0]]
                tokens.popleft()

        return ans


assert Solution().romanToInt("III") == 3
assert Solution().romanToInt("LVIII") == 58
assert Solution().romanToInt("MCMXCIV") == 1994
