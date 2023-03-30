import java.util.ArrayList;

public class ARRAYLISTS_IN_JAVA {

    public static int storeWater(ArrayList<Integer> height){
        int maxWater  = 0;
        //brute force (test method)
        for(int i = 0; i < height.size(); i++){
            for (int j = i+1; j < height.size(); j++){
                int l1 = height.get(i);
                int l2 = height.get(j);
                int h = Math.min(l1,l2);
                int w = j-i;
                int currentWater = h*w;
                maxWater = Math.max(maxWater, currentWater);
            }
//            System.out.println(maxW);
        }
        return maxWater;
    }

    public static int MaxStroredWater(ArrayList<Integer> height){
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;

        while(lp < rp){
            int ht = Math.min(height.get(lp), height.get(rp));
            int w = rp - lp;
            int currWater = ht*w;
            maxWater = Math.max(maxWater, currWater);
            if(height.get(lp) < height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }return maxWater;
    }

    public static void swapping(ArrayList<Integer> arr, int idx1, int idx2){
//        method1
//        int element1 = arr.get(idx1);
//        int element2 = arr.get(idx2);
//        int a = element1;
//        int b = element2;
//        arr.set(idx1, b);
//        arr.set(idx2, a);

//        method2
//        int temp = arr.get(idx1);
//        arr.set(idx1, arr.get(idx2));
//        arr.set(idx2, temp);
    }



    public static int trappedWater(int[] height){
        int n = height.length;
//        getting lefatMax ==> array1
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
//        getting heightMax ==> array2
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int j=n-2; j>=0; j--){
            rightMax[j] = Math.max(height[j], rightMax[j+1]);
        }
//        trapped water
        int tw = 0;
        for(int k=0; k<n; k++){
            int cw = Math.min(leftMax[k], rightMax[k]) - height[k];
            tw += cw;
        }return tw;
    }

    public static boolean pairSum1(ArrayList<Integer> arrayList, int target){
        int lp = 0;
        int rp = arrayList.size()-1;

        while(lp != rp){
            if(arrayList.get(lp) + arrayList.get(rp) == target){
                return true;
            }else if(arrayList.get(lp) + arrayList.get(rp) < target) {
                lp++;
            }else{
                rp--;
            }
        }return false;
    }

//    pairsum1 my improvised
    public static void sumtargeted(ArrayList<Integer> arrayList, int target){
        int lp = 0;
        int rp = arrayList.size()-1;
        int sum = 0;

        while(lp < rp){
            sum = arrayList.get(lp) + arrayList.get(rp);
            if(sum > target){
                rp--;
            }else if(sum == target){
                System.out.println("OUR REQUIRED PAIR IS : ( " + arrayList.get(lp) + " , " + arrayList.get(rp) + " )");
                rp--;
                lp++;
            } else if(rp-lp == 1 && sum != target ) {
                System.out.println("SORRY THERE ISNT A PAIR FOR YOUR REQUIRED SUM 5 !!!");
                return;
            } else{
                lp++;
            }
        }
    }

    public static boolean sumtargetedByTwoPointers(ArrayList<Integer> arrayList, int target) {
        int bp = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > arrayList.get(i + 1)) {
                bp = i;
                break;
            }
            int lp = bp + 1;
            int rp = bp;
            int n = arrayList.size();

            while (lp != rp) {
                if (arrayList.get(lp) + arrayList.get(rp) == target) {
                    return true;
                } else if (arrayList.get(lp) + arrayList.get(rp) < target) {
                    lp = (lp + 1) % n;
                } else {
                    rp = (rp + n - 1);
                }
            }
        }
        return false;
    }

    public static void swapAlternate(ArrayList<Integer> mainList, int i) {
        int n = mainList.size();

        if (n % 2 == 0) {

            if (i == n) {

                for (int k = 0; k < n; k++) {
                    System.out.print(mainList.get(k) + " ");
                }
                return;
            } else {
                int c = mainList.get(i);
                mainList.set(i, mainList.get(i + 1));
                mainList.set(i + 1, c);
                swapAlternate(mainList, i + 2);
            }

        }
        if (n % 2 != 0) {
            for (int k = 0;k < n - 1; k += 2) {
                int c = mainList.get(i);
                mainList.set(k, mainList.get(i + 1));
                mainList.set(k + 1, c);
            }
        }
    }










        public static void main(String[] args) {

//         SWAP TWO NUMBERS OF A LIST
//        swap numbers at idx1 and idx2
//        ArrayList<Integer> my_array = new ArrayList<>();
//        my_array.add(0);
//        my_array.add(1);
//        my_array.add(2);
//        my_array.add(3);
//        my_array.add(4);
//        my_array.add(5);
//        swapping(my_array, 2,5);
//        System.out.println(my_array);

//        container with most volume of water(brute force method)      https://youtu.be/pxpcVMscHYQ?t=3863
//        height of array = [1,8,6,2,5,4,8,3,7]
//        ArrayList<Integer> h = new ArrayList<>();
//        h.add(1);
//        h.add(8);
//        h.add(2);
//        h.add(6);
//        h.add(5);
//        h.add(4);
//        h.add(8);
//        h.add(3);
//        h.add(7);
//        System.out.println(storeWater(h));

//        container with most water(two pointers approach)     https://youtu.be/pxpcVMscHYQ?t=5109
        //        height of array = [1,8,6,2,5,4,8,3,7]
//        ArrayList<Integer> h = new ArrayList<>();
//        h.add(1);
//        h.add(8);
//        h.add(2);
//        h.add(6);
//        h.add(5);
//        h.add(4);
//        h.add(8);
//        h.add(3);
//        h.add(7);
//        System.out.println(storeWater(h));


        //    trapped water                                    https://youtu.be/DBaewkhpsxs?t=8963
//        int[] ht = {4,2,0,6,3,2,5};
//        System.out.println(trappedWater(ht));

//        find a pair in given sorted array which gives the desired sum      https://youtu.be/pxpcVMscHYQ?t=5462
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.add(4);
//        arr.add(5);
//        arr.add(6);
//        System.out.println(pairSum1(arr, 5));;

//        find a pair in given sorted and rotated array which gives the desired sum    https://youtu.be/pxpcVMscHYQ?t=6000
//        method 1 brute force
//        methpd 2 two pointers

//            swapp elements      https://youtu.be/oVa8DfUDKTw?t=1594

//            find unique elements    https://youtu.be/oVa8DfUDKTw?t=1594




    }


}
