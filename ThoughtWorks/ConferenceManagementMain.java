/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

import ThoughtWorks.Constants.InputReader;
import ThoughtWorks.Constants.Reader;
import ThoughtWorks.Controller.ConferenceManager;
import ThoughtWorks.Controller.EventScheduler;
import ThoughtWorks.WorkEngine.BinPackBestFit;
import ThoughtWorks.WorkEngine.Solver;

/**
 *
 * @author raja-1573
 */
public class ConferenceManagementMain {
    public static void main(String args[]) throws IOException
    {
    	Reader r = new InputReader();
    	List<String> l = r.inputReader();
    	List<JSONObject> talks = r.parse(l);
    	Iterator<JSONObject> iter = talks.iterator();
    	int[] talkArray = new int[talks.size()];
    	int[] possibleSessionBlocks = new int[talks.size()];
    	int i = 0;
    	while(iter.hasNext()) {
    		JSONObject job = iter.next();
    		talkArray[i] = job.getInt("duration");
    		i++;
    	}
    	for(int j = 0; j < talkArray.length; j++) {
    		if(j % 2 == 0)
    			possibleSessionBlocks[j] = 180;
    		else 
    			possibleSessionBlocks[j] = 240;
    	}
    	Solver s = new BinPackBestFit();
        ConferenceManager conf = new EventScheduler();
        int[] allocation = conf.plan(s, possibleSessionBlocks, talkArray);
        int max = 0;
        for(i =0; i < allocation.length; i++) {
        	if(max < allocation[i])
        		max = allocation[i];
        }
        conf.initialize(allocation, max, talks);
        conf.createTrackWithSession("DAY_TRACK");
        conf.schedule();
        conf.writeResponse();
        
    }
    
}
