/**
 * Author:   amos
 * Date:     2019/1/23 9:34 AM
 * Description:
 * 使用分治的思想获取一个数组的逆序对数
 *大致上的思路：
 * （1）首先应该是用递归的方式，将数组分为两个部分，分别求其中的逆序对数
 * （2）之后怎么对其进行合并呢？使用归并函数的方式。
 */

public class getReverseNum {
    private static int reverseNum = 0; //初始化逆序对数

    //我写的代码
//    //求两个数组之间的逆序对数,这个其实也是归并排序的一部分
//    private static int getNumBetweenAB(int[] partA,int[] partB){
//
//        int partReverseNum = 0;
//        int[] array = new int[partA.length+partB.length];
//
//        int flagA = 0;
//        int flagB = 0;
//        while (flagA<partA.length&&flagB<partB.length){
//            if (partA[flagA]<=partB[flagB]){
////                array[i] = partA[flagA];
//                flagA++;
//            }else{
////                array[flagA] = partB[flagB];
//                flagB++;
//                partReverseNum += partA.length-flagA;
//            }
//        }
//        return partReverseNum;
//
//    }
//
//    //将所有的数组分开,传入的参数是要求的数组
//    private static void recursion(int[] array){
//        int len = array.length;
//        if(len == 1){
//            return;
//        }
//
//        //求出本集合中的逆序对数
//        if(len == 2){
//            if (array[0] > array[1]){
//                reverseNum++;
//                return;
//            }
//        }
//
//        //判断奇偶，如果是奇数，将中间数补上
//        int half = 0;
//        if(len % 2 == 0){
//            half = (int) len/2;
//        }else{
//            half = len/2+1;
//        }
//
//
//
//        int[] partA = new int[half];
//        int[] partB = new int[len - half+1];
//
//        for (int i = 0;i<half;i++){
//            partA[i] = array[i];
//        }
//        for (int i = half-1;i<len;i++){
//            partB[i-half+1] = array[i];
//        }
//
//
//
//        //求出两个之间的逆序对数
//        reverseNum += getNumBetweenAB(partA,partB);
//    }
//    public static void main(String[] args){
//        int[] array = {2,4,3,1,5,6};
//        recursion(array);
//        System.out.println(reverseNum);
//    }


    //大佬写的代码
    public int count(int[] a,int n){
        mergeSortCounting(a,0,n-1);
        return reverseNum;
    }

    //这里他使用的是flag
    private void mergeSortCounting(int[] a,int p,int r){
        if(p >= r) return;
        int q = (p+r)/2;
        mergeSortCounting(a,p,q);
        mergeSortCounting(a,q+1,r);
        merge(a,p,q,r);
    }

    //大致思路相同，但是他用的是两个指针，而我用的是两个数组。还是他的这个比较好一点。
    private void merge(int[] a,int p,int q,int r){
        int i = p,j = q+1,k = 0;
        int[] tmp = new int[r-p+1];//关于两个两个下标之间的距离问题。
        while (i <= q && j <= r){
            if(a[i] <= a[j]){//判定如果前一个比后一个小，也就是不是逆序对
                tmp[k++] = a[i++];
            }else {
                reverseNum += q-i+1;
                tmp[k++] = a[j++];
            }
        }

        while (i <= q){
            tmp[k++] = a[i];
        }

        while (j <= r){
            tmp[k++] = a[j];
        }

        for (i = 0;i <= r-p;i++){
            a[p+i] = tmp[i];
        }

    }


}
