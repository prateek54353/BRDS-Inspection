package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class SessionLogoutResponse {

    @SerializedName("Message")
    @Expose
    private String msg;

    @SerializedName("Status")
    @Expose
    private Boolean status;

    public SessionLogoutResponse() {
    }

    public SessionLogoutResponse(Boolean status, String msg) {
        this.status = status;
        this.msg = msg;
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
}