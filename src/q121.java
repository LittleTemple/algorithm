/**
 * Author:   amos
 * Date:     2019/1/29 2:58 PM
 * Description:
 */

class q121 {
    //翻译一下，大致就是第i个元素就是第i天的价格，最后输出的是最大的利润
    //其实就是找到相差最大的两个数，但是保证小的数在前面。这不是废话嘛
    //或者怎么换一种解释？
    //最大值的问题，会不会是用的是贪心算法？
    //贪心算法就是多阶段决策的一个过程，那么我选择那个作为自己的阶段呢？
    //就选择区间中的两个数的最大差作为阶段。
    //有个前提，前一个数必须比后一个要小
    //考察前后状态
    //需要知道两个差别最大的下标和值
    //如果后加入的i，比最小的那个小。不对这个思路有问题
    //emmmm,两层for循环就行了,就是这个肯定可以，但是时间太长了。
    //emmm，怎么对其进行优化呢？
    public int maxProfit(int[] prices) {
        //翻译一下，大致就是第i个元素就是第i天的价格，最后输出的是最大的利润
        //其实就是找到相差最大的两个数，但是保证小的数在前面。这不是废话嘛
        //或者怎么换一种解释？
        //最大值的问题，会不会是用的是贪心算法？
        //贪心算法就是多阶段决策的一个过程，那么我选择那个作为自己的阶段呢？
        //就选择区间中的两个数的最大差作为阶段。
        //有个前提，前一个数必须比后一个要小
        //考察前后状态
        //需要知道两个差别最大的下标和值
        //如果后加入的i，比最小的那个小。不对这个思路有问题
        //emmmm,两层for循环就行了,就是这个肯定可以，但是时间太长了。
        //emmm，怎么对其进行优化呢？
        //
        int max = 0;
        for(int i = 0;i<prices.length;i++){
            int flag = prices[i];
            for(int j = i+1;j<prices.length;j++){
                if(prices[j]>flag){
                    max = Math.max((prices[j]-flag),max);
                }
            }
        }
        return max;
    }

    //这个就是传说中的Kadane's Algorithm。不知道是什么，不过挺牛逼的
    //这个和674很像
    public int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            //其实就是通过求和来计算两个数之间的距离的。
            //如果判断两个数一旦变为0以下，就可以将其舍弃，防止影响后面的计算。导致出现76。。56的情况
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    //这个更简单
    //这里可以学到的就是，可以使用一个数来获取最小值。
    public int maxProfit3(int[] prices){
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);//记录前面的最小值
            maxPro = Math.max(maxPro, prices[i] - minPrice);//计算最大值
        }
        return maxPro;
    }


}