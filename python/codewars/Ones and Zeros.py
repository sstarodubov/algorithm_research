def binary_array_to_number(arr):
    ans, idx = 0, 0
    for bit in reversed(arr):
        if bit == 1:
            ans += pow(2, idx)
        idx += 1
    return ans


assert binary_array_to_number([1, 0, 1, 1]) == 11
print("tests passed")
