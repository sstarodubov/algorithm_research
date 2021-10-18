# Time O(n) and Space O(n)
def zig_zag_traverse(array: [[int]]):
    def is_out_of_bounds(row, col, height, width):
        return row < 0 or row > height or col < 0 or col > width

    height = len(array) - 1
    width = len(array[0]) - 1
    result = []
    row, col = 0, 0
    going_down = True

    while not is_out_of_bounds(row, col, height, width):
        result.append(array[row][col])
        if going_down:
            if col == 0 or row == height:
                going_down = True
                if row == height:
                    col += 1
                else:
                    row += 1
            else:
                row += 1
                col -= 1
        else:
            if row == 0 or col == width:
                going_down = True
                if col == width:
                    row += 1
                else:
                    col += 1
            else:
                row -= 1
                col += 1
    return result
