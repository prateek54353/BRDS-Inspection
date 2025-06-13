package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class PlantationReportResponse {

    @SerializedName("Data")
    @Expose
    private ArrayList<PlantationReportList> data;

    @SerializedName("Message")
    @Expose
    private String msg;

    @SerializedName("Status")
    @Expose
    private Boolean status;

    public PlantationReportResponse(Boolean status, String msg, ArrayList<PlantationReportList> data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<PlantationReportList> getData() {
        return this.data;
    }

    public void setData(ArrayList<PlantationReportList> data) {
        this.data = data;
    }
}