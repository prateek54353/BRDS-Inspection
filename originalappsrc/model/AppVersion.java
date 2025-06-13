package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class AppVersion {

    @SerializedName("AdminMsg")
    @Expose
    private String AdminMsg;

    @SerializedName("AdminTitle")
    @Expose
    private String AdminTitle;

    @SerializedName("AppUrl")
    @Expose
    private String AppUrl;

    @SerializedName("IsValidDevice")
    @Expose
    private String IsValidDevice;

    @SerializedName("Priority")
    @Expose
    private Integer Priority;

    @SerializedName("Role")
    @Expose
    private String Role;

    /* renamed from: SN */
    @SerializedName("SN")
    @Expose
    private String f197SN;

    @SerializedName("UpdateMsg")
    @Expose
    private String UpdateMsg;

    @SerializedName("UpdateTitle")
    @Expose
    private String UpdateTitle;

    @SerializedName("Version")
    @Expose
    private String Version;

    public AppVersion(String SN, Integer priority, String adminMsg, String adminTitle, String updateMsg, String updateTitle, String appUrl, String role, String version, String isValidDevice) {
        this.f197SN = SN;
        this.Priority = priority;
        this.AdminMsg = adminMsg;
        this.AdminTitle = adminTitle;
        this.UpdateMsg = updateMsg;
        this.UpdateTitle = updateTitle;
        this.AppUrl = appUrl;
        this.Role = role;
        this.Version = version;
        this.IsValidDevice = isValidDevice;
    }

    public String getSN() {
        return this.f197SN;
    }

    public void setSN(String SN) {
        this.f197SN = SN;
    }

    public Integer getPriority() {
        return this.Priority;
    }

    public void setPriority(Integer priority) {
        this.Priority = priority;
    }

    public String getAdminMsg() {
        return this.AdminMsg;
    }

    public void setAdminMsg(String adminMsg) {
        this.AdminMsg = adminMsg;
    }

    public String getAdminTitle() {
        return this.AdminTitle;
    }

    public void setAdminTitle(String adminTitle) {
        this.AdminTitle = adminTitle;
    }

    public String getUpdateMsg() {
        return this.UpdateMsg;
    }

    public void setUpdateMsg(String updateMsg) {
        this.UpdateMsg = updateMsg;
    }

    public String getUpdateTitle() {
        return this.UpdateTitle;
    }

    public void setUpdateTitle(String updateTitle) {
        this.UpdateTitle = updateTitle;
    }

    public String getAppUrl() {
        return this.AppUrl;
    }

    public void setAppUrl(String appUrl) {
        this.AppUrl = appUrl;
    }

    public String getRole() {
        return this.Role;
    }

    public void setRole(String role) {
        this.Role = role;
    }

    public String getVersion() {
        return this.Version;
    }

    public void setVersion(String version) {
        this.Version = version;
    }

    public String getIsValidDevice() {
        return this.IsValidDevice;
    }

    public void setIsValidDevice(String isValidDevice) {
        this.IsValidDevice = isValidDevice;
    }
}