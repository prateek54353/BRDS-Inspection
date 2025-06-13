package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class District implements Serializable {
    public static Class<District> DISTRICT_CLASS = District.class;
    private static final long serialVersionUID = 1;
    private String _DistCode = "";
    private String _DistName = "";
    private String _StateCode = "";

    public String get_DistCode() {
        return this._DistCode;
    }

    public void set_DistCode(String _DistCode) {
        this._DistCode = _DistCode;
    }

    public String get_DistName() {
        return this._DistName;
    }

    public void set_DistName(String _DistName) {
        this._DistName = _DistName;
    }

    public String get_StateCode() {
        return this._StateCode;
    }

    public void set_StateCode(String _StateCode) {
        this._StateCode = _StateCode;
    }
}