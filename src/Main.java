import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException {

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("ToDoList.xml");

            TaskList toDo = new TaskList();
            WorkWithXML reader = new WorkWithXML();
            toDo = reader.readXML(document, toDo);

            Commands start = new Commands();
            start.menu(toDo);
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
