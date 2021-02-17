package MiniFacebook;

import java.util.ArrayList;
import java.util.Scanner;

public class Facebook {

    private final Scanner sc = new Scanner(System.in);

    private final String toBrake = "quit";
    private final ArrayList<User> users;
    private int usersCount = 0;

    public Facebook() {
        this.users = new ArrayList<>();
    }

    public void startFacebook() {
        String input;
        System.out.println("MyFacebook ჩაირთო.");
        while (true) {
            input = sc.nextLine();
            if (input.toLowerCase().equals("quit")) {
                System.out.println("MyFacebook გაითიშა.");
                break;
            }

            String[] inputs = input.split(" ");
            if (inputs[0].toLowerCase().equals("create")) {

                if (inputs.length != 2) {
                    continue;
                }
                if (containsUser(inputs[1])) {
                    System.out.println("ასეთი იუსერი უკვე რეგისტრირებულია.");
                } else {
                    usersCount++;
                    users.add(new User(inputs[1]));
                    System.out.println("იუსერი სახელით: " + inputs[1] + " დარეგისტრირდა.");
                }

            } else if (inputs[0].toLowerCase().equals("remove")) {

                if (inputs.length != 2) {
                    continue;
                }
                if (containsUser(inputs[1])) {
                    usersCount--;
                    removeUser(inputs[1]);
                    System.out.println("იუსერი სახელით: " + inputs[1] + " წაიშალა სისტემიდან.");
                } else {
                    System.out.println("იუსერი სახელით: " + inputs[1] + " არ არსებობს.");
                }

            } else if (inputs[0].toLowerCase().equals("status")) {

                if (inputs.length != 2 || inputs.length != 3) continue;

                if (inputs.length == 2) {
                    User curr = getUser(inputs[1]);
                    if (curr != null)
                        System.out.println(inputs[1] + " -ის სტატუსია: " + " " + curr.getStatus());
                    else
                        System.out.println("იუსერი სახელით: " + inputs[1] + " არ არსებობს.");
                } else if (inputs.length == 3) {
                    User curr = getUser(inputs[1]);
                    if (curr != null) {
                        curr.setStatus(inputs[2]);
                        System.out.println(inputs[1] + " -ის ახალი სტატუსია: " + " " + curr.getStatus());
                    } else
                        System.out.println("იუსერი სახელით: " + inputs[1] + " არ არსებობს.");
                }

            } else if (inputs[0].toLowerCase().equals("change")) {

                if (inputs.length != 3) {
                    continue;
                }
                User curr = getUser(inputs[1]);
                if (curr != null) {
                    curr.setName(inputs[1]);
                    changeUser(curr, inputs[2]);
                    System.out.println("იუსერის სახელი: " + inputs[1] + " შეიცვალა, ახალი სახელია: " + curr.getName());
                } else {
                    System.out.println("იუსერი სახელით: " + inputs[1] + " არ არსებობს.");
                }

            } else if (inputs[0].toLowerCase().equals("removefriend")) {

                if (inputs.length != 3) {
                    continue;
                }
                User from = getUser(inputs[1]);
                User to = getUser(inputs[2]);
                if (from != null && to != null) {
                    from.removeFr(to);
                    to.removeFr(from);
                    System.out.println("inputs[1]" + " და " + inputs[2] + " მეგობრები აღარ არიან.");
                } else {
                    System.out.println("იუსერი სახელით: " + inputs[1] + " ან " + inputs[2] + " არ არსებობს.");
                }

            } else if (inputs[0].toLowerCase().equals("add")) {

                if (inputs.length != 3) {
                    continue;
                }
                User from = getUser(inputs[1]);
                User to = getUser(inputs[2]);
                if (from != null && to != null) {
                    if (from.friendsWith(to)) {
                        System.out.println("იუსერები უკვე მეგობრები არიან.");
                        continue;
                    }
                    from.addFr(to);
                    to.addFr(from);
                    System.out.println(inputs[1] + " და " + inputs[2] + " მეგობრები აღარ არიან.");
                } else {
                    System.out.println("იუსერი სახელით: " + inputs[1] + " ან " + inputs[2] + " არ არსებობს.");
                }

            } else if (inputs[0].toLowerCase().equals("send")) {

                if (inputs.length != 4) {
                    continue;
                }
                User from = getUser(inputs[1]);
                User to = getUser(inputs[2]);
                if (from != null && to != null) {
                    User.messageOperation(from, to, inputs[3]);
                    System.out.println(inputs[1] + " -მა " + inputs[2] + " -ს გაუგზავნა წერილი: " + inputs[3]);
                } else {
                    System.out.println("იუსერი სახელით: " + inputs[1] + " ან " + inputs[2] + " არ არსებობს.");
                }
            }
        }
    }

    private void changeUser(User user, String newName) {
        for (User u : users) {
            u.changeUserEverywhere(user.getName(), newName);
        }
    }

    private User getUser(String name) {
        for (User u : users) {
            if (u.getName().equals(name)) return u;
        }
        return null;
    }

    private void removeUser(String user) {
        User tmp = getUser(user);
        for (User u : users) {
            assert tmp != null;
            u.removeFr(tmp);
        }
        users.removeIf(u -> u.getName().equals(user));
    }

    private boolean containsUser(String user) {
        for (User u : users) {
            if (u.getName().equals(user)) return true;
        }
        return false;
    }

}
