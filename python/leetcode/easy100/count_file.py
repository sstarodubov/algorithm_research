import os
print(len(list(os.walk(os.curdir))[0][2]) - 1)