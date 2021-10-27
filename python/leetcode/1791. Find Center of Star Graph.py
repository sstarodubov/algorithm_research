from typing import List


class Solution:

    # cpu O(edges + nodes) and ram O(nodes)
    def findCenter(self, edges: List[List[int]]) -> int:
        count = {}
        for edge in edges:
            if edge[0] in count:
                count[edge[0]] += 1
            else:
                count[edge[0]] = 1
            if edge[1] in count:
                count[edge[1]] += 1
            else:
                count[edge[1]] = 1
        maximum = 0
        node = -1
        for key in count:
            if count[key] > maximum:
                maximum = count[key]
                node = key
        return node


assert Solution().findCenter([[1, 2], [2, 3], [4, 2]]) == 2
assert Solution().findCenter([[1, 2], [5, 1], [1, 3], [1, 4]]) == 1
print("tests passed")
