import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


/**
 * Created by Александр on 15.03.2016.
 */
public class LocalDB { //imitation DB
    private static LocalDB ourInstance = new LocalDB();

    public synchronized static LocalDB getInstance() {
        return ourInstance;
    }

    public ArrayList<Contact> contacts = new ArrayList<>();
    public ArrayList<Message> history = new ArrayList<>();

    private LocalDB() {
        contacts.add(new Contact("Petya"));
        contacts.add(new Contact("Vasya"));
        contacts.add(new Contact("Jenya"));
        contacts.add(new Contact("Lena"));

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int contNumber = Math.abs(random.nextInt()%4);
            Contact contact = contacts.get(contNumber);
            Date date = new Date();
            Boolean incoming = random.nextInt()%2 == 0;
            String message = "Message ";
            if (incoming) message += "from "+contact.name;
            else message += "to "+contact.name;

            history.add(new Message(date,contact,message,incoming));
        }
    }
}
