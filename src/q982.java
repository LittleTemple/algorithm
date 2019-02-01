import java.util.*;

/**
 * Author:   amos
 * Date:     2019/1/28 10:04 AM
 * Description:
 */

public class q982 {
    int countTriplets(int[] A) {

        String str = "123";
        int count = 0;
        Map<Integer,Integer> list = new HashMap<>();
        for (int i = 0;i<A.length;i++){
            for (int j = 0;j<A.length;j++){
                int key = A[i] & A[j];
                int pre = list.get(key);
                list.put(key,pre+1);
            }
        }

        for (int i = 0;i<A.length;i++){
            for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
                int k = entry.getKey() & A[i];
                if(k == 0){
                    count += entry.getValue();
                }
            }
        }
        return count;
    }

    public int countTriplet(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int tmp = A[i] & A[j];
                for (int k = j; k < A.length; k++) {
                    int re = tmp & A[k];
                    if (re == 0) {
                        if (i == j && j == k) {
                            count += 1;
                        } else if (i == j || i == k || j == k) {
                            count += 3;
                        } else {
                            count += 6;
                        }
                    }
                }
            }
        }

        return count;
    }
}
