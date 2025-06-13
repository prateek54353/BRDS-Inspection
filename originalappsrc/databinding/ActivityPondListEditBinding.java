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
public final class ActivityPondListEditBinding implements ViewBinding {
    public final FooterBinding footer;
    public final HeaderBinding header;
    public final ListView listviewshow;
    private final RelativeLayout rootView;
    public final TextView tvNorecord;
    public final TextView tvTitle;

    private ActivityPondListEditBinding(RelativeLayout rootView, FooterBinding footer, HeaderBinding header, ListView listviewshow, TextView tvNorecord, TextView tvTitle) {
        this.rootView = rootView;
        this.footer = footer;
        this.header = header;
        this.listviewshow = listviewshow;
        this.tvNorecord = tvNorecord;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPondListEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPondListEditBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_pond_list_edit, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityPondListEditBinding bind(View rootView) {
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
                    id = C0594R.id.tv_Norecord;
                    TextView tvNorecord = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_Norecord);
                    if (tvNorecord != null) {
                        id = C0594R.id.tv_title;
                        TextView tvTitle = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_title);
                        if (tvTitle != null) {
                            return new ActivityPondListEditBinding((RelativeLayout) rootView, binding_footer, binding_header, listviewshow, tvNorecord, tvTitle);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}