package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class FragmentSecondBinding implements ViewBinding {
    public final Button buttonSecond;
    private final NestedScrollView rootView;
    public final TextView textviewSecond;

    private FragmentSecondBinding(NestedScrollView rootView, Button buttonSecond, TextView textviewSecond) {
        this.rootView = rootView;
        this.buttonSecond = buttonSecond;
        this.textviewSecond = textviewSecond;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentSecondBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentSecondBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.fragment_second, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentSecondBinding bind(View rootView) {
        int id = C0594R.id.button_second;
        Button buttonSecond = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.button_second);
        if (buttonSecond != null) {
            id = C0594R.id.textview_second;
            TextView textviewSecond = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textview_second);
            if (textviewSecond != null) {
                return new FragmentSecondBinding((NestedScrollView) rootView, buttonSecond, textviewSecond);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}