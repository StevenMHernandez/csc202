package model;

import java.io.Serializable;

public class User extends Person implements Serializable {
    private String username;
    private String email;
    private String phone;
    private String password;
    private String photo;

    public User(String username, String email, String phone, String password, String photo) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.photo = photo;
    }

    public User(String firstName, String lastName, String gender, String dob, String ssn, String username, String email, String phone, String password, String photo) {
        super(firstName, lastName, gender, dob, ssn);
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
