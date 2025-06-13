package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class AdaptorPlantationBinding implements ViewBinding {
    public final Button btnInspect;
    public final Button btnMap;
    public final LinearLayout llBtn;
    public final LinearLayout llInspectedBy;
    public final LinearLayout llMap;
    private final LinearLayout rootView;
    public final LinearLayout sblist;
    public final TextView tvAgencyName;
    public final TextView tvInspectedBy;
    public final TextView tvLatitude;
    public final TextView tvLongitude;
    public final TextView tvWorkCode;
    public final TextView tvWorkName;
    public final TextView tvWorkType;

    private AdaptorPlantationBinding(LinearLayout rootView, Button btnInspect, Button btnMap, LinearLayout llBtn, LinearLayout llInspectedBy, LinearLayout llMap, LinearLayout sblist, TextView tvAgencyName, TextView tvInspectedBy, TextView tvLatitude, TextView tvLongitude, TextView tvWorkCode, TextView tvWorkName, TextView tvWorkType) {
        this.rootView = rootView;
        this.btnInspect = btnInspect;
        this.btnMap = btnMap;
        this.llBtn = llBtn;
        this.llInspectedBy = llInspectedBy;
        this.llMap = llMap;
        this.sblist = sblist;
        this.tvAgencyName = tvAgencyName;
        this.tvInspectedBy = tvInspectedBy;
        this.tvLatitude = tvLatitude;
        this.tvLongitude = tvLongitude;
        this.tvWorkCode = tvWorkCode;
        this.tvWorkName = tvWorkName;
        this.tvWorkType = tvWorkType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AdaptorPlantationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdaptorPlantationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.adaptor_plantation, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AdaptorPlantationBinding bind(View rootView) {
        int id = C0594R.id.btn_inspect;
        Button btnInspect = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_inspect);
        if (btnInspect != null) {
            id = C0594R.id.btn_map;
            Button btnMap = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_map);
            if (btnMap != null) {
                id = C0594R.id.ll_btn;
                LinearLayout llBtn = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_btn);
                if (llBtn != null) {
                    id = C0594R.id.ll_inspected_by;
                    LinearLayout llInspectedBy = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_inspected_by);
                    if (llInspectedBy != null) {
                        id = C0594R.id.ll_map;
                        LinearLayout llMap = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_map);
                        if (llMap != null) {
                            id = C0594R.id.sblist;
                            LinearLayout sblist = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.sblist);
                            if (sblist != null) {
                                id = C0594R.id.tv_agency_name;
                                TextView tvAgencyName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_agency_name);
                                if (tvAgencyName != null) {
                                    id = C0594R.id.tv_inspected_by;
                                    TextView tvInspectedBy = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_inspected_by);
                                    if (tvInspectedBy != null) {
                                        id = C0594R.id.tv_latitude;
                                        TextView tvLatitude = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_latitude);
                                        if (tvLatitude != null) {
                                            id = C0594R.id.tv_longitude;
                                            TextView tvLongitude = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_longitude);
                                            if (tvLongitude != null) {
                                                id = C0594R.id.tv_work_code;
                                                TextView tvWorkCode = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_work_code);
                                                if (tvWorkCode != null) {
                                                    id = C0594R.id.tv_work_name;
                                                    TextView tvWorkName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_work_name);
                                                    if (tvWorkName != null) {
                                                        id = C0594R.id.tv_work_type;
                                                        TextView tvWorkType = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_work_type);
                                                        if (tvWorkType != null) {
                                                            return new AdaptorPlantationBinding((LinearLayout) rootView, btnInspect, btnMap, llBtn, llInspectedBy, llMap, sblist, tvAgencyName, tvInspectedBy, tvLatitude, tvLongitude, tvWorkCode, tvWorkName, tvWorkType);
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