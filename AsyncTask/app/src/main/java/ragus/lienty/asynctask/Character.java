package ragus.lienty.asynctask;

import java.util.ArrayList;

/**
 * Created by leone on 27/02/2017.
 */

public class Character {

    private String corpName;
    private String charId;
    private String name;
    private ArrayList<String> mList;
    private ArrayList<EveNotif> listNotif = new ArrayList<>();

    public Character(){
        //Empty constructor for ORM
    }


    public Character(String name, String corpName, String charId, String[] apiInfos){

        this.corpName = corpName;
        this.name = name;
        this.charId = charId;
        createNotif(apiInfos[0], apiInfos[1]);

    }

    private ArrayList<String> getNotif(String key, String verif){

        ArrayList<String> list = null;

        try {
            list = XmlParser.extractXMLNotif(key, verif, this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void createNotif(String key, String verif){

        this.mList = getNotif(key, verif);
        String[] tmpTab;

        for (int i=0; i < this.mList.size() ; i++){
            tmpTab = this.mList.get(i)
                    .trim()
                    .split(",");
            EveNotif n = new EveNotif(tmpTab[0],tmpTab[1],tmpTab[2]);
            this.listNotif.add(n);
        }
    }

    // Getter / Setter

    public String getCorpName() {
        return corpName;
    }

    public String getCharId() {
        return charId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<EveNotif> getListNotif() {
        return listNotif;
    }
}
