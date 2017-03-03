package ragus.lienty.asynctask;


import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by leone on 24/02/2017.
 */

public class XmlParser {

    public static ArrayList<String> extractXMLchar(String keyID, String vCode) throws ParserConfigurationException, IOException, SAXException {
        String rep = "";
        HttpsQuery hQuery = new HttpsQuery();
        String query = "https://api.eveonline.com/account/Character.xml.aspx?keyID=" + keyID + "&vCode=" + vCode;
        try {
            rep = hQuery.execute(query).get();
            Log.d("XML parser Char", query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(rep.getBytes("utf-8"))));
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("row");
        ArrayList<String> tab = new ArrayList<>();
        for (int tmp = 0; tmp < nList.getLength(); tmp++) {
            Node nNode = nList.item(tmp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String tempo = eElement.getAttribute("name") + "," + eElement.getAttribute("corporationName") + "," + eElement.getAttribute("characterID")+ "\n";
                tab.add(tmp, tempo);
            }
        }
        return tab;
    }

    public static ArrayList<String> extractXMLNotif(String keyID, String vCode, Character toon) throws ParserConfigurationException, IOException, SAXException {
        String rep = "";
        HttpsQuery hQuery = new HttpsQuery();
        String query = "https://api.eveonline.com/char/EveNotif.xml.aspx?characterID=" + toon.getCharId() + "&keyID=" + keyID + "&vCode=" + vCode;
        try {
           rep = hQuery.execute(query).get();
            Log.d("XML parser Notif", query);
        } catch (Exception e) {
           e.printStackTrace();
        }
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(rep.getBytes("utf-8"))));
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("row");
        ArrayList<String> tab = new ArrayList<>();
        for (int tmp = 0; tmp < nList.getLength(); tmp++) {
            Node nNode = nList.item(tmp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String tempo = eElement.getAttribute("notificationID")+ "," + eElement.getAttribute("typeID")  + "," + eElement.getAttribute("read") + "\n";
                tab.add(tmp, tempo);
            }
        }
        return tab;
    }
}

