package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class UpdatePasswordRequest {

    @SerializedName("ClientKey")
    @Expose
    private String ClientKey;

    @SerializedName("ConfirmPassword")
    @Expose
    private String ConfirmPassword;

    @SerializedName("DeviceId")
    @Expose
    private String DeviceId;

    @SerializedName("IpAddress")
    @Expose
    private String IpAddress;

    @SerializedName("Password")
    @Expose
    private String Password;

    @SerializedName("Userid")
    @Expose
    private String Userid;

    public String getClientKey() {
        return this.ClientKey;
    }

    public void setClientKey(String clientKey) {
        this.ClientKey = clientKey;
    }

    public String getUserid() {
        return this.Userid;
    }

    public void setUserid(String userid) {
        this.Userid = userid;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getConfirmPassword() {
        return this.ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.ConfirmPassword = confirmPassword;
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