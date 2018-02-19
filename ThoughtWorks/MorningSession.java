/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ThoughtWorks.Constants.ClockUtil;

/**
 *
 * @author raja-1573
 */
public class MorningSession extends Session implements SessionOperations{

    private List<Talk> talkList          =   new ArrayList<Talk>();
    int currentFilledTime = 0;

    public MorningSession(double sessionID, String sessionType, int scheduleStartTime, int scheduleEndTime, long scheduleDate) {
        this.sessionID = sessionID;
        this.sessionType = sessionType;
        this.currentFilledTime = scheduleStartTime;
        this.time = new TimeFrame(scheduleStartTime, scheduleEndTime, scheduleDate);
        this.status = Status.YET_TO_BEGIN;
    }
    
    @Override
    public void addTalkToSession(Talk talk) {
        talk.setStatus(Status.YET_TO_BEGIN);
        int endtime = ClockUtil.addTime(this.currentFilledTime, talk.getDuration());
        TimeFrame time = new TimeFrame(this.currentFilledTime, endtime, this.time.getScheduledDate());
        this.currentFilledTime = endtime;
        talk.setTime(time);
        talkList.add(talk);
    }

    public boolean changeTalkStatus(double id, Status status) {
        return false;
    }
    
    public String getTime(int time) {
    	DecimalFormat formatter = new DecimalFormat("00");
    	String result = formatter.format(time / 100) + ":" + formatter.format(time % 100) + " AM";
    	return result;
    }

	@Override
	public void printSession() {
		System.out.println();
		System.out.println("MORNING SESSION");
		Iterator<Talk> iter = talkList.iterator();
		while(iter.hasNext()) {
			Talk t = iter.next();
			System.out.println(t.getTitle() + " "+ t.getDuration() +" "+ this.getTime(t.getTime().getScheduleStartTime()));
		}
		
	}
    
}
