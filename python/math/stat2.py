import numpy as np
from scipy.stats import chi2_contingency
import math

import pandas as pd
from sklearn.metrics import euclidean_distances

# Пример: таблица сопряжённости 2x2
# Например, данные о покупках мужчин и женщин:
#        | Купили | Не купили |
# Мужчины|   45    |    15     |
# Женщины|   30    |    30     |

observed = np.array([
                         [20, 15],
                         [11, 12],
                         [7, 9]
                     ])

# Выполняем хи-квадрат тест
chi2, p, dof, expected = chi2_contingency(observed)

#print(f"Хи-квадрат статистика: {chi2:.4f}")
#print(f"p-value: {p:.4f}")
#print(f"Степени свободы: {dof}")
#print("Ожидаемые частоты:\n", expected)

cluster = [(-3, 3), (1, 4), (2, 6), (3, 8), (5,2), (6,11), (7,1)]
def centroid(arr):
    x, y = 0, 0
    for i in range(len(arr)):
        x += arr[i][0]
        y += arr[i][1]

    return x / len(arr), y / len(arr)

def _euclidean_distances(p1, p2):
    x1, y1 = p1
    x2, y2 = p2
    return math.sqrt((x2 - x1)**2 + (y2 - y1)**2)

#внутригрупповая сумма квадратов отклонения
def wcss(cluster):
    xc, yc = centroid(cluster)
    print(f"centroid: {(xc, yc)}")
    result = 0
    for i in range(len(cluster)):
        x, y = cluster[i]
        result += _euclidean_distances((xc, yc), (x, y)) ** 2
    print(f"wcss: {result}")
    return result

wcss(cluster)
