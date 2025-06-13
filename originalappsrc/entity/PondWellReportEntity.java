package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class PondWellReportEntity implements Serializable {
    public static Class<PondWellReportEntity> PondWellReportCLASS = PondWellReportEntity.class;
    private String BlockCode;
    private String BlockName;
    private String DistCode;
    private String DistName;
    private String Latitude;
    private String Longitude;
    private String PanchayatCode;
    private String PanchayatName;
    private String RajswaThanaNumber;
    private String VILLCODE;
    private String VILLNAME;
    private String Verified_By;

    /* renamed from: id */
    private String f181id;

    public static Class<PondWellReportEntity> getPondWellReportCLASS() {
        return PondWellReportCLASS;
    }

    public static void setPondWellReportCLASS(Class<PondWellReportEntity> pondWellReportCLASS) {
        PondWellReportCLASS = pondWellReportCLASS;
    }

    public String getDistCode() {
        return this.DistCode;
    }

    public void setDistCode(String distCode) {
        this.DistCode = distCode;
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

    public String getPanchayatCode() {
        return this.PanchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.PanchayatCode = panchayatCode;
    }

    public String getPanchayatName() {
        return this.PanchayatName;
    }

    public void setPanchayatName(String panchayatName) {
        this.PanchayatName = panchayatName;
    }

    public String getVILLCODE() {
        return this.VILLCODE;
    }

    public void setVILLCODE(String VILLCODE) {
        this.VILLCODE = VILLCODE;
    }

    public String getVILLNAME() {
        return this.VILLNAME;
    }

    public void setVILLNAME(String VILLNAME) {
        this.VILLNAME = VILLNAME;
    }

    public String getRajswaThanaNumber() {
        return this.RajswaThanaNumber;
    }

    public void setRajswaThanaNumber(String rajswaThanaNumber) {
        this.RajswaThanaNumber = rajswaThanaNumber;
    }

    public String getId() {
        return this.f181id;
    }

    public void setId(String id) {
        this.f181id = id;
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

    public String getVerified_By() {
        return this.Verified_By;
    }

    public void setVerified_By(String verified_By) {
        this.Verified_By = verified_By;
    }
}