package model;

import utils.LinkedListIndexedList;
import utils.LinkedListStack;

import java.util.LinkedList;

public class UserDB {
    private static LinkedListIndexedList<User> users = new LinkedListIndexedList<User>();

    public UserDB() {

    }

    public static LinkedListIndexedList<User> getUsers() {
        return users;
    }

    public static void setUsers(LinkedListIndexedList<User> users) {
        UserDB.users = users;
    }

    public static boolean usernameExists(String username) {
        for (int i = 0; i < UserDB.getUsers().size(); i++) {
            if (UserDB.getUsers().get(i).getUsername().equals(username)) return true;
        }
        return false;
    }
}
