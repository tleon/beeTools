package ragus.lienty.asynctask;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by leone on 27/02/2017.
 */

public class Account {

    private ArrayList<Character> listChar = new ArrayList<>();
    protected String apiKey;
    protected String vCode;


    public Account(){
        //Empty constructor for ORM
    }

    public Account(String apiKey, String vCode){

        this.apiKey = apiKey;
        this.vCode = vCode;
    }

    public void retrieveCharacters(){

        try {
            this.listChar = XmlParser.extractXMLchar(this.apiKey, this.vCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // Getter / Setter

    public String getApiKey() {
        return apiKey;
    }

    public String getvCode() {
        return vCode;
    }

    public ArrayList<Character> getListChar() {
        return listChar;
    }
}
