import java.io.PrintWriter;

/**
 * Author:   amos
 * Date:     2019/1/22 5:20 PM
 * Description:
 * Tire树的实现
 */
class TireNode{
    char data;
    TireNode[] children = new TireNode[26];
    boolean isEndingChar = false;

    TireNode(char data) {
        this.data = data;
    }

    TireNode() {

    }
}

public class Tire {
    private static TireNode root = new TireNode('/');

    //向tire树中插入一个节点
    public static void insert(char[] text){
        TireNode p = root;
        for (int i = 0;i<text.length;i++){
            int index = text[i] - 'a';
            if(p.children[index] == null){ //判断插入的节点在当前节点parent的子节点中不存在
                TireNode newNode = new TireNode(text[i]);//用插入节点的值创建新的节点child。
                p.children[index] = newNode;//将parent对应的位置设置为新的节点child
            }
            p = p.children[index];//将指针指向新创建的节点child
        }
        p.isEndingChar = true;//设定每个分支最后一个字符的判定条件
    }

    //在tire树中查询一个节点,其中pattern是要查询的字符串的字符数组
    public boolean find(char[] pattern){
        TireNode p = root;
        for(int i = 0;i<pattern.length;i++){
            int index = pattern[i] - 'a';
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];//遍历其子节点

        }
        if(p.isEndingChar){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args){
        char[]  text = {'a','b','c','d','e'};
        insert(text);


    }
}
