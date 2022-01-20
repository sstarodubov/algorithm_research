from typing import List


class Solution:

    def exclusiveTime(self, n, logs):
        ans = [0] * n
        stack = []
        prev_time = 0

        for log in logs:
            id, action, time = log.split(":")
            id, time = int(id), int(time)
            if action == "start":
                if stack:
                    ans[stack[-1]] += time - prev_time
                prev_time = time
                stack.append(id)
            else:
                ans[stack.pop()] += time + 1 - prev_time
                prev_time = time + 1

        return ans


assert Solution().exclusiveTime(2, ["0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8"]) == [8, 1]
assert Solution().exclusiveTime(n=2, logs=["0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"]) \
       == [7, 1]
assert Solution().exclusiveTime(n=1, logs=["0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"]) \
       == [8]
assert Solution().exclusiveTime(n=2, logs=["0:start:0", "1:start:2", "1:end:5", "0:end:6"]) == [3, 4]
