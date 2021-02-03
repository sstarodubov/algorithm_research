from binarytree import build
from binarytree import Node
from typing import List

nodes = [10, 5, 15, 2, 5, 13, 22, 1, None, None, None, None, 14]

# Building the tree
tree: Node = build(nodes)
print('Binary tree from list :\n',
      tree)


# O(lg n)
def find_node_trace(node: Node, trace: List[int], cur_node_value: int):
    trace.append(node.value)
    if node.value == cur_node_value and node.right is None and node.left is None:
        return trace
    if node.value <= cur_node_value:
        return find_node_trace(node.right, trace, cur_node_value)
    else:
        return find_node_trace(node.left, trace, cur_node_value)


# O(lg n)
def find_last_leaves(node: Node, result: List[int]) -> List[int]:
    if node is not None:
        find_last_leaves(node.left, result)
        if node.left is None and node.right is None:
            result.append(node.value)
        find_last_leaves(node.right, result)
    return result



# O(n)
def find_sum_branch(_tree: Node, _leaves: List[int], low: int, high: int, result=[]):
    if high == low:
        r = sum(find_node_trace(_tree, [], _leaves[high]))
        result.append(r)
    else:
        mid = int((high + low) / 2)
        find_sum_branch(_tree, _leaves, low, mid)
        find_sum_branch(_tree, _leaves, mid + 1, high)
    return result


leaves = find_last_leaves(tree, [])
res = find_sum_branch(tree, leaves, 0, len(leaves) - 1)
print(res)
