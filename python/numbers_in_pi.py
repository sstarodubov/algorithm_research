

def numbers_in_pi(target: str, nums:{}):
    out = []
    num_in_pi_helper(nums, target, 0, out)
    return min(out)


def num_in_pi_helper(nums:{}, cur_val:str, count:int, out = []):
    if not cur_val:
        out.append(count)
        return count
    ptr = 1
    while ptr <= len(cur_val):
        head = cur_val[0:ptr]
        tail = cur_val[ptr:]
        if head in nums:
            result = num_in_pi_helper(nums, tail, count + 1, out)
            result = max(result, count)
        ptr += 1
    return result

st = {
    "3141":True,
    "5":True,
    "31":True,
    "2":True,
    "4159":True,
    "9":True,
    "42":True
}
print(numbers_in_pi("3141592", st))

