package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class LocalSpinnerData {
    private String code;
    private String code2;
    private String field;
    private String value;

    public LocalSpinnerData() {
    }

    public LocalSpinnerData(String code, String value, String field, String code2) {
        this.code = code;
        this.value = value;
        this.field = field;
        this.code2 = code2;
    }

    public String getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }

    public String getField() {
        return this.field;
    }

    public String getCode2() {
        return this.code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setField(String field) {
        this.field = field;
    }
}