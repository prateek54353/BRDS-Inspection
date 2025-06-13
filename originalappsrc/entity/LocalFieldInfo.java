package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class LocalFieldInfo {
    private String Field;
    private String Label;
    private String Sequence;
    private String Type;
    private String isActive;
    private String slNo;

    public LocalFieldInfo(String slNo, String Field, String Label, String isActive, String Type, String Sequence) {
        this.slNo = slNo;
        this.Field = Field;
        this.Label = Label;
        this.isActive = isActive;
        this.Type = Type;
        this.Sequence = Sequence;
    }

    public String getslNo() {
        return this.slNo;
    }

    public String getField() {
        return this.Field;
    }

    public String getLabel() {
        return this.Label;
    }

    public String getisActive() {
        return this.isActive;
    }

    public String getType() {
        return this.Type;
    }

    public String getSequence() {
        return this.Sequence;
    }
}