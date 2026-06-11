import java.util.*

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements (only 0s and 1s):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        int preSum = 0;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            preSum += (arr[i] == 0) ? -1 : 1;

            if (preSum == 0) {
                res = i + 1;
            }

            if (mp.containsKey(preSum)) {
                res = Math.max(res, i - mp.get(preSum));
            } else {
                mp.put(preSum, i);
            }
        }

        System.out.println("Length of the longest subarray with equal number of 0s and 1s: " + res);
        
        sc.close();
    }
}
