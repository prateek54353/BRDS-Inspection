package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class DialogLayoutBinding implements ViewBinding {
    public final CheckBox checkbox1;
    public final CheckBox checkbox2;
    public final CheckBox checkbox3;
    public final CheckBox checkbox4;
    private final LinearLayout rootView;
    public final TextView textDescription;
    public final TextView textTitle;

    private DialogLayoutBinding(LinearLayout rootView, CheckBox checkbox1, CheckBox checkbox2, CheckBox checkbox3, CheckBox checkbox4, TextView textDescription, TextView textTitle) {
        this.rootView = rootView;
        this.checkbox1 = checkbox1;
        this.checkbox2 = checkbox2;
        this.checkbox3 = checkbox3;
        this.checkbox4 = checkbox4;
        this.textDescription = textDescription;
        this.textTitle = textTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogLayoutBinding bind(View rootView) {
        int id = C0594R.id.checkbox1;
        CheckBox checkbox1 = (CheckBox) ViewBindings.findChildViewById(rootView, C0594R.id.checkbox1);
        if (checkbox1 != null) {
            id = C0594R.id.checkbox2;
            CheckBox checkbox2 = (CheckBox) ViewBindings.findChildViewById(rootView, C0594R.id.checkbox2);
            if (checkbox2 != null) {
                id = C0594R.id.checkbox3;
                CheckBox checkbox3 = (CheckBox) ViewBindings.findChildViewById(rootView, C0594R.id.checkbox3);
                if (checkbox3 != null) {
                    id = C0594R.id.checkbox4;
                    CheckBox checkbox4 = (CheckBox) ViewBindings.findChildViewById(rootView, C0594R.id.checkbox4);
                    if (checkbox4 != null) {
                        id = C0594R.id.text_description;
                        TextView textDescription = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.text_description);
                        if (textDescription != null) {
                            id = C0594R.id.text_title;
                            TextView textTitle = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.text_title);
                            if (textTitle != null) {
                                return new DialogLayoutBinding((LinearLayout) rootView, checkbox1, checkbox2, checkbox3, checkbox4, textDescription, textTitle);
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