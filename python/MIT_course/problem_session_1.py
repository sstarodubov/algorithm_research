from typing import List


def shift_left(arr: List[int], k: int) -> List[int]:
    match k:
        case k if k <= 0 or k >= len(arr):
            return arr
        case _:
            head, *tail = arr
            tail.append(head)
            return shift_left(tail, k - 1)


assert shift_left([1, 2, 3, 4, 5, 6], 3) == [4, 5, 6, 1, 2, 3]
