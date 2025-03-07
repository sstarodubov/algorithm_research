class Solution:
    def toHex(self, num: int) -> str:
        def add(arr):
            carry = 1
            for i in range(31, -1, -1):
                arr[i] += carry
                if arr[i] == 2:
                    arr[i] = 0
                else:
                    break

        def flip(arr):
            for i in range(len(arr)):
                if arr[i] == 0:
                    arr[i] = 1
                else:
                    arr[i] = 0

        hm = {
            "0000" : "0",
            "0001" : "1",
            "0010" : "2",
            "0011" : "3",
            "0100" : "4",
            "0101" : "5",
            "0110" : "6",
            "0111" : "7",
            "1000" : "8",
            "1001" : "9",
            "1010" : "a",
            "1011" : "b",
            "1100" : "c",
            "1101" : "d",
            "1110" : "e",
            "1111" : "f"
        }
        arr = []
        origin = num
        num = abs(num)
        for i in range(32):
            arr.append(num & 1)
            num = num >> 1
        arr.reverse()

        if origin < 0:
            flip(arr)
            add(arr)

        bit1 = str(arr[0]) + str(arr[1]) + str(arr[2]) + str(arr[3])
        bit2 = str(arr[4]) + str(arr[5]) + str(arr[6]) + str(arr[7])
        bit3 = str(arr[8]) + str(arr[9]) + str(arr[10]) + str(arr[11])
        bit4 = str(arr[12]) + str(arr[13]) + str(arr[14]) + str(arr[15])
        bit5 = str(arr[16]) + str(arr[17]) + str(arr[18]) + str(arr[19])
        bit6 = str(arr[20]) + str(arr[21]) + str(arr[22]) + str(arr[23])
        bit7 = str(arr[24]) + str(arr[25]) + str(arr[26]) + str(arr[27])
        bit8 = str(arr[28]) + str(arr[29]) + str(arr[30]) + str(arr[31])

        lead_zero =  hm[bit1] + hm[bit2] + hm[bit3] + hm[bit4] + hm[bit5] + hm[bit6] + hm[bit7] + hm[bit8]
        for i in range(len(lead_zero)):
           if lead_zero[i] != '0':
               return lead_zero[i:]

        return "0"



print(Solution().toHex(0))