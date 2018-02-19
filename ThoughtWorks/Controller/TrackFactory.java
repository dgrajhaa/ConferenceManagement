/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks.Controller;

import org.json.JSONObject;

import ThoughtWorks.DayTrack;
import ThoughtWorks.Track;


/**
 *
 * @author raja-1573
 */
public class TrackFactory {
    public static Track getTrackObject(JSONObject TrackObj) {
        double trackID = TrackObj.getDouble("trackID");
		String trackType = TrackObj.getString("trackType");
        int scheduleStartTime = TrackObj.getInt("scheduleStartTime");
        int scheduleEndTime = TrackObj.getInt("scheduleEndTime");
        int scheduleDate = TrackObj.getInt("scheduleDate");
		if ("day".equals(trackType)) {
			 return new DayTrack(trackID, trackType, scheduleStartTime, scheduleEndTime, scheduleDate);
		} 
                    return null;
	}
    
}
