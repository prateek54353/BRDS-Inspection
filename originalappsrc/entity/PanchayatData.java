package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class PanchayatData {
    public static Class<PanchayatData> PanchayatData_CLASS = PanchayatData.class;
    String Pcode = "";
    String Pname = "";
    String Dcode = "";
    String Bcode = "";
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

    public void setPcode(String _pcode) {
        this.Pcode = _pcode;
    }

    public String getPname() {
        return this.Pname;
    }

    public void setPname(String _pname) {
        this.Pname = _pname;
    }

    public String getDcode() {
        return this.Dcode;
    }

    public void setDcode(String dcode) {
        this.Dcode = dcode;
    }

    public String getBcode() {
        return this.Bcode;
    }

    public void setBcode(String bcode) {
        this.Bcode = bcode;
    }
}