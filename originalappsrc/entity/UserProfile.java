package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class UserProfile implements Serializable {
    public static Class<UserProfile> UserProfile_CLASS = UserProfile.class;
    private String ContactNo;
    private String Email;
    private String Photo;
    private String UserId;
    private String UserName;

    public String getUserId() {
        return this.UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getContactNo() {
        return this.ContactNo;
    }

    public void setContactNo(String contactNo) {
        this.ContactNo = contactNo;
    }

    public String getPhoto() {
        return this.Photo;
    }

    public void setPhoto(String photo) {
        this.Photo = photo;
    }
}