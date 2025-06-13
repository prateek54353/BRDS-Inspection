package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class PondInspectionDetail {
    private static Class<PondInspectionDetail> POND_CLASS = PondInspectionDetail.class;
    private String DistName;
    private String DistrictCode;
    private String InspectionID;
    private String Latitude_Mob;
    private String Longitude_Mob;
    private String PondAvblValue;
    private String PondCatValue;
    private String Verified_Date;
    private String areaByGovtRecord;
    private String availiablityOfWater;
    private String blockCode;
    private String blockName;
    private String connectedWithPine;

    /* renamed from: id */
    private int f178id;
    private String isUpdated;
    private String khataKhesraNo;
    private String latitude;
    private String longitude;
    private String ownerName;
    private String panchayatCode;
    private String panchayatName;
    private String photo1;
    private String photo2;
    private String photo3;
    private String photo4;
    private String pondCatName;
    private String pondOwnerOtherDeptName;
    private String privateOrPublic;
    private String rajswaThanaNo;
    private String recommendedExecutionDept;
    private String remarks;
    private String requirementOfMachine;
    private String requirementOfRenovation;
    private String statusOfEncroachment;
    private String typesOfEncroachment;
    private String village;
    private String villageName;

    public PondInspectionDetail() {
        this.f178id = 0;
        this.InspectionID = "";
        this.blockCode = "";
        this.blockName = "";
        this.rajswaThanaNo = "";
        this.village = "";
        this.villageName = "";
        this.latitude = "";
        this.longitude = "";
        this.panchayatCode = "";
        this.panchayatName = "";
        this.khataKhesraNo = "";
        this.privateOrPublic = "";
        this.areaByGovtRecord = "";
        this.connectedWithPine = "";
        this.availiablityOfWater = "";
        this.statusOfEncroachment = "";
        this.typesOfEncroachment = "";
        this.requirementOfRenovation = "";
        this.recommendedExecutionDept = "";
        this.requirementOfMachine = "";
        this.remarks = "";
        this.isUpdated = "";
        this.ownerName = "";
        this.DistName = "";
        this.DistrictCode = "";
        this.PondAvblValue = "";
        this.PondCatValue = "";
    }

    public PondInspectionDetail(int id) {
        this.f178id = 0;
        this.InspectionID = "";
        this.blockCode = "";
        this.blockName = "";
        this.rajswaThanaNo = "";
        this.village = "";
        this.villageName = "";
        this.latitude = "";
        this.longitude = "";
        this.panchayatCode = "";
        this.panchayatName = "";
        this.khataKhesraNo = "";
        this.privateOrPublic = "";
        this.areaByGovtRecord = "";
        this.connectedWithPine = "";
        this.availiablityOfWater = "";
        this.statusOfEncroachment = "";
        this.typesOfEncroachment = "";
        this.requirementOfRenovation = "";
        this.recommendedExecutionDept = "";
        this.requirementOfMachine = "";
        this.remarks = "";
        this.isUpdated = "";
        this.ownerName = "";
        this.DistName = "";
        this.DistrictCode = "";
        this.PondAvblValue = "";
        this.PondCatValue = "";
        this.f178id = id;
    }

    public static void setPondClass(Class<PondInspectionDetail> pondClass) {
        POND_CLASS = pondClass;
    }

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

    public String getVillageName() {
        return this.villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
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

    public int getId() {
        return this.f178id;
    }

    public void setId(int id) {
        this.f178id = id;
    }

    public String getBlockCode() {
        return this.blockCode;
    }

    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getRajswaThanaNo() {
        return this.rajswaThanaNo;
    }

    public void setRajswaThanaNo(String rajswaThanaNo) {
        this.rajswaThanaNo = rajswaThanaNo;
    }

    public String getVillage() {
        return this.village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPanchayatCode() {
        return this.panchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.panchayatCode = panchayatCode;
    }

    public String getPanchayatName() {
        return this.panchayatName;
    }

    public void setPanchayatName(String panchayatName) {
        this.panchayatName = panchayatName;
    }

    public String getKhataKhesraNo() {
        return this.khataKhesraNo;
    }

    public void setKhataKhesraNo(String khataKhesraNo) {
        this.khataKhesraNo = khataKhesraNo;
    }

    public String getPrivateOrPublic() {
        return this.privateOrPublic;
    }

    public void setPrivateOrPublic(String privateOrPublic) {
        this.privateOrPublic = privateOrPublic;
    }

    public String getAreaByGovtRecord() {
        return this.areaByGovtRecord;
    }

    public void setAreaByGovtRecord(String areaByGovtRecord) {
        this.areaByGovtRecord = areaByGovtRecord;
    }

    public String getConnectedWithPine() {
        return this.connectedWithPine;
    }

    public void setConnectedWithPine(String connectedWithPine) {
        this.connectedWithPine = connectedWithPine;
    }

    public String getAvailiablityOfWater() {
        return this.availiablityOfWater;
    }

    public void setAvailiablityOfWater(String availiablityOfWater) {
        this.availiablityOfWater = availiablityOfWater;
    }

    public String getStatusOfEncroachment() {
        return this.statusOfEncroachment;
    }

    public void setStatusOfEncroachment(String statusOfEncroachment) {
        this.statusOfEncroachment = statusOfEncroachment;
    }

    public String getTypesOfEncroachment() {
        return this.typesOfEncroachment;
    }

    public void setTypesOfEncroachment(String typesOfEncroachment) {
        this.typesOfEncroachment = typesOfEncroachment;
    }

    public String getRequirementOfRenovation() {
        return this.requirementOfRenovation;
    }

    public void setRequirementOfRenovation(String requirementOfRenovation) {
        this.requirementOfRenovation = requirementOfRenovation;
    }

    public String getRecommendedExecutionDept() {
        return this.recommendedExecutionDept;
    }

    public void setRecommendedExecutionDept(String recommendedExecutionDept) {
        this.recommendedExecutionDept = recommendedExecutionDept;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIsUpdated() {
        return this.isUpdated;
    }

    public void setIsUpdated(String isUpdated) {
        this.isUpdated = isUpdated;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDistName() {
        return this.DistName;
    }

    public void setDistName(String distName) {
        this.DistName = distName;
    }

    public String getDistrictCode() {
        return this.DistrictCode;
    }

    public void setDistrictCode(String districtCode) {
        this.DistrictCode = districtCode;
    }

    public String getRequirementOfMachine() {
        return this.requirementOfMachine;
    }

    public void setRequirementOfMachine(String requirementOfMachine) {
        this.requirementOfMachine = requirementOfMachine;
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

    public String getInspectionID() {
        return this.InspectionID;
    }

    public void setInspectionID(String inspectionID) {
        this.InspectionID = inspectionID;
    }
}