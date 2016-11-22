package BO;

import DB.DAL.UserDb;
import DB.Entities.UserEntity;
import UI.ViewModels.UserViewModel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Marthin on 2016-11-11.
 */
public class UserManager {
    private UserDb db;
    public UserManager(){
        this.db = new UserDb();
    }

    public UserViewModel login(UserViewModel user) {
        user.setPassword(digestPassword(user.getPassword()));
        return Converter.convertToUserViewModel(db.authenticate(user));
    }

    public void register(UserViewModel user) {
        user.setPassword(digestPassword(user.getPassword()));
        System.out.println(user.toString());
        db.register(user);
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
