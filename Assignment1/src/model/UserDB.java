package model;

import java.util.LinkedList;

public class UserDB {
    private static LinkedList<User> users = new LinkedList<User>();

    public UserDB() {

    }

    public static LinkedList<User> getUsers() {
        return users;
    }

    public static void setUsers(LinkedList<User> users) {
        UserDB.users = users;
    }

    public static boolean usernameExists(String username) {
        for (User user : UserDB.getUsers()) {
            if (user.getUsername().equals(username)) return true;
        }
        return false;
    }
}
