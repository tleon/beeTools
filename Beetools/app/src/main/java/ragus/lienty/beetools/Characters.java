package ragus.lienty.beetools;


/**
 * Created by Tom on 13/02/2017.
 */

public class Characters {
    protected int charId, accId;
    protected String name, expireCacheDate, rootElement ;
    protected boolean isActive;




    public void Characters(){

    }

    public void Characters(int charId, String name, int accId, boolean isActive, String expireCacheDate){
        this.charId = charId;
        this.name = name;
        this.accId = accId;
        this.isActive = isActive;
        this.expireCacheDate = expireCacheDate;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpireCacheDate(String expireCacheDate) {
        this.expireCacheDate = expireCacheDate;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCharId() {
        return charId;
    }

    public int getAccId() {
        return accId;
    }

    public String getName() {
        return name;
    }

    public String getExpireCacheDate() {
        return expireCacheDate;
    }

    public boolean isActive() {
        return isActive;
    }



}
