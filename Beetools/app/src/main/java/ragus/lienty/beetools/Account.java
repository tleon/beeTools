package ragus.lienty.beetools;

import android.support.v4.app.Fragment;

import java.util.List;

/**
 * Created by leone on 13/02/2017.
 */

public class Account{

    protected int accID;
    protected String keyApi, vCode;
    protected List characters;

    public Account() { // empty constructeur for ORM / DOA
    }

    public Account(int accId, String keyApi, String vCode) {
        this.accID = accId;
        this.keyApi = keyApi;
        this.vCode = vCode;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getKeyApi() {
        return keyApi;
    }

    public void setKeyApi(String keyApi) {
        this.keyApi = keyApi;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    public void getCharacters(){
        String test = "test"; // get char for this account by DB /DOA
        if(true) { //test if result is not empty b4 adding
            this.characters.add(test);
        }
    }

}
