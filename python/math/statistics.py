import math


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


print(prob_model([97, 47, 77]))