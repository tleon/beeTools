package ragus.lienty.asynctask;

import android.app.Notification;

/**
 * Created by leone on 27/02/2017.
 */

public class Notifications {

    private String notifId;
    private String notifType;
    private String read;


    public Notifications(){
        //Empty constructor for ORM
    }

    public Notifications(String notifId, String notifType, String read){

        this.notifId = notifId;
        this.notifType = notifType;
        this.read = read;
    }

    // Getter / Setter

    public String getNotifId() {
        return notifId;
    }

    public String getNotifType() {
        return notifType;
    }

    public boolean isRead() {
        if (read == "1")
            return true;
        else
            return false;
    }

    public void setRead(String read) {
        this.read = read;
    }

}
