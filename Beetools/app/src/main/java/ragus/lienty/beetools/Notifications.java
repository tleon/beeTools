package ragus.lienty.beetools;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by leone on 14/02/2017.
 */

public class Notifications {
    @DatabaseField(id =true)
    public int notifId;
    @DatabaseField
    public int notifType;
    @DatabaseField
    public int senderId;
    @DatabaseField (canBeNull = false, foreign = true, foreignAutoRefresh = true)
    public Characters charId;
    @DatabaseField
    public String senderName;
    @DatabaseField
    public Date sentDate;
    @DatabaseField
    public boolean isRead;

    public void Notifications(){

    }

    public void Notifications(int notifId, int notifType, int senderId, String senderName, Date sentDate, Characters charId, boolean isRead){
        this.notifId = notifId;
        this.notifType = notifType;
        this.senderId = senderId;
        this.senderName = senderName;
        this.sentDate = sentDate;
        this.charId = charId;
        this.isRead = isRead;
    }

    public int getNotifId() {
        return notifId;
    }

    public void setNotifId(int notifId) {
        this.notifId = notifId;
    }

    public int getNotifType() {
        return notifType;
    }

    public void setNotifType(int notifType) {
        this.notifType = notifType;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public Characters getCharId() {
        return charId;
    }

    public void setCharId(Characters charId) {
        this.charId = charId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
