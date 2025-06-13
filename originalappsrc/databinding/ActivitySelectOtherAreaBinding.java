package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ActivitySelectOtherAreaBinding implements ViewBinding {
    public final FooterBinding footer;
    public final HeaderBinding header;
    private final RelativeLayout rootView;
    public final RecyclerView rvData;
    public final TextView tvHeader;

    private ActivitySelectOtherAreaBinding(RelativeLayout rootView, FooterBinding footer, HeaderBinding header, RecyclerView rvData, TextView tvHeader) {
        this.rootView = rootView;
        this.footer = footer;
        this.header = header;
        this.rvData = rvData;
        this.tvHeader = tvHeader;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySelectOtherAreaBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySelectOtherAreaBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_select_other_area, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivitySelectOtherAreaBinding bind(View rootView) {
        int id = C0594R.id.footer;
        View footer = ViewBindings.findChildViewById(rootView, C0594R.id.footer);
        if (footer != null) {
            FooterBinding binding_footer = FooterBinding.bind(footer);
            id = C0594R.id.header;
            View header = ViewBindings.findChildViewById(rootView, C0594R.id.header);
            if (header != null) {
                HeaderBinding binding_header = HeaderBinding.bind(header);
                id = C0594R.id.rv_data;
                RecyclerView rvData = (RecyclerView) ViewBindings.findChildViewById(rootView, C0594R.id.rv_data);
                if (rvData != null) {
                    id = C0594R.id.tv_header;
                    TextView tvHeader = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_header);
                    if (tvHeader != null) {
                        return new ActivitySelectOtherAreaBinding((RelativeLayout) rootView, binding_footer, binding_header, rvData, tvHeader);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}