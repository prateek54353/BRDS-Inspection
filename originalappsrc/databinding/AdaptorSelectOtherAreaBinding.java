package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class AdaptorSelectOtherAreaBinding implements ViewBinding {
    public final LinearLayout llBlock;
    public final LinearLayout llOthArea;
    public final LinearLayout llPanchayat;
    private final LinearLayout rootView;
    public final TextView tvBlockOth;
    public final TextView tvCount;
    public final TextView tvDistrictOth;
    public final TextView tvPanchayatOth;
    public final TextView tvSameArea;

    private AdaptorSelectOtherAreaBinding(LinearLayout rootView, LinearLayout llBlock, LinearLayout llOthArea, LinearLayout llPanchayat, TextView tvBlockOth, TextView tvCount, TextView tvDistrictOth, TextView tvPanchayatOth, TextView tvSameArea) {
        this.rootView = rootView;
        this.llBlock = llBlock;
        this.llOthArea = llOthArea;
        this.llPanchayat = llPanchayat;
        this.tvBlockOth = tvBlockOth;
        this.tvCount = tvCount;
        this.tvDistrictOth = tvDistrictOth;
        this.tvPanchayatOth = tvPanchayatOth;
        this.tvSameArea = tvSameArea;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AdaptorSelectOtherAreaBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdaptorSelectOtherAreaBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.adaptor_select_other_area, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AdaptorSelectOtherAreaBinding bind(View rootView) {
        int id = C0594R.id.ll_block;
        LinearLayout llBlock = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_block);
        if (llBlock != null) {
            id = C0594R.id.ll_oth_area;
            LinearLayout llOthArea = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_oth_area);
            if (llOthArea != null) {
                id = C0594R.id.ll_panchayat;
                LinearLayout llPanchayat = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_panchayat);
                if (llPanchayat != null) {
                    id = C0594R.id.tv_block_oth;
                    TextView tvBlockOth = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_block_oth);
                    if (tvBlockOth != null) {
                        id = C0594R.id.tv_count;
                        TextView tvCount = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_count);
                        if (tvCount != null) {
                            id = C0594R.id.tv_district_oth;
                            TextView tvDistrictOth = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_district_oth);
                            if (tvDistrictOth != null) {
                                id = C0594R.id.tv_panchayat_oth;
                                TextView tvPanchayatOth = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_panchayat_oth);
                                if (tvPanchayatOth != null) {
                                    id = C0594R.id.tv_same_area;
                                    TextView tvSameArea = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_same_area);
                                    if (tvSameArea != null) {
                                        return new AdaptorSelectOtherAreaBinding((LinearLayout) rootView, llBlock, llOthArea, llPanchayat, tvBlockOth, tvCount, tvDistrictOth, tvPanchayatOth, tvSameArea);
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