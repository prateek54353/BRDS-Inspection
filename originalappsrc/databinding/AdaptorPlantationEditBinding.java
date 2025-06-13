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
public final class AdaptorPlantationEditBinding implements ViewBinding {
    public final Button btnEdit;
    public final Button btnRemove;
    public final Button btnUpload;
    private final LinearLayout rootView;
    public final LinearLayout sblist;
    public final TextView tvAgencyName;
    public final TextView tvWorkCode;
    public final TextView tvWorkName;
    public final TextView tvWorkType;

    private AdaptorPlantationEditBinding(LinearLayout rootView, Button btnEdit, Button btnRemove, Button btnUpload, LinearLayout sblist, TextView tvAgencyName, TextView tvWorkCode, TextView tvWorkName, TextView tvWorkType) {
        this.rootView = rootView;
        this.btnEdit = btnEdit;
        this.btnRemove = btnRemove;
        this.btnUpload = btnUpload;
        this.sblist = sblist;
        this.tvAgencyName = tvAgencyName;
        this.tvWorkCode = tvWorkCode;
        this.tvWorkName = tvWorkName;
        this.tvWorkType = tvWorkType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AdaptorPlantationEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdaptorPlantationEditBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.adaptor_plantation_edit, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AdaptorPlantationEditBinding bind(View rootView) {
        int id = C0594R.id.btn_edit;
        Button btnEdit = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_edit);
        if (btnEdit != null) {
            id = C0594R.id.btn_remove;
            Button btnRemove = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_remove);
            if (btnRemove != null) {
                id = C0594R.id.btn_upload;
                Button btnUpload = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_upload);
                if (btnUpload != null) {
                    id = C0594R.id.sblist;
                    LinearLayout sblist = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.sblist);
                    if (sblist != null) {
                        id = C0594R.id.tv_agency_name;
                        TextView tvAgencyName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_agency_name);
                        if (tvAgencyName != null) {
                            id = C0594R.id.tv_work_code;
                            TextView tvWorkCode = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_work_code);
                            if (tvWorkCode != null) {
                                id = C0594R.id.tv_work_name;
                                TextView tvWorkName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_work_name);
                                if (tvWorkName != null) {
                                    id = C0594R.id.tv_work_type;
                                    TextView tvWorkType = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_work_type);
                                    if (tvWorkType != null) {
                                        return new AdaptorPlantationEditBinding((LinearLayout) rootView, btnEdit, btnRemove, btnUpload, sblist, tvAgencyName, tvWorkCode, tvWorkName, tvWorkType);
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