import math

heap = [8, 12, 23, 17, 31, 30, 44, 102, 18]


def parent_node_idx(i):
    return math.floor((i - 1) / 2)


def child_left_idx(i):
    return (2 * i) + 1


def child_right_idx(i):
    return (2 * i) + 2

def sift_up(heap, i):
    parent_idx = parent_node_idx(i)
    heap[parent_idx], heap[i] = heap[i], heap[parent_idx]

def insert(heap: [int], el: int) -> [int]:
    heap.append(el)
    cur_el_idx = len(heap) - 1
    parent_idx = parent_node_idx(cur_el_idx)
    while heap[cur_el_idx] <= heap[parent_idx]:
        sift_up(heap, cur_el_idx)
        cur_el_idx = parent_idx
        parent_idx = parent_node_idx(cur_el_idx)
    print(heap)


insert(heap, 9)





