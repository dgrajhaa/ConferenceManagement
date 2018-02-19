/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks.Controller;

import java.util.Iterator;

import org.json.JSONObject;

import ThoughtWorks.DayTrack;
import ThoughtWorks.EveningSession;
import ThoughtWorks.MorningSession;
import ThoughtWorks.Talk;
import ThoughtWorks.Track;
import ThoughtWorks.WorkEngine.Solver;

/**
 *
 * @author raja-1573
 */
public class EventScheduler extends ConferenceManager {

    @Override
    public int[] plan(Solver s, int[] bucket, int[] weight) {
        return s.allocate(bucket, weight);
  
    }
	@Override
	public void schedule() {
		for(int i =0; i< this.talksAllocation.length; i++) {
				int allo = this.talksAllocation[i];
				JSONObject job = this.validTalksList.get(i);
				int trackNo = (int) Math.ceil(allo/2);
				DayTrack track = (DayTrack) this.dayTrackList.get(trackNo);
				int sessionCnt = allo % 2;
				Talk t = new Talk(i, job.getString("title"), job.getInt("duration"));
				if(sessionCnt == 0) {
					MorningSession ms = (MorningSession) track.getSession("morning");
					ms.addTalkToSession(t);
				}
				else {
					EveningSession ms = (EveningSession) track.getSession("evening");
					ms.addTalkToSession(t);
				}
		}
	}
	@Override
	public void writeResponse() {
		Iterator<Track> iter = this.dayTrackList.iterator();
		while(iter.hasNext()) {
			DayTrack t = (DayTrack) iter.next();
			t.printTrack();
		}
		
	}
    
}
