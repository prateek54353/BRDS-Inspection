package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class VillageListEntity implements Serializable {
    public static Class<VillageListEntity> VillageList_CLASS = VillageListEntity.class;
    private String BlockCode;
    private String PanchayatCode;
    private String VillCode;

    /* renamed from: id */
    private int f195id;
    private String villName;

    public String getBlockCode() {
        return this.BlockCode;
    }

    public void setBlockCode(String blockCode) {
        this.BlockCode = blockCode;
    }

    public int getId() {
        return this.f195id;
    }

    public void setId(int id) {
        this.f195id = id;
    }

    public String getPanchayatCode() {
        return this.PanchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.PanchayatCode = panchayatCode;
    }

    public String getVillCode() {
        return this.VillCode;
    }

    public void setVillCode(String villCode) {
        this.VillCode = villCode;
    }

    public String getVillName() {
        return this.villName;
    }

    public void setVillName(String villName) {
        this.villName = villName;
    }
}