# Space O(1) and Time O(n * lg n)
def heap_sort(array: [int]):
    build_max_heap(array)
    for end_idx in reversed(range(1, len((array)))):
        swap(0, end_idx, array)
        sift_down(0, end_idx - 1, array)
    return array


def swap(i, y, arr):
    arr[i], arr[y] = arr[y], arr[i]


def build_max_heap(array):
    first_parent_idx = (len(array) - 1) // 2
    for cur in reversed(range(first_parent_idx + 1)):
        sift_down(cur, len(array) - 1, array)


def sift_down(cur, end_idx, heap):
    child1 = cur * 2 + 1
    while child1 <= end_idx:
        child2 = cur * 2 + 2 if cur * 2 + 2 <= end_idx else - 1
        if child2 > -1 and heap[child2] > heap[child1]:
            i = child2
        else:
            i = child1
        if heap[i] > heap[cur]:
            swap(cur, i, heap)
            cur = i
            child1 = cur * 2 + 1
        else:
            return

assert [2, 3, 4, 5] == heap_sort([5, 4, 3, 2])

print("tests passed")