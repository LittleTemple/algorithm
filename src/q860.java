/**
 * Author:   amos
 * Date:     2019/1/23 9:08 PM
 * Description:
 * 其实就是使用的是贪心算法。
 */

class q860 {
    //这个其实还是贪心算法的一种，因为首先还是要近可能的使用10元的纸币。
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten  = 0;
        //暂时不需要twenty值
//        int twenty = 0;
        int len = bills.length;
        for(int i = 0;i<len;i++){
            if(bills[i] == 5){
                five++;
            }else if(bills[i] == 10){
                ten++;
                five--;
            }else{
//                twenty++;
                if(ten>0){
                    ten--;
                    five--; //这里会产生问题
                }else{
                    five = five - 3;
                }
            }

            //判定是否越界
            if(ten<0||five<0){
                return false;
            }
        }
        return true;
    }
}
