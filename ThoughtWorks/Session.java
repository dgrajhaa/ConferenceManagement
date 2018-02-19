/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks;

/**
 *
 * @author raja-1573
 */
public abstract class Session {
    
    public double sessionID;
    public String sessionType;
    public TimeFrame time;
    public Status status;
    public int currentFilledTime;

    
    public double getSessionID() {
        return sessionID;
    }

    public void setSessionID(double sessionID) {
        this.sessionID = sessionID;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public TimeFrame getTime() {
        return time;
    }

    public void setTime(TimeFrame time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public int getCurrentFilledTime() {
        return currentFilledTime;
    }

    public void setCurrentFilledTime(int currentFilledTime) {
        this.currentFilledTime = currentFilledTime;
    }
}
