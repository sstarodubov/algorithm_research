def unique_in_order(iterable):
    ans = []
    front = 0
    while front < len(iterable):
        cur_letter = iterable[front]
        ans.append(cur_letter)
        while iterable[front] == cur_letter:
            front += 1
            if front >= len(iterable):
                return ans
    return ans


assert unique_in_order('AAAABBBCCDAABBB') == ['A', 'B', 'C', 'D', 'A', 'B']
assert unique_in_order('ABBCcAD') == ['A', 'B', 'C', 'c', 'A', 'D']
assert unique_in_order([1, 2, 2, 3, 3]) == [1, 2, 3]

print("test passed")
