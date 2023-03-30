import java.util.Arrays;

public class kadanes {

    public static boolean isPossible(int[] arr, int k, int mid){
        int cowCount = 1;
        int lastPos = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] - lastPos >= mid){
                cowCount++;
                if(cowCount == k){
                    return true;
                }lastPos = arr[i];
            }
        }
        return true;
    }

    public static int aggressiveCows(int[] arr, int k){
        Arrays.sort(arr);
        int s = 0;
        int maxi = -1;
        for(int i=0; i<arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }
        int e = maxi;
        int ans = -1;
        int mid = s + (e-s)/2;
        while(s<=e){
            if(isPossible(arr, k, mid)){
                ans  = mid;
                s = mid+1;
            }else{
                e = mid-1;
            }mid = s + (e-s)/2;
        }return ans;

    }

    public static void main(String[] args) {

    }
}