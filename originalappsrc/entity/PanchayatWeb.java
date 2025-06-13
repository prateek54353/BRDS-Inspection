package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class PanchayatWeb {
    public static Class<PanchayatWeb> PanchayatWeb_CLASS = PanchayatWeb.class;
    private String AWC_Code;
    private String SectorCode;
    private String code;
    private String userid;
    private String value;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSectorCode() {
        return this.SectorCode;
    }

    public void setSectorCode(String sectorCode) {
        this.SectorCode = sectorCode;
    }

    public String getAWC_Code() {
        return this.AWC_Code;
    }

    public void setAWC_Code(String AWC_Code) {
        this.AWC_Code = AWC_Code;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}