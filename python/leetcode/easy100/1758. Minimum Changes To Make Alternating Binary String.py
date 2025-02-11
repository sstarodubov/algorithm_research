class Solution:
    def minOperations(self, s: str) -> int:
        def nextElem(seq):
            if seq == '0':
                return '1'
            else: return '0'

        zeroSeq, oneSeq = '0', '1'
        zeroCh , oneCh = 0, 0
        for ch in s:
            if ch != zeroSeq:
                zeroCh += 1
            if ch != oneSeq:
                oneCh += 1
            zeroSeq = nextElem(zeroSeq)
            oneSeq = nextElem(oneSeq)

        return min(zeroCh, oneCh)