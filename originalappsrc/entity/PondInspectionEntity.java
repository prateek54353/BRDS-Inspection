package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class PondInspectionEntity implements Serializable {
    public static Class<PondInspectionEntity> PondInspectionInfo_CLASS = PondInspectionEntity.class;
    private String Area_by_Govt_Record;
    private String Availability_Of_Water;
    private String BlockID;
    private String BlockName;
    private String DistID;
    private String DistName;
    String InspectionID;
    private String Khata_Khesra_No;
    private String Latitude;
    private String Latitude_Mob;
    private String Longitude;
    private String Longitude_Mob;
    private String Panchayat_Code;
    private String Panchayat_Name;
    private String Private_or_Public;
    private String RajswaThanaNumber;
    private String Recommended_Execution_Dept;
    private String Remarks;
    private String Requirement_of_Renovation;
    private String Requirement_of_machine;
    private String Status_of_Encroachment;
    private String Types_of_Encroachment;
    private String Verified_Date;
    private String VillageID;
    private String VillageName;
    private String connectedWithPine;

    /* renamed from: id */
    private int f179id;
    private String isUpdated;
    private String photo1;
    private String photo2;
    private String photo3;
    private String photo4;
    private String pondCatName;
    private String pondOwnerOtherDeptName;
    private String Name_of_undertaken = "";
    private String PondAvblValue = "";
    private String PondCatValue = "";

    public String getPondCatName() {
        return this.pondCatName;
    }

    public void setPondCatName(String pondCatName) {
        this.pondCatName = pondCatName;
    }

    public String getPondOwnerOtherDeptName() {
        return this.pondOwnerOtherDeptName;
    }

    public void setPondOwnerOtherDeptName(String pondOwnerOtherDeptName) {
        this.pondOwnerOtherDeptName = pondOwnerOtherDeptName;
    }

    public String getPondAvblValue() {
        return this.PondAvblValue;
    }

    public void setPondAvblValue(String pondAvblValue) {
        this.PondAvblValue = pondAvblValue;
    }

    public String getPondCatValue() {
        return this.PondCatValue;
    }

    public void setPondCatValue(String pondCatValue) {
        this.PondCatValue = pondCatValue;
    }

    public String getDistName() {
        return this.DistName;
    }

    public void setDistName(String distName) {
        this.DistName = distName;
    }

    public int getId() {
        return this.f179id;
    }

    public void setId(int id) {
        this.f179id = id;
    }

    public static Class<PondInspectionEntity> getPondInspectionInfo_CLASS() {
        return PondInspectionInfo_CLASS;
    }

    public static void setPondInspectionInfo_CLASS(Class<PondInspectionEntity> pondInspectionInfo_CLASS) {
        PondInspectionInfo_CLASS = pondInspectionInfo_CLASS;
    }

    public String getLongitude_Mob() {
        return this.Longitude_Mob;
    }

    public void setLongitude_Mob(String longitude_Mob) {
        this.Longitude_Mob = longitude_Mob;
    }

    public String getLatitude_Mob() {
        return this.Latitude_Mob;
    }

    public void setLatitude_Mob(String latitude_Mob) {
        this.Latitude_Mob = latitude_Mob;
    }

    public String getInspectionID() {
        return this.InspectionID;
    }

    public void setInspectionID(String inspectionID) {
        this.InspectionID = inspectionID;
    }

    public String getDistID() {
        return this.DistID;
    }

    public void setDistID(String distID) {
        this.DistID = distID;
    }

    public String getBlockID() {
        return this.BlockID;
    }

    public void setBlockID(String blockID) {
        this.BlockID = blockID;
    }

    public String getBlockName() {
        return this.BlockName;
    }

    public void setBlockName(String blockName) {
        this.BlockName = blockName;
    }

    public String getRajswaThanaNumber() {
        return this.RajswaThanaNumber;
    }

    public void setRajswaThanaNumber(String rajswaThanaNumber) {
        this.RajswaThanaNumber = rajswaThanaNumber;
    }

    public String getVillageID() {
        return this.VillageID;
    }

    public void setVillageID(String villageID) {
        this.VillageID = villageID;
    }

    public String getVillageName() {
        return this.VillageName;
    }

    public void setVillageName(String villageName) {
        this.VillageName = villageName;
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

    public String getPanchayat_Code() {
        return this.Panchayat_Code;
    }

    public void setPanchayat_Code(String panchayat_Code) {
        this.Panchayat_Code = panchayat_Code;
    }

    public String getPanchayat_Name() {
        return this.Panchayat_Name;
    }

    public void setPanchayat_Name(String panchayat_Name) {
        this.Panchayat_Name = panchayat_Name;
    }

    public String getKhata_Khesra_No() {
        return this.Khata_Khesra_No;
    }

    public void setKhata_Khesra_No(String khata_Khesra_No) {
        this.Khata_Khesra_No = khata_Khesra_No;
    }

    public String getPrivate_or_Public() {
        return this.Private_or_Public;
    }

    public void setPrivate_or_Public(String private_or_Public) {
        this.Private_or_Public = private_or_Public;
    }

    public String getArea_by_Govt_Record() {
        return this.Area_by_Govt_Record;
    }

    public void setArea_by_Govt_Record(String area_by_Govt_Record) {
        this.Area_by_Govt_Record = area_by_Govt_Record;
    }

    public String getAvailability_Of_Water() {
        return this.Availability_Of_Water;
    }

    public void setAvailability_Of_Water(String availability_Of_Water) {
        this.Availability_Of_Water = availability_Of_Water;
    }

    public String getStatus_of_Encroachment() {
        return this.Status_of_Encroachment;
    }

    public void setStatus_of_Encroachment(String status_of_Encroachment) {
        this.Status_of_Encroachment = status_of_Encroachment;
    }

    public String getTypes_of_Encroachment() {
        return this.Types_of_Encroachment;
    }

    public void setTypes_of_Encroachment(String types_of_Encroachment) {
        this.Types_of_Encroachment = types_of_Encroachment;
    }

    public String getRequirement_of_Renovation() {
        return this.Requirement_of_Renovation;
    }

    public void setRequirement_of_Renovation(String requirement_of_Renovation) {
        this.Requirement_of_Renovation = requirement_of_Renovation;
    }

    public String getRecommended_Execution_Dept() {
        return this.Recommended_Execution_Dept;
    }

    public void setRecommended_Execution_Dept(String recommended_Execution_Dept) {
        this.Recommended_Execution_Dept = recommended_Execution_Dept;
    }

    public String getRemarks() {
        return this.Remarks;
    }

    public void setRemarks(String remarks) {
        this.Remarks = remarks;
    }

    public String getIsUpdated() {
        return this.isUpdated;
    }

    public void setIsUpdated(String isUpdated) {
        this.isUpdated = isUpdated;
    }

    public String getRequirement_of_machine() {
        return this.Requirement_of_machine;
    }

    public void setRequirement_of_machine(String requirement_of_machine) {
        this.Requirement_of_machine = requirement_of_machine;
    }

    public String getName_of_undertaken() {
        return this.Name_of_undertaken;
    }

    public void setName_of_undertaken(String name_of_undertaken) {
        this.Name_of_undertaken = name_of_undertaken;
    }

    public String getConnectedWithPine() {
        return this.connectedWithPine;
    }

    public void setConnectedWithPine(String connectedWithPine) {
        this.connectedWithPine = connectedWithPine;
    }

    public String getVerified_Date() {
        return this.Verified_Date;
    }

    public void setVerified_Date(String verified_Date) {
        this.Verified_Date = verified_Date;
    }

    public String getPhoto1() {
        return this.photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return this.photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return this.photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getPhoto4() {
        return this.photo4;
    }

    public void setPhoto4(String photo4) {
        this.photo4 = photo4;
    }
}