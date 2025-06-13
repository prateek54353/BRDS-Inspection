package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class VerifyOtpRequest {

    @SerializedName("ClientKey")
    @Expose
    private String ClientKey;

    @SerializedName("DeviceId")
    @Expose
    private String DeviceId;

    @SerializedName("IpAddress")
    @Expose
    private String IpAddress;

    @SerializedName("MobileNo")
    @Expose
    private String MobileNo;

    @SerializedName("UserId")
    @Expose
    private String UserId;

    @SerializedName("otp")
    @Expose
    private String otp;

    public VerifyOtpRequest() {
    }

    public VerifyOtpRequest(String userId, String mobileNo, String otp, String clientKey, String deviceId, String ipAddress) {
        this.UserId = userId;
        this.MobileNo = mobileNo;
        this.otp = otp;
        this.ClientKey = clientKey;
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

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getClientKey() {
        return this.ClientKey;
    }

    public void setClientKey(String clientKey) {
        this.ClientKey = clientKey;
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