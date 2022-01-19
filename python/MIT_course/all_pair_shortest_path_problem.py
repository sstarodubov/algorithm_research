from typing import List

graph = [
    # 0  1  2  3  4  5  6
    [float("inf"), 2, float("inf"), float("inf"), 5, float("inf"), 7],  # 0
    [float("inf"), float("inf"), 3, 3, float("inf"), float("inf"), float("inf")],  # 1
    [float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), 1, float("inf")],  # 2
    [float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), 1, 3],  # 3
    [float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), 2],  # 4
    [float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), 1],  # 5
    [float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), float("inf")],  # 6
]


def setup(m: List[List[int]]) -> (List[List[int]], List[List[int]]):
    dp = [[0] * len(m) for x in m]
    nxt = [[0] * len(m) for x in m]
    for i in range(len(m)):
        for j in range(len(m)):
            dp[i][j] = m[i][j]
        if m[i][j] != float("inf"):
            nxt[i][j] = j
    return nxt, dp


def reconstruct_path(start: int, end: int, dp, nxt) -> List[int]:
    path = []
    if dp[start][end] == float("inf"): return path
    at = start
    while at != end:
        if at == -1: return None
        path.append(at)
        at = nxt[at][end]
    if nxt[at][end] == -1: return None
    path.append(end)
    return path


def floyd_warshall(m: List[List[int]]) -> (List[List[int]], List[List[int]]):
    nxt, dp = setup(m)
    for k in range(len(m)):
        for i in range(len(m)):
            for j in range(len(m)):
                if dp[i][k] + dp[k][j] < dp[i][j]:
                    dp[i][j] = dp[i][k] + dp[k][j]

    # check negative cycle
    for k in range(len(m)):
        for i in range(len(m)):
            for j in range(len(m)):
                if dp[i][k] + dp[k][j] < dp[i][j]:
                    raise Exception("negative cycle is detected")

    return dp, nxt


apsp, _ = floyd_warshall(graph)
print(apsp)
