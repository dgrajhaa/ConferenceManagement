/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks.WorkEngine;

/**
 *
 * @author raja-1573
 */
public class KnapSackSolver implements Solver {

    @Override
    public int[] allocate(int[] sessionDurations, int[] talkDuration) {
    	int talks[] = {2, 5, 4, 7, 1, 3, 8 };
		int N = talks.length;

		int[] profit = new int[N];
		int[] weight = new int[N];
		
		for (int j = 0; j < N; j++) {
			profit[j] = weight[j] = talks[j];
		}
                boolean[] takeIndex = knapsackAlgorithm(N, 10, profit, weight);
                for(int k = 0; k < takeIndex.length; k++)
                	System.out.println(takeIndex[k]);
                return null;
		
    }
    
    private static boolean[] knapsackAlgorithm(int N, int W, int[] profit, int[] weight) {
     
        int[][] opt = new int[N + 1][W + 1];
		boolean[][] sol = new boolean[N + 1][W + 1];

		for (int n = 1; n < N; n++) {
			for (int w = 1; w <= W; w++) {

				// don't take item n
				int option1 = opt[n - 1][w];

				// take item n
				int option2 = Integer.MIN_VALUE;
				if (weight[n] <= w)
					option2 = profit[n] + opt[n - 1][w - weight[n]];

				// select better of two options
				opt[n][w] = Math.max(option1, option2);
				sol[n][w] = (option2 > option1);
			}
		}

		// determine which items to take
		boolean[] take = new boolean[N + 1];
		for (int n = N, w = W; n > 0; n--) {
			if (sol[n][w]) {
				take[n] = true;
				w = w - weight[n];
			} else {
				take[n] = false;
			}
		}
                return take;
    }
       
}
