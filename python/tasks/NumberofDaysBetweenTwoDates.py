import time
import datetime

"""
Write a program to count the number of days between two dates.

The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.

 """


class Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        start = time.mktime(datetime.datetime.strptime(date1, "%Y-%m-%d").timetuple())
        end = time.mktime(datetime.datetime.strptime(date2, "%Y-%m-%d").timetuple())
        if start < end:
            res = (end - start) // (24 * 60 * 60)
            return int(res)
        else:
            res = (start - end) // (24 * 60 * 60)
            return int(res)


s = Solution()

assert 15 == s.daysBetweenDates(date1="2020-01-15", date2="2019-12-31"), "2"
assert 1 == s.daysBetweenDates(date1="2019-06-29", date2="2019-06-30"), "1"

print("tests passed")
