/**
 * Author:   amos
 * Date:     2019/1/19 4:51 PM
 * Description:
 * the goal of this passage is to learn something about Recurrence
 * and also explore the Time complexity of Recurrence Tree.
 *
 *
 */

public class Recurrence {

    //k is the length of the subarrary each time
    //判断结尾是1的，之后判断结尾是2的，判断结尾是3的。。。
    public static void printPermutation(int[] data,int n,int k){
        //the end condition
        if(k == 1){
            //print all the data
            for (int i  = 0;i<n;i++){
                System.out.println(data[i]+" ");
            }
            System.out.println();
        }

        //将每个数依次和最后一个数进行交换
        for(int i = 0;i<k;i++){
            int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;

            //进行递归
            printPermutation(data,n,k-1);

            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;



        }
    }
    public static void main(String[] args){
        int[] a = {1,2,3,4};

        printPermutation(a,4,4);

    }
}
