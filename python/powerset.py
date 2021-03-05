def power_set(arr: [int]) -> [[int]]:
    result: list = [[]]
    window_size = 1
    while True:
        if window_size == len(arr):
            break
        window = [0 for i in range(window_size)]
        move_window(window, arr, result)
        window_size += 1
    result.append(arr)
    return result


def move_window(window, arr, result:[]):
    cur_idx = 0
    flag = False
    while True:
        if window[0] == 0 and flag:
            break
        for i in range(len(window)):
            if cur_idx >= len(arr):
                cur_idx = 0
            at = cur_idx + i
            if at >= len(arr):
                at = (at % len(arr))
            window[i] = at
        cur_idx += 1
        if not flag:
            tmp = []
            for w in window:
                tmp.append(arr[w])
            result.append(tmp)
        if window[0] == len(arr) - 1:
            flag = True
    return result

print(power_set([10,20,30]))