/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author raja-1573
 */
public class DayTrack extends Track implements TrackOperations{

    private Map<String, Session> sessionList    =   new HashMap<String, Session>();
    
    public DayTrack(double trackID, String tractType, int scheduleStartTime, int scheduleEndTime, long scheduleDate) {
        this.trackID = trackID;
        this.tractType = tractType;
        time = new TimeFrame(scheduleStartTime, scheduleEndTime, scheduleDate);
        this.status = Status.YET_TO_BEGIN;
    }
    
    public boolean changeSessionStatus(double id, Status status) {
        return false;
    }
    
    public boolean changeSessionTimeFrame(double id, TimeFrame time) {
        return false;
    }

	@Override
	public void addSessionToTrack(String sessionType, Session session) {
		if("morning".equals(sessionType)) 
			this.sessionList.put(sessionType, (MorningSession) session);
		else if("evening".equals(sessionType)) 
			this.sessionList.put(sessionType, (EveningSession) session);
		else if("lunch".equals(sessionType)) 
			this.sessionList.put(sessionType, (LunchSession) session);
		else if("network".equals(sessionType)) 
			this.sessionList.put(sessionType, (NetworkSession) session);
	}

	public Session getSession(String sessionType) {
		return this.sessionList.get(sessionType);
	}
	@Override
	public void printTrack() {
		MorningSession ms = (MorningSession) this.sessionList.get("morning");
		LunchSession   ls = (LunchSession) this.sessionList.get("lunch");
		EveningSession es = (EveningSession) this.sessionList.get("evening");
		NetworkSession ns = (NetworkSession) this.sessionList.get("network");
		ms.printSession();
		ls.printSession();
		es.printSession();
		ns.printSession();
	}
    
}
