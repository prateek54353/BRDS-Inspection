package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class GeoFencing {

    @SerializedName("GeoFenLatitude")
    @Expose
    private String GeoFenLatitude;

    @SerializedName("GeoFenLongitude")
    @Expose
    private String GeoFenLongitude;

    @SerializedName("GeoSeqID")
    @Expose
    private String GeoSeqID;

    public String getGeoFenLatitude() {
        return this.GeoFenLatitude;
    }

    public void setGeoFenLatitude(String geoFenLatitude) {
        this.GeoFenLatitude = geoFenLatitude;
    }

    public String getGeoFenLongitude() {
        return this.GeoFenLongitude;
    }

    public void setGeoFenLongitude(String geoFenLongitude) {
        this.GeoFenLongitude = geoFenLongitude;
    }

    public String getGeoSeqID() {
        return this.GeoSeqID;
    }

    public void setGeoSeqID(String geoSeqID) {
        this.GeoSeqID = geoSeqID;
    }
}