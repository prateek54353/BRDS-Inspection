package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class ChangePasswordRequest {

    @SerializedName("ConfirmNewPassword")
    @Expose
    private String ConfirmNewPassword;

    @SerializedName("DeviceId")
    @Expose
    private String DeviceId;

    @SerializedName("IpAddress")
    @Expose
    private String IpAddress;

    @SerializedName("NewPassword")
    @Expose
    private String NewPassword;

    @SerializedName("OldPassword")
    @Expose
    private String OldPassword;

    public String getOldPassword() {
        return this.OldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.OldPassword = oldPassword;
    }

    public String getNewPassword() {
        return this.NewPassword;
    }

    public void setNewPassword(String newPassword) {
        this.NewPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return this.ConfirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.ConfirmNewPassword = confirmNewPassword;
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