/**
 * Author:   amos
 * Date:     2019/1/22 9:35 AM
 * Description:
 * 传说中最牛逼的BM算法实现;
 * 大致的讲一下BM实现的思路，分为两个规则：
 *
 * 坏字符：
 * (1)主串M,模式串P,在失配位置上的主串中的字符m,就是坏字符。
 * (2)找到P中和他相同且最靠后的字符p。-------这里可以使用遍历的方式，也可以使用散列表的方式
 * (3)移动模式串使得p与m对齐。
 *
 * 好后缀：
 * (1)主串M,模式串P,在匹配过程中已经匹配的部分{u},就是好后缀
 * (2)找到P中和他相同且最靠后的子串p。-------这里可以使用遍历的方式，也可以使用散列表的方式
 * (3)移动模式串使得p与m对齐。
 *
 * (4)如果找不到p,就找到好后缀{u}的后缀子串{u*},找到模式串P的前缀子串{*p},
 * (5)查看是否相同。如果相同，将两者对齐。如果没有，将模式串移动模式串长度。
 * ---------------------
 * 这里的后缀子串就是包含最后一个字符的子集。前缀子串就是包含第一个字符的子集。
 * 前缀子串同理。
 *
 * ——————————————————————
 * 预知详情，请查看https://littlemonk.site
 * 或者查看极客时间王争老师的数据结构与算法之美，与我一起学习。
 *
 *
 *
 *
 *
 */

public class BM {

    //这个全局变量是用来设定散列表的长度的
    private static final int SIZE = 256;

    //构建散列表，这里的p其实就是模式串，m是模式串的长度。
    private void getHash(char[] p,int m,int[] hash){
        //初始化
        for (int i = 0;i<SIZE;i++){
            hash[i] = -1;
        }

        for(int i = 0;i<m;i++){
            int ascii = (int)p[i]; //计算每一个的ascii值
            hash[ascii] = i;//以ascii作为下标，值为当前的下标值。
        }

    }

    //p是模式串,m是模式串的长度。

    private void getGS(char[] p,int m,int[] suffix,boolean[] prefix){
        for(int i = 0;i<m;i++){
            suffix[i] = -1;
            prefix[i] = false;
        }

        //这里其实用了一个小技巧。
        // 也就是如果主串和模式串含有相同的后缀子串，那么想要知道主串中的后缀字符是否在模式串中出现。
        // 只需要比较模式串的前缀与模式串的后缀即可。不需要再涉及到子串了。
        for (int i = 0;i<m-1;i++){
            int j = i;
            int k = 0;//这个是公共后缀子串的长度
            while (j>=0&&p[j] == p[m-k-1]){
                j--;
                k++;
                suffix[k] = j+1;
            }
            if(j == -1) prefix[k] = true; //这个地方等于-1，说明从j到0都是匹配的，也就是满足后缀子串与前缀子串相等。
        }


    }


    //这里的m是模式串的长度，j是坏字符在模式串中的下标
    private int moveByGS(int j,int m,int[] suffix,boolean[] prefix){
        int k = m - 1 - j;  //好后缀的长度
        if(suffix[k]!=-1)   //这里也就表示的是能够知道与好后缀匹配的前缀子串
            return j - suffix[k] + 1;   //这里我还是有个问题，这个suffix[k]不是就是0吗？
        for(int r = j+2;r<=m-1;r++){//这里的j+2,是因为上面的好后缀已经将j+1的部分比较完了。所以这个地方就不用在此比较了
            if(prefix[m-r]){ //这里的m-r就是长度
                return r;
            }
        }
        return m;
    }

    //这里的a为主串,p为模式串。
    public int bm(char[] a,int n,char[] p,int m){
        //坏字符的编写
        int[] hash = new int[SIZE];
        getHash(p,m,hash);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        getGS(p,m,suffix,prefix);


        int i = 0;//这个i,是主串与子串匹配的第一个字符的在主串中的下标
        while(i <= n-m){
            int j;
            for (j = m-1;j>=0;j--){//这个j是在模式串上滑动的游标
                if(a[i+j] != p[j]) //失配,此时坏字符在主串中对应的下标就为(i+j)
                    break;
            }
            if(j<0){
                return i;//j == 0，表示匹配成功，匹配的第一个字符在主串中的下标
            }
            //j是失配位置，hash[(int)a[i+j]]是坏字符在模式串中的最后位置
            int x = j-hash[(int)p[i+j]];
            int y = 0;
            if(j < m-1){ //这个是有好后缀的情况
                y = moveByGS(j,m,suffix,prefix);
            }
            i = i+Math.max(x,y);


        }

        return -1;//匹配不成功，返回-1


    }


}
