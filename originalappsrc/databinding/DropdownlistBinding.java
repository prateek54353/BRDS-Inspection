package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class DropdownlistBinding implements ViewBinding {
    public final TextView droplist;
    private final TextView rootView;

    private DropdownlistBinding(TextView rootView, TextView droplist) {
        this.rootView = rootView;
        this.droplist = droplist;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static DropdownlistBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DropdownlistBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.dropdownlist, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DropdownlistBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        TextView droplist = (TextView) rootView;
        return new DropdownlistBinding((TextView) rootView, droplist);
    }
}