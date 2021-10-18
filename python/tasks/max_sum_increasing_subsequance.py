

# space O(n) Time O(n ^ 2)
def max_sum(array:[int]):
    sums = [0 for x in array]
    subs =[ -1 for x in array]
    sums[0] = array[0]

    for i in range(1, len(array)):
        sums[i] = array[i]
        for y in range(i):
            if array[i] > array[y]:
                if sums[y] + array[i] > sums[i]:
                    sums[i] = sums[y] + array[i]
                    subs[i] = y

    max_sum_idx = 0
    for i in range(1, len(sums)):
        if sums[max_sum_idx] < sums[i]:
            max_sum_idx = i

    def find_sums_details(idx, result = []):
        result.append(array[idx])
        if subs[idx] == -1:
            return result
        return find_sums_details(subs[idx], result)

    return find_sums_details(max_sum_idx)

print(max_sum([8,12,2,3,15,5,7]))










