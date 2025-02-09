class Solution:

    def sortSentence(self, s: str) -> str:
        arr = []

        for word in s.split(" "):
            n = int(word[-1])
            r = word[:-1]

            arr.append((n, r))

        arr.sort(key=lambda x: x[0])
        tarr = map(lambda x: x[1], arr)
        return " ".join(tarr)

print(Solution().sortSentence("is2 sentence4 This1 a3"))