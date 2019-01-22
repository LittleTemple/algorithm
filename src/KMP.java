/**
 * Author:   amos
 * Date:     2019/1/22 3:50 PM
 * Description:
 * 本篇主要实现的是KMP算法
 * 大致的思路很简单，其实就是找到模式串中相同前缀子串和后缀子串，并且使这个子串的长度最大化。
 * 之后在主串和模式串进行比较的时候，一旦产生好前缀（ps：KMP是从前向后比较），并且发生失配。
 * 就将模式串的后缀子串与主串中的适配位置进行对齐即可。
 * ——————————————————————
 *  * 预知详情，请查看https://littlemonk.site
 *  * 或者查看极客时间王争老师的数据结构与算法之美，与我一起学习。
 */

public class KMP {

    private int[] getNext(char[] p, int m) {
        System.out.println("");
        return null;
    }


    //这里的a为主串,p为模式串。n是主串的长度，m是模式串的长度。
    public int kmp(char[] a,int n,char[] p,int m){
        int[] next = getNext(p,m);
        int i = 0;
        for (i = 0;i<n-m+1;i++){
            if(a[i] != p[i]){
                break;
            }
        }
        return -1;

    }

    private static int[] getNexts(char[] p,int m){
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1;i < m;i++){
            while (k != -1 && p[k+1] != p[i]){
                k = next[k];
            }
        }

        return null;
    }


    public static void main(String[] args){
        //坏字符的编写


    }
}
