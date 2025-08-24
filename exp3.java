import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])) map.put(arr[i],map.get(arr[i])+1);
            else map.put(arr[i],1);
        }
        
        for(int key : map.keySet()){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(key); list.add(map.get(key));
            ans.add(list);
        }
        
        return ans;
    }
}