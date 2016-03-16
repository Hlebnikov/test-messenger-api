import java.util.Date;

/**
 * Created by Александр on 16.03.2016.
 */
@SuppressWarnings("ALL")
public class Message {
    Date date;
    Contact contact;
    String text;
    Boolean incoming;

    Message(Date date, Contact contact, String message, Boolean incoming){
        this.date = date;
        this.contact = contact;
        this.text = message;
        this.incoming = incoming;
    }
}
