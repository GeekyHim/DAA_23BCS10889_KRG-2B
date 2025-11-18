import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public static int[] prevGreater(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            if(stack.isEmpty()) {
                ans[i] = -1;
                stack.push(arr[i]);
                continue;
            }

            if(stack.peek() > arr[i]) {
                ans[i] = stack.peek();
                stack.push(arr[i]);
                continue;
            }   



            while(!stack.isEmpty() && stack.peek() <=  arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }   

            stack.push(arr[i]);
            
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int val : ans) {
            list.add(val);
        }
        return list;
    }
}
