/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raja-1573
 */
public abstract class Track {
    
    public double trackID;
    public String tractType;
    public TimeFrame time;
    public Status status;
    public List<User> audience          =   new ArrayList<User>();

    public Track() {
    	
    }
    public double getTrackID() {
        return trackID;
    }

    public void setTrackID(double trackID) {
        this.trackID = trackID;
    }

    public String getTractType() {
        return tractType;
    }

    public void setTractType(String tractType) {
        this.tractType = tractType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TimeFrame getTime() {
        return time;
    }

    public void setTime(TimeFrame time) {
        this.time = time;
    }
    
}
