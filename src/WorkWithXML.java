import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class WorkWithXML extends TaskList{

    public TaskList readXML (Document document, TaskList toDo) {
        try{
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("Task");

            for (int i = 0; i < nList.getLength(); ++i) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    Task task = new Task();
                    if (uniqueId(element.getElementsByTagName("Task_id").item(0).getTextContent())) {
                        task.setId(element.getElementsByTagName("Task_id").item(0).getTextContent());
                        task.setCaption(element.getElementsByTagName("Caption").item(0).getTextContent());
                        task.setDescription(element.getElementsByTagName("Description").item(0).getTextContent());
                        task.setPriority(Integer.parseInt(element.getElementsByTagName("Priority").item(0).getTextContent()));
                        task.setDeadline(new SimpleDateFormat("yyyy-MM-dd").parse(element.getElementsByTagName("Deadline").item(0).getTextContent()));
                        task.setStatus(element.getElementsByTagName("Status").item(0).getTextContent());
                        if (task.getStatus().equals("done"))
                            task.setCompleteDate(new SimpleDateFormat("yyyy-MM-dd").parse(element.getElementsByTagName("Complete").item(0).getTextContent()));
                        toDo.addTask(task);
                    } else {
                        System.out.println("Ошибка! Задачи имеют одинаковые идентификаторы. XML файл поврежден!");
                        System.exit(0);
                    }
                }
            }
        } catch (ParseException e) {
            System.out.println("Ошибка! Даты не соответствуют формату yyyy-MM-dd. XML файл поврежден!");
            e.printStackTrace();
        }
        return toDo;
    }
    public void printXML(TaskList toDo) throws TransformerFactoryConfigurationError, DOMException {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("ToDoList_update.xml");

            for (Task task : toDo.getToDoList()) {

                Node root = document.getDocumentElement();

                Element newTask = document.createElement("Task");
                root.appendChild(newTask);

                Element taskId = document.createElement("Task_id");
                taskId.setTextContent(task.getId());
                newTask.appendChild(taskId);

                Element caption = document.createElement("Caption");
                caption.setTextContent(task.getCaption());
                newTask.appendChild(caption);

                Element description = document.createElement("Description");
                description.setTextContent(task.getDescription());
                newTask.appendChild(description);

                Element priority = document.createElement("Priority");
                priority.setTextContent(String.valueOf(task.getPriority()));
                newTask.appendChild(priority);

                Element deadline = document.createElement("Deadline");
                deadline.setTextContent(new SimpleDateFormat("yyyy-MM-dd").format(task.getDeadline()));
                newTask.appendChild(deadline);

                Element status = document.createElement("Status");
                status.setTextContent(task.getStatus());
                newTask.appendChild(status);

                if (task.getStatus().equals("done")) {
                    Element completeDate = document.createElement("Complete");
                    completeDate.setTextContent(new SimpleDateFormat("yyyy-MM-dd").format(task.getCompleteDate()));
                    newTask.appendChild(completeDate);
                }
            }
            writeDocument(document);
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("ToDoList.xml"));
            tr.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        }
    }
}
