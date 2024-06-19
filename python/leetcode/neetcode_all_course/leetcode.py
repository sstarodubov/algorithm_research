import string
from collections import deque
from typing import List, Optional, Deque

from tree_node import TreeNode


def create_matrix(n, m, v=0):
    mtx = []
    for r in range(n):
        mtx.append([])
        for c in range(m):
            mtx[r].append(v)

    return mtx


