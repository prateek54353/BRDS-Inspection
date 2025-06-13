package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class PanchayatRequest {

    @SerializedName("BlockCode")
    @Expose
    private String BlockCode;

    @SerializedName("DistCode")
    @Expose
    private String DistCode;

    public PanchayatRequest(String distCode, String blockCode) {
        this.DistCode = distCode;
        this.BlockCode = blockCode;
    }

    public String getDistCode() {
        return this.DistCode;
    }

    public void setDistCode(String distCode) {
        this.DistCode = distCode;
    }

    public String getBlockCode() {
        return this.BlockCode;
    }

    public void setBlockCode(String blockCode) {
        this.BlockCode = blockCode;
    }
}