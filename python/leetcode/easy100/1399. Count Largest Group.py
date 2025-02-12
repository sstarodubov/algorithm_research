class Solution:
    def countLargestGroup(self, n: int) -> int:
        def int_sum(n):
            ret = 0
            while n:
                ret += n % 10
                n = n // 10
            return ret

        hm = {}
        cur_max, counter = 0, 0
        for i in range(1, n + 1):
            k = int_sum(i)
            if k in hm:
                hm[k] += 1
            else:
                hm[k] = 1
            if cur_max < hm[k]:
                counter = 1
                cur_max = hm[k]
            elif cur_max == hm[k]:
                counter += 1

        return counter



print(Solution().countLargestGroup(13))