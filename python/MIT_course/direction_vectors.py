def find_neigberhood(matrix, r, c):
    dr = [+1, -1, 0, 0]
    dc = [0, 0, -1, +1]
    for i in range(4):
        rr = r + dr[i]
        cc = r + dc[i]
        if rr < 0 or cc < 0:
            continue
        if rr >= len(matrix) or cc >= len(matrix):
            continue

        print(matrix[rr][cc])


find_neigberhood([[1, 2, 3], [4, 5, 6], [7, 8, 9]], 1, 1)
