/**
 * Author:   amos
 * Date:     2019/1/27 10:10 AM
 * Description:
 * 关于Redis中的List结构
 */
class listNode{
    listNode pre;
    listNode next;
    int value;//这里应该可以是多种数据类型
}
public class RList {
    listNode head;
    listNode tail;
    long len;
}


