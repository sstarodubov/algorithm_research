import math
from typing import Tuple, List


def median(xs):
    n = len(xs)
    if (n & 1) == 0:
        i = n // 2
        return (xs[i] + xs[i - 1]) / 2
    else:
        return xs[n // 2]


def IQR(xs):
    n = len(xs)
    i = n // 2
    if (n & 1) == 0:
        return median(xs[i:]) - median(xs[:i])
    else:
        return median(xs[i + 1:]) - median(xs[:i])


def mean(xs):
    ret = 0

    for x in xs:
        ret += x
    return ret / len(xs)


def variance(xs):
    n, k, m = len(xs), 0, mean(xs)
    for x in xs:
        k += (x - m) ** 2

    return k / n


def sample_variance(xs):
    n, k, m = len(xs), 0, mean(xs)
    for x in xs:
        k += (x - m) ** 2

    return k / (n - 1)


def standard_deviation(xs):
    return math.sqrt(variance(xs))


def sample_standard_deviation(xs):
    return math.sqrt(sample_variance(xs))


def _split_by_median(xs):
    n = len(xs)
    i = n // 2
    if (n & 1) == 0:
        return xs[:i], xs[i:]
    else:
        return xs[:i], xs[i + 1:]


def create_box_plot(xs):
    if len(xs) <= 1:
        print("no data to create box plot")
        return
    xs.sort()
    lp = xs[0]
    rp = xs[-1]
    ml = median(xs)

    l, r = _split_by_median(xs)
    ll = median(l)
    rl = median(r)

    print(f"""            
                                {ml} 
                        ____________________
                       |         |          |               
        *--------------|         |          | --------------*
                       |_________|__________| 
         {lp}            {ll}                   {rl}               {rp} 
""")


def outliers_bound(q1, q3, mid):
    iqr = q3 - q1
    return q1 - (1.5 * iqr), q3 + (1.5 * iqr)


def outliers(xs):
    xs.sort()
    iqr = IQR(xs)
    l, r = _split_by_median(xs)

    left_bound = median(l) - (1.5 * iqr)
    right_bound = median(r) + (1.5 * iqr)

    out = []
    for x in xs:
        if x < left_bound:
            out.append(x)
        elif x > right_bound:
            out.append(x)
    return out


def range_fn(xs):
    return max(xs) - min(xs)


def mid_range(xs):
    return (max(xs) + min(xs)) / 2


def MAD(xs):
    m = mean(xs)
    cur = 0
    for x in xs:
        cur += abs(x - m)

    return cur / len(xs)


def least_square_regression_line(x_mean, y_mean, sx, sy, r):
    m = r * (sy / sx)
    b = y_mean - (m * x_mean)

    sign = "-" if b < 0 else "+"
    print(f"y^ = {m}x {sign} {abs(b)}")


def prob_model(xs):
    s = sum(xs)
    ret = []
    for x in xs:
        ret.append(x / s)
    return ret


# xs - array of (value, value probability )
def expected_value(xs: List[Tuple[int | float, float]]):
    ret = 0

    for x, px in xs:
        ret += (px * x)

    return ret


# xs - array of (value, value probability )
def discrete_rand_var_variance(xs: List[Tuple[int | float, float]]):
    mean = expected_value(xs)
    ret = 0
    for x, px in xs:
        ret += ((x - mean) ** 2) * px

    return ret


# xs - array of (value, value probability )
def std_deviation_rand_var(xs: List[Tuple[int | float, float]]):
    return math.sqrt(discrete_rand_var_variance(xs))


#        _
# mean = x
# t_interval = t-interval
# s = sample standard deviation
# n - sample size
def t_interval(mean, s, n, t_interval):
    d = t_interval * s / math.sqrt(n)
    print(f"{mean} +- ({d})")
    print(f"({mean - d} , {mean + d})")

# p0 - zero proportion
# n - sample size
# sp = sample proportion
def z_test_proportion(p0, sp, n):
    return (sp - p0)/ math.sqrt((p0* (1 - p0))/ n)

def t_statistics(sample_mean, sample_std_deviation, sample_size, assumed_mean):
    return (sample_mean - assumed_mean) / ((sample_std_deviation/math.sqrt(sample_size)))

print(t_statistics(assumed_mean=68, sample_size=100, sample_mean=67, sample_std_deviation=1))