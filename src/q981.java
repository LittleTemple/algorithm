import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class q981 {
    //这里需要记住，可以使用相当于多层hash表的方式来存储多个属性的值。
    private HashMap<String,HashMap<Integer,String>> kvs;

    /** Initialize your data structure here. */
    public q981() {
        kvs = new HashMap<String,HashMap<Integer,String>>();
    }

    public void set(String key, String value, int timestamp) {
        //这里要记得将相同的值对接到一块
        HashMap<Integer,String> tempMap = kvs.getOrDefault(key,new HashMap<Integer,String>());
        tempMap.put(timestamp,value);
        kvs.put(key,tempMap);
//         HashMap<Integer,String> tv = new HashMap<Integer,String>();  //这种方式是分开来的，确实是找不到
//         tv.put(timestamp,value);
//         kvs.put(key,tv);

    }

    public String get(String key, int timestamp) {
        if(!kvs.containsKey(key)) return "";
        else{
            Map<Integer,String> tempMap = kvs.get(key);
            for(int i = timestamp;i>=0;i--){//直接用这么暴力的方式吗？？
                if(tempMap.containsKey(i)){
                    return tempMap.get(i);
                }
            }
            return "";
        }


    }

    public String get21(String key, int timestamp) {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        if(treeMap==null) {
            return "";
        }
        Integer floor = treeMap.floorKey(timestamp);
        if(floor==null) {
            return "";
        }
        return treeMap.get(floor);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */