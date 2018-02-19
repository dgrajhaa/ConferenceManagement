package ThoughtWorks.WorkEngine;

public class BinPackBestFit implements Solver{


	@Override
	public int[] allocate(int[] sessionDurations, int[] talkDuration) {

		int[] allocation = new int[talkDuration.length];
    	for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
    		int res = 0;
    	    for (int i = 0; i < talkDuration.length; i++)
    	    {
    	        int min = sessionDurations[res] + 1;
    	        int bi = 0;
    	 
    	        for (int k=0; k < res; k++)
    	        {
    	            if (sessionDurations[k] >= talkDuration[i] && sessionDurations[k] - talkDuration[i] < min)
    	            {
    	                bi = k;
    	                min = sessionDurations[k] - talkDuration[i];
    	            }
    	        }
    	        // If no bin could accommodate weight[i],
    	        // create a new bin
    	        if (min == sessionDurations[res]+1)
    	        {
    	        	sessionDurations[res] -= talkDuration[i];
    	        	allocation[i] = res;
    	            res++;
    	        }
    	        else // Assign the item to best bin
    	        {
    	        	sessionDurations[bi] -= talkDuration[i];
    	        	allocation[i] = bi;
    	        }
    	    }
    	    
    	return allocation;
	}

}
