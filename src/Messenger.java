import java.util.ArrayList;

/**
 * Created by Александр on 14.03.2016.
 */
public class Messenger extends User {
    public static void main(String... args){
        Messenger messenger = new Messenger();

        System.out.println(messenger.status);
        messenger.setStatus(Status.Online);

        System.out.println("Загрузка контактов:");
        ArrayList<Contact> contacts = messenger.getContacts();
        for (Contact contact : contacts){
            System.out.println(contact.name);
        }
        System.out.println("Контакты загружены");

        messenger.setStatus(Status.Online);
        System.out.println("Статус: "+messenger.status);

        Server server = new Server();
        server.addClient(messenger);
        server.sendMessage("Hello",contacts.get(0)); //Imitation
        messenger.sendMessage("Lalala", contacts.get(2));

        ArrayList<Message> history = messenger.getHistory(contacts.get(2),0,10);
        messenger.printHistory(history);

        history = messenger.getHistory(contacts.get(0),0.5,15);
        messenger.printHistory(history);
    }

    @Override
    public void gotMessage(String message, Contact contact) {
        System.out.println(contact.name+ " : "+ message);
    }

    void printHistory(ArrayList<Message> history){
        for (Message message : history) {
            System.out.print(message.date);
            if (message.incoming) System.out.println(" * Входящее сообщение от "+message.contact.name);
            else System.out.println(" * Исходящее сообщение к "+ message.contact.name);
            System.out.println("   "+message.text);
        }
    }
}
