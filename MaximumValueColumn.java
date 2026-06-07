import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows and columns: ");
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] grid = new int[R][C];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[R][C];
        for (int row = 0; row < R; row++) {
            dp[row][0] = grid[row][0];
        }
        for (int col = 1; col < C; col++) {
            int[] maxVals = fmaxsmax(dp, col - 1, R);
            int max = maxVals[0];
            int secondMax = maxVals[1];
            for (int row = 0; row < R; row++) {
                if (dp[row][col - 1] == max) {
                    dp[row][col] = grid[row][col] + secondMax;
                } else {
                    dp[row][col] = grid[row][col] + max;
                }
            }
        }
        int result = fmaxsmax(dp, C - 1, R)[0];
        System.out.println("Final Answer = " + result);
        sc.close();
    }
    public static int[] fmaxsmax(int[][] dp, int col, int R) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int row = 0; row < R; row++) {
            if (dp[row][col] > max) {
                secondMax = max;
                max = dp[row][col];
            } else if (dp[row][col] > secondMax) {
                secondMax = dp[row][col];
            }
        }
        return new int[]{max, secondMax};
    }
}
