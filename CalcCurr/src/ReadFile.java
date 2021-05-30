
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadFile {
    public ReadFile() {
    }

    public HashMap<String, Double> parseToMap(String filename) {
        HashMap<String, Double> returnMap = new HashMap();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filename);
            doc.getDocumentElement().normalize();
            NodeList currencyList = doc.getElementsByTagName("Cube");

            for(int i = 2; i < currencyList.getLength(); ++i) {
                Node c = currencyList.item(i);
                if (c.getNodeType() == 1) {
                    Element element = (Element)c;
                    String currency = element.getAttribute("currency");
                    String rateAsString = element.getAttribute("rate");
                    double rateAsDouble = 0.0D;
                    if (!rateAsString.isEmpty()) {
                        rateAsDouble = Double.parseDouble(rateAsString);
                    }

                    returnMap.put(currency, rateAsDouble);
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException var14) {
            var14.printStackTrace();
        }

        return returnMap;
    }
}
