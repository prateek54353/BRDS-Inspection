package bih.p003in.forestdept.model;

import android.content.Context;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class UserLogin {
    private String Authtoken;

    @SerializedName("DeviceId")
    @Expose
    private String DeviceId;

    @SerializedName("IpAddress")
    @Expose
    private String IpAddress;

    @SerializedName("Message")
    @Expose
    private String Message;

    @SerializedName("ResultMessage")
    @Expose
    private String ResultMessage;

    @SerializedName("Status")
    @Expose
    private String Status;
    private String _encriptionKey;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;

    @SerializedName("ClientKey")
    @Expose
    private String clientkey;

    @SerializedName("Password")
    @Expose
    private String password;

    @SerializedName("UserDetails")
    private UserDetail userDetails;

    @SerializedName("UserID")
    @Expose
    private String userId;

    public UserLogin() {
    }

    public UserLogin(String clientkey, String userId, String password, String deviceid, String ipAddress) {
        this.clientkey = clientkey;
        this.userId = userId;
        this.password = password;
        this.DeviceId = deviceid;
        this.IpAddress = ipAddress;
    }

    public UserLogin(UserLogin obj, Context context, String _enriptionkey) {
        Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        this.aes256CbcEncryptDecrypt = aes256CbcEncryptDecrypt;
        try {
            this.ResultMessage = aes256CbcEncryptDecrypt.Decrypt(obj.getResultMessage(), _enriptionkey);
            this.Status = this.aes256CbcEncryptDecrypt.Decrypt(obj.getStatus(), _enriptionkey);
            this.Message = this.aes256CbcEncryptDecrypt.Decrypt(obj.getMessage(), _enriptionkey);
            this.userDetails = new UserDetail(obj.getUserDetails(), context, _enriptionkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserDetail getUserDetails() {
        return this.userDetails;
    }

    public void setUserDetails(UserDetail userDetails) {
        this.userDetails = userDetails;
    }

    public Aes256CbcEncryptDecrypt getAes256CbcEncryptDecrypt() {
        return this.aes256CbcEncryptDecrypt;
    }

    public void setAes256CbcEncryptDecrypt(Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt) {
        this.aes256CbcEncryptDecrypt = aes256CbcEncryptDecrypt;
    }

    public String getAuthtoken() {
        return this.Authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.Authtoken = authtoken;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getMessage() {
        return this.Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public String getResultMessage() {
        return this.ResultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.ResultMessage = resultMessage;
    }

    public String getClientkey() {
        return this.clientkey;
    }

    public void setClientkey(String clientkey) {
        this.clientkey = clientkey;
    }

    public String get_encriptionKey() {
        return this._encriptionKey;
    }

    public void set_encriptionKey(String _encriptionKey) {
        this._encriptionKey = _encriptionKey;
    }

    public String getDeviceId() {
        return this.DeviceId;
    }

    public void setDeviceId(String deviceId) {
        this.DeviceId = deviceId;
    }

    public String getIpAddress() {
        return this.IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.IpAddress = ipAddress;
    }
}