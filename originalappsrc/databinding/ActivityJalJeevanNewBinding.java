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
public final class ActivityJalJeevanNewBinding implements ViewBinding {
    public final RelativeLayout activityNewEntry;
    public final TextView block;
    public final TextView blockName;
    public final Button btnReg;
    public final TextView districtName;
    public final EditText etAreaByGovtRecord;
    public final EditText etOwnerName;
    public final EditText etRemark;
    public final FooterBinding footer;
    public final HeaderBinding header;
    public final LinearLayout llComercial;
    public final TextView rajaswaThana;
    public final ScrollView regForm;
    private final RelativeLayout rootView;
    public final LinearLayout sblist;
    public final Spinner spinDeptName;
    public final Spinner spinEncroachmentStatus;
    public final Spinner spinEncroachmentType;
    public final Spinner spinOwnerDept;
    public final Spinner spinPanchayat;
    public final Spinner spinPine;
    public final Spinner spinRqrmntOfMachine;
    public final Spinner spinRqrmntRenovation;
    public final Spinner spinWaterAvailibility;
    public final Spinner spnBlk;
    public final TextView tvEncrhStatus;
    public final TextView tvEncrhType;
    public final TextView tvMachine;
    public final TextView tvOwnerDeptName;
    public final TextView tvPanchayat;
    public final TextView tvPine;
    public final TextView tvPolicestationcode;
    public final TextView tvPondType;
    public final TextView tvRenovation;
    public final TextView tvWaterAvbl;

