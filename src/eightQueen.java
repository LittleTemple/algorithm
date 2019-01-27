import org.junit.Test;

/**
 * Author:   amos
 * Date:     2019/1/23 11:19 AM
 * Description:
 * 关于八皇后问题:8*8的矩阵。向里面放置棋子，每个棋子的每一行，每一列，
 * 还有交于这一点的对角线都不能有棋子存在。
 */

public class eightQueen {

    //其实就是8个棋子，用下标来代表每一行，用值来代表第几列
    int[] result = new int[8];

    public  void cal8queens(int row){

        if(row == 8){ //满足条件，输出数组，跳出
            printQueens(result);
            return;
        }

        for (int col = 0;col<8;col++){//每一列每一列的试探
            if(isOk(row,col)){ //判断是否满足条件
                result[row] = col;
                cal8queens(row+1);
            }
        }

    }

    public  boolean isOk(int row,int col){
        int leftup = col-1,rightup = col+1;
        for (int i = row-1;i>=0;i--){
            if (result[i] == col) return false;
            if (leftup > 0){
                if (result[i] == leftup) return false;
            }
            if(rightup < 8){
                if (result[i] == rightup) return false;
            }

            //依次判断对角线
            leftup--;
            rightup++;
        }
        return true;
    }

    public  void printQueens(int[] result){
        for (int row = 0;row<8;row++){
            for (int col = 0;col<8;col++){
                if(col == result[row]){
                    System.out.print("*");
                }else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }

    }

    @Test
    public void test(){
         cal8queens(0);
    }
}
