package bih.p003in.forestdept.model;

import android.content.Context;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class PanchayatList {

    @SerializedName("AreaType")
    @Expose
    private String AreaType;

    @SerializedName("Panchayat")
    @Expose
    private String Panchayat;

    @SerializedName("Panchayat_Code")
    @Expose
    private String Panchayat_Code;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;

    public PanchayatList() {
    }

    public PanchayatList(String panchayat, String panchayat_Code, String areaType) {
        this.Panchayat = panchayat;
        this.Panchayat_Code = panchayat_Code;
        this.AreaType = areaType;
    }

    public PanchayatList(PanchayatList list, Context context) {
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        String temp32Enc_key = CommonPref.getUserDetails(context).get_encriptionKey();
        this.Panchayat = this.aes256CbcEncryptDecrypt.Decrypt(list.getPanchayat(), temp32Enc_key);
        this.Panchayat_Code = this.aes256CbcEncryptDecrypt.Decrypt(list.getPanchayat_Code(), temp32Enc_key);
        this.AreaType = this.aes256CbcEncryptDecrypt.Decrypt(list.getAreaType(), temp32Enc_key);
    }

    public String getPanchayat() {
        return this.Panchayat;
    }

    public void setPanchayat(String panchayat) {
        this.Panchayat = panchayat;
    }

    public String getPanchayat_Code() {
        return this.Panchayat_Code;
    }

    public void setPanchayat_Code(String panchayat_Code) {
        this.Panchayat_Code = panchayat_Code;
    }

    public String getAreaType() {
        return this.AreaType;
    }

    public void setAreaType(String areaType) {
        this.AreaType = areaType;
    }

    public String toString() {
        return this.Panchayat;
    }
}