
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class Event {

    private int id = (int)(Math.random() * 100000);
    private String message;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", date format=" + df.format(date) +
                '}';
    }
}
