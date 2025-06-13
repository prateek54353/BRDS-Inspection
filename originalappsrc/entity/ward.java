package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class ward {
    public static Class<ward> ward_CLASS = ward.class;
    String wardCode = "";
    String wardname = "";
    String blockCode = "";
    String panchayatCode = "";
    String areaType = "";

    public String getAreaType() {
        return this.areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public static Class<ward> getWard_CLASS() {
        return ward_CLASS;
    }

    public static void setWard_CLASS(Class<ward> ward_CLASS2) {
        ward_CLASS = ward_CLASS2;
    }

    public String getWardCode() {
        return this.wardCode;
    }

    public void setWardCode(String _wardCode) {
        this.wardCode = _wardCode;
    }

    public String getWardname() {
        return this.wardname;
    }

    public void setWardname(String _wardname) {
        this.wardname = _wardname;
    }

    public String getBlockCode() {
        return this.blockCode;
    }

    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }

    public String getPanchayatCode() {
        return this.panchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.panchayatCode = panchayatCode;
    }
}