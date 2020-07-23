
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document doc = db.parse("C:\\Javalearning\\XMLL\\src\\books.xml");
        
        Element root = doc.getDocumentElement();
        
        Element book = doc.createElement("book");
        Element title = doc.createElement("title");
        Element author = doc.createElement("author");
        
        book.setAttribute("id", "1234567654");
        book.setAttribute("isbn", "5464");
        title.setTextContent("The Caves of Steel");
        author.setTextContent("Isac Adamov");
        
        book.appendChild(title);
        book.appendChild(author);
        root.appendChild(book);
        
        DOMSource xmlDoc = new DOMSource(doc);
        String outputURL = "books_edit.xml";
        StreamResult result = new StreamResult(new FileOutputStream(outputURL));
        
        TransformerFactory transofrmerFactory = TransformerFactory.newInstance();
        Transformer transformer = transofrmerFactory.newTransformer();
        transformer.transform(xmlDoc, result);
    }

}
