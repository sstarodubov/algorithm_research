from collections import deque


def tower_builder(n_floors):
    if n_floors == 0: return [""]
    if n_floors == 1: return ["*"]

    width = 1
    rows_count = 1
    for i in range(n_floors - 1):
        width += 2
        rows_count += 1
    ans = []
    for i in range(rows_count):
        ans.append(["*"] * width)

    rm = 1
    for idx in range(len(ans) - 2, -1, -1):
        for ir in range(rm):
            ans[idx][ir] = " "
        for rir in range(len(ans[idx]) - 1, len(ans[idx]) - rm - 1, -1):
            ans[idx][rir] = " "
        rm += 1

    for idx in range(len(ans)):
        ans[idx] = "".join(ans[idx])
    return ans


assert tower_builder(6) == [
    '     *     ',
    '    ***    ',
    '   *****   ',
    '  *******  ',
    ' ********* ',
    '***********'
]

print("tests passed")
