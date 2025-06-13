package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class SendOTPForNewMobileRequest {

    @SerializedName("DeviceId")
    @Expose
    private String DeviceId;

    @SerializedName("IpAddress")
    @Expose
    private String IpAddress;

    @SerializedName("MobileNo")
    @Expose
    private String MobileNo;

    @SerializedName("Userid")
    @Expose
    private String UserId;

    @SerializedName("UserRole")
    @Expose
    private String userRole;

    public SendOTPForNewMobileRequest() {
    }

    public SendOTPForNewMobileRequest(String userId, String mobileNo, String userRole, String deviceId, String ipAddress) {
        this.UserId = userId;
        this.MobileNo = mobileNo;
        this.userRole = userRole;
        this.DeviceId = deviceId;
        this.IpAddress = ipAddress;
    }

    public String getUserId() {
        return this.UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public String getMobileNo() {
        return this.MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.MobileNo = mobileNo;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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