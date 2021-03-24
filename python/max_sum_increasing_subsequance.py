

# space O(n) Time O(n)
def max_sum(array:[int]):

    base_idx = 0
    storage = {}
    ptr = 1
    mx_sum = 0
    cur_sum = array[0]
    storage[array[0]] = True
    while len(storage.keys()) != len(array):
        if ptr == len(array):
            mx_sum = max(mx_sum, cur_sum)
            cur_sum = 0
            base_idx = None
            ptr = 0
            while base_idx is None:
                is_used = storage.get(array[ptr])
                if is_used:
                    ptr += 1
                else:
                    base_idx = ptr
                    storage[array[base_idx]] = True
                    cur_sum += array[base_idx]
        if array[ptr] > array[base_idx]:
            base_idx = ptr
            cur_sum += array[base_idx]
            storage[array[base_idx]] = True
        ptr += 1

    return max(mx_sum, cur_sum)


print(max_sum([10,11,1,2,3,5,6,7,100]))





