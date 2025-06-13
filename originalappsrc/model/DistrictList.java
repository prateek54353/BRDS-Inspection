package bih.p003in.forestdept.model;

import android.content.Context;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class DistrictList {

    @SerializedName("_DistNameEn")
    @Expose
    private String DistNameEn;

    @SerializedName("_DistNameHn")
    @Expose
    private String DistNameHn;

    @SerializedName("_Distcode")
    @Expose
    private String _Distcode;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;

    @SerializedName("DistCode")
    @Expose
    private String distCode;

    public DistrictList() {
    }

    public DistrictList(String distNameEn, String distcode, String distNameHn, String distCode) {
        this.DistNameEn = distNameEn;
        this._Distcode = distcode;
        this.DistNameHn = distNameHn;
        this.distCode = distCode;
    }

    public DistrictList(DistrictList list, Context context) {
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        String temp32Enc_key = CommonPref.getUserDetails(context).get_encriptionKey();
        this.DistNameEn = this.aes256CbcEncryptDecrypt.Decrypt(list.getDistNameEn(), temp32Enc_key);
        this._Distcode = this.aes256CbcEncryptDecrypt.Decrypt(list.get_Distcode(), temp32Enc_key);
        this.DistNameHn = this.aes256CbcEncryptDecrypt.Decrypt(list.getDistNameHn(), temp32Enc_key);
        this.distCode = this.aes256CbcEncryptDecrypt.Decrypt(list.getDistCode(), temp32Enc_key);
    }

    public String getDistNameEn() {
        return this.DistNameEn;
    }

    public void setDistNameEn(String distNameEn) {
        this.DistNameEn = distNameEn;
    }

    public String get_Distcode() {
        return this._Distcode;
    }

    public void set_Distcode(String _Distcode) {
        this._Distcode = _Distcode;
    }

    public String getDistNameHn() {
        return this.DistNameHn;
    }

    public void setDistNameHn(String distNameHn) {
        this.DistNameHn = distNameHn;
    }

    public String getDistCode() {
        return this.distCode;
    }

    public void setDistCode(String distCode) {
        this.distCode = distCode;
    }
}