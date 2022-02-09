from typing import List


class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        d = {list1[i]: i for i in range(len(list1))}
        ans, last_sum = [], float("inf")
        for i in range(len(list2)):
            w = list2[i]
            if w in d:
                cur = d[w] + i
                if cur < last_sum:
                    ans.clear()
                    ans.append(w)
                    last_sum = cur
                elif cur == last_sum:
                    ans.append(w)
        return ans


assert Solution().findRestaurant(list1=["Shogun", "Tapioca Express", "Burger King", "KFC"],
                                 list2=["KFC", "Shogun", "Burger King"]) == ["Shogun"]

assert Solution().findRestaurant(list1=["Shogun", "Tapioca Express", "Burger King", "KFC"],
                                 list2=["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse",
                                        "Shogun"]) == ["Shogun"]
