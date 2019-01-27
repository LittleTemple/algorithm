/**
 * Author:   amos
 * Date:     2019/1/23 7:22 PM
 * Description:
 * 利用动态规划对背包问题进行进一步的解读
 *
 */

public class bag2 {
    //items:所有的物品的重量, n:物品的个数，w:背包可以承载的重量
    public int knapsack(int[] items,int n,int w){
        boolean[][] status = new boolean[n][w];
        //这个表示的是第一个物品,下标为0
        // 有两种情况，一种是0,一种是items[0]
        status[0][0] = true;
        status[0][items[0]] = true;

        //i == 1,表示的是第二个物品
        for (int i = 1;i<n;i++){ //开始根据第一个物品的状态向下推导
            for (int j = 0;j<=w;j++){   //不将当前的这个物品放入背包中
                if(status[i-1][j]){     //判断上一个成立
                    status[i][j] = status[i-1][j];
                }
            }

            for (int j = 0;j<=w;j++){   //将当前的这个物品放入背包中
                if(status[i-1][j]){     //判断上一个成立
                    status[i-1][j+items[i]] = true;
                }
            }
        }

        for (int i = w;i >= 0;i--){
            if (status[n-1][i]){//这里是n-1是因为下标是从0开始的
                return i;
            }
        }

        return 0;

    }

    public int knapsack2(int[] items,int n,int w){
        boolean[] status = new boolean[w+1];
        //这个表示的是第一个物品,下标为0
        // 有两种情况，一种是0,一种是items[0]
        status[0] = true;
        status[items[0]] = true;

        for (int i = 1;i<n;i++){ //这个毫无疑问，肯定是指的是
            for (int j = w-items[i];j>=0;j--){
                if (status[j]){
                    status[j+items[j]] = true;
                }
            }
        }

        for (int i = w;i >= 0;i--){
            if (status[i]){
                return i;
            }
        }

        return 0;


    }





}
