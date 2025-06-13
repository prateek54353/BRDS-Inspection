package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class SevikaSahaikaEntity implements Serializable {
    private String aanganvariCode;
    private String districtCode;

    /* renamed from: id */
    private String f194id;
    private String projectCode;
    private String sahaikaPhoto;
    private String sectorCode;
    private String sevikaPhoto;
    private String userId;

    public String getId() {
        return this.f194id;
    }

    public void setId(String id) {
        this.f194id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDistrictCode() {
        return this.districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getSectorCode() {
        return this.sectorCode;
    }

    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }

    public String getAanganvariCode() {
        return this.aanganvariCode;
    }

    public void setAanganvariCode(String aanganvariCode) {
        this.aanganvariCode = aanganvariCode;
    }

    public String getSevikaPhoto() {
        return this.sevikaPhoto;
    }

    public void setSevikaPhoto(String sevikaPhoto) {
        this.sevikaPhoto = sevikaPhoto;
    }

    public String getSahaikaPhoto() {
        return this.sahaikaPhoto;
    }

    public void setSahaikaPhoto(String sahaikaPhoto) {
        this.sahaikaPhoto = sahaikaPhoto;
    }
}