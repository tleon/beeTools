package ragus.lienty.beetools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Tom on 22/02/2017.
 */

public class XmlParser {
    public static final String webQuery = "https://api.eveonline.com/account/Characters.xml.aspx?keyID=5259527&vCode=tDpJsVRltuilMdhc6Q8sSSBy4F3lJaByiZDibfoUbPhEIJ0kgDBgU6SqFDC0KSWs";



    public static void extractXMLString() throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(webQuery.getBytes("utf-8"))));
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nListCol = doc.getElementsByTagName("rowset");
        NodeList nList = doc.getElementsByTagName("row");
        System.out.println("----------------------------");
        Node nNodeCol = nListCol.item(0);
        Element eElement1 = (Element) nNodeCol;
        String[] columns =  eElement1.getAttribute("columns").trim().split(",");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                for(int i = 0; i < columns.length; i++){
                    System.out.println(columns[i] + " : " + eElement.getAttribute(columns[i]));
                }
//print tableau useless here

            }
        }
    }

    public static String get(String url) throws IOException{

        String source ="";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            source +=inputLine;
        in.close();
        return source;
    }

}
