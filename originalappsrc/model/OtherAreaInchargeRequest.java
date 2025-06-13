package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class OtherAreaInchargeRequest {

    @SerializedName("UserId")
    @Expose
    private String UserId;

    public OtherAreaInchargeRequest(String userId) {
        this.UserId = userId;
    }

    public String getUserId() {
        return this.UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }
}