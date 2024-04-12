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


def range_(xs):
    return max(xs) - min(xs)


def mid_range(xs):
    return range_(xs) / 2


def _split_by_median(xs):
    n = len(xs)
    i = n // 2
    if (n & 1) == 0:
        return xs[i:], xs[:i]
    else:
        return xs[i + 1:], xs[:i]


def create_box_plot(xs):
    if len(xs) <= 1:
        print("no data to create box plot")
        return
    xs.sort()
    lp = xs[0]
    rp = xs[-1]
    ml = median(xs)

    r, l = _split_by_median(xs)
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




def stat(xs):
    print(f"mean = {mean(xs)}")
    print(f"standard deviation = {standard_deviation(xs)}")
    print(f"sample standard deviation = {sample_standard_deviation(xs)}")
    print(f"median = {median(xs)}")
    print(f"IQR = {IQR(xs)}")
    print(f"range = {range_(xs)}")
