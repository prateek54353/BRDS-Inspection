package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class PlantationReportRequest {

    @SerializedName("BlockCode")
    @Expose
    private String BlockCode;

    @SerializedName("DeviceId")
    @Expose
    private String DeviceId;

    @SerializedName("DistrictCode")
    @Expose
    private String DistrictCode;

    @SerializedName("IpAddress")
    @Expose
    private String IpAddress;

    @SerializedName("PanchayatCode")
    @Expose
    private String PanchayatCode;

    @SerializedName("UserId")
    @Expose
    private String UserId;

    @SerializedName("UserRole")
    @Expose
    private String UserRole;

    public PlantationReportRequest() {
    }

    public PlantationReportRequest(String userId, String userRole, String districtCode, String blockCode, String panchayatCode, String deviceId, String ipAddress) {
        this.UserId = userId;
        this.UserRole = userRole;
        this.DistrictCode = districtCode;
        this.BlockCode = blockCode;
        this.PanchayatCode = panchayatCode;
        this.DeviceId = deviceId;
        this.IpAddress = ipAddress;
    }

    public String getUserId() {
        return this.UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public String getUserRole() {
        return this.UserRole;
    }

    public void setUserRole(String userRole) {
        this.UserRole = userRole;
    }

    public String getDistrictCode() {
        return this.DistrictCode;
    }

    public void setDistrictCode(String districtCode) {
        this.DistrictCode = districtCode;
    }

    public String getBlockCode() {
        return this.BlockCode;
    }

    public void setBlockCode(String blockCode) {
        this.BlockCode = blockCode;
    }

    public String getPanchayatCode() {
        return this.PanchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.PanchayatCode = panchayatCode;
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