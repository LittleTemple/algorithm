
class q983 {
    public int mincostTickets(int[] days, int[] costs) {

        boolean[] dayIncluded = new boolean[366];//这个是所有的天数
        for (int day : days) {
            dayIncluded[day] = true;//初始化
        }
        int[] minCost = new int[366];
        minCost[0] = 0;
        for (int day = 1; day <= 365; ++day) {
            if (!dayIncluded[day]) {
                minCost[day] = minCost[day-1];
                continue;
            }

            int min;
            //考察上一个状态和当前状态之间的关系。
            min = minCost[day-1] + costs[0];
            min =Math.min(min, minCost[Math.max(0, day-7)] + costs[1]);
            min = Math.min(min, minCost[Math.max(0, day-30)] + costs[2]);
            minCost[day] = min;
        }

        return minCost[365];
    }
}