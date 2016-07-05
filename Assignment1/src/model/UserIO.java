package model;

import java.io.*;
import java.util.LinkedList;

public class UserIO {
    public static void writeUsers(LinkedList<User> users) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("users.dat"));

        output.writeObject(users);
    }

    public static Object readUsers() throws IOException {
        Object obj = new Object();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("users.dat"));

            obj = input.readObject();
        } catch (ClassNotFoundException e) {
            System.err.print("Cannot find User Class");
            e.printStackTrace();
        }

        return obj;
    }
}
