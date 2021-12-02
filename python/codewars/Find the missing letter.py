def find_missing_letter(chars):
    cur = ord(chars[0])
    for i in range(1, len(chars)):
        cur += 1
        if cur != ord(chars[i]):
            return chr(cur)
    return 0

assert find_missing_letter(["a", "b", "c", "d", "f"]) == "e"
assert find_missing_letter(["O", "Q", "R", "S"]) == "P"

print("tests passed")
