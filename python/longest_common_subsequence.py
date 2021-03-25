

# Time O() and Space O()
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

print(longest_common_subsequence("xkykzpw", "zxvvyzw"))
