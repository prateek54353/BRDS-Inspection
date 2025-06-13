package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class PlantationReportEntity implements Serializable {
    public static Class<PlantationReportEntity> PlantationReportEntity_CLASS = PlantationReportEntity.class;
    private String AgencyName;
    private String Average_height_Plant;
    private String BhumiType;
    private String BlockID;
    private String BlockName;
    private String DistID;
    private String DistName;
    private String IsInspected;
    private String IsInspectedBy;
    private String IsInspectedDate;
    private String LastInspDetails;
    private String PanchayatID;
    private String PanchayatName;
    private String Plantation_Site_Id;
    private String Remarks;
    private String Ropit_PlantNo;
    private String SanctionAmtLabourCom;
    private String SanctionAmtMaterialCom;
    private String Userrole;
    private String Utarjibit_25PercentLess;
    private String Utarjibit_50_75Percent;
    private String Utarjibit_75_90Percent;
    private String Utarjibit_90PercentMore;
    private String Utarjibit_PlantNo;
    private String UtarjibitaPercent;
    private String Van_Posak_bhugtaan;
    private String Van_Posako_No;
    private String WorkCode;
    private String WorkName;
    private String WorkStateFyear;
    private String Worktype;
    private String Years;
    private String gavyan_percentage;

    public static Class<PlantationReportEntity> getPlantationReportEntity_CLASS() {
        return PlantationReportEntity_CLASS;
    }

    public static void setPlantationReportEntity_CLASS(Class<PlantationReportEntity> plantationReportEntity_CLASS) {
        PlantationReportEntity_CLASS = plantationReportEntity_CLASS;
    }

    public String getUserrole() {
        return this.Userrole;
    }

    public void setUserrole(String userrole) {
        this.Userrole = userrole;
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

    public String getVan_Posak_bhugtaan() {
        return this.Van_Posak_bhugtaan;
    }

    public void setVan_Posak_bhugtaan(String van_Posak_bhugtaan) {
        this.Van_Posak_bhugtaan = van_Posak_bhugtaan;
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

    public String getWorktype() {
        return this.Worktype;
    }

    public void setWorktype(String worktype) {
        this.Worktype = worktype;
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

    public String getWorkStateFyear() {
        return this.WorkStateFyear;
    }

    public void setWorkStateFyear(String workStateFyear) {
        this.WorkStateFyear = workStateFyear;
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

    public String getBhumiType() {
        return this.BhumiType;
    }

    public void setBhumiType(String bhumiType) {
        this.BhumiType = bhumiType;
    }

    public String getYears() {
        return this.Years;
    }

    public void setYears(String years) {
        this.Years = years;
    }

    public String getRemarks() {
        return this.Remarks;
    }

    public void setRemarks(String remarks) {
        this.Remarks = remarks;
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

    public String getIsInspected() {
        return this.IsInspected;
    }

    public void setIsInspected(String isInspected) {
        this.IsInspected = isInspected;
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

    public String getLastInspDetails() {
        return this.LastInspDetails;
    }

    public void setLastInspDetails(String lastInspDetails) {
        this.LastInspDetails = lastInspDetails;
    }
}