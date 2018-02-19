/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks.Controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import ThoughtWorks.DayTrack;
import ThoughtWorks.Session;
import ThoughtWorks.Track;
import ThoughtWorks.Constants.ConstantFile;
import ThoughtWorks.WorkEngine.Solver;

/**
 *
 * @author raja-1573
 */
public abstract class ConferenceManager {
    
    public int[] talksAllocation;
    public int totalSessionCount;
    public List<JSONObject> validTalksList;
    public List<Track> dayTrackList	                 	=   new ArrayList<Track>();
    public static JSONArray daySessionList 				= 	new JSONArray(ConstantFile.getProp("daysessionlist"));
    public static JSONObject dayTrackObject 			= 	new JSONObject(ConstantFile.getProp("daytracklist"));
    
    public void initialize(int[] talkAllocation, int totalSessionCount, List<JSONObject> validTalksList) {
    	this.talksAllocation 	= talkAllocation;
    	this.totalSessionCount 	= totalSessionCount;
    	this.validTalksList 	= validTalksList;
    }
    
    public void createTrackWithSession(String trackType) {
    	int totalTrackNeed = (int) Math.ceil((totalSessionCount+1)/2);
    	for(int i = 0; i < totalTrackNeed; i++) 
    	{
	        if("DAY_TRACK".equals(trackType)) {
	        	DayTrack t = (DayTrack) TrackFactory.getTrackObject(dayTrackObject);
	            for(int j=0; j< daySessionList.length(); j++) {
	            	JSONObject job = daySessionList.getJSONObject(j);
	            	Session	s = SessionFactory.getSessionObject(job);            	
	                t.addSessionToTrack(job.getString("name"), s);
	            }
	            this.dayTrackList.add(t);
	        }
        }   
    }
    
    public abstract int[] plan(Solver s, int[] bucket, int[] weight);
    public abstract void schedule();
    public abstract void writeResponse();
}
