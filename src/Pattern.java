/**
 * Author:   amos
 * Date:     2019/1/23 3:40 PM
 * Description:
 * 这一篇还有上一篇都是关于回溯算法，也就是传说中的backtracking
 * 这一个是正则表达式的例子
 */

public class Pattern {
    private boolean matched = false;
    private char[] pattern; //这个就是传说中的正则表达式
    private int plen;   //这个是正则表达式的长度

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    //输入一个字符串，还有字符串的长度
    public boolean isMatched(char[] text,int tlen) {
        matched = false;
        rmatch(0,0,text,tlen);
        return matched;
    }

    //分为两块，ti为文本的下标，pj为正则表达式的下标
    public void rmatch(int ti,int pj,char[] text,int tlen) {
        if (matched) return;
        if (pj == plen){
            if (ti == tlen){
                matched = true;
                return;
            }
        }
        if(pattern[pj] == '*'){
            for (int k = 0;k<=tlen-ti;k++){
                rmatch(ti+k,pj+1,text,tlen);
            }
        }else if(pattern[pj] == '?'){
            rmatch(ti,pj+1,text,tlen);
            rmatch(ti+1,pj+1,text,tlen);
        }else if(ti < tlen && pattern[pj] == text[ti]){
            rmatch(ti+1,pj+1,text,tlen);
        }

    }


}
