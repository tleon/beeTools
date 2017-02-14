package ragus.lienty.beetools;


import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 * Created by Tom on 13/02/2017.
 */

public class Characters {
    @DatabaseField(id = true, columnName = "charId")
    public int charId;
    @DatabaseField (canBeNull = false, foreign = true, foreignAutoRefresh = true)
    public Account accId;
    @DatabaseField
    public String name;
    @DatabaseField
    public Date expireCacheDate;
    @DatabaseField
    public boolean isActive;

    public void Characters(){

    }

    public void Characters(int charId, String name, Account accId, boolean isActive, Date expireCacheDate){
        this.charId = charId;
        this.name = name;
        this.accId = accId;
        this.isActive = isActive;
        this.expireCacheDate = expireCacheDate;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public void setAccId(Account accId) {
        this.accId = accId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpireCacheDate(Date expireCacheDate) {
        this.expireCacheDate = expireCacheDate;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCharId() {
        return charId;
    }

    public Account getAccId() {
        return accId;
    }

    public String getName() {
        return name;
    }

    public Date getExpireCacheDate() {
        return expireCacheDate;
    }

    public boolean isActive() {
        return isActive;
    }



}
