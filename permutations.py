def swap(arr, i, y):
    arr[i], arr[y] = arr[y], arr[i]


def cicle_first_element(arr):
    i = 0
    idx_to_swap = i + 1
    while idx_to_swap != len(arr):
        print(arr)
        swap(arr, i, idx_to_swap)
        idx_to_swap += 1
        i += 1
    print(arr)
    print("---------------")
    tmp = arr.pop()
    arr.insert(0, tmp)


def permutation(arr: [int]) -> [[int]]:
    ptr = 0
    cicle_first_element(arr)
    while ptr < len(arr) - 1:
        ptr += 1
        swap(arr, 0, ptr)
        cicle_first_element(arr)


permutation([1, 2, 3, 4])
