

/**
 * Created by Александр on 14.03.2016.
 */
public class Server {
    User client;

    public void addClient(User user){
        client = user;
    }
    public void sendMessage(String message, Contact contact){
        client.gotMessage(message,contact);
    }
}
