package bih.p003in.forestdept.model;

import android.content.Context;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class LatLongList {

    @SerializedName("BlockCode")
    @Expose
    private String BlockCode;

    @SerializedName("DistCode")
    @Expose
    private String DistCode;

    @SerializedName("PanchayatCode")
    @Expose
    private String PanchayatCode;

    @SerializedName("PointLocation")
    @Expose
    private String PointLocation;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;

    public LatLongList() {
    }

    public LatLongList(Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt, String distcode, String blockcode, String panchayatcode, String pointlocation) {
        this.aes256CbcEncryptDecrypt = aes256CbcEncryptDecrypt;
        this.DistCode = distcode;
        this.BlockCode = blockcode;
        this.PanchayatCode = panchayatcode;
        this.PointLocation = pointlocation;
    }

    public LatLongList(LatLongList obj, Context context) {
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        String temp32Enc_key = CommonPref.getUserDetails(context).get_encriptionKey();
        this.DistCode = this.aes256CbcEncryptDecrypt.Decrypt(obj.getDistCode(), temp32Enc_key);
        this.BlockCode = this.aes256CbcEncryptDecrypt.Decrypt(obj.getBlockCode(), temp32Enc_key);
        this.PanchayatCode = this.aes256CbcEncryptDecrypt.Decrypt(obj.getPanchayatCode(), temp32Enc_key);
        this.PointLocation = this.aes256CbcEncryptDecrypt.Decrypt(obj.getPointLocation(), temp32Enc_key);
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

    public String getPointLocation() {
        return this.PointLocation;
    }

    public void setPointLocation(String pointLocation) {
        this.PointLocation = pointLocation;
    }
}