import org.w3c.dom.Document;

public interface WorkWithFile {
    TaskList read(String uri);
    void print(TaskList toDo, String uri);
    void writeDocument(Document document, String uri);
}
