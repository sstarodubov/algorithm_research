class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        devs = []
        for i in range(1, num):
            if num % i == 0:
                devs.append(i)
        return sum(devs) == num
