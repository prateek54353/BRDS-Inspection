package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ActivityMapBinding implements ViewBinding {
    public final TextView btnMapSatellite;
    public final ImageButton buttonManual;
    public final TextView detail;
    public final EditText edtSearch;
    public final FooterBinding footer;
    public final HeaderBinding header;
    public final ImageView imgSearch;
    public final RelativeLayout rel1;
    public final RelativeLayout rel2;
    public final RelativeLayout rel21;
    public final RelativeLayout rel23;
    public final RelativeLayout rel24;
    public final RelativeLayout rlHealthFID;
    private final RelativeLayout rootView;
    public final Spinner spnHealthfId;
    public final TextView tvDistanceTime;

    private ActivityMapBinding(RelativeLayout rootView, TextView btnMapSatellite, ImageButton buttonManual, TextView detail, EditText edtSearch, FooterBinding footer, HeaderBinding header, ImageView imgSearch, RelativeLayout rel1, RelativeLayout rel2, RelativeLayout rel21, RelativeLayout rel23, RelativeLayout rel24, RelativeLayout rlHealthFID, Spinner spnHealthfId, TextView tvDistanceTime) {
        this.rootView = rootView;
        this.btnMapSatellite = btnMapSatellite;
        this.buttonManual = buttonManual;
        this.detail = detail;
        this.edtSearch = edtSearch;
        this.footer = footer;
        this.header = header;
        this.imgSearch = imgSearch;
        this.rel1 = rel1;
        this.rel2 = rel2;
        this.rel21 = rel21;
        this.rel23 = rel23;
        this.rel24 = rel24;
        this.rlHealthFID = rlHealthFID;
        this.spnHealthfId = spnHealthfId;
        this.tvDistanceTime = tvDistanceTime;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMapBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMapBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_map, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMapBinding bind(View rootView) {
        int id = C0594R.id.btn_map_satellite;
        TextView btnMapSatellite = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.btn_map_satellite);
        if (btnMapSatellite != null) {
            id = C0594R.id.button_manual;
            ImageButton buttonManual = (ImageButton) ViewBindings.findChildViewById(rootView, C0594R.id.button_manual);
            if (buttonManual != null) {
                id = C0594R.id.detail;
                TextView detail = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.detail);
                if (detail != null) {
                    id = C0594R.id.edt_search;
                    EditText edtSearch = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.edt_search);
                    if (edtSearch != null) {
                        id = C0594R.id.footer;
                        View footer = ViewBindings.findChildViewById(rootView, C0594R.id.footer);
                        if (footer != null) {
                            FooterBinding binding_footer = FooterBinding.bind(footer);
                            id = C0594R.id.header;
                            View header = ViewBindings.findChildViewById(rootView, C0594R.id.header);
                            if (header != null) {
                                HeaderBinding binding_header = HeaderBinding.bind(header);
                                id = C0594R.id.img_search;
                                ImageView imgSearch = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.img_search);
                                if (imgSearch != null) {
                                    id = C0594R.id.rel1;
                                    RelativeLayout rel1 = (RelativeLayout) ViewBindings.findChildViewById(rootView, C0594R.id.rel1);
                                    if (rel1 != null) {
                                        id = C0594R.id.rel2;
                                        RelativeLayout rel2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, C0594R.id.rel2);
                                        if (rel2 != null) {
                                            id = C0594R.id.rel21;
                                            RelativeLayout rel21 = (RelativeLayout) ViewBindings.findChildViewById(rootView, C0594R.id.rel21);
                                            if (rel21 != null) {
                                                id = C0594R.id.rel23;
                                                RelativeLayout rel23 = (RelativeLayout) ViewBindings.findChildViewById(rootView, C0594R.id.rel23);
                                                if (rel23 != null) {
                                                    id = C0594R.id.rel24;
                                                    RelativeLayout rel24 = (RelativeLayout) ViewBindings.findChildViewById(rootView, C0594R.id.rel24);
                                                    if (rel24 != null) {
                                                        id = C0594R.id.rl_healthFID;
                                                        RelativeLayout rlHealthFID = (RelativeLayout) ViewBindings.findChildViewById(rootView, C0594R.id.rl_healthFID);
                                                        if (rlHealthFID != null) {
                                                            id = C0594R.id.spn_healthf_id;
                                                            Spinner spnHealthfId = (Spinner) ViewBindings.findChildViewById(rootView, C0594R.id.spn_healthf_id);
                                                            if (spnHealthfId != null) {
                                                                id = C0594R.id.tv_distance_time;
                                                                TextView tvDistanceTime = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_distance_time);
                                                                if (tvDistanceTime != null) {
                                                                    return new ActivityMapBinding((RelativeLayout) rootView, btnMapSatellite, buttonManual, detail, edtSearch, binding_footer, binding_header, imgSearch, rel1, rel2, rel21, rel23, rel24, rlHealthFID, spnHealthfId, tvDistanceTime);
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