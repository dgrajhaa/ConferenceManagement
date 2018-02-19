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
public class EveningSession extends Session implements SessionOperations{

    private List<Talk> talkList          =   new ArrayList<Talk>();
    int currentFilledTime = 0;
    
    public EveningSession(double sessionID, String sessionType, int scheduleStartTime, int scheduleEndTime, long scheduleDate, int bufferTime) {
        this.sessionID = sessionID;
        this.sessionType = sessionType;
        this.currentFilledTime = scheduleStartTime;
        time = new TimeFrame(scheduleStartTime, scheduleEndTime, scheduleDate, bufferTime);
        this.status = Status.YET_TO_BEGIN;
    }
    
    @Override
    public void addTalkToSession(Talk talk) {
    	talk.setStatus(Status.YET_TO_BEGIN);
        int endtime = ClockUtil.addTime(this.currentFilledTime, talk.getDuration());
        TimeFrame time = new TimeFrame(this.currentFilledTime, endtime, 0);
        this.currentFilledTime = endtime;
        talk.setTime(time);
        talkList.add(talk);
    }

    public String getTime(int time) {
    	DecimalFormat formatter = new DecimalFormat("00");
    	String result = formatter.format(time / 100) + ":" + formatter.format(time % 100) + " PM";
    	return result;
    }

	@Override
	public void printSession() {
		System.out.println();
		System.out.println("EVENING SESSION");
		Iterator<Talk> iter = talkList.iterator();
		while(iter.hasNext()) {
			Talk t = iter.next();
			System.out.println(t.getTitle() + " "+ t.getDuration() +" "+ this.getTime(t.getTime().getScheduleStartTime()));
		}
	}
    
}
