package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class SanrachnaTypeEntity implements Serializable {
    public static Class<SanrachnaTypeEntity> SanrachnaType_CLASS = SanrachnaTypeEntity.class;
    private String sancrachnaId;
    private String sancrachnaName;
    private String sub_Execution_DeptID;

    public String getSub_Execution_DeptID() {
        return this.sub_Execution_DeptID;
    }

    public void setSub_Execution_DeptID(String sub_Execution_DeptID) {
        this.sub_Execution_DeptID = sub_Execution_DeptID;
    }

    public static Class<SanrachnaTypeEntity> getSanrachnaType_CLASS() {
        return SanrachnaType_CLASS;
    }

    public static void setSanrachnaType_CLASS(Class<SanrachnaTypeEntity> sanrachnaType_CLASS) {
        SanrachnaType_CLASS = sanrachnaType_CLASS;
    }

    public String getSancrachnaId() {
        return this.sancrachnaId;
    }

    public void setSancrachnaId(String sancrachnaId) {
        this.sancrachnaId = sancrachnaId;
    }

    public String getSancrachnaName() {
        return this.sancrachnaName;
    }

    public void setSancrachnaName(String sancrachnaName) {
        this.sancrachnaName = sancrachnaName;
    }
}