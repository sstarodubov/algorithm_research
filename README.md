#Tips

If input array is sorted then
- Binary search
- Two pointers

If asked for all permutations/subsets then
- Backtracking

If given a tree then
- DFS
- BFS

If given a graph then
- DFS
- BFS

If given a linked list then
- Two pointers

If recursion is banned then
- Stack

If must solve in-place then
- Swap corresponding values
- Store one or more different values in the same pointer

If asked for maximum/minimum subarray/subset/options then
- Dynamic programming

If asked for top/least K items then
- Heap

If asked for common strings then
- Map
- Trie

Else
- Map/Set for O(1) time & O(n) space
- Sort input for O(nlogn) time and O(1) space

# bit operations

n - number

1. get last bit -> num & 1
2. erase last 1s bit -> (num - 1) & num. (100100 - 1) & 100100 = 100000
3. extract last set of 1s bit -> n &\~(n - 1). 10010 &~ (10010 - 1) = 10
4. get bit by idx -> (n >> idx) & 1
5. get first bit -> math.floor(math.log(number | 0) / math.log(2)) + 1
# combinatorics

1. amount of combinations: ((n-1) * (n)) / 2

# arrays:

1. window (fixed, dynamic)
2. 2 - ptr (read/ overwrite , shrinking/expanding)
3. prefix/suffix - sum
4. Kadane's algorithm \
    
    
    
    public int maxSubArray(int[] nums) { \
        int ans = nums[0]; \
        for (int i = 1; i < nums.length; i++) { \
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]); \
            ans = Math.max(ans, nums[i]); \
        }\
        return ans; \
    }
5. Monotoic stack: to solve the problem "Next Great Element"
6. These completed rows contain in total 1 + 2 + ... + k = (k * (k + 1)) // 2
