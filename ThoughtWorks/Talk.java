/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks;

/**
 *
 * @author raja-1573
 */
public class Talk {

	private double talkID;
    private String title;
    private User author;
    private int duration;
    private TimeFrame time;
    private Status status;

    public Talk(double talkID, String title, int duration) {
        this.talkID = talkID;
        this.title = title;
        this.author = new User();
        this.duration = duration;
        this.status = Status.YET_TO_SCHEDULE;
    }
    
    public Talk(Talk t) {
        this.talkID     =   t.talkID;
        this.title      =   t.title;
        this.author     =   t.author;
        this.duration   =   t.duration;
        this.time       =   t.time;
    }

    
    public double getTalkID() {
        return talkID;
    }

    public void setTalkID(double talkID) {
        this.talkID = talkID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public TimeFrame getTime() {
        return time;
    }

    public void setTime(TimeFrame t) {
        this.time = t;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status s) {
        this.status = s;
    }
    
    
    
}
