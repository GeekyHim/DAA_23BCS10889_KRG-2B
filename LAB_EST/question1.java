package LAB_EST;

public class question1 {
    public int subarraySum(int[] arr, int k) {
        int i = -1, j=0, sum=arr[j], count = 0, n = arr.length, target = k;
        while(i < n && j < n) {
            if(sum == target) {
                count++;
                j++;
                if(j < n) sum += arr[j];
            } else if(sum < target) {
                j++;
                if(j < n) sum += arr[j];
            } else {
                i++;
                if(i<n && i<=j) sum -= arr[i];
            }
        }

        while(i < n) {
            if(sum == target) {
                count++;
            }
            i++;
            if(i<n) sum -= arr[i];
        }
        if(sum == target) count++;

        return count;
    }
}
