package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class SchemeId {
    public static Class<SchemeId> EFFORTS_TAKEN_CLASS = SchemeId.class;
    private String SchemeId;
    private String SchemeName;
    private String SchemeYearId;
    private String SchemeYearName;

    public String getSchemeId() {
        return this.SchemeId;
    }

    public void setSchemeId(String schemeId) {
        this.SchemeId = schemeId;
    }

    public String getSchemeName() {
        return this.SchemeName;
    }

    public void setSchemeName(String schemeName) {
        this.SchemeName = schemeName;
    }

    public String getSchemeYearName() {
        return this.SchemeYearName;
    }

    public void setSchemeYearName(String schemeYearName) {
        this.SchemeYearName = schemeYearName;
    }

    public String getSchemeYearId() {
        return this.SchemeYearId;
    }

    public void setSchemeYearId(String schemeYearId) {
        this.SchemeYearId = schemeYearId;
    }
}