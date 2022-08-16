# math

- 1*k + 2*k + 3*k + ... + w * k => ((w * (w+1) * k)) / 2  
- `boolean являетсяЛиЧислоПростым(long num) {
        if (num == 2) return true;
        if (num == 3) return true;
        return (num * num) % 24 == 1;
  }`

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
