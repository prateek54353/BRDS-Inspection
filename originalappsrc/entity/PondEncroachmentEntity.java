package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class PondEncroachmentEntity implements Serializable {
    public static Class<PondEncroachmentEntity> PondEncroachmentEntity_CLASS = PondEncroachmentEntity.class;
    private String AppVersion;
    private String BlockID;
    private String BlockName;
    private String DistID;
    private String DistName;
    private String EStatus;
    private String Ench_Verified_By;
    private String EnchrochmentEndDate;
    private String EnchrochmentStartDate;
    private String InspectionID;
    private String IsInspected;
    private String Khaata_Kheshara_Number;
    private String Latitude;
    private String Longitude;
    private String NoticeDate;
    private String NoticeNo;
    private String PanchayatID;
    private String PanchayatName;
    private String RajswaThanaNumber;
    private String Status_Of_Encroachment;
    private String Type_Of_Encroachment;
    private String UploadType;
    private String VILLNAME;
    private String Verified_By;
    private String Verified_Date;
    private String VillageID;

    /* renamed from: id */
    private int f176id;
    private String isUpdated;

    public static Class<PondEncroachmentEntity> getPondEncroachmentEntity_CLASS() {
        return PondEncroachmentEntity_CLASS;
    }

    public static void setPondEncroachmentEntity_CLASS(Class<PondEncroachmentEntity> pondEncroachmentEntity_CLASS) {
        PondEncroachmentEntity_CLASS = pondEncroachmentEntity_CLASS;
    }

    public String getAppVersion() {
        return this.AppVersion;
    }

    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
    }

    public String getUploadType() {
        return this.UploadType;
    }

    public void setUploadType(String uploadType) {
        this.UploadType = uploadType;
    }

    public String getEnch_Verified_By() {
        return this.Ench_Verified_By;
    }

    public void setEnch_Verified_By(String ench_Verified_By) {
        this.Ench_Verified_By = ench_Verified_By;
    }

    public String getEStatus() {
        return this.EStatus;
    }

    public void setEStatus(String EStatus) {
        this.EStatus = EStatus;
    }

    public String getEnchrochmentStartDate() {
        return this.EnchrochmentStartDate;
    }

    public void setEnchrochmentStartDate(String enchrochmentStartDate) {
        this.EnchrochmentStartDate = enchrochmentStartDate;
    }

    public String getEnchrochmentEndDate() {
        return this.EnchrochmentEndDate;
    }

    public void setEnchrochmentEndDate(String enchrochmentEndDate) {
        this.EnchrochmentEndDate = enchrochmentEndDate;
    }

    public String getNoticeDate() {
        return this.NoticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.NoticeDate = noticeDate;
    }

    public String getNoticeNo() {
        return this.NoticeNo;
    }

    public void setNoticeNo(String noticeNo) {
        this.NoticeNo = noticeNo;
    }

    public int getId() {
        return this.f176id;
    }

    public void setId(int id) {
        this.f176id = id;
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

    public String getRajswaThanaNumber() {
        return this.RajswaThanaNumber;
    }

    public void setRajswaThanaNumber(String rajswaThanaNumber) {
        this.RajswaThanaNumber = rajswaThanaNumber;
    }

    public String getKhaata_Kheshara_Number() {
        return this.Khaata_Kheshara_Number;
    }

    public void setKhaata_Kheshara_Number(String khaata_Kheshara_Number) {
        this.Khaata_Kheshara_Number = khaata_Kheshara_Number;
    }

    public String getVillageID() {
        return this.VillageID;
    }

    public void setVillageID(String villageID) {
        this.VillageID = villageID;
    }

    public String getVILLNAME() {
        return this.VILLNAME;
    }

    public void setVILLNAME(String VILLNAME) {
        this.VILLNAME = VILLNAME;
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

    public String getStatus_Of_Encroachment() {
        return this.Status_Of_Encroachment;
    }

    public void setStatus_Of_Encroachment(String status_Of_Encroachment) {
        this.Status_Of_Encroachment = status_Of_Encroachment;
    }

    public String getType_Of_Encroachment() {
        return this.Type_Of_Encroachment;
    }

    public void setType_Of_Encroachment(String type_Of_Encroachment) {
        this.Type_Of_Encroachment = type_Of_Encroachment;
    }

    public String getVerified_By() {
        return this.Verified_By;
    }

    public void setVerified_By(String verified_By) {
        this.Verified_By = verified_By;
    }

    public String getIsInspected() {
        return this.IsInspected;
    }

    public void setIsInspected(String isInspected) {
        this.IsInspected = isInspected;
    }

    public String getVerified_Date() {
        return this.Verified_Date;
    }

    public void setVerified_Date(String verified_Date) {
        this.Verified_Date = verified_Date;
    }

    public String getIsUpdated() {
        return this.isUpdated;
    }

    public void setIsUpdated(String isUpdated) {
        this.isUpdated = isUpdated;
    }
}