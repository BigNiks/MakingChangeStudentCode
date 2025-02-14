import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Niko Madriz
 */

public class MakingChange {
    public static long countWays(int target, int[] coins) {
        Arrays.sort(coins);
        long total;
        long[][] arr = new long[coins.length][target + 1];
        //sets up base cases for both tab and mem
        for (int i = 0; i < coins.length; i++) {
            arr[i][0] = 1;
        }
        //tabulation (comment out for memoization)
        for (int i = 0; i < coins.length; i++){
            for (int j = 1; j <= target; j++) {
                //keeps track of our included and excluded values
                long include = 0;
                long exclude = 0;

                // Conditionally set the values of include and exclude
                //if j is not going out of bounds then solve for include
                if (j - coins[i] >= 0) {
                    include = arr[i][j - coins[i]];
                }
                //if i will not be going out of bounds then solve for exclude
                if (i > 0) {
                    exclude = arr[i - 1][j];
                }
                //save solution
                arr[i][j] = include + exclude;
            }
        }
        //return the solutions (both tab and mem)
        total = arr[coins.length - 1][target];
        //uncomment line below for memoization
        //total = count(target, coins, 0, arr);
        return total;
    }

    public static long count(int sum, int[] coins, int index, long[][] grid) {
        //base cases
        if (sum == 0) {
            return 1;
        }
        else if (index >= coins.length) {
            return 0;
        }
        else if (sum < 0) {
            return 0;
        }
        else if (grid[index][sum]  != 0) {
            return grid[index][sum];
        }
        //saves the value in current spot in array, adds included and excluded values
        grid[index][sum] = count(sum - coins[index], coins, index, grid) + count(sum, coins, index + 1, grid);
        return grid[index][sum];
    }
}
