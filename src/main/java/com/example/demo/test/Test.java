package com.example.demo.test;

import java.util.Arrays;

/**
 * ClassName: Test
 * Package: com.example.demo.test
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        nums = [1,2,3,4,5,6,7], k = 3
//        目标：[5,6,7,1,2,3,4]
//        int[]  result= test1(new int[]{1,2,3,4,5,6,7},1);
//        Arrays.stream(result).forEach(System.out::println);
        int[]  nums= test1(new int[]{1,2,3,4,5,6,7},1);
        int max = 0;
        for(int i= 0;i<nums.length-1;i++){
            max = max > ((i + nums[i])) ? max : (i + nums[i]);

            if(max >= nums.length){
//                return true;
            }
        }

        test2(new int[]{1,2,3,4,5,6,7});
    }

    private static int test2(int[] prices) {
        int min_price = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min_price < 0) {
                min_price = prices[i];
            }else {
                maxProfit = prices[i] - min_price > maxProfit ? prices[i] - min_price: maxProfit;
                return maxProfit;
            }
        }
        return maxProfit;
    }

    static int[] test1(int[] nums,int k){
        int n = nums.length - 1;
        if (nums.length <= 1) return nums;

        k = k % nums.length; // 关键！防止 k > n

        reverseArr(nums,0, n);
        reverseArr(nums,0,k-1);
        reverseArr(nums,k,n);
        return nums;
    }

    private static void reverseArr(int[] nums, int start, int end) {
        if (nums.length == 0 || nums.length == 1) return;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
