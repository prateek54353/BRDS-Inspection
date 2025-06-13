package bih.p003in.forestdept.model;

import bih.p003in.forestdept.database.feedEntry;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class LatLongRequest {

    @SerializedName("BlockCode")
    @Expose
    private String BlockCode;

    @SerializedName("DistCode")
    @Expose
    private String DistCode;

    @SerializedName(feedEntry.Latitude)
    @Expose
    private String Latitude;

    @SerializedName(feedEntry.Longitude)
    @Expose
    private String Longitude;

    @SerializedName("PanchayatCode")
    @Expose
    private String PanchayatCode;

    public LatLongRequest(String distCode, String blockCode, String panchayatCode, String latitude, String longitude) {
        this.DistCode = distCode;
        this.BlockCode = blockCode;
        this.PanchayatCode = panchayatCode;
        this.Latitude = latitude;
        this.Longitude = longitude;
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

    public String getPanchayatCode() {
        return this.PanchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.PanchayatCode = panchayatCode;
    }

    public String getLatitude() {
        return this.Latitude;
    }

    public void setLatitude(String latitude) {
        this.Latitude = latitude;
    }

    public String getLongitude() {
        return this.Longitude;
    }

    public void setLongitude(String longitude) {
        this.Longitude = longitude;
    }
}