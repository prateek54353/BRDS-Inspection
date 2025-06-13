package bih.p003in.forestdept.model;

import android.content.Context;
import bih.p003in.forestdept.database.feedEntry;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class PlantationReportList {

    @SerializedName("AgencyName")
    @Expose
    private String AgencyName;

    @SerializedName("AppVersion")
    @Expose
    private String AppVersion;

    @SerializedName("Average_height_Plant")
    @Expose
    private String Average_height_Plant;

    @SerializedName("BhumiType")
    @Expose
    private String BhumiType;

    @SerializedName("BlockID")
    @Expose
    private String BlockID;

    @SerializedName("BlockName")
    @Expose
    private String BlockName;

    @SerializedName("DistID")
    @Expose
    private String DistID;

    @SerializedName("DistName")
    @Expose
    private String DistName;

    @SerializedName("IsInspected")
    @Expose
    private String IsInspected;

    @SerializedName("IsInspectedBy")
    @Expose
    private String IsInspectedBy;

    @SerializedName("IsInspectedDate")
    @Expose
    private String IsInspectedDate;

    @SerializedName("Latitude_Mob")
    @Expose
    private String Latitude_Mob;

    @SerializedName("Longitude_Mob")
    @Expose
    private String Longitude_Mob;

    @SerializedName("PanchayatID")
    @Expose
    private String PanchayatID;

    @SerializedName("PanchayatName")
    @Expose
    private String PanchayatName;

    @SerializedName(feedEntry.Phtot1)
    @Expose
    private String Photo1;

    @SerializedName("Plantation_Site_Id")
    @Expose
    private String Plantation_Site_Id;

    @SerializedName(feedEntry.Remark)
    @Expose
    private String Remarks;

    @SerializedName("Ropit_PlantNo")
    @Expose
    private String Ropit_PlantNo;

    @SerializedName("SanctionAmtLabourCom")
    @Expose
    private String SanctionAmtLabourCom;

    @SerializedName("SanctionAmtMaterialCom")
    @Expose
    private String SanctionAmtMaterialCom;

    @SerializedName("Userrole")
    @Expose
    private String Userrole;

    @SerializedName("Utarjibit_25PercentLess")
    @Expose
    private String Utarjibit_25PercentLess;

    @SerializedName("Utarjibit_50_75Percent")
    @Expose
    private String Utarjibit_50_75Percent;

    @SerializedName("Utarjibit_75_90Percent")
    @Expose
    private String Utarjibit_75_90Percent;

    @SerializedName("Utarjibit_90PercentMore")
    @Expose
    private String Utarjibit_90PercentMore;

    @SerializedName("Utarjibit_PlantNo")
    @Expose
    private String Utarjibit_PlantNo;

    @SerializedName("UtarjibitaPercent")
    @Expose
    private String UtarjibitaPercent;

    @SerializedName("Van_Posak_bhugtaan")
    @Expose
    private String Van_Posak_bhugtaan;

    @SerializedName("Van_Posako_No")
    @Expose
    private String Van_Posako_No;

    @SerializedName("WorkCode")
    @Expose
    private String WorkCode;

    @SerializedName("WorkName")
    @Expose
    private String WorkName;

    @SerializedName("WorkStateFyear")
    @Expose
    private String WorkStateFyear;

    @SerializedName("Worktype")
    @Expose
    private String Worktype;

    @SerializedName("Years")
    @Expose
    private String Years;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;

    @SerializedName("gavyan_percentage")
    @Expose
    private String gavyan_percentage;

    @SerializedName("photo")
    @Expose
    private String photo;

    public PlantationReportList() {
    }

    public PlantationReportList(Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt, String distID, String distName, String blockID, String blockName, String panchayatID, String panchayatName, String bhumiType, String years, String remarks, String ropit_PlantNo, String utarjibit_PlantNo, String utarjibitaPercent, String utarjibit_90PercentMore, String utarjibit_75_90Percent, String utarjibit_50_75Percent, String utarjibit_25PercentLess, String isInspected, String isInspectedDate, String isInspectedBy, String appVersion, String photo, String photo1, String latitude_Mob, String longitude_Mob, String userrole, String plantation_Site_Id, String van_Posako_No, String van_Posak_bhugtaan, String gavyan_percentage, String average_height_Plant, String worktype, String workName, String workCode, String agencyName, String sanctionAmtLabourCom, String sanctionAmtMaterialCom, String workStateFyear) {
        this.aes256CbcEncryptDecrypt = aes256CbcEncryptDecrypt;
        this.DistID = distID;
        this.DistName = distName;
        this.BlockID = blockID;
        this.BlockName = blockName;
        this.PanchayatID = panchayatID;
        this.PanchayatName = panchayatName;
        this.BhumiType = bhumiType;
        this.Years = years;
        this.Remarks = remarks;
        this.Ropit_PlantNo = ropit_PlantNo;
        this.Utarjibit_PlantNo = utarjibit_PlantNo;
        this.UtarjibitaPercent = utarjibitaPercent;
        this.Utarjibit_90PercentMore = utarjibit_90PercentMore;
        this.Utarjibit_75_90Percent = utarjibit_75_90Percent;
        this.Utarjibit_50_75Percent = utarjibit_50_75Percent;
        this.Utarjibit_25PercentLess = utarjibit_25PercentLess;
        this.IsInspected = isInspected;
        this.IsInspectedDate = isInspectedDate;
        this.IsInspectedBy = isInspectedBy;
        this.AppVersion = appVersion;
        this.photo = photo;
        this.Photo1 = photo1;
        this.Latitude_Mob = latitude_Mob;
        this.Longitude_Mob = longitude_Mob;
        this.Userrole = userrole;
        this.Plantation_Site_Id = plantation_Site_Id;
        this.Van_Posako_No = van_Posako_No;
        this.Van_Posak_bhugtaan = van_Posak_bhugtaan;
        this.gavyan_percentage = gavyan_percentage;
        this.Average_height_Plant = average_height_Plant;
        this.Worktype = worktype;
        this.WorkName = workName;
        this.WorkCode = workCode;
        this.AgencyName = agencyName;
        this.SanctionAmtLabourCom = sanctionAmtLabourCom;
        this.SanctionAmtMaterialCom = sanctionAmtMaterialCom;
        this.WorkStateFyear = workStateFyear;
    }

    public PlantationReportList(PlantationReportList obj, Context context) {
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        String temp32Enc_key = CommonPref.getUserDetails(context).get_encriptionKey();
        this.DistID = this.aes256CbcEncryptDecrypt.Decrypt(obj.getDistID(), temp32Enc_key);
        this.DistName = this.aes256CbcEncryptDecrypt.Decrypt(obj.getDistName(), temp32Enc_key);
        this.BlockID = this.aes256CbcEncryptDecrypt.Decrypt(obj.getBlockID(), temp32Enc_key);
        this.BlockName = this.aes256CbcEncryptDecrypt.Decrypt(obj.getBlockName(), temp32Enc_key);
        this.PanchayatID = this.aes256CbcEncryptDecrypt.Decrypt(obj.getPanchayatID(), temp32Enc_key);
        this.PanchayatName = this.aes256CbcEncryptDecrypt.Decrypt(obj.getPanchayatName(), temp32Enc_key);
        this.BhumiType = this.aes256CbcEncryptDecrypt.Decrypt(obj.getBhumiType(), temp32Enc_key);
        this.Years = this.aes256CbcEncryptDecrypt.Decrypt(obj.getYears(), temp32Enc_key);
        this.Remarks = this.aes256CbcEncryptDecrypt.Decrypt(obj.getRemarks(), temp32Enc_key);
        this.Ropit_PlantNo = this.aes256CbcEncryptDecrypt.Decrypt(obj.getRopit_PlantNo(), temp32Enc_key);
        this.Utarjibit_PlantNo = this.aes256CbcEncryptDecrypt.Decrypt(obj.getUtarjibit_PlantNo(), temp32Enc_key);
        this.UtarjibitaPercent = this.aes256CbcEncryptDecrypt.Decrypt(obj.getUtarjibitaPercent(), temp32Enc_key);
        this.Utarjibit_90PercentMore = this.aes256CbcEncryptDecrypt.Decrypt(obj.getUtarjibit_90PercentMore(), temp32Enc_key);
        this.Utarjibit_75_90Percent = this.aes256CbcEncryptDecrypt.Decrypt(obj.getUtarjibit_75_90Percent(), temp32Enc_key);
        this.Utarjibit_50_75Percent = this.aes256CbcEncryptDecrypt.Decrypt(obj.getUtarjibit_50_75Percent(), temp32Enc_key);
        this.Utarjibit_25PercentLess = this.aes256CbcEncryptDecrypt.Decrypt(obj.getUtarjibit_25PercentLess(), temp32Enc_key);
        this.IsInspected = this.aes256CbcEncryptDecrypt.Decrypt(obj.getIsInspected(), temp32Enc_key);
        this.IsInspectedDate = this.aes256CbcEncryptDecrypt.Decrypt(obj.getIsInspectedDate(), temp32Enc_key);
        this.IsInspectedBy = this.aes256CbcEncryptDecrypt.Decrypt(obj.getIsInspectedBy(), temp32Enc_key);
        this.AppVersion = this.aes256CbcEncryptDecrypt.Decrypt(obj.getAppVersion(), temp32Enc_key);
        this.photo = obj.getPhoto();
        this.Photo1 = obj.getPhoto1();
        this.Latitude_Mob = this.aes256CbcEncryptDecrypt.Decrypt(obj.getLatitude_Mob(), temp32Enc_key);
        this.Longitude_Mob = this.aes256CbcEncryptDecrypt.Decrypt(obj.getLongitude_Mob(), temp32Enc_key);
        this.Userrole = this.aes256CbcEncryptDecrypt.Decrypt(obj.getUserrole(), temp32Enc_key);
        this.Plantation_Site_Id = this.aes256CbcEncryptDecrypt.Decrypt(obj.getPlantation_Site_Id(), temp32Enc_key);
        this.Van_Posako_No = this.aes256CbcEncryptDecrypt.Decrypt(obj.getVan_Posako_No(), temp32Enc_key);
        this.Van_Posak_bhugtaan = this.aes256CbcEncryptDecrypt.Decrypt(obj.getVan_Posak_bhugtaan(), temp32Enc_key);
        this.gavyan_percentage = this.aes256CbcEncryptDecrypt.Decrypt(obj.getGavyan_percentage(), temp32Enc_key);
        this.Average_height_Plant = this.aes256CbcEncryptDecrypt.Decrypt(obj.getAverage_height_Plant(), temp32Enc_key);
        this.Worktype = this.aes256CbcEncryptDecrypt.Decrypt(obj.getWorktype(), temp32Enc_key);
        this.WorkName = this.aes256CbcEncryptDecrypt.Decrypt(obj.getWorkName(), temp32Enc_key);
        this.WorkCode = this.aes256CbcEncryptDecrypt.Decrypt(obj.getWorkCode(), temp32Enc_key);
        this.AgencyName = this.aes256CbcEncryptDecrypt.Decrypt(obj.getAgencyName(), temp32Enc_key);
        this.SanctionAmtLabourCom = this.aes256CbcEncryptDecrypt.Decrypt(obj.getSanctionAmtLabourCom(), temp32Enc_key);
        this.SanctionAmtMaterialCom = this.aes256CbcEncryptDecrypt.Decrypt(obj.getSanctionAmtMaterialCom(), temp32Enc_key);
        this.WorkStateFyear = this.aes256CbcEncryptDecrypt.Decrypt(obj.getWorkStateFyear(), temp32Enc_key);
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

    public String getAppVersion() {
        return this.AppVersion;
    }

    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
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
}