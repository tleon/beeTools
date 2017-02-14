package ragus.lienty.beetools;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by leone on 14/02/2017.
 */

public class NotificationSettings {
    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField (canBeNull = false, foreign = true, foreignAutoRefresh = true)
    public Characters charId;
    @DatabaseField
    public int notifType;
    @DatabaseField
    public boolean disable;

    public void NotificationSettings(){

    }

    public void NotificationSettings(Characters charId, int notifType, boolean disable){
        this.charId = charId;
        this.notifType = notifType;
        this.disable = disable;
    }

    public Characters getCharId() {
        return charId;
    }

    public void setCharId(Characters charId) {
        this.charId = charId;
    }

    public int getNotifType() {
        return notifType;
    }

    public void setNotifType(int notifType) {
        this.notifType = notifType;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
