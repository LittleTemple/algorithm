import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Author:   amos
 * Date:     2019/1/23 3:04 PM
 * Description:
 * 主要是关于回溯算法
 * 0-1背包问题
 */

public class bag {

    //这个表示的是存储背包中物品总重量的最大值
    public int maxW = Integer.MAX_VALUE;

    // cw表示当前已经放入背包的重量，i表示当前是第几次放入。
    // items就是所有的物品,w表示背包所能承受的重量,n表示的是物品的个数
    public void f(int i,int cw,int[] items,int n,int w){
        if(cw == w||i == n){ //终止条件
            if(cw > maxW) maxW = cw; //这个是为了确保最后返回的一定是重量的最大值。
            return;
        }
        HashSet<String> list = new HashSet<>();
        //这里是有两种尝试，一种是没有选择当前物品，所以没有对重量进行更新
        f(i+1,cw,items,n,w);

        //这里是选择了当前物品，所以对重量进行了更新
        if((items[i]+cw) <= w){
            f(i+1,cw+items[i],items,n,w);
        }

    }

}
