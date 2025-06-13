package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class ReportEntity implements Serializable {
    public static Class<ReportEntity> ReportEntity_CLASS = ReportEntity.class;
    private String AWCGOICode;
    private String AWCName;
    private String Attend_Reg_PhotoPath;
    private String Attend_Reg_PhotoPath2;
    private String Children_PhotoPath;
    private String Children_Present;
    private String Insp_Date_GPS;
    private String Insp_Reg_PhotoPath;
    private String Latitude;
    private String Longitude;
    private String MakeFood;
    private String Menu_Followed;
    private String Morning_Snacks;
    private String NoOfRegChild;
    private String Open_Flag;
    private String Rating;
    private String Remarks;
    private String S_W_Children_PhotoPath;
    private String Upload_Date;

    public String getAWCGOICode() {
        return this.AWCGOICode;
    }

    public void setAWCGOICode(String AWCGOICode) {
        this.AWCGOICode = AWCGOICode;
    }

    public String getAWCName() {
        return this.AWCName;
    }

    public void setAWCName(String AWCName) {
        this.AWCName = AWCName;
    }

    public String getMakeFood() {
        return this.MakeFood;
    }

    public void setMakeFood(String makeFood) {
        this.MakeFood = makeFood;
    }

    public String getNoOfRegChild() {
        return this.NoOfRegChild;
    }

    public void setNoOfRegChild(String noOfRegChild) {
        this.NoOfRegChild = noOfRegChild;
    }

    public String getOpen_Flag() {
        return this.Open_Flag;
    }

    public void setOpen_Flag(String open_Flag) {
        this.Open_Flag = open_Flag;
    }

    public String getChildren_Present() {
        return this.Children_Present;
    }

    public void setChildren_Present(String children_Present) {
        this.Children_Present = children_Present;
    }

    public String getMorning_Snacks() {
        return this.Morning_Snacks;
    }

    public void setMorning_Snacks(String morning_Snacks) {
        this.Morning_Snacks = morning_Snacks;
    }

    public String getMenu_Followed() {
        return this.Menu_Followed;
    }

    public void setMenu_Followed(String menu_Followed) {
        this.Menu_Followed = menu_Followed;
    }

    public String getRating() {
        return this.Rating;
    }

    public void setRating(String rating) {
        this.Rating = rating;
    }

    public String getRemarks() {
        return this.Remarks;
    }

    public void setRemarks(String remarks) {
        this.Remarks = remarks;
    }

    public String getInsp_Date_GPS() {
        return this.Insp_Date_GPS;
    }

    public void setInsp_Date_GPS(String insp_Date_GPS) {
        this.Insp_Date_GPS = insp_Date_GPS;
    }

    public String getLatitude() {
        return this.Latitude;
    }

    public void setLatitude(String latitude) {
        this.Latitude = latitude;
    }

    public String getLongitude() {
        return this.Longitude;
    }

    public void setLongitude(String longitude) {
        this.Longitude = longitude;
    }

    public String getChildren_PhotoPath() {
        return this.Children_PhotoPath;
    }

    public void setChildren_PhotoPath(String children_PhotoPath) {
        this.Children_PhotoPath = children_PhotoPath;
    }

    public String getS_W_Children_PhotoPath() {
        return this.S_W_Children_PhotoPath;
    }

    public void setS_W_Children_PhotoPath(String s_W_Children_PhotoPath) {
        this.S_W_Children_PhotoPath = s_W_Children_PhotoPath;
    }

    public String getUpload_Date() {
        return this.Upload_Date;
    }

    public void setUpload_Date(String upload_Date) {
        this.Upload_Date = upload_Date;
    }

    public String getAttend_Reg_PhotoPath() {
        return this.Attend_Reg_PhotoPath;
    }

    public void setAttend_Reg_PhotoPath(String attend_Reg_PhotoPath) {
        this.Attend_Reg_PhotoPath = attend_Reg_PhotoPath;
    }

    public String getAttend_Reg_PhotoPath2() {
        return this.Attend_Reg_PhotoPath2;
    }

    public void setAttend_Reg_PhotoPath2(String attend_Reg_PhotoPath2) {
        this.Attend_Reg_PhotoPath2 = attend_Reg_PhotoPath2;
    }

    public String getInsp_Reg_PhotoPath() {
        return this.Insp_Reg_PhotoPath;
    }

    public void setInsp_Reg_PhotoPath(String insp_Reg_PhotoPath) {
        this.Insp_Reg_PhotoPath = insp_Reg_PhotoPath;
    }
}