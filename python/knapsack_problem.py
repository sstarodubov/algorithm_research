
def knap_sack(elements, capacity) -> [[int]]:
    matrix = [[0 for _ in range(capacity + 1)] for _ in range(len(elements) + 1)]
    for i in range(1, len(matrix)):
        for j in range(1, len(matrix[i])):
            cur_ele = elements[i - 1]
            if cur_ele[1] <= j:
                matrix[i][j] = max(matrix[i - 1][j], matrix[i-1][j - cur_ele[1]] + cur_ele[0])
            else:
                matrix[i][j] = matrix[i - 1][j]

    i, j = len(matrix) - 1, len(matrix[0]) - 1
    out = []
    sum = 0
    while sum < capacity:
        cur_el = matrix[i][j]
        above_el = matrix[i - 1][j]

        if above_el < cur_el:
            product = elements[i - 1]
            sum += product[0]
            out.append(product)
            i -= 1
            j = j - product[1]
        else:
            product = elements[i - 2]
            sum += product[0]
            out.append(product)
            i -= 1

    return out

print(knap_sack([[1,2], [4,3], [5,6], [6,7]], 10))
