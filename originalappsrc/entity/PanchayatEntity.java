package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class PanchayatEntity implements Serializable {
    public static Class<PanchayatEntity> PanchayatEntity_CLASS = PanchayatEntity.class;
    String Pcode = "";
    String Pname = "";
    String AreaType = "";

    public String getAreaType() {
        return this.AreaType;
    }

    public void setAreaType(String areaType) {
        this.AreaType = areaType;
    }

    public String getPcode() {
        return this.Pcode;
    }

    public void setPcode(String pcode) {
        this.Pcode = pcode;
    }

    public String getPname() {
        return this.Pname;
    }

    public void setPname(String pname) {
        this.Pname = pname;
    }

    public static Class<PanchayatEntity> getPanchayatEntity_CLASS() {
        return PanchayatEntity_CLASS;
    }

    public static void setPanchayatEntity_CLASS(Class<PanchayatEntity> panchayatEntity_CLASS) {
        PanchayatEntity_CLASS = panchayatEntity_CLASS;
    }
}