    private ActivityJalJeevanNewBinding(RelativeLayout rootView, RelativeLayout activityNewEntry, TextView block, TextView blockName, Button btnReg, TextView districtName, EditText etAreaByGovtRecord, EditText etOwnerName, EditText etRemark, FooterBinding footer, HeaderBinding header, LinearLayout llComercial, TextView rajaswaThana, ScrollView regForm, LinearLayout sblist, Spinner spinDeptName, Spinner spinEncroachmentStatus, Spinner spinEncroachmentType, Spinner spinOwnerDept, Spinner spinPanchayat, Spinner spinPine, Spinner spinRqrmntOfMachine, Spinner spinRqrmntRenovation, Spinner spinWaterAvailibility, Spinner spnBlk, TextView tvEncrhStatus, TextView tvEncrhType, TextView tvMachine, TextView tvOwnerDeptName, TextView tvPanchayat, TextView tvPine, TextView tvPolicestationcode, TextView tvPondType, TextView tvRenovation, TextView tvWaterAvbl) {
        this.rootView = rootView;
        this.activityNewEntry = activityNewEntry;
        this.block = block;
        this.blockName = blockName;
        this.btnReg = btnReg;
        this.districtName = districtName;
        this.etAreaByGovtRecord = etAreaByGovtRecord;
        this.etOwnerName = etOwnerName;
        this.etRemark = etRemark;
        this.footer = footer;
        this.header = header;
        this.llComercial = llComercial;
        this.rajaswaThana = rajaswaThana;
        this.regForm = regForm;
        this.sblist = sblist;
        this.spinDeptName = spinDeptName;
        this.spinEncroachmentStatus = spinEncroachmentStatus;
        this.spinEncroachmentType = spinEncroachmentType;
        this.spinOwnerDept = spinOwnerDept;
        this.spinPanchayat = spinPanchayat;
        this.spinPine = spinPine;
        this.spinRqrmntOfMachine = spinRqrmntOfMachine;
        this.spinRqrmntRenovation = spinRqrmntRenovation;
        this.spinWaterAvailibility = spinWaterAvailibility;
        this.spnBlk = spnBlk;
        this.tvEncrhStatus = tvEncrhStatus;
        this.tvEncrhType = tvEncrhType;
        this.tvMachine = tvMachine;
        this.tvOwnerDeptName = tvOwnerDeptName;
        this.tvPanchayat = tvPanchayat;
        this.tvPine = tvPine;
        this.tvPolicestationcode = tvPolicestationcode;
        this.tvPondType = tvPondType;
        this.tvRenovation = tvRenovation;
        this.tvWaterAvbl = tvWaterAvbl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityJalJeevanNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityJalJeevanNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_jal_jeevan_new, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityJalJeevanNewBinding bind(View rootView) {
        RelativeLayout activityNewEntry = (RelativeLayout) rootView;
        int id = C0594R.id.block;
        TextView block = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.block);
        if (block != null) {
            id = C0594R.id.block_name;
            TextView blockName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.block_name);
            if (blockName != null) {
                id = C0594R.id.btn_reg;
                Button btnReg = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_reg);
                if (btnReg != null) {
                    id = C0594R.id.district_name;
                    TextView districtName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.district_name);
                    if (districtName != null) {
                        id = C0594R.id.et_area_by_govt_record;
                        EditText etAreaByGovtRecord = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_area_by_govt_record);
                        if (etAreaByGovtRecord != null) {
                            id = C0594R.id.et_owner_name;
                            EditText etOwnerName = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_owner_name);
                            if (etOwnerName != null) {
                                id = C0594R.id.et_remark;
                                EditText etRemark = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_remark);
                                if (etRemark != null) {
                                    id = C0594R.id.footer;
                                    View footer = ViewBindings.findChildViewById(rootView, C0594R.id.footer);
                                    if (footer != null) {
                                        FooterBinding binding_footer = FooterBinding.bind(footer);
                                        id = C0594R.id.header;
                                        View header = ViewBindings.findChildViewById(rootView, C0594R.id.header);
                                        if (header != null) {
                                            HeaderBinding binding_header = HeaderBinding.bind(header);
                                            id = C0594R.id.ll_comercial;
                                            LinearLayout llComercial = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_comercial);
                                            if (llComercial != null) {
                                                id = C0594R.id.rajaswa_thana;
                                                TextView rajaswaThana = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.rajaswa_thana);
                                                if (rajaswaThana != null) {
                                                    id = C0594R.id.reg_form;
                                                    ScrollView regForm = (ScrollView) ViewBindings.findChildViewById(rootView, C0594R.id.reg_form);
                                                    if (regForm != null) {
                                                        id = C0594R.id.sblist;
                                                        LinearLayout sblist = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.sblist);
                                                        if (sblist != null) {
                                                            id = C0594R.id.spin_dept_name;
                                                            Spinner spinDeptName = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_dept_name);
                                                            if (spinDeptName != null) {
                                                                id = C0594R.id.spin_encroachment_status;
                                                                Spinner spinEncroachmentStatus = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_encroachment_status);
                                                                if (spinEncroachmentStatus != null) {
                                                                    id = C0594R.id.spin_encroachment_type;
                                                                    Spinner spinEncroachmentType = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_encroachment_type);
                                                                    if (spinEncroachmentType != null) {
                                                                        id = C0594R.id.spin_owner_dept;
                                                                        Spinner spinOwnerDept = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_owner_dept);
                                                                        if (spinOwnerDept != null) {
                                                                            id = C0594R.id.spin_panchayat;
                                                                            Spinner spinPanchayat = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_panchayat);
                                                                            if (spinPanchayat != null) {
                                                                                id = C0594R.id.spin_pine;
                                                                                Spinner spinPine = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_pine);
                                                                                if (spinPine != null) {
                                                                                    id = C0594R.id.spin_rqrmnt_of_machine;
                                                                                    Spinner spinRqrmntOfMachine = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_rqrmnt_of_machine);
                                                                                    if (spinRqrmntOfMachine != null) {
                                                                                        id = C0594R.id.spin_rqrmnt_renovation;
                                                                                        Spinner spinRqrmntRenovation = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_rqrmnt_renovation);
                                                                                        if (spinRqrmntRenovation != null) {
                                                                                            id = C0594R.id.spin_water_availibility;
                                                                                            Spinner spinWaterAvailibility = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_water_availibility);
                                                                                            if (spinWaterAvailibility != null) {
                                                                                                id = C0594R.id.spn_blk;
                                                                                                Spinner spnBlk = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spn_blk);
                                                                                                if (spnBlk != null) {
                                                                                                    id = C0594R.id.tv_encrh_status;
                                                                                                    TextView tvEncrhStatus = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_encrh_status);
                                                                                                    if (tvEncrhStatus != null) {
                                                                                                        id = C0594R.id.tv_encrh_type;
                                                                                                        TextView tvEncrhType = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_encrh_type);
                                                                                                        if (tvEncrhType != null) {
                                                                                                            id = C0594R.id.tv_machine;
                                                                                                            TextView tvMachine = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_machine);
                                                                                                            if (tvMachine != null) {
                                                                                                                id = C0594R.id.tv_owner_dept_name;
                                                                                                                TextView tvOwnerDeptName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_owner_dept_name);
                                                                                                                if (tvOwnerDeptName != null) {
                                                                                                                    id = C0594R.id.tv_panchayat;
                                                                                                                    TextView tvPanchayat = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_panchayat);
                                                                                                                    if (tvPanchayat != null) {
                                                                                                                        id = C0594R.id.tv_pine;
                                                                                                                        TextView tvPine = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_pine);
                                                                                                                        if (tvPine != null) {
                                                                                                                            id = C0594R.id.tv_policestationcode;
                                                                                                                            TextView tvPolicestationcode = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_policestationcode);
                                                                                                                            if (tvPolicestationcode != null) {
                                                                                                                                id = C0594R.id.tv_pond_type;
                                                                                                                                TextView tvPondType = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_pond_type);
                                                                                                                                if (tvPondType != null) {
                                                                                                                                    id = C0594R.id.tv_renovation;
                                                                                                                                    TextView tvRenovation = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_renovation);
                                                                                                                                    if (tvRenovation != null) {
                                                                                                                                        TextView tvWaterAvbl = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_water_avbl);
                                                                                                                                        if (tvWaterAvbl == null) {
                                                                                                                                            id = C0594R.id.tv_water_avbl;
                                                                                                                                        } else {
                                                                                                                                            return new ActivityJalJeevanNewBinding((RelativeLayout) rootView, activityNewEntry, block, blockName, btnReg, districtName, etAreaByGovtRecord, etOwnerName, etRemark, binding_footer, binding_header, llComercial, rajaswaThana, regForm, sblist, spinDeptName, spinEncroachmentStatus, spinEncroachmentType, spinOwnerDept, spinPanchayat, spinPine, spinRqrmntOfMachine, spinRqrmntRenovation, spinWaterAvailibility, spnBlk, tvEncrhStatus, tvEncrhType, tvMachine, tvOwnerDeptName, tvPanchayat, tvPine, tvPolicestationcode, tvPondType, tvRenovation, tvWaterAvbl);
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