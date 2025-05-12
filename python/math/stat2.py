#хи - квадрат
import math

import pandas as pd


def hi2(observed, expected):
    a = 0
    for i in range(len(observed)):
       a += (math.pow(observed[i] - expected[i], 2) / expected[i])

    return a

def expected(observed, proportion):
    if proportion is None:
        proportion = [1, 1, 1]
    n = sum(observed)
    p = sum(proportion)
    per = n / p
    expect = [0] * len(observed)
    for i in range(len(observed)):
        expect[i] = per * proportion[i]
    return expect

def expected_table(t):
    col_len = len(t[0])
    row_len = len(t)
    row_sum = [0] * row_len
    col_sum = [0] * col_len
    for i in range(col_len):
        for j in range(row_len):
            row_sum[i] += t[i][j]
    for i in range(row_len):
        for j in range(col_len):
            col_sum[i] += t[j][i]

    all = sum(row_sum)
    for i in range(col_len):
        for j in range(row_len):
            t[i][j] = (row_sum[j] * col_sum[i]) / all
    print(table)


table= [
    [10, 6],
    [5, 15]
]

expected_table(table)