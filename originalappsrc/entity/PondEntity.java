package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class PondEntity implements Serializable {
    public static Class<PondEntity> PondInfo_CLASS = PondEntity.class;
    private static final long serialVersionUID = 1;
    private String BlockID;
    private String BlockName;
    private String DistID;
    private String DistName;
    String InspectionID;
    private String KhataKhesraNo;
    private String Latitude;
    private String Longitude;
    private String PanchayatID;
    private String PanchayatName;
    private String RajswaThanaNumber;
    private String VillageID;
    private String VillageName;

    /* renamed from: id */
    private int f177id;
    String slno;

    public static Class<PondEntity> getPondInfo_CLASS() {
        return PondInfo_CLASS;
    }

    public static void setPondInfo_CLASS(Class<PondEntity> pondInfo_CLASS) {
        PondInfo_CLASS = pondInfo_CLASS;
    }

    public int getId() {
        return this.f177id;
    }

    public void setId(int id) {
        this.f177id = id;
    }

    public String getKhataKhesraNo() {
        return this.KhataKhesraNo;
    }

    public void setKhataKhesraNo(String khataKhesraNo) {
        this.KhataKhesraNo = khataKhesraNo;
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

    public static long getSerialVersionUID() {
        return 1L;
    }

    public String getSlno() {
        return this.slno;
    }

    public void setSlno(String slno) {
        this.slno = slno;
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

    public String getBlockName() {
        return this.BlockName;
    }

    public String getDistName() {
        return this.DistName;
    }

    public void setDistName(String distName) {
        this.DistName = distName;
    }

    public void setBlockName(String blockName) {
        this.BlockName = blockName;
    }

    public String getVillageName() {
        return this.VillageName;
    }

    public void setVillageName(String villageName) {
        this.VillageName = villageName;
    }
}