package BO;

import DB.DAL.UserDb;
import UI.ViewModels.UserViewModel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Marthin on 2016-11-11.
 */
public class UserManager {
    private UserViewModel user;
    private UserDb db;
    public UserManager(){
        this.db = new UserDb();
    }

    public boolean login(UserViewModel user) {
        this.user = user;
        this.user.setPassword(digestPassword(this.user.getPassword()));
        return db.authenticate(this.user);
    }

    public void register(UserViewModel user) {
        this.user = user;
        this.user.setPassword(digestPassword(this.user.getPassword()));
        System.out.println(user.toString());
        db.register(this.user);
    }

    private String digestPassword(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Could not digest password.");
        }
        messageDigest.update(password.getBytes());
        return new String(messageDigest.digest());
    }

}
