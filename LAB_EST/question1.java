class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i=1;i<nums.length;i++){
            nums[i] += nums[i-1]; // prefix arr bn gya 
        }

        Map <Integer,Integer> freq = new HashMap<>();
        int rem = 0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]==k) count ++;
            rem = nums[j] - k;
            if(freq.containsKey(rem)) count += freq.get(rem);
            if(freq.containsKey(nums[j])) {
                freq.put(nums[j], freq.get(nums[j])+1);
            }else{
                freq.put(nums[j],1);
            }
        }
        return count;
    }
}