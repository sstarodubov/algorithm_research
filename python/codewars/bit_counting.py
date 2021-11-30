def count_bits(n):
    count = 0
    while n:
        n = (n - 1) & n
        count += 1
    return count


assert count_bits(1234) == 5
print("tests passed")
