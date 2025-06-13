package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class OtherAreaInchargeEntity implements Serializable {
    public static Class<OtherAreaInchargeEntity> OtherAreaInchargeEntity_CLASS = OtherAreaInchargeEntity.class;
    private String BlockCode;
    private String BlockName;
    private String DistrictCode;
    private String DistrictName;
    private String PanchayatCode;
    private String PanchayatName;
    private String UserId;
    private String UserRole;

    public OtherAreaInchargeEntity() {
    }

    public OtherAreaInchargeEntity(String userId, String userRole, String districtCode, String districtName, String blockCode, String blockName, String panchayatCode, String panchayatName) {
        this.UserId = userId;
        this.UserRole = userRole;
        this.DistrictCode = districtCode;
        this.DistrictName = districtName;
        this.BlockCode = blockCode;
        this.BlockName = blockName;
        this.PanchayatCode = panchayatCode;
        this.PanchayatName = panchayatName;
    }

    public String getUserId() {
        return this.UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public String getUserRole() {
        return this.UserRole;
    }

    public void setUserRole(String userRole) {
        this.UserRole = userRole;
    }

    public String getDistrictCode() {
        return this.DistrictCode;
    }

    public void setDistrictCode(String districtCode) {
        this.DistrictCode = districtCode;
    }

    public String getDistrictName() {
        return this.DistrictName;
    }

    public void setDistrictName(String districtName) {
        this.DistrictName = districtName;
    }

    public String getBlockCode() {
        return this.BlockCode;
    }

    public void setBlockCode(String blockCode) {
        this.BlockCode = blockCode;
    }

    public String getBlockName() {
        return this.BlockName;
    }

    public void setBlockName(String blockName) {
        this.BlockName = blockName;
    }

    public String getPanchayatCode() {
        return this.PanchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.PanchayatCode = panchayatCode;
    }

    public String getPanchayatName() {
        return this.PanchayatName;
    }

    public void setPanchayatName(String panchayatName) {
        this.PanchayatName = panchayatName;
    }
}