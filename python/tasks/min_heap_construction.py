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


def remove(heap: [int]):
    if len(heap) == 1:
        heap.pop()
        return
    if not heap: return

    heap[0], heap[len(heap) - 1] = heap[len(heap) - 1], heap[0]
    heap.pop()
    cur_el_idx = 0
    while True:
        left_child_idx = child_left_idx(cur_el_idx)
        right_child_idx = child_right_idx(cur_el_idx)
        if left_child_idx >= len(heap) and right_child_idx >= len(heap):
            break
        if left_child_idx >= len(heap):
            heap[right_child_idx], heap[cur_el_idx] = heap[cur_el_idx], heap[right_child_idx]
            cur_el_idx = right_child_idx
        elif right_child_idx >= len(heap):
            heap[left_child_idx], heap[cur_el_idx] = heap[cur_el_idx], heap[left_child_idx]
            cur_el_idx = left_child_idx
        elif heap[left_child_idx] < heap[right_child_idx]:
            heap[left_child_idx], heap[cur_el_idx] = heap[cur_el_idx], heap[left_child_idx]
            cur_el_idx = left_child_idx
        else:
            heap[right_child_idx], heap[cur_el_idx] = heap[cur_el_idx], heap[right_child_idx]
            cur_el_idx = right_child_idx



remove(heap)
