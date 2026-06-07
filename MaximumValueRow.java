import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of row and column:");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[r][c];
        for (int j = 0; j < c; j++) {
            dp[0][j] = grid[0][j];
        }
        for (int i = 1; i < r; i++) {
            int[] maxVals = fmaxsmax(dp, i - 1, c);
            int max1 = maxVals[0];
            int max2 = maxVals[1];
            int maxCol = maxVals[2];
            for (int j = 0; j < c; j++) {
                if (j == maxCol) {
                    dp[i][j] = grid[i][j] + max2;
                } else {
                    dp[i][j] = grid[i][j] + max1;
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int j = 0; j < c; j++) {
            answer = Math.max(answer, dp[r - 1][j]);
        }
        System.out.println("Maximum value: " + answer);
        sc.close();
    }
    public static int[] fmaxsmax(int[][] dp, int row, int C) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int maxCol = -1;

        for (int j = 0; j < C; j++) {
            if (dp[row][j] > max1) {
                max2 = max1;
                max1 = dp[row][j];
                maxCol = j;
            } else if (dp[row][j] > max2) {
                max2 = dp[row][j];
            }
        }
        return new int[]{max1, max2, maxCol};
    }
}
