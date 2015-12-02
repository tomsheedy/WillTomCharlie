/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author t2-sheedy
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class JSonReader {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static String readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            //JSONObject json = new JSONObject(jsonText);
            return jsonText;
        } finally {
            is.close();
        }
    }

    public static int getDistance(String url) throws IOException,  SAXException, ParserConfigurationException {

//        String j = (json.toString());
//        JSONArray rows = json.getJSONArray("rows");
//        JSONObject elements = rows.getJSONObject(0);
//        //JSONArray eleArr = JSONObjectToJSONArray(elements);
//        JSONArray distance = elements.getJSONArray("distance");
//        //String distval = (distance.get("value")).toString();
//        return distance.toString();//"1";
        String xml = readJsonFromUrl(url);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);

        doc.getDocumentElement().normalize();

        String valS = Recursive(doc.getChildNodes(), true, "");

        int valI = Integer.parseInt(valS);

        double valD = (double) valI;
        valD = valD / 1609.344;
        int val = (int) valD;
        return val;

    }

    private static String Recursive(NodeList nl, boolean contin, String val) {
        if ("".equals(val)) {
            for (int c = 0; c < nl.getLength(); c++) {
                String nN = nl.item(c).getNodeName();
                if (nN.equals("distance")) {
                    NodeList distances = nl.item(c).getChildNodes();
                    for (int x = 0; x < distances.getLength(); x++) {
                        String dN = distances.item(x).getNodeName();
                        if (dN.equals("value")) {
                            NodeList vals = distances.item(x).getChildNodes();
                            for (int i = 0; i < vals.getLength(); i++) {
                                String txt = vals.item(i).getTextContent();
                                String oth = vals.item(i).getNodeValue();
                                contin = false;
                                return oth;
                            }
                        }
                    }
                } else {
                    if (contin) {
                        val = Recursive(nl.item(c).getChildNodes(), true, val);
                        if (!"".equals(val)) {
                            contin = false;
                        }
                    }
                }
            }
        }
        return val;
    }

}
