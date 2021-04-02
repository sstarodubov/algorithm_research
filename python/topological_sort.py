class JobGraph:
    def __init__(self, jobs):
        self.nodes = []
        self.graph = {}
        for job in jobs:
            self.add_node(job)

    def add_prereq(self, job, prereq):
        job_node = self.get_node(job)
        prereq_node = self.get_node(prereq)
        job_node.prereqs.append(prereq_node)

    def add_node(self, job):
        self.graph[job] = JobNode(job)
        self.nodes.append(self.graph[job])

    def get_node(self, job):
        if job not in self.graph:
            self.add_node(job)
        return self.graph[job]

class JobNode:

    def __init__(self, job):
        self.job = job
        self.prereqs = []
        self.visited = False
        self.visiting = False


def topological_sort_dfs(jobs, deps):
    job_graph = create_job_graph(jobs, deps)
    return get_order_jobs(job_graph)

def get_order_jobs(graph):
    order_jobs = []
    nodes = graph.nodes
    while len(nodes):
        node = nodes.pop()
        contains_cycle = depth_first_traverse(node, order_jobs)
        if contains_cycle:
            return []
    return order_jobs

def depth_first_traverse(node:JobNode, order_jobs):
    if node.visited:
        return False
    if node.visiting:
        return True
    node.visiting = True
    for prereq_node in node.prereqs:
        contains_cycle = depth_first_traverse(prereq_node, order_jobs)
        if contains_cycle: return True
    node.visited = True
    node.visiting = False
    order_jobs.append(node.job)


def create_job_graph(jobs, deps):
    graph = JobGraph(jobs)
    for prereq, job in deps:
        graph.add_prereq(job, prereq)
    return graph