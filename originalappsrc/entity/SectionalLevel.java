package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class SectionalLevel {
    public static Class<Efforts_Taken> EFFORTS_TAKEN_CLASS = Efforts_Taken.class;
    private String OrderID;
    private String SectionalLevelId;
    private String SectionalLevelName;

    public String getOrderID() {
        return this.OrderID;
    }

    public void setOrderID(String orderID) {
        this.OrderID = orderID;
    }

    public String getSectionalLevelId() {
        return this.SectionalLevelId;
    }

    public void setSectionalLevelId(String sectionalLevelId) {
        this.SectionalLevelId = sectionalLevelId;
    }

    public String getSectionalLevelName() {
        return this.SectionalLevelName;
    }

    public void setSectionalLevelName(String sectionalLevelName) {
        this.SectionalLevelName = sectionalLevelName;
    }
}