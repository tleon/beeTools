package ragus.lienty.beetools;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Tom on 22/02/2017.
 */

public class XmlParser {
    public static final String webQuery = "https://api.eveonline.com/account/Characters.xml.aspx?keyID=5259527&vCode=tDpJsVRltuilMdhc6Q8sSSBy4F3lJaByiZDibfoUbPhEIJ0kgDBgU6SqFDC0KSWs";



    public static List<Map> extractXMLString() throws SAXException, IOException, ParserConfigurationException, ExecutionException, InterruptedException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        String rep = new HttpReq().execute(webQuery).get();
        Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(rep.getBytes("utf-8"))));
        doc.getDocumentElement().normalize();
        //Doc Builder and factory
        NodeList nListCol = doc.getElementsByTagName("rowset");
        NodeList nList = doc.getElementsByTagName("row");
        Node nNodeCol = nListCol.item(0);
        Element eElement1 = (Element) nNodeCol;
        String[] columns =  eElement1.getAttribute("columns").trim().split(",");
        Map<String, String>  hm = new HashMap<>();
        List<Map> mapTab = null;
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                for(int i = 0; i < columns.length; i++){
                    hm.put(columns[i], eElement.getAttribute(columns[i]));
                }
            }
            mapTab.add(temp, hm);//Null pointer exeption here Wtf !
        }
        return mapTab;
    }

    private static class HttpReq extends AsyncTask<String, Void ,String>{


        @Override
        protected String doInBackground(String... params) {

            String source ="";
            String query = params[0];
            URL oracle = null;
            try {
                oracle = new URL(query);
            //https
             HttpsURLConnection  yc = (HttpsURLConnection )oracle.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                source +=inputLine;
            in.close();
            return source;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
        }
    }

}

