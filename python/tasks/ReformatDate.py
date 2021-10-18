class Solution:
    def reformatDate(self, date: str) -> str:
        months = {"Jan": "01", "Feb": "02", "Mar": "03", "Apr": "04",
                  "May": "05", "Jun": "06", "Jul": "07", "Aug": "08", "Sep": "09", "Oct": "10", "Nov": "11",
                  "Dec": "12"}

        def format_day(d):
            for i in range(len(d)):
                if not str.isdigit(d[i]):
                    return d[0: i]

        arr = date.split(" ")
        day = format_day(arr[0])
        day_form = day if len(day) >= 2 else "0" + day
        return f"{arr[2]}-{months[arr[1]]}-{day_form}"


s = Solution()

assert s.reformatDate("20th Oct 2052") == "2052-10-20"

print("tests passed")
