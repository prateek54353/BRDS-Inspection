package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ActivityPlantationListBinding implements ViewBinding {
    public final Button btnAddPond;
    public final Button btnSearch;
    public final Button btnViewPondMap;
    public final EditText etWorkCode;
    public final FooterBinding footer;
    public final HeaderBinding header;
    public final ListView listviewshow;
    public final LinearLayout llBlock;
    public final LinearLayout llBlockSection;
    public final LinearLayout llBtn;
    public final LinearLayout llDistrict;
    public final LinearLayout llDistrictSection;
    public final LinearLayout llPanchayat;
    public final LinearLayout llPanchayatSection;
    public final LinearLayout llWorkCode;
    private final RelativeLayout rootView;
    public final Spinner spinBlock;
    public final Spinner spinDistrict;
    public final Spinner spinPanchayat;
    public final TextView tvBlock;
    public final TextView tvDistrict;
    public final TextView tvHeader;
    public final TextView tvNorecord;
    public final TextView tvPanchayat;

    private ActivityPlantationListBinding(RelativeLayout rootView, Button btnAddPond, Button btnSearch, Button btnViewPondMap, EditText etWorkCode, FooterBinding footer, HeaderBinding header, ListView listviewshow, LinearLayout llBlock, LinearLayout llBlockSection, LinearLayout llBtn, LinearLayout llDistrict, LinearLayout llDistrictSection, LinearLayout llPanchayat, LinearLayout llPanchayatSection, LinearLayout llWorkCode, Spinner spinBlock, Spinner spinDistrict, Spinner spinPanchayat, TextView tvBlock, TextView tvDistrict, TextView tvHeader, TextView tvNorecord, TextView tvPanchayat) {
        this.rootView = rootView;
        this.btnAddPond = btnAddPond;
        this.btnSearch = btnSearch;
        this.btnViewPondMap = btnViewPondMap;
        this.etWorkCode = etWorkCode;
        this.footer = footer;
        this.header = header;
        this.listviewshow = listviewshow;
        this.llBlock = llBlock;
        this.llBlockSection = llBlockSection;
        this.llBtn = llBtn;
        this.llDistrict = llDistrict;
        this.llDistrictSection = llDistrictSection;
        this.llPanchayat = llPanchayat;
        this.llPanchayatSection = llPanchayatSection;
        this.llWorkCode = llWorkCode;
        this.spinBlock = spinBlock;
        this.spinDistrict = spinDistrict;
        this.spinPanchayat = spinPanchayat;
        this.tvBlock = tvBlock;
        this.tvDistrict = tvDistrict;
        this.tvHeader = tvHeader;
        this.tvNorecord = tvNorecord;
        this.tvPanchayat = tvPanchayat;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPlantationListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPlantationListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_plantation_list, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityPlantationListBinding bind(View rootView) {
        int id = C0594R.id.btn_add_pond;
        Button btnAddPond = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_add_pond);
        if (btnAddPond != null) {
            id = C0594R.id.btn_search;
            Button btnSearch = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_search);
            if (btnSearch != null) {
                id = C0594R.id.btn_view_pond_map;
                Button btnViewPondMap = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_view_pond_map);
                if (btnViewPondMap != null) {
                    id = C0594R.id.et_work_code;
                    EditText etWorkCode = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_work_code);
                    if (etWorkCode != null) {
                        id = C0594R.id.footer;
                        View footer = ViewBindings.findChildViewById(rootView, C0594R.id.footer);
                        if (footer != null) {
                            FooterBinding binding_footer = FooterBinding.bind(footer);
                            id = C0594R.id.header;
                            View header = ViewBindings.findChildViewById(rootView, C0594R.id.header);
                            if (header != null) {
                                HeaderBinding binding_header = HeaderBinding.bind(header);
                                id = C0594R.id.listviewshow;
                                ListView listviewshow = (ListView) ViewBindings.findChildViewById(rootView, C0594R.id.listviewshow);
                                if (listviewshow != null) {
                                    id = C0594R.id.ll_block;
                                    LinearLayout llBlock = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_block);
                                    if (llBlock != null) {
                                        id = C0594R.id.ll_block_section;
                                        LinearLayout llBlockSection = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_block_section);
                                        if (llBlockSection != null) {
                                            id = C0594R.id.ll_btn;
                                            LinearLayout llBtn = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_btn);
                                            if (llBtn != null) {
                                                id = C0594R.id.ll_district;
                                                LinearLayout llDistrict = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_district);
                                                if (llDistrict != null) {
                                                    id = C0594R.id.ll_district_section;
                                                    LinearLayout llDistrictSection = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_district_section);
                                                    if (llDistrictSection != null) {
                                                        id = C0594R.id.ll_panchayat;
                                                        LinearLayout llPanchayat = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_panchayat);
                                                        if (llPanchayat != null) {
                                                            id = C0594R.id.ll_panchayat_section;
                                                            LinearLayout llPanchayatSection = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_panchayat_section);
                                                            if (llPanchayatSection != null) {
                                                                id = C0594R.id.ll_work_Code;
                                                                LinearLayout llWorkCode = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_work_Code);
                                                                if (llWorkCode != null) {
                                                                    id = C0594R.id.spin_block;
                                                                    Spinner spinBlock = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_block);
                                                                    if (spinBlock != null) {
                                                                        id = C0594R.id.spin_district;
                                                                        Spinner spinDistrict = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_district);
                                                                        if (spinDistrict != null) {
                                                                            id = C0594R.id.spin_panchayat;
                                                                            Spinner spinPanchayat = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spin_panchayat);
                                                                            if (spinPanchayat != null) {
                                                                                id = C0594R.id.tv_block;
                                                                                TextView tvBlock = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_block);
                                                                                if (tvBlock != null) {
                                                                                    id = C0594R.id.tv_district;
                                                                                    TextView tvDistrict = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_district);
                                                                                    if (tvDistrict != null) {
                                                                                        id = C0594R.id.tv_header;
                                                                                        TextView tvHeader = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_header);
                                                                                        if (tvHeader != null) {
                                                                                            id = C0594R.id.tv_Norecord;
                                                                                            TextView tvNorecord = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_Norecord);
                                                                                            if (tvNorecord != null) {
                                                                                                id = C0594R.id.tv_panchayat;
                                                                                                TextView tvPanchayat = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_panchayat);
                                                                                                if (tvPanchayat != null) {
                                                                                                    return new ActivityPlantationListBinding((RelativeLayout) rootView, btnAddPond, btnSearch, btnViewPondMap, etWorkCode, binding_footer, binding_header, listviewshow, llBlock, llBlockSection, llBtn, llDistrict, llDistrictSection, llPanchayat, llPanchayatSection, llWorkCode, spinBlock, spinDistrict, spinPanchayat, tvBlock, tvDistrict, tvHeader, tvNorecord, tvPanchayat);
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