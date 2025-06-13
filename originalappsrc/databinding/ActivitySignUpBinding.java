package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ActivitySignUpBinding implements ViewBinding {
    public final TextView address;
    public final Button btnSignUp;
    public final EditText etAdress;
    public final EditText etConformPassword;
    public final EditText etDesignation;
    public final EditText etFarmerName;
    public final EditText etFatherHusband;
    public final EditText etMobileNumber;
    public final EditText etPoliceStationMobileNumber;
    public final LinearLayout llOutpost;
    public final LinearLayout llPoliceStation;
    public final TextView mobilenumber;
    public final TextView outPostLandline;
    public final TextView outpostName;
    public final TextView password;
    public final Button regCancel;
    public final ScrollView regForm;
    public final RelativeLayout rlFarmer;
    private final RelativeLayout rootView;
    public final Spinner spUserType;
    public final Spinner spnBlock;
    public final Spinner spnDist;
    public final TextView tvOutpostcode;
    public final TextView tvPolicestationcode;

    private ActivitySignUpBinding(RelativeLayout rootView, TextView address, Button btnSignUp, EditText etAdress, EditText etConformPassword, EditText etDesignation, EditText etFarmerName, EditText etFatherHusband, EditText etMobileNumber, EditText etPoliceStationMobileNumber, LinearLayout llOutpost, LinearLayout llPoliceStation, TextView mobilenumber, TextView outPostLandline, TextView outpostName, TextView password, Button regCancel, ScrollView regForm, RelativeLayout rlFarmer, Spinner spUserType, Spinner spnBlock, Spinner spnDist, TextView tvOutpostcode, TextView tvPolicestationcode) {
        this.rootView = rootView;
        this.address = address;
        this.btnSignUp = btnSignUp;
        this.etAdress = etAdress;
        this.etConformPassword = etConformPassword;
        this.etDesignation = etDesignation;
        this.etFarmerName = etFarmerName;
        this.etFatherHusband = etFatherHusband;
        this.etMobileNumber = etMobileNumber;
        this.etPoliceStationMobileNumber = etPoliceStationMobileNumber;
        this.llOutpost = llOutpost;
        this.llPoliceStation = llPoliceStation;
        this.mobilenumber = mobilenumber;
        this.outPostLandline = outPostLandline;
        this.outpostName = outpostName;
        this.password = password;
        this.regCancel = regCancel;
        this.regForm = regForm;
        this.rlFarmer = rlFarmer;
        this.spUserType = spUserType;
        this.spnBlock = spnBlock;
        this.spnDist = spnDist;
        this.tvOutpostcode = tvOutpostcode;
        this.tvPolicestationcode = tvPolicestationcode;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySignUpBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySignUpBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_sign_up, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivitySignUpBinding bind(View rootView) {
        int id = C0594R.id.address;
        TextView address = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.address);
        if (address != null) {
            id = C0594R.id.btn_signUp;
            Button btnSignUp = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_signUp);
            if (btnSignUp != null) {
                id = C0594R.id.et_adress;
                EditText etAdress = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_adress);
                if (etAdress != null) {
                    id = C0594R.id.et_conform_password;
                    EditText etConformPassword = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_conform_password);
                    if (etConformPassword != null) {
                        id = C0594R.id.et_designation;
                        EditText etDesignation = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_designation);
                        if (etDesignation != null) {
                            id = C0594R.id.et_farmer_name;
                            EditText etFarmerName = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_farmer_name);
                            if (etFarmerName != null) {
                                id = C0594R.id.et_father_husband;
                                EditText etFatherHusband = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_father_husband);
                                if (etFatherHusband != null) {
                                    id = C0594R.id.et_mobile_number;
                                    EditText etMobileNumber = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_mobile_number);
                                    if (etMobileNumber != null) {
                                        id = C0594R.id.et_police_station_mobile_number;
                                        EditText etPoliceStationMobileNumber = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_police_station_mobile_number);
                                        if (etPoliceStationMobileNumber != null) {
                                            id = C0594R.id.ll_outpost;
                                            LinearLayout llOutpost = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_outpost);
                                            if (llOutpost != null) {
                                                id = C0594R.id.ll_police_station;
                                                LinearLayout llPoliceStation = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_police_station);
                                                if (llPoliceStation != null) {
                                                    id = C0594R.id.mobilenumber;
                                                    TextView mobilenumber = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.mobilenumber);
                                                    if (mobilenumber != null) {
                                                        id = C0594R.id.out_post_landline;
                                                        TextView outPostLandline = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.out_post_landline);
                                                        if (outPostLandline != null) {
                                                            id = C0594R.id.outpost_name;
                                                            TextView outpostName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.outpost_name);
                                                            if (outpostName != null) {
                                                                id = C0594R.id.password;
                                                                TextView password = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.password);
                                                                if (password != null) {
                                                                    id = C0594R.id.reg_cancel;
                                                                    Button regCancel = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.reg_cancel);
                                                                    if (regCancel != null) {
                                                                        id = C0594R.id.reg_form;
                                                                        ScrollView regForm = (ScrollView) ViewBindings.findChildViewById(rootView, C0594R.id.reg_form);
                                                                        if (regForm != null) {
                                                                            id = C0594R.id.rl_farmer;
                                                                            RelativeLayout rlFarmer = (RelativeLayout) ViewBindings.findChildViewById(rootView, C0594R.id.rl_farmer);
                                                                            if (rlFarmer != null) {
                                                                                id = C0594R.id.sp_user_type;
                                                                                Spinner spUserType = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.sp_user_type);
                                                                                if (spUserType != null) {
                                                                                    id = C0594R.id.spn_block;
                                                                                    Spinner spnBlock = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spn_block);
                                                                                    if (spnBlock != null) {
                                                                                        id = C0594R.id.spn_dist;
                                                                                        Spinner spnDist = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spn_dist);
                                                                                        if (spnDist != null) {
                                                                                            id = C0594R.id.tv_outpostcode;
                                                                                            TextView tvOutpostcode = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_outpostcode);
                                                                                            if (tvOutpostcode != null) {
                                                                                                id = C0594R.id.tv_policestationcode;
                                                                                                TextView tvPolicestationcode = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_policestationcode);
                                                                                                if (tvPolicestationcode != null) {
                                                                                                    return new ActivitySignUpBinding((RelativeLayout) rootView, address, btnSignUp, etAdress, etConformPassword, etDesignation, etFarmerName, etFatherHusband, etMobileNumber, etPoliceStationMobileNumber, llOutpost, llPoliceStation, mobilenumber, outPostLandline, outpostName, password, regCancel, regForm, rlFarmer, spUserType, spnBlock, spnDist, tvOutpostcode, tvPolicestationcode);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}