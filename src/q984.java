import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Author:   amos
 * Date:     2019/1/27 1:36 PM
 * Description:
 */

public class q984 {
    //贪心算法的应用，他的脑回路是什么呢？
    //首先解析题目的意思，不能出现连续的三个相同字符。说白了，
    // 就是两种情况，一个是1：1，一个是2：1。
    //1：1非常好办，其实就是两个相等的情况。这个时候可以直接求解没有难度。
    //2：1有点难办，因为他是2：1与1：1混合的情况。也就是在1：1的基础上，判断哪些是需要进行2：1，插入操作的。
    // 而且这个还有一个问题，就是你是插入到右边，还是插入到左边，还是混合插入。
    //这些都是问题。
    // 当然左边右边可以放在一起考虑。
    //如果是混合的插入的话，过程比较复杂，没有想过。
    //如果是插在相同的一边的话，底边这个就是一种解法。
    //我要做的就是将数量多的那个字符插入相同元素，而且都是插入到右边。之后剩下的就是1：1的了。

    public String greedy(int A,int B,char a,char b,String res){
        if(B > A){
            greedy(B,A,b,a,res);
        }
        while (A > 0 || B > 0){
            if(A > 0) {
                res += a;
                A--;
            }
            if(A > B){
                res += a;
            }
            if(B > 0){
                res += b;
                B--;
            }
        }
        return res;
    }

    //这个体现的更明显一点。
    public String simple(int A, int B) {
        String s = "";
        //首先搞定所有的ab，也就是1:1的情况.
        while(A != 0 && B!= 0){
            s = s +"a"+"b";
            A--;
            B--;
        }
        //之后判断是a多还是b多
        if(A != 0){
            s = s + "a";//这个地方可以不写，最后将没有用到的a加到最后就可以了
            A--;
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<s.length();i++){
                sb.append(s.charAt(i));
                if(A > 0 && s.charAt(i) == 'a'){
                    //在a的前面添加一个a，变成2:1的情况
                    sb.append('a');
                    A--;
                }
            }
            return sb.toString();
        }
        if(B != 0){
            s = "b" + s;
            B--;
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<s.length();i++){
                sb.append(s.charAt(i));
                if(B > 0 && s.charAt(i) == 'b'){
                    sb.append('b');
                    B--;
                }
            }
            return sb.toString();
        }
        return s;
    }

    //这种就是直接求解
    public String straight(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while(A + B > 0) {
            int l = sb.length();
            if (l > 1 && sb.charAt(l - 2) == sb.charAt(l - 1)) {//如果存在两个相同的字符
                if (sb.charAt(l - 1) == 'a') {//如果是a
                    sb.append('b');//添加b
                    B--;
                } else {
                    sb.append('a');
                    A--;
                }
            } else {
                if (A > B) {//带有上面贪心的意思，如果A多，添加a
                    sb.append('a');
                    A--;
                } else {
                    sb.append('b');
                    B--;
                }
            }
        }
        return sb.toString();
    }


    public String strWithout3a3b(int A, int B){

        String str = "";
        return greedy(A,B,'a','b',"");
    }

}
