graph = {
    "start": {
        "a": 6,
        "b": 2
    },

    "a": {
        "end": 1
    },

    "b": {
        "a": 3,
        "end": 5
    },
    "end": {}
}



def dijkstra(graph, from_node, to_node):
    def find_lowest_cost_node(costs, processed):
        lowest_cost = float("inf")
        lowest_cost_node = None
        for node in costs:
            cost = costs[node]
            if cost < lowest_cost and node not in processed:
                lowest_cost = cost
                lowest_cost_node = node
        return lowest_cost_node

    processed = []
    costs = {}
    for a in graph[from_node].keys():
        costs[a] = graph[from_node][a]
    costs["end"] = float("inf")
    costs[from_node] = 0
    parent = {}
    for key in graph[from_node].keys():
        parent[key] = from_node
    parent["end"] = None
    node = find_lowest_cost_node(costs, processed)
    while node is not None:
        cost = costs[node]
        nbs = graph[node]
        for n in nbs.keys():
            new_cost = cost + nbs[n]
            if costs[n] > new_cost:
                costs[n] = new_cost
                parent[n] = node
        processed.append(node)
        node = find_lowest_cost_node(costs, processed)

    def find_way(cur_node, goal, parents_list, result=[]):
        result.append(cur_node)
        if cur_node == goal:
            return result
        next_node_el = parents_list[cur_node]
        return find_way(next_node_el, goal, parents_list, result)

    return find_way(to_node, from_node, parent)


print(dijkstra(graph, "start", "b"))
