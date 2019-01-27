/**
 * Author:   amos
 * Date:     2019/1/26 10:43 AM
 * Description:
 * 关于B+树的操作
 */

import org.junit.Test;

/**
 * 这是 B+ 树非叶子节点的定义。
 *
 * 假设 keywords=[3, 5, 8, 10]
 * 4 个键值将数据分为 5 个区间：(-INF,3), [3,5), [5,8), [8,10), [10,INF)
 * 5 个区间分别对应：children[0]...children[4]
 *
 * 可以使用getconfig来查看内存页的大小
 * m 值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小：
 * PAGE_SIZE = (m-1)*4[keywordss 大小]+m*8[children 大小]
 */

//一个是非叶子节点
class BPlusNode{
    public static int m = 5;//这个m表示根据内存页的大小来判断。
    public int[] keywords = new int[m-1];//非叶子节点使用keywords来分割区间
    public BPlusNode[] children = new BPlusNode[m];//保存子节点的指针
}

/**
 * 这是 B+ 树中叶子节点的定义。
 *
 * B+ 树中的叶子节点跟内部结点是不一样的,
 * 叶子节点存储的是值，而非区间。
 * 这个定义里，每个叶子节点存储 3 个数据行的键值及地址信息。
 *
 * k 值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小：
 * PAGE_SIZE = k*4[keyw.. 大小]+k*8[dataAd.. 大小]+8[prev 大小]+8[next 大小]
 */

//这个是叶子节点
class BPlusLeafNode{
    //k值同样是通过计算出来的。但是这个k值有什么意义呢？
    //表示的是每个叶子节点存储3个数据行的键值和地址信息
    public static int k = 3;

    public int[] keywords = new int[k];//存储的键值
    public long[] dataAddress = new long[k];//存储的地址值

    public BPlusLeafNode pre;//链表中的前驱节点
    public BPlusLeafNode next;//链表中的后继节点



}

