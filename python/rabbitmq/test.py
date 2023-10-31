import math
import sys
n = int(sys.stdin.read())
m = int(sys.stdin.read())
a = int(sys.stdin.read())
nn = math.ceil(n / a)
mm = math.ceil(m / a)

print(m * n)