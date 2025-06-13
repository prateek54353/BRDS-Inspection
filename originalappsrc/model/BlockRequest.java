package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class BlockRequest {

    @SerializedName("DistCode")
    @Expose
    private String DistCode;

    public BlockRequest() {
    }

    public BlockRequest(String distCode) {
        this.DistCode = distCode;
    }

    public String getDistCode() {
        return this.DistCode;
    }

    public void setDistCode(String distCode) {
        this.DistCode = distCode;
    }
}