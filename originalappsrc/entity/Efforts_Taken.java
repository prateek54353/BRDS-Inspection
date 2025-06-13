package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class Efforts_Taken {
    public static Class<Efforts_Taken> EFFORTS_TAKEN_CLASS = Efforts_Taken.class;
    private String Dept_ID;
    private String EffortTaken;
    private String EffortTakenId;
    private String Inspection_id;

    public String getEffortTakenId() {
        return this.EffortTakenId;
    }

    public void setEffortTakenId(String effortTakenId) {
        this.EffortTakenId = effortTakenId;
    }

    public String getEffortTaken() {
        return this.EffortTaken;
    }

    public void setEffortTaken(String effortTaken) {
        this.EffortTaken = effortTaken;
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