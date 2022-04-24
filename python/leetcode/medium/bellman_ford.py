def bf(edges, start, target):
    distance = {}
    for frm, to, weight in edges:
        distance[frm] = float("inf")
        distance[to] = float("inf")

    distance[start] = 0

    V = len(distance.keys())

    for i in range(V - 1):
        for frm, to, weight in edges:
            if distance[frm] + weight < distance[to]:
                distance[to] = distance[frm] + weight

    for frm, to, weight in edges:
        if distance[frm] + weight < distance[to]:
            raise "negative cycle is detected"

    return distance[target]


