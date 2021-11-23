# bit operations

n - number

1. get last bit -> num & 1
2. erase last 1s bit -> (num - 1) & num. (100100 - 1) & 100100 = 100000
3. extract last set of 1s bit -> n &\~(n - 1). 10010 &~ (10010 - 1) = 10
4. get bit by idx -> (n >> idx) & 1

# combinatorics

1. amount of combinations: ((n-1) * (n)) / 2

# arrays:

1. window (fixed, dynamic)
2. 2 - ptr
3. prefix/suffix - sum
4. Kadane's algorithm
    example
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
