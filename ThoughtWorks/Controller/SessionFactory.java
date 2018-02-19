/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks.Controller;

import org.json.JSONObject;

import ThoughtWorks.EveningSession;
import ThoughtWorks.LunchSession;
import ThoughtWorks.MorningSession;
import ThoughtWorks.NetworkSession;
import ThoughtWorks.Session;

/**
 *
 * @author raja-1573
 */
public class SessionFactory {
	
    public static Session getSessionObject(JSONObject sessionObj) {
	        Session s = null;
	        double sessionID = sessionObj.getDouble("id");
			String sessionType = sessionObj.getString("name");
	        int scheduleStartTime = sessionObj.getInt("startTime");
	        int scheduleEndTime = sessionObj.getInt("endTime");
	        int scheduleDate = sessionObj.getInt("date");
	        int bufferTime = sessionObj.getInt("buffer");
	        
			if ("morning".equals(sessionType)) {
				 s = new MorningSession(sessionID, sessionType, scheduleStartTime, scheduleEndTime, scheduleDate);
			} else if ("lunch".equals(sessionType)) {
				s = new LunchSession(sessionID, sessionType, scheduleStartTime, scheduleEndTime, scheduleDate);
			}
			else if("evening".equals(sessionType)) {
				s = new EveningSession(sessionID, sessionType, scheduleStartTime, scheduleEndTime, scheduleDate, bufferTime);
			}
			else if("network".equals(sessionType)) {
				s= new NetworkSession(sessionID, sessionType, scheduleStartTime, scheduleEndTime, scheduleDate);
			}
	        return s;
	}
}
