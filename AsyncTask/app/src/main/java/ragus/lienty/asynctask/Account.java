package ragus.lienty.asynctask;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by leone on 27/02/2017.
 */

public class Account {

    private ArrayList<String> mList;
    private ArrayList<Character> listChar = new ArrayList<>();
    protected String apiKey;
    protected String vCode;


    public Account(){
        //Empty constructor for ORM
    }

    public Account(String apiKey, String vCode){

        this.apiKey = apiKey;
        this.vCode = vCode;
        createChar();
    }

    private ArrayList<String> getChar(){

        ArrayList<String> list = new ArrayList<String>();

        try {
            list = XmlParser.extractXMLchar(this.apiKey, this.vCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private void createChar(){

        this.mList = getChar();
        String[] tmpTab;
        String [] apiInfos = {this.apiKey, this.vCode};

        if (this.mList != null) {
            for (int i = 0; i < this.mList.size(); i++) {
                tmpTab = this.mList.get(i)
                        .trim()
                        .split(",");
                Character c = new Character(tmpTab[0], tmpTab[1], tmpTab[2], apiInfos);
                this.listChar.add(c);
            }
        } else {
            Log.d("ERROR", "CHAR LIST EMPTY");
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
