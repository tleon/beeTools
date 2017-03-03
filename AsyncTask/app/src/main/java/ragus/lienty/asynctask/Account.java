package ragus.lienty.asynctask;

import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by leone on 27/02/2017.
 */

public class Account {
    private ArrayList<String> mList;
    private ArrayList<Characters> listChar = new ArrayList<>();
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

        ArrayList<String> list = null;

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

        for (int i=0; i < this.mList.size(); i++){
            tmpTab = this.mList.get(i)
                    .trim()
                    .split(",");
            Characters c = new Characters(tmpTab[0],tmpTab[1],tmpTab[2], apiInfos);
            this.listChar.add(c);
        }
    }

    // Getter / Setter

    public String getApiKey() {
        return apiKey;
    }

    public String getvCode() {
        return vCode;
    }

    public ArrayList<Characters> getListChar() {
        return listChar;
    }
}
