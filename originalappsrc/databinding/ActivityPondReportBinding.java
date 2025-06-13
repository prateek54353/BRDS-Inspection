package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ActivityPondReportBinding implements ViewBinding {
    public final FooterBinding footer;
    public final HeaderBinding header;
    public final ListView listviewshow;
    private final RelativeLayout rootView;
    public final TextView tvHeader;
    public final TextView tvNorecord;

    private ActivityPondReportBinding(RelativeLayout rootView, FooterBinding footer, HeaderBinding header, ListView listviewshow, TextView tvHeader, TextView tvNorecord) {
        this.rootView = rootView;
        this.footer = footer;
        this.header = header;
        this.listviewshow = listviewshow;
        this.tvHeader = tvHeader;
        this.tvNorecord = tvNorecord;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPondReportBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPondReportBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_pond_report, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityPondReportBinding bind(View rootView) {
        int id = C0594R.id.footer;
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
                    id = C0594R.id.tv_header;
                    TextView tvHeader = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_header);
                    if (tvHeader != null) {
                        id = C0594R.id.tv_Norecord;
                        TextView tvNorecord = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_Norecord);
                        if (tvNorecord != null) {
                            return new ActivityPondReportBinding((RelativeLayout) rootView, binding_footer, binding_header, listviewshow, tvHeader, tvNorecord);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}