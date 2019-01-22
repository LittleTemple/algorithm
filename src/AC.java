import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:   amos
 * Date:     2019/1/22 8:14 PM
 * Description:
 * 本篇主要是介绍AC自动机的构建过程
 */
class ACNode{
    char data;
    ACNode[] children = new ACNode[26];//创建一个含有26个空位的数组，用来存放a~z,有点类似于Tire树
    boolean isEndingChar = false;//记录的是结尾字符
    int length = -1;//记录模式串的长度
    ACNode fail;//失败时候的指针
    ACNode(char data){
        this.data = data;
    }


}
public class AC{

    //创建一颗tire树
    private static ACNode root = new ACNode('/');

    public static void insertNode(char[] text){
        ACNode tmp = root;
        for (int i = 0;i<text.length;i++){
            int index = text[i] - 'a';
            if(tmp.children[index] == null){
                ACNode newNode = new ACNode(text[i]);
                tmp.children[index] = newNode;
            }
            tmp = tmp.children[index];
        }
        tmp.isEndingChar = true;
    }

    public static void buildFailurePointer(){
        Queue<ACNode> queue = new LinkedList<>();
        root.fail = null;//这是将根节点的fail指标设置为null
        ((LinkedList<ACNode>) queue).add(root);

        while (!queue.isEmpty()){
            ACNode p = queue.remove();
            for (int i = 0;i < 26;i++){
                ACNode pc = p.children[i];
                if(pc == null)
                    continue;
                if(p == root){
                    pc.fail = root;
                }else{
                    ACNode q = p.fail;
                    while (q != null){
                        ACNode qc = q.children[pc.data - 'a'];
                        if(qc != null){
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }

                    if (q == null){
                        pc.fail = root;
                    }
                }

                ((LinkedList<ACNode>) queue).add(pc);
            }

        }


    }

    public static void match(char[] text){ //text是主串
        int n = text.length;
        ACNode p = root;
        for (int i = 0;i<n;i++){
            int index = text[i] - 'a';
            while (p.children[index] == null && p!=null){
                p = p.fail;
            }
            p = p.children[index];
            if(p == null){
                p = root;
            }

            ACNode tmp = p;
            while (tmp != root){
                if (tmp.isEndingChar){
                    int pos = i - tmp.length+1;
                    System.out.println("匹配的起始下标为:"+pos+";长度"+tmp.length);
                }
                tmp = tmp.fail;
            }
        }

    }

    public static void main(String[] args){
        char[] text1 = {'a','b','c','e'};
        char[] text2 = {'b','c','d'};
        char[] text3 = {'c','e'};

        char[] mText = {'a','b'};

        insertNode(text1);
        insertNode(text2);
        insertNode(text3);

        buildFailurePointer();

        match(mText);




    }

}
