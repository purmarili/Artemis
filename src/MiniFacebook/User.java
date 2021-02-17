package MiniFacebook;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String name;
    private String status;
    private ArrayList<String> friends;
    private HashMap<String, ArrayList<String>> receivedMessages;
    private HashMap<String, ArrayList<String>> sentMessages;

    public User(String name){
        this.name = name;
        this.status = "";
        friends = new ArrayList<>();
        receivedMessages = new HashMap<>();
        sentMessages = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void receiveMessage(String user, String message){
        if (receivedMessages.get(user) == null){
            ArrayList<String> lst = new ArrayList<>();
            lst.add(message);
            receivedMessages.put(user, lst);
        } else {
            receivedMessages.get(user).add(message);
        }
    }

    public void sendMessage(String user, String message){
        if (sentMessages.get(user) == null){
            ArrayList<String> lst = new ArrayList<>();
            lst.add(message);
            sentMessages.put(user, lst);
        } else {
            sentMessages.get(user).add(message);
        }
    }

    public static void messageOperation(User from, User to, String message){
        from.sendMessage(to.getName(), message);
        to.receiveMessage(from.getName(), message);
    }

    public void addFr(User friend){
        friends.add(friend.name);
    }

    public static void addFriend(User from, User to){
        from.addFr(to);
        to.addFr(from);
    }

    public void removeFr(User friend){
        if (friends.contains(friend.getName()))
            friends.remove(friend.name);
    }

    public static void removeFriend(User from, User to){
        from.removeFr(to);
        to.removeFr(from);
    }

    public void changeUserEverywhere(String user, String newName){
        for (String s : friends){
            if (s.equals(user)){
                friends.remove(s);
                friends.add(newName);
            }
        }
        ArrayList<String> received = receivedMessages.get(user);
        if (received != null){
            receivedMessages.remove(user);
            receivedMessages.put(newName, received);
        }
        ArrayList<String> sent = sentMessages.get(user);
        if (received != null){
            sentMessages.remove(user);
            sentMessages.put(newName, sent);
        }
    }

    public boolean friendsWith(User user){
        return friends.contains(user.getName());
    }
}
