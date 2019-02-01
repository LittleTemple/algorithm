/**
 * Author:   amos
 * Date:     2019/1/29 4:55 PM
 * Description:
 */

public class q746 {
    //这个跟上一个很类似，但是是带有权值的。
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0){
            return 0;
        }else if(cost.length == 1){
            return cost[0];
        }
        //多阶段决策性问题，应该还是动态规划的问题.
        return min(cost.length,cost);



    }

    //返回的值就是需要的最小的消耗
    public int min(int index,int[] cost){
        if(index == 1){
            return cost[0];
        }else if(index == 2){
            return Math.min(cost[0],cost[1]);
        }
        //还是，有两种可能
        int min1 = min(index-1,cost)+cost[index-1];
        int min2 = min(index-2,cost)+cost[index-2];
        if(min1 > min2){
            return min2;
        }else{
            return min1;
        }

    }


    //动态规划还有贪心
    public int minCostClimbingStairs2(int[] cost) {
        //通过累加的方式，这样就可以算出到所有位置的消耗了。
        //对这种数值这种方法进行累加，真的是very nice！！！！！！
        for (int i = 2; i < cost.length; i++) {
            //这个就是用来求这个位置的最小值的
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        //判断是通过哪一个到达的最后一个。
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
}
