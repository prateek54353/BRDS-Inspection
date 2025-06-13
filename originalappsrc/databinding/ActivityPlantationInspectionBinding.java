package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ActivityPlantationInspectionBinding implements ViewBinding {
    public final RelativeLayout activityNewEntry;
    public final Button btnReg;
    public final TextView errorTextView;
    public final EditText et5075Per;
    public final EditText et7590Per;
    public final EditText etAbove90Per;
    public final EditText etAverageHeightOfPlant;
    public final EditText etBelow25Per;
    public final EditText etGawyanPer;
    public final EditText etLivePantNo;
    public final EditText etLivePantPercent;
    public final EditText etPlantedNo;
    public final EditText etPlntAgnstDealplnt;
    public final EditText etRemark;
    public final FooterBinding footer;
    public final HeaderBinding header;
    public final LinearLayout llForestPoshakPantNo;
    public final LinearLayout llLandType;
    public final LinearLayout llLivePantNo;
    public final LinearLayout llLivePantPercent;
    public final LinearLayout llPlantSchemeNo;
    public final LinearLayout llPlantedNo;
    public final ProgressBar locationProgress;
    public final RecyclerView recyclerViewLocation;
    public final ScrollView regForm;
    private final RelativeLayout rootView;
    public final LinearLayout sblist;
    public final Spinner spinBhugtanPlantMonth;
    public final Spinner spinBhugtanPlantYear;
    public final EditText spinForestPoshakPantNo;
    public final Spinner spinPlantationSite;
    public final Spinner spinYear;
    public final Button takeLocation;
    public final TextView tvAgencyName;
    public final TextView tvForestPoshakBhugtanPantNo;
    public final TextView tvForestPoshakPantNo;
    public final TextView tvFyear;
    public final TextView tvPlantationSite;
    public final TextView tvWorkCode;
    public final TextView tvWorkName;
    public final TextView tvWorkType;
    public final TextView tvYear;

    private ActivityPlantationInspectionBinding(RelativeLayout rootView, RelativeLayout activityNewEntry, Button btnReg, TextView errorTextView, EditText et5075Per, EditText et7590Per, EditText etAbove90Per, EditText etAverageHeightOfPlant, EditText etBelow25Per, EditText etGawyanPer, EditText etLivePantNo, EditText etLivePantPercent, EditText etPlantedNo, EditText etPlntAgnstDealplnt, EditText etRemark, FooterBinding footer, HeaderBinding header, LinearLayout llForestPoshakPantNo, LinearLayout llLandType, LinearLayout llLivePantNo, LinearLayout llLivePantPercent, LinearLayout llPlantSchemeNo, LinearLayout llPlantedNo, ProgressBar locationProgress, RecyclerView recyclerViewLocation, ScrollView regForm, LinearLayout sblist, Spinner spinBhugtanPlantMonth, Spinner spinBhugtanPlantYear, EditText spinForestPoshakPantNo, Spinner spinPlantationSite, Spinner spinYear, Button takeLocation, TextView tvAgencyName, TextView tvForestPoshakBhugtanPantNo, TextView tvForestPoshakPantNo, TextView tvFyear, TextView tvPlantationSite, TextView tvWorkCode, TextView tvWorkName, TextView tvWorkType, TextView tvYear) {
        this.rootView = rootView;
        this.activityNewEntry = activityNewEntry;
        this.btnReg = btnReg;
        this.errorTextView = errorTextView;
        this.et5075Per = et5075Per;
        this.et7590Per = et7590Per;
        this.etAbove90Per = etAbove90Per;
        this.etAverageHeightOfPlant = etAverageHeightOfPlant;
        this.etBelow25Per = etBelow25Per;
        this.etGawyanPer = etGawyanPer;
        this.etLivePantNo = etLivePantNo;
        this.etLivePantPercent = etLivePantPercent;
        this.etPlantedNo = etPlantedNo;
        this.etPlntAgnstDealplnt = etPlntAgnstDealplnt;
        this.etRemark = etRemark;
        this.footer = footer;
        this.header = header;
        this.llForestPoshakPantNo = llForestPoshakPantNo;
        this.llLandType = llLandType;
        this.llLivePantNo = llLivePantNo;
        this.llLivePantPercent = llLivePantPercent;
        this.llPlantSchemeNo = llPlantSchemeNo;
        this.llPlantedNo = llPlantedNo;
        this.locationProgress = locationProgress;
        this.recyclerViewLocation = recyclerViewLocation;
        this.regForm = regForm;
        this.sblist = sblist;
        this.spinBhugtanPlantMonth = spinBhugtanPlantMonth;
        this.spinBhugtanPlantYear = spinBhugtanPlantYear;
        this.spinForestPoshakPantNo = spinForestPoshakPantNo;
        this.spinPlantationSite = spinPlantationSite;
        this.spinYear = spinYear;
        this.takeLocation = takeLocation;
        this.tvAgencyName = tvAgencyName;
        this.tvForestPoshakBhugtanPantNo = tvForestPoshakBhugtanPantNo;
        this.tvForestPoshakPantNo = tvForestPoshakPantNo;
        this.tvFyear = tvFyear;
        this.tvPlantationSite = tvPlantationSite;
        this.tvWorkCode = tvWorkCode;
        this.tvWorkName = tvWorkName;
        this.tvWorkType = tvWorkType;
        this.tvYear = tvYear;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPlantationInspectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPlantationInspectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_plantation_inspection, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityPlantationInspectionBinding bind(View rootView) {
        RelativeLayout activityNewEntry = (RelativeLayout) rootView;
        int id = C0594R.id.btn_reg;
        Button btnReg = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_reg);
        if (btnReg != null) {
            id = C0594R.id.errorTextView;
            TextView errorTextView = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.errorTextView);
            if (errorTextView != null) {
                id = C0594R.id.et_50_75_per;
                EditText et5075Per = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_50_75_per);
                if (et5075Per != null) {
                    id = C0594R.id.et_75_90_per;
                    EditText et7590Per = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_75_90_per);
                    if (et7590Per != null) {
                        id = C0594R.id.et_above_90_per;
                        EditText etAbove90Per = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_above_90_per);
                        if (etAbove90Per != null) {
                            id = C0594R.id.et_average_height_of_plant;
                            EditText etAverageHeightOfPlant = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_average_height_of_plant);
                            if (etAverageHeightOfPlant != null) {
                                id = C0594R.id.et_below_25_per;
                                EditText etBelow25Per = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_below_25_per);
                                if (etBelow25Per != null) {
                                    id = C0594R.id.et_gawyan_per;
                                    EditText etGawyanPer = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_gawyan_per);
                                    if (etGawyanPer != null) {
                                        id = C0594R.id.et_live_pant_no;
                                        EditText etLivePantNo = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_live_pant_no);
                                        if (etLivePantNo != null) {
                                            id = C0594R.id.et_live_pant_percent;
                                            EditText etLivePantPercent = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_live_pant_percent);
                                            if (etLivePantPercent != null) {
                                                id = C0594R.id.et_planted_no;
                                                EditText etPlantedNo = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_planted_no);
                                                if (etPlantedNo != null) {
                                                    id = C0594R.id.et_plnt_agnst_dealplnt;
                                                    EditText etPlntAgnstDealplnt = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_plnt_agnst_dealplnt);
                                                    if (etPlntAgnstDealplnt != null) {
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
                                                                    id = C0594R.id.ll_forest_poshak_pant_no;
                                                                    LinearLayout llForestPoshakPantNo = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_forest_poshak_pant_no);
                                                                    if (llForestPoshakPantNo != null) {
                                                                        id = C0594R.id.ll_land_type;
                                                                        LinearLayout llLandType = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_land_type);
                                                                        if (llLandType != null) {
                                                                            id = C0594R.id.ll_live_pant_no;
                                                                            LinearLayout llLivePantNo = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_live_pant_no);
                                                                            if (llLivePantNo != null) {
                                                                                id = C0594R.id.ll_live_pant_percent;
                                                                                LinearLayout llLivePantPercent = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_live_pant_percent);
                                                                                if (llLivePantPercent != null) {
                                                                                    id = C0594R.id.ll_plant_scheme_no;
                                                                                    LinearLayout llPlantSchemeNo = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_plant_scheme_no);
                                                                                    if (llPlantSchemeNo != null) {
                                                                                        id = C0594R.id.ll_planted_no;
                                                                                        LinearLayout llPlantedNo = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_planted_no);
                                                                                        if (llPlantedNo != null) {
                                                                                            id = C0594R.id.location_progress;
                                                                                            ProgressBar locationProgress = (ProgressBar) ViewBindings.findChildViewById(rootView, C0594R.id.location_progress);
                                                                                            if (locationProgress != null) {
                                                                                                id = C0594R.id.recyclerView_location;
                                                                                                RecyclerView recyclerViewLocation = (RecyclerView) ViewBindings.findChildViewById(rootView, C0594R.id.recyclerView_location);
                                                                                                if (recyclerViewLocation != null) {
                                                                                                    id = C0594R.id.reg_form;
                                                                                                    ScrollView regForm = (ScrollView) ViewBindings.findChildViewById(rootView, C0594R.id.reg_form);
                                                                                                    if (regForm != null) {
                                                                                                        id = C0594R.id.sblist;
                                                                                                        LinearLayout sblist = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.sblist);
                                                                                                        if (sblist != null) {
                                                                                                            id = C0594R.id.spin_bhugtan_plant_month;
                                                                                                            Spinner spinBhugtanPlantMonth = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_bhugtan_plant_month);
                                                                                                            if (spinBhugtanPlantMonth != null) {
                                                                                                                id = C0594R.id.spin_bhugtan_plant_year;
                                                                                                                Spinner spinBhugtanPlantYear = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_bhugtan_plant_year);
                                                                                                                if (spinBhugtanPlantYear != null) {
                                                                                                                    id = C0594R.id.spin_forest_poshak_pant_no;
                                                                                                                    EditText spinForestPoshakPantNo = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.spin_forest_poshak_pant_no);
                                                                                                                    if (spinForestPoshakPantNo != null) {
                                                                                                                        id = C0594R.id.spin_plantation_site;
                                                                                                                        Spinner spinPlantationSite = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_plantation_site);
                                                                                                                        if (spinPlantationSite != null) {
                                                                                                                            id = C0594R.id.spin_year;
                                                                                                                            Spinner spinYear = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_year);
                                                                                                                            if (spinYear != null) {
                                                                                                                                id = C0594R.id.take_location;
                                                                                                                                Button takeLocation = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.take_location);
                                                                                                                                if (takeLocation != null) {
                                                                                                                                    id = C0594R.id.tv_agency_name;
                                                                                                                                    TextView tvAgencyName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_agency_name);
                                                                                                                                    if (tvAgencyName != null) {
                                                                                                                                        id = C0594R.id.tv_forest_poshak_bhugtan_pant_no;
                                                                                                                                        TextView tvForestPoshakBhugtanPantNo = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_forest_poshak_bhugtan_pant_no);
                                                                                                                                        if (tvForestPoshakBhugtanPantNo != null) {
                                                                                                                                            id = C0594R.id.tv_forest_poshak_pant_no;
                                                                                                                                            TextView tvForestPoshakPantNo = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_forest_poshak_pant_no);
                                                                                                                                            if (tvForestPoshakPantNo != null) {
                                                                                                                                                id = C0594R.id.tv_fyear;
                                                                                                                                                TextView tvFyear = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_fyear);
                                                                                                                                                if (tvFyear != null) {
                                                                                                                                                    id = C0594R.id.tv_plantation_site;
                                                                                                                                                    TextView tvPlantationSite = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_plantation_site);
                                                                                                                                                    if (tvPlantationSite != null) {
                                                                                                                                                        id = C0594R.id.tv_work_code;
                                                                                                                                                        TextView tvWorkCode = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_work_code);
                                                                                                                                                        if (tvWorkCode != null) {
                                                                                                                                                            id = C0594R.id.tv_work_name;
                                                                                                                                                            TextView tvWorkName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_work_name);
                                                                                                                                                            if (tvWorkName != null) {
                                                                                                                                                                id = C0594R.id.tv_work_type;
                                                                                                                                                                TextView tvWorkType = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_work_type);
                                                                                                                                                                if (tvWorkType != null) {
                                                                                                                                                                    TextView tvYear = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_year);
                                                                                                                                                                    if (tvYear == null) {
                                                                                                                                                                        id = C0594R.id.tv_year;
                                                                                                                                                                    } else {
                                                                                                                                                                        return new ActivityPlantationInspectionBinding((RelativeLayout) rootView, activityNewEntry, btnReg, errorTextView, et5075Per, et7590Per, etAbove90Per, etAverageHeightOfPlant, etBelow25Per, etGawyanPer, etLivePantNo, etLivePantPercent, etPlantedNo, etPlntAgnstDealplnt, etRemark, binding_footer, binding_header, llForestPoshakPantNo, llLandType, llLivePantNo, llLivePantPercent, llPlantSchemeNo, llPlantedNo, locationProgress, recyclerViewLocation, regForm, sblist, spinBhugtanPlantMonth, spinBhugtanPlantYear, spinForestPoshakPantNo, spinPlantationSite, spinYear, takeLocation, tvAgencyName, tvForestPoshakBhugtanPantNo, tvForestPoshakPantNo, tvFyear, tvPlantationSite, tvWorkCode, tvWorkName, tvWorkType, tvYear);
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