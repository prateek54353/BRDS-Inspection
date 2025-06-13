package bih.p003in.forestdept.model;

import android.os.Parcel;
import android.os.Parcelable;
import bih.p003in.forestdept.database.feedEntry;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class PlantationInspDetails_Request implements Parcelable {
    public static final Parcelable.Creator<PlantationInspDetails_Request> CREATOR = new Parcelable.Creator<PlantationInspDetails_Request>() { // from class: bih.in.forestdept.model.PlantationInspDetails_Request.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlantationInspDetails_Request createFromParcel(Parcel in) {
            return new PlantationInspDetails_Request(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlantationInspDetails_Request[] newArray(int size) {
            return new PlantationInspDetails_Request[size];
        }
    };
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

    @SerializedName("BlockCode")
    @Expose
    private String BlockCode;
    private String BlockName;

    @SerializedName("DeviceId")
    @Expose
    private String DeviceId;

    @SerializedName("DistCode")
    @Expose
    private String DistCode;
    private String DistName;
    private String Fyear;

    @SerializedName("InspectionID")
    @Expose
    private String InspectionID;

    @SerializedName("IpAddress")
    @Expose
    private String IpAddress;

    @SerializedName("IsInspected")
    @Expose
    private String IsInspected;

    @SerializedName("IsInspectedBy")
    @Expose
    private String IsInspectedBy;
    private String IsInspectedByDSTAE;
    private String IsInspectedByDSTDDC;
    private String IsInspectedByDSTDRDA;
    private String IsInspectedByDSTEE;

    @SerializedName("IsInspectedDate")
    @Expose
    private String IsInspectedDate;
    private String LastInspectionDetails;

    @SerializedName("Latitude_Mob")
    @Expose
    private String Latitude_Mob;

    @SerializedName("Longitude_Mob")
    @Expose
    private String Longitude_Mob;

    @SerializedName("PanchayatCode")
    @Expose
    private String PanchayatCode;
    private String PanchayatName;

    @SerializedName(feedEntry.Phtot1)
    @Expose
    private String Photo1;

    @SerializedName("PlantAgainstDeadPlnt")
    @Expose
    private String PlantAgainstDeadPlnt;

    @SerializedName("_PlantationGeoTaging_obj")
    @Expose
    private String PlantationGeoTaging_obj;

    @SerializedName("Plantation_Site_Id")
    @Expose
    private String Plantation_Site_Id;
    private String Plantation_Site_Name;
    private String Posak_bhugtaanMonth;
    private String Posak_bhugtaanYear;

    @SerializedName(feedEntry.Remark)
    @Expose
    private String Remarks;

    @SerializedName("ResultMessage")
    @Expose
    private String ResultMessage;

    @SerializedName("Ropit_PlantNo")
    @Expose
    private String Ropit_PlantNo;
    private String SanctionAmtLabourCom;
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
    private String WorkCode;
    private String WorkName;
    private String WorkStateFyear;
    private String Worktype;

    @SerializedName("Years")
    @Expose
    private String Years;

    @SerializedName("gavyan_percentage")
    @Expose
    private String gavyan_percentage;

    /* renamed from: id */
    private int f199id;
    private String isUpdated;

    @SerializedName("photo")
    @Expose
    private String photo;
    private String verifiedBy;
    private String verifiedDate;

    public PlantationInspDetails_Request() {
    }

    protected PlantationInspDetails_Request(Parcel in) {
        this.f199id = in.readInt();
        this.DistCode = in.readString();
        this.DistName = in.readString();
        this.BlockCode = in.readString();
        this.BlockName = in.readString();
        this.PanchayatCode = in.readString();
        this.PanchayatName = in.readString();
        this.BhumiType = in.readString();
        this.Years = in.readString();
        this.Remarks = in.readString();
        this.InspectionID = in.readString();
        this.Ropit_PlantNo = in.readString();
        this.Utarjibit_PlantNo = in.readString();
        this.UtarjibitaPercent = in.readString();
        this.Utarjibit_90PercentMore = in.readString();
        this.Utarjibit_75_90Percent = in.readString();
        this.Utarjibit_50_75Percent = in.readString();
        this.Utarjibit_25PercentLess = in.readString();
        this.IsInspected = in.readString();
        this.IsInspectedDate = in.readString();
        this.IsInspectedBy = in.readString();
        this.AppVersion = in.readString();
        this.photo = in.readString();
        this.Photo1 = in.readString();
        this.Latitude_Mob = in.readString();
        this.Longitude_Mob = in.readString();
        this.Userrole = in.readString();
        this.Van_Posako_No = in.readString();
        this.Van_Posak_bhugtaan = in.readString();
        this.gavyan_percentage = in.readString();
        this.Average_height_Plant = in.readString();
        this.PlantAgainstDeadPlnt = in.readString();
        this.ResultMessage = in.readString();
        this.IsInspectedByDSTAE = in.readString();
        this.IsInspectedByDSTEE = in.readString();
        this.IsInspectedByDSTDRDA = in.readString();
        this.IsInspectedByDSTDDC = in.readString();
        this.WorkCode = in.readString();
        this.WorkName = in.readString();
        this.Worktype = in.readString();
        this.AgencyName = in.readString();
        this.WorkStateFyear = in.readString();
        this.Plantation_Site_Id = in.readString();
        this.Plantation_Site_Name = in.readString();
        this.Fyear = in.readString();
        this.SanctionAmtLabourCom = in.readString();
        this.SanctionAmtMaterialCom = in.readString();
        this.Posak_bhugtaanMonth = in.readString();
        this.Posak_bhugtaanYear = in.readString();
        this.isUpdated = in.readString();
        this.verifiedBy = in.readString();
        this.verifiedDate = in.readString();
        this.LastInspectionDetails = in.readString();
        this.DeviceId = in.toString();
        this.IpAddress = in.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f199id);
        dest.writeString(this.DistCode);
        dest.writeString(this.DistName);
        dest.writeString(this.BlockCode);
        dest.writeString(this.BlockName);
        dest.writeString(this.PanchayatCode);
        dest.writeString(this.PanchayatName);
        dest.writeString(this.BhumiType);
        dest.writeString(this.Years);
        dest.writeString(this.Remarks);
        dest.writeString(this.InspectionID);
        dest.writeString(this.Ropit_PlantNo);
        dest.writeString(this.Utarjibit_PlantNo);
        dest.writeString(this.UtarjibitaPercent);
        dest.writeString(this.Utarjibit_90PercentMore);
        dest.writeString(this.Utarjibit_75_90Percent);
        dest.writeString(this.Utarjibit_50_75Percent);
        dest.writeString(this.Utarjibit_25PercentLess);
        dest.writeString(this.IsInspected);
        dest.writeString(this.IsInspectedDate);
        dest.writeString(this.IsInspectedBy);
        dest.writeString(this.AppVersion);
        dest.writeString(this.photo);
        dest.writeString(this.Photo1);
        dest.writeString(this.Latitude_Mob);
        dest.writeString(this.Longitude_Mob);
        dest.writeString(this.Userrole);
        dest.writeString(this.Van_Posako_No);
        dest.writeString(this.Van_Posak_bhugtaan);
        dest.writeString(this.gavyan_percentage);
        dest.writeString(this.Average_height_Plant);
        dest.writeString(this.PlantAgainstDeadPlnt);
        dest.writeString(this.ResultMessage);
        dest.writeString(this.IsInspectedByDSTAE);
        dest.writeString(this.IsInspectedByDSTEE);
        dest.writeString(this.IsInspectedByDSTDRDA);
        dest.writeString(this.IsInspectedByDSTDDC);
        dest.writeString(this.WorkCode);
        dest.writeString(this.WorkName);
        dest.writeString(this.Worktype);
        dest.writeString(this.AgencyName);
        dest.writeString(this.WorkStateFyear);
        dest.writeString(this.Plantation_Site_Id);
        dest.writeString(this.Plantation_Site_Name);
        dest.writeString(this.Fyear);
        dest.writeString(this.SanctionAmtLabourCom);
        dest.writeString(this.SanctionAmtMaterialCom);
        dest.writeString(this.Posak_bhugtaanMonth);
        dest.writeString(this.Posak_bhugtaanYear);
        dest.writeString(this.isUpdated);
        dest.writeString(this.verifiedBy);
        dest.writeString(this.verifiedDate);
        dest.writeString(this.LastInspectionDetails);
        dest.writeString(this.DeviceId);
        dest.writeString(this.IpAddress);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDistCode() {
        return this.DistCode;
    }

    public void setDistCode(String distCode) {
        this.DistCode = distCode;
    }

    public String getBlockCode() {
        return this.BlockCode;
    }

    public void setBlockCode(String blockCode) {
        this.BlockCode = blockCode;
    }

    public String getPanchayatCode() {
        return this.PanchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.PanchayatCode = panchayatCode;
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

    public String getInspectionID() {
        return this.InspectionID;
    }

    public void setInspectionID(String inspectionID) {
        this.InspectionID = inspectionID;
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

    public String getResultMessage() {
        return this.ResultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.ResultMessage = resultMessage;
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

    public String getPlantAgainstDeadPlnt() {
        return this.PlantAgainstDeadPlnt;
    }

    public void setPlantAgainstDeadPlnt(String plantAgainstDeadPlnt) {
        this.PlantAgainstDeadPlnt = plantAgainstDeadPlnt;
    }

    public String getWorkCode() {
        return this.WorkCode;
    }

    public void setWorkCode(String workCode) {
        this.WorkCode = workCode;
    }

    public String getWorkName() {
        return this.WorkName;
    }

    public void setWorkName(String workName) {
        this.WorkName = workName;
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

    public String getWorkStateFyear() {
        return this.WorkStateFyear;
    }

    public void setWorkStateFyear(String workStateFyear) {
        this.WorkStateFyear = workStateFyear;
    }

    public String getPlantation_Site_Name() {
        return this.Plantation_Site_Name;
    }

    public void setPlantation_Site_Name(String plantation_Site_Name) {
        this.Plantation_Site_Name = plantation_Site_Name;
    }

    public String getFyear() {
        return this.Fyear;
    }

    public void setFyear(String fyear) {
        this.Fyear = fyear;
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

    public String getIsUpdated() {
        return this.isUpdated;
    }

    public void setIsUpdated(String isUpdated) {
        this.isUpdated = isUpdated;
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

    public String getDistName() {
        return this.DistName;
    }

    public void setDistName(String distName) {
        this.DistName = distName;
    }

    public String getBlockName() {
        return this.BlockName;
    }

    public void setBlockName(String blockName) {
        this.BlockName = blockName;
    }

    public String getPanchayatName() {
        return this.PanchayatName;
    }

    public void setPanchayatName(String panchayatName) {
        this.PanchayatName = panchayatName;
    }

    public int getId() {
        return this.f199id;
    }

    public void setId(int id) {
        this.f199id = id;
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

    public String getLastInspectionDetails() {
        return this.LastInspectionDetails;
    }

    public void setLastInspectionDetails(String lastInspectionDetails) {
        this.LastInspectionDetails = lastInspectionDetails;
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

    public String getDeviceId() {
        return this.DeviceId;
    }

    public void setDeviceId(String deviceId) {
        this.DeviceId = deviceId;
    }

    public String getIpAddress() {
        return this.IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.IpAddress = ipAddress;
    }

    public String getPlantationGeoTaging_obj() {
        return this.PlantationGeoTaging_obj;
    }

    public void setPlantationGeoTaging_obj(String plantationGeoTaging_obj) {
        this.PlantationGeoTaging_obj = plantationGeoTaging_obj;
    }
}