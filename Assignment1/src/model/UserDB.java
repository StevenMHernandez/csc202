package model;

import java.util.ArrayList;

public class UserDB {
    private static ArrayList<User> users = new ArrayList<User>();

    public UserDB() {

    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        UserDB.users = users;
    }

    public static boolean usernameExists(String username) {
        for (User user : UserDB.getUsers()) {
            if (user.getUsername().equals(username)) return true;
        }
        return false;
    }
}
