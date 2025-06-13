package bih.p003in.forestdept.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class PublicKeyResponse {

    @SerializedName("KeyDetails")
    @Expose
    private ArrayList<KeyDetail> keyDetails;

    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("Status")
    @Expose
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<KeyDetail> getKeyDetails() {
        return this.keyDetails;
    }

    public void setKeyDetails(ArrayList<KeyDetail> keyDetails) {
        this.keyDetails = keyDetails;
    }
}