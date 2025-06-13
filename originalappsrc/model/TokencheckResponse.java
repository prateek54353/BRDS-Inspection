package bih.p003in.forestdept.model;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class TokencheckResponse {

    @SerializedName("message")
    @Expose
    private String msg;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    @Expose
    private Boolean status;

    public TokencheckResponse() {
    }

    public TokencheckResponse(Boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}