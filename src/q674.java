import java.util.HashMap;
import java.util.Scanner;

/**
 * Author:   amos
 * Date:     2019/1/31 12:17 PM
 * Description:
 */

public class q674 {
    // 首先第一种非常简单，就是记录长度即可
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //这个就可以使用差距算法，我是这么认为的。
        //计算所有的两个之间的差距，如果差距大于0，就将总和加一，否则的话，就将和归0
        int count = 1;
        int max = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                count++;
                max = Math.max(max,count);
            }else{
                count = 1;
            }
        }
        return max;

    }

    //第二种，叫做双指针的方式，一个标记最长数组的头，一个标记最长数组的尾
    public int findLengthOfLCIS2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //这个就可以使用差距算法，我是这么认为的。
        //计算所有的两个之间的差距，如果差距大于0，就将总和加一，否则的话，就将和归0
        int j = 0;
        int max = 1;
        for(int i = 0;i<nums.length;i++){
            if(i == 0||nums[i]<=nums[i-1]){
                j = i;
            }else{
                max = Math.max(max,j-(i-1));
            }
        }
        return max;

    }

    //第三种方式，使用的是动态规划。可以理解一下
    public int findLengthOfLCIS3(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];

        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            //当前下标的值有两种可能，一种为符合条件，一种不符合条件的。
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }




}
