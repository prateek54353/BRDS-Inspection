package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class UserDetails {
    private static Class<UserDetails> USER_CLASS = UserDetails.class;
    private boolean isAuthenticated = true;
    private String Password = "";
    private String UserID = "";
    private String LastVisitedOn = "";
    private String MobileNo = "";
    private String Address = "";
    private String Email = "";
    private String DistrictCode = "";
    private String DistName = "";
    private String BlockCode = "";
    private String BlockName = "";
    private String PanchayatName = "";
    private String PanchayatCode = "";
    private String Degignation = "";
    private String Userrole = "";
    private String Name = "";
    private String DeptName = "";

    public static Class<UserDetails> getUserClass() {
        return USER_CLASS;
    }

    public static void setUserClass(Class<UserDetails> userClass) {
        USER_CLASS = userClass;
    }

    public String getDeptName() {
        return this.DeptName;
    }

    public void setDeptName(String deptName) {
        this.DeptName = deptName;
    }

    public String getPanchayatName() {
        return this.PanchayatName;
    }

    public void setPanchayatName(String panchayatName) {
        this.PanchayatName = panchayatName;
    }

    public String getPanchayatCode() {
        return this.PanchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.PanchayatCode = panchayatCode;
    }

    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.isAuthenticated = authenticated;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public Boolean getIsAuthenticated() {
        return Boolean.valueOf(this.isAuthenticated);
    }

    public void setIsAuthenticated(Boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated.booleanValue();
    }

    public String getLastVisitedOn() {
        return this.LastVisitedOn;
    }

    public void setLastVisitedOn(String lastVisitedOn) {
        this.LastVisitedOn = lastVisitedOn;
    }

    public String getMobileNo() {
        return this.MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.MobileNo = mobileNo;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getDistrictCode() {
        return this.DistrictCode;
    }

    public void setDistrictCode(String districtCode) {
        this.DistrictCode = districtCode;
    }

    public String getDistName() {
        return this.DistName;
    }

    public void setDistName(String distName) {
        this.DistName = distName;
    }

    public String getBlockCode() {
        return this.BlockCode;
    }

    public void setBlockCode(String blockCode) {
        this.BlockCode = blockCode;
    }

    public String getBlockName() {
        return this.BlockName;
    }

    public void setBlockName(String blockName) {
        this.BlockName = blockName;
    }

    public String getDegignation() {
        return this.Degignation;
    }

    public void setDegignation(String degignation) {
        this.Degignation = degignation;
    }

    public String getUserrole() {
        return this.Userrole;
    }

    public void setUserrole(String userrole) {
        this.Userrole = userrole;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}