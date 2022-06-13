from typing import List


class Solution:

    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda arr: arr[0])
        ans = []
        for ps, pe in intervals:
            if not ans:
                ans.append([ps, pe])
            else:
                xs, xe = ans[-1]

                if xs <= ps and xe <= pe and xe < ps:
                    ans.append([ps, pe])
                elif xs <= ps and xe <= pe:
                    ans.pop()
                    ans.append([xs, pe])
                elif xs <= ps and xe >= pe:
                    continue
                else:
                    ans.append([ps, pe])

        return ans


assert [[1, 5]] == Solution().merge([[1, 4], [4, 5]])
assert [[1, 6], [8, 10], [15, 18]] == Solution().merge([[1, 3], [2, 6], [8, 10], [15, 18]])
