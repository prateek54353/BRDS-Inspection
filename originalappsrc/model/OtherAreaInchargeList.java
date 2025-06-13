package bih.p003in.forestdept.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class OtherAreaInchargeList implements Parcelable {
    public static final Parcelable.Creator<OtherAreaInchargeList> CREATOR = new Parcelable.Creator<OtherAreaInchargeList>() { // from class: bih.in.forestdept.model.OtherAreaInchargeList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OtherAreaInchargeList createFromParcel(Parcel in) {
            return new OtherAreaInchargeList(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OtherAreaInchargeList[] newArray(int size) {
            return new OtherAreaInchargeList[size];
        }
    };

    @SerializedName("_BlockCode")
    @Expose
    private String _BlockCode;

    @SerializedName("_BlockName")
    @Expose
    private String _BlockName;

    @SerializedName("_DistrictCode")
    @Expose
    private String _DistrictCode;

    @SerializedName("_DistrictName")
    @Expose
    private String _DistrictName;

    @SerializedName("_PanchayatCode")
    @Expose
    private String _PanchayatCode;

    @SerializedName("_PanchayatName")
    @Expose
    private String _PanchayatName;

    @SerializedName("_UserId")
    @Expose
    private String _UserId;

    @SerializedName("_UserRole")
    @Expose
    private String _UserRole;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;

    public OtherAreaInchargeList() {
    }

    public OtherAreaInchargeList(String _UserId, String _UserRole, String _DistrictCode, String _DistrictName, String _BlockCode, String _BlockName, String _PanchayatCode, String _PanchayatName) {
        this._UserId = _UserId;
        this._UserRole = _UserRole;
        this._DistrictCode = _DistrictCode;
        this._DistrictName = _DistrictName;
        this._BlockCode = _BlockCode;
        this._BlockName = _BlockName;
        this._PanchayatCode = _PanchayatCode;
        this._PanchayatName = _PanchayatName;
    }

    public OtherAreaInchargeList(OtherAreaInchargeList list, Context context) {
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        String temp32Enc_key = CommonPref.getUserDetails(context).get_encriptionKey();
        this._UserId = this.aes256CbcEncryptDecrypt.Decrypt(list.get_UserId(), temp32Enc_key);
        this._UserRole = this.aes256CbcEncryptDecrypt.Decrypt(list.get_UserRole(), temp32Enc_key);
        this._DistrictCode = this.aes256CbcEncryptDecrypt.Decrypt(list.get_DistrictCode(), temp32Enc_key);
        this._DistrictName = this.aes256CbcEncryptDecrypt.Decrypt(list.get_DistrictName(), temp32Enc_key);
        this._BlockCode = this.aes256CbcEncryptDecrypt.Decrypt(list.get_BlockCode(), temp32Enc_key);
        this._BlockName = this.aes256CbcEncryptDecrypt.Decrypt(list.get_BlockName(), temp32Enc_key);
        this._PanchayatCode = this.aes256CbcEncryptDecrypt.Decrypt(list.get_PanchayatCode(), temp32Enc_key);
        this._PanchayatName = this.aes256CbcEncryptDecrypt.Decrypt(list.get_PanchayatName(), temp32Enc_key);
    }

    protected OtherAreaInchargeList(Parcel in) {
        this._UserId = in.readString();
        this._UserRole = in.readString();
        this._DistrictCode = in.readString();
        this._DistrictName = in.readString();
        this._BlockCode = in.readString();
        this._BlockName = in.readString();
        this._PanchayatCode = in.readString();
        this._PanchayatName = in.readString();
    }

    public String get_UserId() {
        return this._UserId;
    }

    public void set_UserId(String _UserId) {
        this._UserId = _UserId;
    }

    public String get_UserRole() {
        return this._UserRole;
    }

    public void set_UserRole(String _UserRole) {
        this._UserRole = _UserRole;
    }

    public String get_DistrictCode() {
        return this._DistrictCode;
    }

    public void set_DistrictCode(String _DistrictCode) {
        this._DistrictCode = _DistrictCode;
    }

    public String get_DistrictName() {
        return this._DistrictName;
    }

    public void set_DistrictName(String _DistrictName) {
        this._DistrictName = _DistrictName;
    }

    public String get_BlockCode() {
        return this._BlockCode;
    }

    public void set_BlockCode(String _BlockCode) {
        this._BlockCode = _BlockCode;
    }

    public String get_BlockName() {
        return this._BlockName;
    }

    public void set_BlockName(String _BlockName) {
        this._BlockName = _BlockName;
    }

    public String get_PanchayatCode() {
        return this._PanchayatCode;
    }

    public void set_PanchayatCode(String _PanchayatCode) {
        this._PanchayatCode = _PanchayatCode;
    }

    public String get_PanchayatName() {
        return this._PanchayatName;
    }

    public void set_PanchayatName(String _PanchayatName) {
        this._PanchayatName = _PanchayatName;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._UserId);
        parcel.writeString(this._UserRole);
        parcel.writeString(this._DistrictCode);
        parcel.writeString(this._DistrictName);
        parcel.writeString(this._BlockCode);
        parcel.writeString(this._BlockName);
        parcel.writeString(this._PanchayatCode);
        parcel.writeString(this._PanchayatName);
    }
}