from typing import List


class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        x = 0
        for op in operations:
            match op:
                case "X++": x+=1
                case "++X": x+= 1
                case "X--": x-=1
                case "--X": x-=1

        return x


print(Solution().finalValueAfterOperations(["--X","X++","X++"]))