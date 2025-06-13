package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class PlantationDetail implements Serializable {
    public static Class<PlantationDetail> PlantationDetail_CLASS = PlantationDetail.class;
    private String AgencyName;
    private String AppVersion;
    private String Average_height_Plant;
    private String BhumiType;
    private String BlockID;
    private String BlockName;
    private String DistID;
    private String DistName;
    private String Fyear;
    private String InspectionID;
    private String IsInspectedBy;
    private String IsInspectedByDSTAE;
    private String IsInspectedByDSTDDC;
    private String IsInspectedByDSTDRDA;
    private String IsInspectedByDSTEE;
    private String IsInspectedDate;
    private String LastInspectionDetails;
    private String Latitude_Mob;
    private String Longitude_Mob;
    private String PanchayatID;
    private String PanchayatName;
    private String Photo1;
    private String PlantAgainstDeadPlnt;
    private String Plantation_Site_Id;
    private String Plantation_Site_Name;
    private String Posak_bhugtaanMonth;
    private String Posak_bhugtaanYear;
    private String Remarks;
    private String Ropit_PlantNo;
    private String SanctionAmtLabourCom;
    private String SanctionAmtMaterialCom;
    private String Utarjibit_25PercentLess;
    private String Utarjibit_50_75Percent;
    private String Utarjibit_75_90Percent;
    private String Utarjibit_90PercentMore;
    private String Utarjibit_PlantNo;
    private String UtarjibitaPercent;
    private String Van_Posako_No;
    private String WorkCode;
    private String WorkName;
    private String WorkStateFyear;
    private String Worktype;
    private String gavyan_percentage;

    /* renamed from: id */
    private int f174id;
    private String isUpdated;
    private String photo;
    private String userRole;
    private String verifiedBy;
    private String verifiedDate;

    public static Class<PlantationDetail> getPlantationDetail_CLASS() {
        return PlantationDetail_CLASS;
    }

    public static void setPlantationDetail_CLASS(Class<PlantationDetail> plantationDetail_CLASS) {
        PlantationDetail_CLASS = plantationDetail_CLASS;
    }

    public String getPlantAgainstDeadPlnt() {
        return this.PlantAgainstDeadPlnt;
    }

    public void setPlantAgainstDeadPlnt(String plantAgainstDeadPlnt) {
        this.PlantAgainstDeadPlnt = plantAgainstDeadPlnt;
    }

    public String getPlantation_Site_Name() {
        return this.Plantation_Site_Name;
    }

    public void setPlantation_Site_Name(String plantation_Site_Name) {
        this.Plantation_Site_Name = plantation_Site_Name;
    }

    public String getPlantation_Site_Id() {
        return this.Plantation_Site_Id;
    }

    public void setPlantation_Site_Id(String plantation_Site_Id) {
        this.Plantation_Site_Id = plantation_Site_Id;
    }

    public String getVan_Posako_No() {
        return this.Van_Posako_No;
    }

    public void setVan_Posako_No(String van_Posako_No) {
        this.Van_Posako_No = van_Posako_No;
    }

    public String getPosak_bhugtaanMonth() {
        return this.Posak_bhugtaanMonth;
    }

    public void setPosak_bhugtaanMonth(String posak_bhugtaanMonth) {
        this.Posak_bhugtaanMonth = posak_bhugtaanMonth;
    }

    public String getPosak_bhugtaanYear() {
        return this.Posak_bhugtaanYear;
    }

    public void setPosak_bhugtaanYear(String posak_bhugtaanYear) {
        this.Posak_bhugtaanYear = posak_bhugtaanYear;
    }

    public String getGavyan_percentage() {
        return this.gavyan_percentage;
    }

    public void setGavyan_percentage(String gavyan_percentage) {
        this.gavyan_percentage = gavyan_percentage;
    }

    public String getAverage_height_Plant() {
        return this.Average_height_Plant;
    }

    public void setAverage_height_Plant(String average_height_Plant) {
        this.Average_height_Plant = average_height_Plant;
    }

    public String getIsInspectedByDSTAE() {
        return this.IsInspectedByDSTAE;
    }

    public void setIsInspectedByDSTAE(String isInspectedByDSTAE) {
        this.IsInspectedByDSTAE = isInspectedByDSTAE;
    }

    public String getIsInspectedByDSTEE() {
        return this.IsInspectedByDSTEE;
    }

    public void setIsInspectedByDSTEE(String isInspectedByDSTEE) {
        this.IsInspectedByDSTEE = isInspectedByDSTEE;
    }

    public String getIsInspectedByDSTDRDA() {
        return this.IsInspectedByDSTDRDA;
    }

    public void setIsInspectedByDSTDRDA(String isInspectedByDSTDRDA) {
        this.IsInspectedByDSTDRDA = isInspectedByDSTDRDA;
    }

    public String getIsInspectedByDSTDDC() {
        return this.IsInspectedByDSTDDC;
    }

    public void setIsInspectedByDSTDDC(String isInspectedByDSTDDC) {
        this.IsInspectedByDSTDDC = isInspectedByDSTDDC;
    }

    public String getFyear() {
        return this.Fyear;
    }

    public void setFyear(String fyear) {
        this.Fyear = fyear;
    }

    public String getBhumiType() {
        return this.BhumiType;
    }

    public void setBhumiType(String bhumiType) {
        this.BhumiType = bhumiType;
    }

    public String getRopit_PlantNo() {
        return this.Ropit_PlantNo;
    }

    public void setRopit_PlantNo(String ropit_PlantNo) {
        this.Ropit_PlantNo = ropit_PlantNo;
    }

    public String getUtarjibit_PlantNo() {
        return this.Utarjibit_PlantNo;
    }

    public void setUtarjibit_PlantNo(String utarjibit_PlantNo) {
        this.Utarjibit_PlantNo = utarjibit_PlantNo;
    }

    public String getUtarjibitaPercent() {
        return this.UtarjibitaPercent;
    }

    public void setUtarjibitaPercent(String utarjibitaPercent) {
        this.UtarjibitaPercent = utarjibitaPercent;
    }

    public String getUtarjibit_90PercentMore() {
        return this.Utarjibit_90PercentMore;
    }

    public void setUtarjibit_90PercentMore(String utarjibit_90PercentMore) {
        this.Utarjibit_90PercentMore = utarjibit_90PercentMore;
    }

    public String getUtarjibit_75_90Percent() {
        return this.Utarjibit_75_90Percent;
    }

    public void setUtarjibit_75_90Percent(String utarjibit_75_90Percent) {
        this.Utarjibit_75_90Percent = utarjibit_75_90Percent;
    }

    public String getUtarjibit_50_75Percent() {
        return this.Utarjibit_50_75Percent;
    }

    public void setUtarjibit_50_75Percent(String utarjibit_50_75Percent) {
        this.Utarjibit_50_75Percent = utarjibit_50_75Percent;
    }

    public String getUtarjibit_25PercentLess() {
        return this.Utarjibit_25PercentLess;
    }

    public void setUtarjibit_25PercentLess(String utarjibit_25PercentLess) {
        this.Utarjibit_25PercentLess = utarjibit_25PercentLess;
    }

    public String getRemarks() {
        return this.Remarks;
    }

    public void setRemarks(String remarks) {
        this.Remarks = remarks;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto1() {
        return this.Photo1;
    }

    public void setPhoto1(String photo1) {
        this.Photo1 = photo1;
    }

    public String getLatitude_Mob() {
        return this.Latitude_Mob;
    }

    public void setLatitude_Mob(String latitude_Mob) {
        this.Latitude_Mob = latitude_Mob;
    }

    public String getLongitude_Mob() {
        return this.Longitude_Mob;
    }

    public void setLongitude_Mob(String longitude_Mob) {
        this.Longitude_Mob = longitude_Mob;
    }

    public int getId() {
        return this.f174id;
    }

    public void setId(int id) {
        this.f174id = id;
    }

    public String getDistID() {
        return this.DistID;
    }

    public void setDistID(String distID) {
        this.DistID = distID;
    }

    public String getDistName() {
        return this.DistName;
    }

    public void setDistName(String distName) {
        this.DistName = distName;
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

    public String getPanchayatID() {
        return this.PanchayatID;
    }

    public void setPanchayatID(String panchayatID) {
        this.PanchayatID = panchayatID;
    }

    public String getPanchayatName() {
        return this.PanchayatName;
    }

    public void setPanchayatName(String panchayatName) {
        this.PanchayatName = panchayatName;
    }

    public String getWorkStateFyear() {
        return this.WorkStateFyear;
    }

    public void setWorkStateFyear(String workStateFyear) {
        this.WorkStateFyear = workStateFyear;
    }

    public String getWorkName() {
        return this.WorkName;
    }

    public void setWorkName(String workName) {
        this.WorkName = workName;
    }

    public String getWorkCode() {
        return this.WorkCode;
    }

    public void setWorkCode(String workCode) {
        this.WorkCode = workCode;
    }

    public String getWorktype() {
        return this.Worktype;
    }

    public void setWorktype(String worktype) {
        this.Worktype = worktype;
    }

    public String getAgencyName() {
        return this.AgencyName;
    }

    public void setAgencyName(String agencyName) {
        this.AgencyName = agencyName;
    }

    public String getSanctionAmtLabourCom() {
        return this.SanctionAmtLabourCom;
    }

    public void setSanctionAmtLabourCom(String sanctionAmtLabourCom) {
        this.SanctionAmtLabourCom = sanctionAmtLabourCom;
    }

    public String getSanctionAmtMaterialCom() {
        return this.SanctionAmtMaterialCom;
    }

    public void setSanctionAmtMaterialCom(String sanctionAmtMaterialCom) {
        this.SanctionAmtMaterialCom = sanctionAmtMaterialCom;
    }

    public String getInspectionID() {
        return this.InspectionID;
    }

    public void setInspectionID(String inspectionID) {
        this.InspectionID = inspectionID;
    }

    public String getIsInspectedDate() {
        return this.IsInspectedDate;
    }

    public void setIsInspectedDate(String isInspectedDate) {
        this.IsInspectedDate = isInspectedDate;
    }

    public String getIsInspectedBy() {
        return this.IsInspectedBy;
    }

    public void setIsInspectedBy(String isInspectedBy) {
        this.IsInspectedBy = isInspectedBy;
    }

    public String getIsUpdated() {
        return this.isUpdated;
    }

    public void setIsUpdated(String isUpdated) {
        this.isUpdated = isUpdated;
    }

    public String getAppVersion() {
        return this.AppVersion;
    }

    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
    }

    public String getVerifiedBy() {
        return this.verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public String getVerifiedDate() {
        return this.verifiedDate;
    }

    public void setVerifiedDate(String verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getLastInspectionDetails() {
        return this.LastInspectionDetails;
    }

    public void setLastInspectionDetails(String lastInspectionDetails) {
        this.LastInspectionDetails = lastInspectionDetails;
    }
}