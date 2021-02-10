import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Task {

    private int id;
    private String caption;
    private String description;
    private int priority;
    private Date deadline;
    private String status;
    private Date completeDate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public Date getDeadline() {
        return deadline;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getCompleteDate() {
        return completeDate;
    }
    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Task() {
        this.id = 0;
        this.caption = null;
        this.description = null;
        this.priority = 0;
        this.deadline = new Date(0);
        this.status = "new";
        this.completeDate = new Date(0);
    }
    public Task(int newId, String newCaption, String newDescription, int newPriority, Date newDeadline, String newStatus, Date newCompleteDate) {
        this.id = newId;
        this.caption = newCaption;
        this.description = newDescription;
        this.priority = newPriority;
        this.deadline = newDeadline;
        this.status = newStatus;
        this.completeDate = newCompleteDate;
    }
    public void setTask (Task t) {
        this.id = t.id;
        this.caption = t.caption;
        this.description = t.description;
        this.priority = t.priority;
        this.deadline = t.deadline;
        this.status = t.status;
        this.completeDate = t.completeDate;
    }
}
