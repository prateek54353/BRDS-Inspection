package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class SearchPlantationDetailRequest {

    @SerializedName("Blockcode")
    @Expose
    private String Blockcode;

    @SerializedName("DeviceId")
    @Expose
    private String DeviceId;

    @SerializedName("DistCode")
    @Expose
    private String DistCode;

    @SerializedName("IpAddress")
    @Expose
    private String IpAddress;

    @SerializedName("PanchayatCode")
    @Expose
    private String PanchayatCode;

    @SerializedName("UserRole")
    @Expose
    private String UserRole;

    @SerializedName("WorkCode")
    @Expose
    private String WorkCode;

    public SearchPlantationDetailRequest(String distCode, String blockcode, String panchayatCode, String userRole, String workCode, String deviceId, String ipAddress) {
        this.DistCode = distCode;
        this.Blockcode = blockcode;
        this.PanchayatCode = panchayatCode;
        this.UserRole = userRole;
        this.WorkCode = workCode;
        this.DeviceId = deviceId;
        this.IpAddress = ipAddress;
    }

    public String getDistCode() {
        return this.DistCode;
    }

    public void setDistCode(String distCode) {
        this.DistCode = distCode;
    }

    public String getBlockcode() {
        return this.Blockcode;
    }

    public void setBlockcode(String blockcode) {
        this.Blockcode = blockcode;
    }

    public String getPanchayatCode() {
        return this.PanchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.PanchayatCode = panchayatCode;
    }

    public String getUserRole() {
        return this.UserRole;
    }

    public void setUserRole(String userRole) {
        this.UserRole = userRole;
    }

    public String getWorkCode() {
        return this.WorkCode;
    }

    public void setWorkCode(String workCode) {
        this.WorkCode = workCode;
    }
}