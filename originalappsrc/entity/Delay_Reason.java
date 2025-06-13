package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class Delay_Reason {
    public static Class<Delay_Reason> Delay_Reason_CLASS = Delay_Reason.class;
    private String Dept_ID;
    private String Inspection_id;
    private String Reason;
    private String Reason_Id;

    public String getReason_Id() {
        return this.Reason_Id;
    }

    public void setReason_Id(String reason_Id) {
        this.Reason_Id = reason_Id;
    }

    public String getReason() {
        return this.Reason;
    }

    public void setReason(String reason) {
        this.Reason = reason;
    }

    public String getDept_ID() {
        return this.Dept_ID;
    }

    public void setDept_ID(String dept_ID) {
        this.Dept_ID = dept_ID;
    }

    public String getInspection_id() {
        return this.Inspection_id;
    }

    public void setInspection_id(String inspection_id) {
        this.Inspection_id = inspection_id;
    }
}