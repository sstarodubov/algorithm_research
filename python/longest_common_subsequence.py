
# Time O(nm * min(n,m)) and Space O(nm * min(n,m))
def lcs_v2(str1, str2):
    lcs = [["" for x in range(len(str1) + 1)] for y in range(len(str2) + 1)]
    for i in range(1, len(str2) + 1):
        for j in range(1, len(str1) + 1):
            if str2[i - 1] == str1[j - 1]:
                lcs[i][j] = lcs[i - 1][j - 1] + str2[i - 1]
            else:
                lcs[i][j] = max(lcs[i -1][j], lcs[i][j -1], key=len)
    return lcs[-1][-1]

# Time O(nm) and Space O(nm)
def lcs_v3(str1, str2):
    lsc = [[[None, 0, None, None] for x in range(len(str1) + 1)] for y in range(len(str2) + 1)]
    for i in range(1, len(str2) + 1):
        for j in range(1, len(str1) + 1):
            if str2[i - 1] == str1[j - 1]:
                lsc[i][j] = [str2[i - 1], lsc[i-1][j-1][1] + 1, i - 1, j - 1]
            else:
                if lsc[i- 1][j][1] > lsc[i][j -1][1]:
                    lsc[i][j] = [None, lsc[i - 1][j][1], i - 1, j]
                else:
                    lsc[i][j] = [None, lsc[i][j - 1][1], i, j - 1]
    return build_seq(lsc)

def build_seq(lcs):
    seq = []
    i = len(lcs) - 1
    j = len(lcs[0]) - 1
    while i != 0 and j != 0:
        cur_entry = lcs[i][j]
        if cur_entry[0] is not None:
            seq.append(cur_entry[0])
        i = cur_entry[2]
        j = cur_entry[3]
    return list(reversed(seq))
# Time O(nm * min(n,m)) and Space O(nm * min(n,m))
def longest_common_subsequence(str1, str2):
    matrix = [["" for b in str2] for a in str1]
    for x in range(len(matrix)):
        for y in range(len(matrix[x])):
            letter1 = str1[y]
            letter2 = str2[x]
            if letter1 != letter2:
                high = "" if x - 1 < 0 else matrix[x - 1][y]
                back = "" if y - 1 < 0 else matrix[x][y - 1]
                char = high if len(high) > len(back) else back
                matrix[x][y] = char
            else:
                cur_letter = "" if x - 1 < 0 or y - 1 < 0 else matrix[x - 1][y - 1]
                matrix[x][y] = cur_letter + str1[y]
    return matrix[len(str1) - 1][len(str2) - 1]


print(lcs_v3("xkykzpw", "zxvvyzw"))
