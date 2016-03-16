import java.util.ArrayList;


/**
 * Created by Александр on 14.03.2016.
 */
public abstract class User {

    enum Status {Online, Offline, Busy}

    Status status = Status.Offline;
    void sendMessage(String message, Contact contact){
        System.out.println("сообщение "+ message+" отправлено контакту "+ contact.name);
    }
    abstract void gotMessage(String message, Contact contact);
    ArrayList<Contact> getContacts(){
        return LocalDB.getInstance().contacts;
    }
    void setStatus(Status status) {
        this.status = status;
    }
    ArrayList<Message> getHistory(Contact contact, double pos, int countMessage){
        /* */
        ArrayList<Message> history = new ArrayList<>();
        int size = LocalDB.getInstance().history.size();
        int curPos = (int) (size*pos);
        while ((curPos < size) && (countMessage !=0)) {
            Message message = LocalDB.getInstance().history.get(curPos++);
            if (message.contact.equals(contact)) {
                countMessage--;
                history.add(message);
            }
        }
        return history;
    }
    private void saveMessage(String message, Contact contact, Boolean incoming){
        /*Method for saving message to local database.
          It is may used in sendMessage method.
           */
    }

}



