package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class F_YearModel {

    @SerializedName("_FYear")
    @Expose
    private String _FYear;

    @SerializedName("_FYearNameEng")
    @Expose
    private String _FYearNameEng;

    @SerializedName("FYear")
    @Expose
    private String fYear;

    @SerializedName("FYearNameEng")
    @Expose
    private String fYearNameEng;

    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("Status")
    @Expose
    private Boolean status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getfYear() {
        return this.fYear;
    }

    public void setfYear(String fYear) {
        this.fYear = fYear;
    }

    public String get_FYear() {
        return this._FYear;
    }

    public void set_FYear(String _FYear) {
        this._FYear = _FYear;
    }

    public String getfYearNameEng() {
        return this.fYearNameEng;
    }

    public void setfYearNameEng(String fYearNameEng) {
        this.fYearNameEng = fYearNameEng;
    }

    public String get_FYearNameEng() {
        return this._FYearNameEng;
    }

    public void set_FYearNameEng(String _FYearNameEng) {
        this._FYearNameEng = _FYearNameEng;
    }
}