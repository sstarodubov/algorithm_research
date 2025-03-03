class Solution:
    def reformatDate(self, date: str) -> str:
        m_map = {
            'Jan' : "01",
            'Feb' : "02",
            'Mar' : "03",
            'Apr' : '04',
            "May" : '05',
            "Jun" : "06",
            "Jul" : "07",
            "Aug" : "08",
            "Sep" : "09",
            "Oct" : "10",
            "Nov" : "11",
            "Dec" : "12"
        }
        arr = date.split(" ")
        y = arr[2]
        m = m_map[arr[1]]
        d = arr[0][:-2]
        if len(d) < 2:
            d = "0" + d
        return f"{y}-{m}-{d}"

