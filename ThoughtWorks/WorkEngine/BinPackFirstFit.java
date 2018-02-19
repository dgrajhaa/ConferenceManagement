package ThoughtWorks.WorkEngine;

public class BinPackFirstFit implements Solver{

	
	@Override
	public int[] allocate(int[] sessionDurations, int[] talkDuration) {
    	int m = sessionDurations.length;
    	int n = talkDuration.length;
    	int allocation[] = new int[n];
        
        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
      
     // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i=0; i<n; i++)
        {
            // Find the best fit block for current process
            int bestIdx = -1;
            for (int j=0; j < m; j++)
            {
                if (sessionDurations[j] >= talkDuration[i])
                {
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (sessionDurations[bestIdx] > sessionDurations[j])
                        bestIdx = j;
                }
            }
      
            // If we could find a block for current process
            if (bestIdx != -1)
            {
                // allocate block j to p[i] process
                allocation[i] = bestIdx;
      
                // Reduce available memory in this block.
                sessionDurations[bestIdx] -= talkDuration[i];
            }
        }
        return allocation;
	}

}
