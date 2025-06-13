package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class SignUp {
    public static Class<SignUp> SIGNUP_CLASS = SignUp.class;
    private String Dist_name;
    private String EntryBy;
    private String IMEI;
    private String address;
    private String appVersion;
    private String block_code;
    private String block_nm;
    private String confirm_password;
    private String designation;
    private String dist_code;
    private String fname;
    private String mobile;
    private String name;
    private String password;

    public static Class<SignUp> getSingUpClass() {
        return SIGNUP_CLASS;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return this.confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getEntryBy() {
        return this.EntryBy;
    }

    public void setEntryBy(String entryBy) {
        this.EntryBy = entryBy;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDist_code() {
        return this.dist_code;
    }

    public void setDist_code(String dist_code) {
        this.dist_code = dist_code;
    }

    public String getDist_name() {
        return this.Dist_name;
    }

    public void setDist_name(String dist_name) {
        this.Dist_name = dist_name;
    }

    public String getBlock_code() {
        return this.block_code;
    }

    public void setBlock_code(String block_code) {
        this.block_code = block_code;
    }

    public String getBlock_nm() {
        return this.block_nm;
    }

    public void setBlock_nm(String block_nm) {
        this.block_nm = block_nm;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getIMEI() {
        return this.IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}