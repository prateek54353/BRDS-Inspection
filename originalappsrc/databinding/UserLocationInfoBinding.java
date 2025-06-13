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
public final class UserLocationInfoBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvUserlocation;

    private UserLocationInfoBinding(LinearLayout rootView, TextView tvUserlocation) {
        this.rootView = rootView;
        this.tvUserlocation = tvUserlocation;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserLocationInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static UserLocationInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.user_location_info, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static UserLocationInfoBinding bind(View rootView) {
        TextView tvUserlocation = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_userlocation);
        if (tvUserlocation == null) {
            String missingId = rootView.getResources().getResourceName(C0594R.id.tv_userlocation);
            throw new NullPointerException("Missing required view with ID: ".concat(missingId));
        }
        return new UserLocationInfoBinding((LinearLayout) rootView, tvUserlocation);
    }
}