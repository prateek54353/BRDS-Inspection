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
public final class FragmentFirstBinding implements ViewBinding {
    public final Button buttonFirst;
    private final NestedScrollView rootView;
    public final TextView textviewFirst;

    private FragmentFirstBinding(NestedScrollView rootView, Button buttonFirst, TextView textviewFirst) {
        this.rootView = rootView;
        this.buttonFirst = buttonFirst;
        this.textviewFirst = textviewFirst;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentFirstBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentFirstBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.fragment_first, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentFirstBinding bind(View rootView) {
        int id = C0594R.id.button_first;
        Button buttonFirst = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.button_first);
        if (buttonFirst != null) {
            id = C0594R.id.textview_first;
            TextView textviewFirst = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textview_first);
            if (textviewFirst != null) {
                return new FragmentFirstBinding((NestedScrollView) rootView, buttonFirst, textviewFirst);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}