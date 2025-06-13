package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class AppDetailsResponse {

    @SerializedName("Data")
    @Expose
    private ArrayList<AppVersion> data;

    @SerializedName("Message")
    @Expose
    private String msg;

    @SerializedName("Status")
    @Expose
    private Boolean status;

    public AppDetailsResponse(Boolean status, String msg, ArrayList<AppVersion> appdata) {
        this.status = status;
        this.msg = msg;
        this.data = appdata;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<AppVersion> getData() {
        return this.data;
    }

    public void setData(ArrayList<AppVersion> data) {
        this.data = data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}