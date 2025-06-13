package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class PondLakeDepartmentEntity implements Serializable {
    public static Class<PondLakeDepartmentEntity> PondLakeDeprt_CLASS = PondLakeDepartmentEntity.class;
    private static final long serialVersionUID = 1;
    private String _DepatmentHNd;
    private String _DepatmentName;

    /* renamed from: id */
    private int f180id;

    public static long getSerialVersionUID() {
        return 1L;
    }

    public static Class<PondLakeDepartmentEntity> getPondLakeDeprt_CLASS() {
        return PondLakeDeprt_CLASS;
    }

    public static void setPondLakeDeprt_CLASS(Class<PondLakeDepartmentEntity> pondLakeDeprt_CLASS) {
        PondLakeDeprt_CLASS = pondLakeDeprt_CLASS;
    }

    public int getId() {
        return this.f180id;
    }

    public void setId(int id) {
        this.f180id = id;
    }

    public String get_DepatmentName() {
        return this._DepatmentName;
    }

    public void set_DepatmentName(String _DepatmentName) {
        this._DepatmentName = _DepatmentName;
    }

    public String get_DepatmentHNd() {
        return this._DepatmentHNd;
    }

    public void set_DepatmentHNd(String _DepatmentHNd) {
        this._DepatmentHNd = _DepatmentHNd;
    }
}