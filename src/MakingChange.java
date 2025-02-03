import java.util.ArrayList;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Niko Madriz
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            count(target, coins[i], list, i, coins);
        }
        return 0;
    }

    public static int count (int target, int coin, ArrayList<Integer> list, int i, int[] coins) {
        //Base case checking for out of bounds
        if (target <= 0) {
            return 0;
        }
        if (target % coin < target) {
            target = target % coin;
            list.add(target);
            return target;
        }
        i++;
        return count(coin, coins[i], list, i, coins);
    }

}
