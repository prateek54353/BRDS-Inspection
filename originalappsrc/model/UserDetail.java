package bih.p003in.forestdept.model;

import android.content.Context;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class UserDetail {

    @SerializedName("BlockCode")
    @Expose
    private String BlockCode;

    @SerializedName("BlockName")
    @Expose
    private String BlockName;

    @SerializedName("Department")
    @Expose
    private String Department;

    @SerializedName("DistName")
    @Expose
    private String DistName;

    @SerializedName("DistrictCode")
    @Expose
    private String DistrictCode;

    @SerializedName("Email")
    @Expose
    private String Email;

    @SerializedName("IsMobileUpdated")
    @Expose
    private String IsMobileUpdated;

    @SerializedName("LastVisitedOn")
    @Expose
    private String LastVisitedOn;

    @SerializedName("MobileNo")
    @Expose
    private String MobileNo;

    @SerializedName("Name")
    @Expose
    private String Name;

    @SerializedName("PanchayatCode")
    @Expose
    private String PanchayatCode;

    @SerializedName("PanchayatName")
    @Expose
    private String PanchayatName;

    @SerializedName("Userrole")
    @Expose
    private String Userrole;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;

    @SerializedName("isChangePassWord")
    @Expose
    private String isChangePassWord;

    @SerializedName("UserID")
    @Expose
    private String userId;

    public UserDetail() {
    }

    public UserDetail(UserDetail obj, Context context, String encriptionKey) {
        Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        this.aes256CbcEncryptDecrypt = aes256CbcEncryptDecrypt;
        this.userId = aes256CbcEncryptDecrypt.Decrypt(obj.getUserId(), encriptionKey);
        this.isChangePassWord = this.aes256CbcEncryptDecrypt.Decrypt(obj.getIsChangePassWord(), encriptionKey);
        this.LastVisitedOn = this.aes256CbcEncryptDecrypt.Decrypt(obj.getLastVisitedOn(), encriptionKey);
        this.MobileNo = this.aes256CbcEncryptDecrypt.Decrypt(obj.getMobileNo(), encriptionKey);
        this.IsMobileUpdated = this.aes256CbcEncryptDecrypt.Decrypt(obj.getIsMobileUpdated(), encriptionKey);
        this.Email = this.aes256CbcEncryptDecrypt.Decrypt(obj.getEmail(), encriptionKey);
        this.DistrictCode = this.aes256CbcEncryptDecrypt.Decrypt(obj.getDistrictCode(), encriptionKey);
        this.DistName = this.aes256CbcEncryptDecrypt.Decrypt(obj.getDistName(), encriptionKey);
        this.BlockCode = this.aes256CbcEncryptDecrypt.Decrypt(obj.getBlockCode(), encriptionKey);
        this.BlockName = this.aes256CbcEncryptDecrypt.Decrypt(obj.getBlockName(), encriptionKey);
        this.PanchayatCode = this.aes256CbcEncryptDecrypt.Decrypt(obj.getPanchayatCode(), encriptionKey);
        this.PanchayatName = this.aes256CbcEncryptDecrypt.Decrypt(obj.getPanchayatName(), encriptionKey);
        this.Userrole = this.aes256CbcEncryptDecrypt.Decrypt(obj.getUserrole(), encriptionKey);
        this.Name = this.aes256CbcEncryptDecrypt.Decrypt(obj.getName(), encriptionKey);
        this.Department = this.aes256CbcEncryptDecrypt.Decrypt(obj.getDepartment(), encriptionKey);
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsChangePassWord() {
        return this.isChangePassWord;
    }

    public void setIsChangePassWord(String isChangePassWord) {
        this.isChangePassWord = isChangePassWord;
    }

    public String getLastVisitedOn() {
        return this.LastVisitedOn;
    }

    public void setLastVisitedOn(String lastVisitedOn) {
        this.LastVisitedOn = lastVisitedOn;
    }

    public String getMobileNo() {
        return this.MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.MobileNo = mobileNo;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getDistrictCode() {
        return this.DistrictCode;
    }

    public void setDistrictCode(String districtCode) {
        this.DistrictCode = districtCode;
    }

    public String getDistName() {
        return this.DistName;
    }

    public void setDistName(String distName) {
        this.DistName = distName;
    }

    public String getBlockCode() {
        return this.BlockCode;
    }

    public void setBlockCode(String blockCode) {
        this.BlockCode = blockCode;
    }

    public String getBlockName() {
        return this.BlockName;
    }

    public void setBlockName(String blockName) {
        this.BlockName = blockName;
    }

    public String getPanchayatCode() {
        return this.PanchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.PanchayatCode = panchayatCode;
    }

    public String getPanchayatName() {
        return this.PanchayatName;
    }

    public void setPanchayatName(String panchayatName) {
        this.PanchayatName = panchayatName;
    }

    public String getUserrole() {
        return this.Userrole;
    }

    public void setUserrole(String userrole) {
        this.Userrole = userrole;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDepartment() {
        return this.Department;
    }

    public void setDepartment(String department) {
        this.Department = department;
    }

    public String getIsMobileUpdated() {
        return this.IsMobileUpdated;
    }

    public void setIsMobileUpdated(String isMobileUpdated) {
        this.IsMobileUpdated = isMobileUpdated;
    }
}