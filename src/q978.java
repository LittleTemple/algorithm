import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Author:   amos
 * Date:     2019/1/20 3:27 PM
 * Description:
 * leetcode第978道题,这里可以看到波浪型的数据就可以这样进行操作。
 */

public class q978 {

    static int maxTurbulenceSize(int[] A) {


        ArrayList<Integer> list = new ArrayList<>();
        //利用正负数的特性将凸和凹两种进行统一
        for(int i = 1;i<A.length;i++){
            if(A[i]>A[i-1]){
                list.add(1);
            }else if(A[i]<A[i-1]){
                list.add(-1);
            }else{
                list.add(0);
            }
        }

        int count = 0;
        int max = 0;
        for(int i = 1;i<list.size();i++){

            if(list.get(i)*list.get(i-1)<0){
                count++;
            }else{
                //使用count来统计每次的长度，一旦遇到不符合的就将count清零
                if(count>max){
                    max = count;
                }
                count = 0;
            }
        }
        //最后这里是为了防止最后几个都是符合条件的，这样max值得不到更新.
        //例如...55 12 24
        if(count>max){
            max = count;
        }

        //有max个空格，也就有max+1个数，加上最后一个数。
        return max+2;




    }

    public static void main(String[] args){
        int[] A= {0,8,45,88,48,68,28,55,12,24};
        maxTurbulenceSize(A);
    }
}
