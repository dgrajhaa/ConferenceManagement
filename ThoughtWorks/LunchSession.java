/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks;

import java.text.DecimalFormat;

/**
 *
 * @author raja-1573
 */
public class LunchSession extends Session implements SessionOperations{

    public LunchSession(double sessionID, String sessionType, int scheduleStartTime, int scheduleEndTime, long scheduleDate) {
        this.sessionID = sessionID;
        this.sessionType = sessionType;
        time = new TimeFrame(scheduleStartTime, scheduleEndTime, scheduleDate);
        this.status = Status.YET_TO_BEGIN;
    }
    
    @Override
    public void addTalkToSession(Talk talkList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public String getTime(int time) {
    	DecimalFormat formatter = new DecimalFormat("00");
    	String result = formatter.format(time / 100) + ":" + formatter.format(time % 100) + " PM";
    	return result;
    }

	@Override
	public void printSession() {
		System.out.println();
		System.out.println("LUNCH SESSION");
		System.out.println(getTime(this.getTime().getScheduleStartTime()) + " "+ getTime(this.getTime().getScheduleEndTime()));
	}
    
}
