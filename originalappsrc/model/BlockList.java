package bih.p003in.forestdept.model;

import android.content.Context;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class BlockList {

    @SerializedName("BlockCode")
    @Expose
    private String BlockCode;

    @SerializedName("BlockName")
    @Expose
    private String BlockName;

    @SerializedName("DistCode")
    @Expose
    private String DistCode;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;

    public BlockList() {
    }

    public BlockList(String distCode, String blockCode, String blockName) {
        this.DistCode = distCode;
        this.BlockCode = blockCode;
        this.BlockName = blockName;
    }

    public BlockList(BlockList list, Context context) {
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        String temp32Enc_key = CommonPref.getUserDetails(context).get_encriptionKey();
        this.DistCode = this.aes256CbcEncryptDecrypt.Decrypt(list.getDistCode(), temp32Enc_key);
        this.BlockCode = this.aes256CbcEncryptDecrypt.Decrypt(list.getBlockCode(), temp32Enc_key);
        this.BlockName = this.aes256CbcEncryptDecrypt.Decrypt(list.getBlockName(), temp32Enc_key);
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

    public String getBlockName() {
        return this.BlockName;
    }

    public void setBlockName(String blockName) {
        this.BlockName = blockName;
    }

    public String toString() {
        return this.BlockName;
    }
}