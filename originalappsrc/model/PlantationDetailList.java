package bih.p003in.forestdept.model;

import android.os.Parcel;
import android.os.Parcelable;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class PlantationDetailList implements Parcelable {
    public static final Parcelable.Creator<PlantationDetailList> CREATOR = new Parcelable.Creator<PlantationDetailList>() { // from class: bih.in.forestdept.model.PlantationDetailList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlantationDetailList createFromParcel(Parcel in) {
            return new PlantationDetailList(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlantationDetailList[] newArray(int size) {
            return new PlantationDetailList[size];
        }
    };

    @SerializedName("AgencyName")
    @Expose
    private String AgencyName;
    private String AppVersion;

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

    @SerializedName("InspectionID")
    @Expose
    private String InspectionID;

    @SerializedName("IsInspectedBy")
    @Expose
    private String IsInspectedBy;

    @SerializedName("IsInspectedByBLKJE")
    @Expose
    private String IsInspectedByBLKJE;

    @SerializedName("IsInspectedByBLKPO")
    @Expose
    private String IsInspectedByBLKPO;

    @SerializedName("IsInspectedByDSTAE")
    @Expose
    private String IsInspectedByDSTAE;

    @SerializedName("IsInspectedByDSTDDC")
    @Expose
    private String IsInspectedByDSTDDC;

    @SerializedName("IsInspectedByDSTDRDA")
    @Expose
    private String IsInspectedByDSTDRDA;

    @SerializedName("IsInspectedByDSTEE")
    @Expose
    private String IsInspectedByDSTEE;

    @SerializedName("IsInspectedByDSTPO")
    @Expose
    private String IsInspectedByDSTPO;

    @SerializedName("IsInspectedDate")
    @Expose
    private String IsInspectedDate;

    @SerializedName("LastInspectionDetails")
    @Expose
    private String LastInspectionDetails;

    @SerializedName("PanchayatID")
    @Expose
    private String PanchayatID;

    @SerializedName("PanchayatName")
    @Expose
    private String PanchayatName;

    @SerializedName("SanctionAmtLabourCom")
    @Expose
    private String SanctionAmtLabourCom;

    @SerializedName("SanctionAmtMaterialCom")
    @Expose
    private String SanctionAmtMaterialCom;

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
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;

    /* renamed from: id */
    private int f198id;
    private String userRole;
    private String verifiedBy;
    private String verifiedDate;

    public PlantationDetailList() {
    }

    public PlantationDetailList(PlantationDetailList list, String temp32Enc_key) {
        Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        this.aes256CbcEncryptDecrypt = aes256CbcEncryptDecrypt;
        this.DistID = aes256CbcEncryptDecrypt.Decrypt(list.getDistID(), temp32Enc_key);
        this.DistName = this.aes256CbcEncryptDecrypt.Decrypt(list.getDistName(), temp32Enc_key);
        this.BlockID = this.aes256CbcEncryptDecrypt.Decrypt(list.getBlockID(), temp32Enc_key);
        this.BlockName = this.aes256CbcEncryptDecrypt.Decrypt(list.getBlockName(), temp32Enc_key);
        this.PanchayatID = this.aes256CbcEncryptDecrypt.Decrypt(list.getPanchayatID(), temp32Enc_key);
        this.PanchayatName = this.aes256CbcEncryptDecrypt.Decrypt(list.getPanchayatName(), temp32Enc_key);
        this.WorkStateFyear = this.aes256CbcEncryptDecrypt.Decrypt(list.getWorkStateFyear(), temp32Enc_key);
        this.WorkName = this.aes256CbcEncryptDecrypt.Decrypt(list.getWorkName(), temp32Enc_key);
        this.WorkCode = this.aes256CbcEncryptDecrypt.Decrypt(list.getWorkCode(), temp32Enc_key);
        this.Worktype = this.aes256CbcEncryptDecrypt.Decrypt(list.getWorktype(), temp32Enc_key);
        this.AgencyName = this.aes256CbcEncryptDecrypt.Decrypt(list.getAgencyName(), temp32Enc_key);
        this.SanctionAmtLabourCom = this.aes256CbcEncryptDecrypt.Decrypt(list.getSanctionAmtLabourCom(), temp32Enc_key);
        this.SanctionAmtMaterialCom = this.aes256CbcEncryptDecrypt.Decrypt(list.getSanctionAmtMaterialCom(), temp32Enc_key);
        this.InspectionID = this.aes256CbcEncryptDecrypt.Decrypt(list.getInspectionID(), temp32Enc_key);
        this.IsInspectedDate = this.aes256CbcEncryptDecrypt.Decrypt(list.getIsInspectedDate(), temp32Enc_key);
        this.IsInspectedBy = this.aes256CbcEncryptDecrypt.Decrypt(list.getIsInspectedBy(), temp32Enc_key);
        this.IsInspectedByDSTAE = this.aes256CbcEncryptDecrypt.Decrypt(list.getIsInspectedByDSTAE(), temp32Enc_key);
        this.IsInspectedByDSTEE = this.aes256CbcEncryptDecrypt.Decrypt(list.getIsInspectedByDSTEE(), temp32Enc_key);
        this.IsInspectedByDSTDRDA = this.aes256CbcEncryptDecrypt.Decrypt(list.getIsInspectedByDSTDRDA(), temp32Enc_key);
        this.IsInspectedByDSTDDC = this.aes256CbcEncryptDecrypt.Decrypt(list.getIsInspectedByDSTDDC(), temp32Enc_key);
        this.IsInspectedByDSTPO = this.aes256CbcEncryptDecrypt.Decrypt(list.getIsInspectedByDSTPO(), temp32Enc_key);
        this.IsInspectedByBLKPO = this.aes256CbcEncryptDecrypt.Decrypt(list.getIsInspectedByBLKPO(), temp32Enc_key);
        this.IsInspectedByBLKJE = this.aes256CbcEncryptDecrypt.Decrypt(list.getIsInspectedByBLKJE(), temp32Enc_key);
        this.LastInspectionDetails = this.aes256CbcEncryptDecrypt.Decrypt(list.getLastInspectionDetails(), temp32Enc_key);
    }

    protected PlantationDetailList(Parcel in) {
        this.f198id = in.readInt();
        this.DistID = in.readString();
        this.DistName = in.readString();
        this.BlockID = in.readString();
        this.BlockName = in.readString();
        this.PanchayatID = in.readString();
        this.PanchayatName = in.readString();
        this.WorkStateFyear = in.readString();
        this.WorkName = in.readString();
        this.WorkCode = in.readString();
        this.Worktype = in.readString();
        this.AgencyName = in.readString();
        this.SanctionAmtLabourCom = in.readString();
        this.SanctionAmtMaterialCom = in.readString();
        this.InspectionID = in.readString();
        this.IsInspectedDate = in.readString();
        this.IsInspectedBy = in.readString();
        this.IsInspectedByDSTAE = in.readString();
        this.IsInspectedByDSTEE = in.readString();
        this.IsInspectedByDSTDRDA = in.readString();
        this.IsInspectedByDSTDDC = in.readString();
        this.IsInspectedByDSTPO = in.readString();
        this.IsInspectedByBLKPO = in.readString();
        this.IsInspectedByBLKJE = in.readString();
        this.LastInspectionDetails = in.readString();
        this.AppVersion = in.readString();
        this.verifiedBy = in.readString();
        this.verifiedDate = in.readString();
        this.userRole = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f198id);
        dest.writeString(this.DistID);
        dest.writeString(this.DistName);
        dest.writeString(this.BlockID);
        dest.writeString(this.BlockName);
        dest.writeString(this.PanchayatID);
        dest.writeString(this.PanchayatName);
        dest.writeString(this.WorkStateFyear);
        dest.writeString(this.WorkName);
        dest.writeString(this.WorkCode);
        dest.writeString(this.Worktype);
        dest.writeString(this.AgencyName);
        dest.writeString(this.SanctionAmtLabourCom);
        dest.writeString(this.SanctionAmtMaterialCom);
        dest.writeString(this.InspectionID);
        dest.writeString(this.IsInspectedDate);
        dest.writeString(this.IsInspectedBy);
        dest.writeString(this.IsInspectedByDSTAE);
        dest.writeString(this.IsInspectedByDSTEE);
        dest.writeString(this.IsInspectedByDSTDRDA);
        dest.writeString(this.IsInspectedByDSTDDC);
        dest.writeString(this.IsInspectedByDSTPO);
        dest.writeString(this.IsInspectedByBLKPO);
        dest.writeString(this.IsInspectedByBLKJE);
        dest.writeString(this.LastInspectionDetails);
        dest.writeString(this.AppVersion);
        dest.writeString(this.verifiedBy);
        dest.writeString(this.verifiedDate);
        dest.writeString(this.userRole);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public String getIsInspectedByDSTPO() {
        return this.IsInspectedByDSTPO;
    }

    public void setIsInspectedByDSTPO(String isInspectedByDSTPO) {
        this.IsInspectedByDSTPO = isInspectedByDSTPO;
    }

    public String getIsInspectedByBLKPO() {
        return this.IsInspectedByBLKPO;
    }

    public void setIsInspectedByBLKPO(String isInspectedByBLKPO) {
        this.IsInspectedByBLKPO = isInspectedByBLKPO;
    }

    public String getIsInspectedByBLKJE() {
        return this.IsInspectedByBLKJE;
    }

    public void setIsInspectedByBLKJE(String isInspectedByBLKJE) {
        this.IsInspectedByBLKJE = isInspectedByBLKJE;
    }

    public String getLastInspectionDetails() {
        return this.LastInspectionDetails;
    }

    public void setLastInspectionDetails(String lastInspectionDetails) {
        this.LastInspectionDetails = lastInspectionDetails;
    }

    public int getId() {
        return this.f198id;
    }

    public void setId(int id) {
        this.f198id = id;
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
}