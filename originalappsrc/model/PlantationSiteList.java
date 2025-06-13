package bih.p003in.forestdept.model;

import android.content.Context;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class PlantationSiteList {

    /* renamed from: Id */
    @SerializedName("Id")
    @Expose
    private String f200Id;

    @SerializedName("PlantationNameEng")
    @Expose
    private String PlantationNameEng;

    @SerializedName("PlantationNameHindi")
    @Expose
    private String PlantationNameHindi;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;

    public PlantationSiteList() {
    }

    public PlantationSiteList(String id, String PlantationNameeng, String PlantationNamehin) {
        this.f200Id = id;
        this.PlantationNameEng = PlantationNameeng;
        this.PlantationNameHindi = PlantationNamehin;
    }

    public PlantationSiteList(PlantationSiteList list, Context context) {
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        String temp32Enc_key = CommonPref.getUserDetails(context).get_encriptionKey();
        this.f200Id = this.aes256CbcEncryptDecrypt.Decrypt(list.getId(), temp32Enc_key);
        this.PlantationNameEng = this.aes256CbcEncryptDecrypt.Decrypt(list.getPlantationNameEng(), temp32Enc_key);
        this.PlantationNameHindi = this.aes256CbcEncryptDecrypt.Decrypt(list.getPlantationNameHindi(), temp32Enc_key);
    }

    public String getId() {
        return this.f200Id;
    }

    public void setId(String id) {
        this.f200Id = id;
    }

    public String getPlantationNameEng() {
        return this.PlantationNameEng;
    }

    public void setPlantationNameEng(String plantationNameEng) {
        this.PlantationNameEng = plantationNameEng;
    }

    public String getPlantationNameHindi() {
        return this.PlantationNameHindi;
    }

    public void setPlantationNameHindi(String plantationNameHindi) {
        this.PlantationNameHindi = plantationNameHindi;
    }

    public String toString() {
        return this.PlantationNameHindi;
    }
}