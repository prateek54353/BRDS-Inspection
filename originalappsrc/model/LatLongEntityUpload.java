package bih.p003in.forestdept.model;

import bih.p003in.forestdept.database.feedEntry;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class LatLongEntityUpload {

    @SerializedName(feedEntry.Latitude)
    @Expose
    private String latitude;

    @SerializedName(feedEntry.Longitude)
    @Expose
    private String longitude;

    public LatLongEntityUpload() {
    }

    public LatLongEntityUpload(String Latitude, String Longitude) {
        this.latitude = Latitude;
        this.longitude = Longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}