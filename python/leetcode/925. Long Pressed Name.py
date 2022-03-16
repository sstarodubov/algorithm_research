class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        if len(name) > len(typed):
            return False
        ptr = 0
        counter = 0
        for n in name:
            if ptr >= len(typed):
                break
            if n == typed[ptr]:
                ptr += 1
                counter += 1
                continue
            if n != typed[ptr]:
                if ptr - 1 < 0:
                    return False
                while typed[ptr - 1] == typed[ptr]:
                    ptr += 1
                    if ptr >= len(typed):
                        break

                if ptr >= len(typed):
                    break

                if typed[ptr] != n:
                    return False
                ptr += 1
                counter += 1
            if ptr >= len(typed):
                break

        if len(typed) > len(name):
            while ptr < len(typed) and typed[ptr] == name[-1]:
                ptr += 1
        c = counter == len(name)
        xx = ptr == len(typed)

        return c and xx


assert Solution().isLongPressedName("leelee", "lleeelee")
assert not Solution().isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz")
assert not Solution().isLongPressedName("alexd", "ale")
assert not Solution().isLongPressedName("pyplrz", "ppyypllr")
assert Solution().isLongPressedName("vtkgn", "vttkgnn")
assert not Solution().isLongPressedName("alex", "aaleexa")
assert Solution().isLongPressedName(name="alex", typed="aaleex")
