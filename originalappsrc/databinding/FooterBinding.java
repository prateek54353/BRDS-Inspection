package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class FooterBinding implements ViewBinding {
    public final RelativeLayout footerLayoutRoot;
    public final TextView headtext1;
    private final RelativeLayout rootView;

    private FooterBinding(RelativeLayout rootView, RelativeLayout footerLayoutRoot, TextView headtext1) {
        this.rootView = rootView;
        this.footerLayoutRoot = footerLayoutRoot;
        this.headtext1 = headtext1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FooterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FooterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.footer, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FooterBinding bind(View rootView) {
        RelativeLayout footerLayoutRoot = (RelativeLayout) rootView;
        TextView headtext1 = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.headtext1);
        if (headtext1 == null) {
            String missingId = rootView.getResources().getResourceName(C0594R.id.headtext1);
            throw new NullPointerException("Missing required view with ID: ".concat(missingId));
        }
        return new FooterBinding((RelativeLayout) rootView, footerLayoutRoot, headtext1);
    }
}