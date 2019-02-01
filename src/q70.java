class q70 {
//     public int climbStairs(int n) {
//         if(n == 1){
//             return 1;
//         }else if(n == 2){
//             return 2;
//         }
//         //不能使用逆向的方式，只能使用正向的方式了。
//         int[] arr = new int[n+1];
//         arr[1] = 1;
//         arr[2] = 2;

//         int i = 1;
//         while(i <= n-2){
//             arr[i+2] = arr[i]+arr[i+1];
//             i++;
//         }

//         return arr[n];
//     }

    public int climbStairs(int n) {
        // base cases
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for(int i=2; i<n; i++){
            all_ways = one_step_before + two_steps_before;
            //之后继续累加就好了,每一次都是之前1步的和之前2步的之和/最后得出的就是最终解
            //这里的顺序纯粹是为了不让one_step_before = one_step_before出现
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }

    //pos表示的是当前已经走到的位置，n表示的是台阶数,返回值就是到当前位置的不同的走法
    //很明显，因为使用的是函数进行递归，所以时间过长了，所以改用数组的方式
    public int DP(int pos){
        //第一反应就是DP，那么就是考察走到pos位置的上一个状态，有几种可能。
        //很明显，有两种可能，要么是通过一步过来的，要么是通过两步过来的。
        //ok，问题解决
        if(pos == 1){
            return 1;
        }else if(pos == 2){
            return 2;
        }

        return DP(pos-1)+DP(pos-2);


    }
}