/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks;

/**
 *
 * @author raja-1573
 */
public class TimeFrame {
    
    private int scheduleStartTime;
    private int scheduleEndTime;
    private int actualStartTime;
    private int actualEndTime;
    private long scheduledDate;
    private long actualDate;
    private int bufferTime;

    public TimeFrame(int scheduleStartTime, int scheduleEndTime, long scheduledDate) {
        this.scheduleStartTime = scheduleStartTime;
        this.scheduleEndTime = scheduleEndTime;
        this.scheduledDate = scheduledDate;
    }

    public TimeFrame(int scheduleStartTime, int scheduleEndTime, long scheduleDate, int bufferTime) {
        this.scheduleStartTime  = scheduleStartTime;
        this.scheduleEndTime    = scheduleEndTime;
        this.scheduledDate      = scheduleDate;
        this.bufferTime         = bufferTime;
    }

    public int getScheduleStartTime() {
        return scheduleStartTime;
    }

    public void setScheduleStartTime(int scheduleStartTime) {
        this.scheduleStartTime = scheduleStartTime;
    }

    public int getScheduleEndTime() {
        return scheduleEndTime;
    }

    public void setScheduleEndTime(int scheduleEndTime) {
        this.scheduleEndTime = scheduleEndTime;
    }

    public int getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(int actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public int getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(int actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public long getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(long scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public long getActualDate() {
        return actualDate;
    }

    public void setActualDate(long actualDate) {
        this.actualDate = actualDate;
    }

    public int getBuffer() {
        return bufferTime;
    }

    public void setBuffer(int bufferTime) {
        this.bufferTime = bufferTime;
    }

    
}
