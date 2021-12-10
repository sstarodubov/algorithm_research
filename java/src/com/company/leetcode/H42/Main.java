package com.company.leetcode.H42;

import javax.swing.text.TableView;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        assert 9 == new Solution().trap(new int[]{4, 2, 0, 3, 2, 5});
        assert 1 == new Solution().trap(new int[]{5, 4, 1, 2});
        assert 6 == new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println("tests passed");
    }
}

class Solution {
    public int trap(int[] height) {
        int ans = 0;
        var st = new Stack<Integer>();
        for (int current = 0; current < height.length; current++) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int boundedHeight = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            st.push(current);
        }
        return ans;
    }
}