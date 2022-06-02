def calculate_z(string: str) -> [int]:
    zx = [0] * len(string)
    left, right = 0, 0
    for k in range(1, len(string)):
        if k > right:
            left = right = k
            while right < len(string) and string[right] == string[right - left]:
                right += 1
            zx[k] = right - left
            right -= 1
        else:
            k1 = k - left

            if zx[k1] < right - k + 1:
                zx[k] = zx[k1]
            else:
                left = k
                while right < len(string) and string[right] == string[right - left]:
                    right += 1
                zx[k] = right - left
                right -= 1
    return zx


calculate_z("abaxabab")


def z_pattern_match(string, pattern) -> [int]:
    p = pattern + "$" + string
    zx = calculate_z(p)
    ans = []
    for idx, z in enumerate(zx):
        if z == len(pattern):
            ans.append(idx - 1 - len(pattern))
    return ans
