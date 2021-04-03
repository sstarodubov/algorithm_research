

def reverseInteger(x:int)->int:

    isNegative = x < 0
    str_num = str(x)
    if isNegative:
        str_num = str_num[1:]
    out = ""
    for i in reversed(range(len(str_num))):
        out += str_num[i]
    if isNegative:
        r = int("-" + out)
    else: r = int(out)
    if r > 2147483650 or r < -2147483650:
        return 0
    return r

print(reverseInteger(1563847412))
