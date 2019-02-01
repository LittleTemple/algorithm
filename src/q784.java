import org.junit.Test;

import java.util.*;

class q784 {
    /*
     * 首先看到遍历所有情况的这个条件，我想到的就是回溯算法。事实上这种算法时间复杂度一般都比较高，不推荐使用。
     * 我的想法是，回溯，贪心，动态规划都要考虑的一个问题就是你要选择那个作为自己的上下步条件。
     * 这里我选的是每一个字符，也可以是选择所有的字母。我感觉这种方式可能会更简单一点，用时更少一点。
     * 之后就是对当前状态和下一个状态进行对比。我们可以发现，如果当前状态是数字，那么我们不需要对其进行变化，直接进入下一个状态就好。
     * 如果当前状态不是数字，那么可以有两种操作，我们选择了这个字符。也就是对其进行了变化的操作。或者我们没有选择这个字符，所以我们直接进入下一个状态。
     *
     * 我这里是直接利用的是HashSet不会出现重复的值的属性存贮
     * */
    static List<String> list2 = new ArrayList<>();
    HashSet<String> list = new HashSet<String>();
    //初始调用的时候是getchanged(S,0)

    //12ms,因为每次都要对字符串长度进行操作，属于n*n
    public void getchanged(String str, int index) {
        list.add(str);
        if (index == str.length()) {
            return;
        }
        char[] chars = str.toCharArray();
        getchanged(str, index + 1);
        if (!Character.isDigit(chars[index])) {
            char c = chars[index];
            if (c >= 'a' && c <= 'z') {
                chars[index] = (char) (chars[index] - 32);
            } else if (c >= 'A' && c <= 'Z') {
                chars[index] = (char) (chars[index] + 32);
            }
            String once = new String(chars);
            getchanged(once, index + 1);
        }
    }

    //6ms,因为每次操作是递增的,1+2+3...+n = (n*n)/2
    public void getchanged2(String orign, int length, int index, String str) {
        if (index == length) {
            list2.add(str);
            return;
        }
        char c = orign.charAt(index);
        String str2 = str;
        str2 += c;
        //直接进行下一步，可能是数字的情况，也可能是不选择这个字符的情况
        getchanged2(orign, length, index + 1, str2);

        //选择这个字符，并且进行下一步
        if (!Character.isDigit(c)) {
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 32);
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }
            str += c;
            getchanged2(orign, length, index + 1, str);
        }

    }


    public List<String> letterCasePermutation(String S) {
        getchanged(S, 0);
        List<String> res = new ArrayList<String>();
        for (String value : list) {
            res.add(value);
        }
        return res;
    }


    //他为什么会想到这种方式呢？
    //sou gar,我知道了。我想到的是多阶段决策，也就是判断这个到底要不要填进去。
    //而他所做的其实是多分支的问题，以后遇到这种多分枝的问题就可以选择这种方式。
    //这里使用的是DFS也就是广度优先
    public List<String> letterCasePermutation3(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }

    //既然想法有了，这里我再使用深度优先来计算一下。
    //这个是我写的深度遍历，再看看别人写的深度遍历
    public static List<String> letterCasePermutation4(String S) {
        //还需要在考察一下
        recurDfs(S, 0);
        return list2;
    }
    public static void recurDfs(String str, int index) {
        if (index == str.length()) {
            list2.add(str);
            return;
        }
        if (Character.isDigit(str.charAt(index))) {
            recurDfs(str, index + 1);
            return;//这个地方少了一个return，导致下面继续执行了。
        }
            char[] chs = str.toCharArray();
            chs[index] = Character.toUpperCase(chs[index]);
            String tmp = new String(chs);
            recurDfs(tmp, index + 1);

            chs[index] = Character.toLowerCase(chs[index]);
            String tmp2 = new String(chs);
            recurDfs(tmp2, index + 1);


    }


    //这是别人写的标准的深度遍历
    public List<String> letterCasePermutation41(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    //他这儿传递的是字符数组，对于java而言，字符数组会比字符串好用的多。
    void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        //判断如果是数字
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }
        //进行左孩子的遍历
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);

        //进行右孩子的遍历
        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }




}