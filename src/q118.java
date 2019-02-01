import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class q118 {
    public List<List<Integer>> generate(int numRows) {
        //暴力吗？
        List<List<Integer>> rlist =
                new ArrayList<List<Integer>>();
        if(numRows<=0){
            return rlist;
        }
        //进行初始化
        List<Integer> zero = new ArrayList<Integer>();
        zero.add(1);
        rlist.add(zero);


        for(int i = 1;i<numRows;i++){
            List<Integer> prelist = rlist.get(i-1);
            ArrayList<Integer> clist = new ArrayList<Integer>();
            int half = prelist.size()/2;
            int sum = 0;
            clist.add(prelist.get(0));
            for(int j = 1;j<half+1;j++){
                sum = prelist.get(j) + prelist.get(j-1);
                clist.add(sum);
            }

            //下面开始判断当前行的奇偶,之后反向添加就可以了
            if(prelist.size() % 2 == 0){
                for(int j = half-1;j>=0;j--){
                    clist.add(clist.get(j));
                }
            }else{
                for(int j = half;j>=0;j--){
                    clist.add(clist.get(j));
                }
            }

            //将clist添加
            rlist.add(clist);
        }

        return rlist;



    }


    static List<List<Integer>> generate2(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            System.out.println(row);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }


    public static void main(String[] args){
        generate2(4);

    }

}