class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        amount = 0
        uf = False
        for i in range(len(word)):
            if i == 0 and word[i].isupper():
                amount += 1
                uf += 1
            else:
                if word[i].isupper():
                    amount += 1
        if amount == len(word):
            return True
        if amount == 1 and uf:
            return True
        if amount == 0:
            return True
        return False
