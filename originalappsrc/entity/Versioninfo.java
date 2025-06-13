package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class Versioninfo {
    public static Class<Versioninfo> Versioninfo_CLASS = Versioninfo.class;
    private String adminMsg;
    private String adminTitle;
    private String appUrl;
    private String imei;
    private boolean isValidDevice;
    private boolean isVerUpdated;
    private int priority;
    private String role;
    private String updateMsg;
    private String updateTile;

    public String getAdminMsg() {
        return this.adminMsg;
    }

    public void setAdminMsg(String adminMsg) {
        this.adminMsg = adminMsg;
    }

    public String getAdminTitle() {
        return this.adminTitle;
    }

    public void setAdminTitle(String adminTitle) {
        this.adminTitle = adminTitle;
    }

    public String getUpdateTile() {
        return this.updateTile;
    }

    public void setUpdateTile(String updateTile) {
        this.updateTile = updateTile;
    }

    public String getUpdateMsg() {
        return this.updateMsg;
    }

    public void setUpdateMsg(String updateMsg) {
        this.updateMsg = updateMsg;
    }

    public String getAppUrl() {
        return this.appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public boolean isVerUpdated() {
        return this.isVerUpdated;
    }

    public void setVerUpdated(boolean isVerUpdated) {
        this.isVerUpdated = isVerUpdated;
    }

    public boolean isValidDevice() {
        return this.isValidDevice;
    }

    public void setValidDevice(boolean isValidDevice) {
        this.isValidDevice = isValidDevice;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}