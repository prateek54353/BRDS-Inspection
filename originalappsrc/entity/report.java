package bih.p003in.forestdept.entity;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class report extends ArrayList<report> implements Serializable {
    private String EffortTaken;
    private String InspectinId;
    private String IsComplition;
    private String IsComplitionDate;
    private String NextInspDate;
    private String Reason;
    private String SanctionNo;
    private String SanctionedLevelID;
    private String SanctionedLevelName;
    private String UserName;
    private String beneficiary_id;
    private String beneficiery_f_name;
    private String beneficiery_name;

    public String getBeneficiary_id() {
        return this.beneficiary_id;
    }

    public void setBeneficiary_id(String beneficiary_id) {
        this.beneficiary_id = beneficiary_id;
    }

    public String getBeneficiery_name() {
        return this.beneficiery_name;
    }

    public void setBeneficiery_name(String beneficiery_name) {
        this.beneficiery_name = beneficiery_name;
    }

    public String getBeneficiery_f_name() {
        return this.beneficiery_f_name;
    }

    public void setBeneficiery_f_name(String beneficiery_f_name) {
        this.beneficiery_f_name = beneficiery_f_name;
    }

    public String getNextInspDate() {
        return this.NextInspDate;
    }

    public void setNextInspDate(String nextInspDate) {
        this.NextInspDate = nextInspDate;
    }

    public String getIsComplition() {
        return this.IsComplition;
    }

    public void setIsComplition(String isComplition) {
        this.IsComplition = isComplition;
    }

    public String getIsComplitionDate() {
        return this.IsComplitionDate;
    }

    public void setIsComplitionDate(String isComplitionDate) {
        this.IsComplitionDate = isComplitionDate;
    }

    public String getSanctionNo() {
        return this.SanctionNo;
    }

    public void setSanctionNo(String sanctionNo) {
        this.SanctionNo = sanctionNo;
    }

    public String getEffortTaken() {
        return this.EffortTaken;
    }

    public void setEffortTaken(String effortTaken) {
        this.EffortTaken = effortTaken;
    }

    public String getReason() {
        return this.Reason;
    }

    public void setReason(String reason) {
        this.Reason = reason;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getSanctionedLevelName() {
        return this.SanctionedLevelName;
    }

    public void setSanctionedLevelName(String sanctionedLevelName) {
        this.SanctionedLevelName = sanctionedLevelName;
    }

    public String getSanctionedLevelID() {
        return this.SanctionedLevelID;
    }

    public void setSanctionedLevelID(String sanctionedLevelID) {
        this.SanctionedLevelID = sanctionedLevelID;
    }

    public String getInspectinId() {
        return this.InspectinId;
    }

    public void setInspectinId(String inspectinId) {
        this.InspectinId = inspectinId;
    }
}