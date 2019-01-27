import org.junit.Test;

import java.util.Arrays;


/**
 * Author:   amos
 * Date:     2019/1/23 9:14 PM
 * Description:
 * 贪心算法样例之二，
 * 这一次的期望值其实是小孩的数量
 * 这一次的限定元素是蛋糕，他有两个元素，数量还有大小。
 * 数量不会随着分配的变化而变化，所以真相只有一个：
 * 这道题的限定值为蛋糕的大小。
 *
 * 好吧！上面一通吹逼其实没啥用。
 *
 *
 */

public class q455 {
    //其中g表示的是需求数值，s表示的蛋糕的大小数值
    public int findContentChildren(int[] g, int[] s) {
        if(g.length == 0||s.length == 0){
            return 0;
        }
        int childGetCookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;
        for (int i = 0;i<g.length;i++){//现在开始给孩子找妈，啊呸，给孩子找糖吃

            while (s[j]<g[i]){
                j++;
                if(j>=s.length){
                    return childGetCookie;
                }
            }

            childGetCookie++;
        }

        return childGetCookie;

    }

}
