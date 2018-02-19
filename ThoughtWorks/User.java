/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks;

/**
 *
 * @author raja-1573
 */
public class User {

	private double userID;
    private String name;
    private long mobileNo;
    private String emailId;
//    private Map<Double, Talk> talkList = new Hashtable<Double, Talk>();

    public double getId() {
        return userID;
    }

    public void setId(double id) {
        this.userID = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
}
