package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class CustomThanaDetailsBinding implements ViewBinding {
    public final TextView districtHqLabel;
    public final TextView districtHqNo;
    public final TextView locatinLabel;
    private final LinearLayout rootView;
    public final TextView spLabel;
    public final TextView spNo;
    public final Button textView10;
    public final TextView textView5;
    public final TextView textView7;
    public final TextView thanano;
    public final TextView thananolabel;
    public final TextView tvACName;
    public final TextView tvBLOName;
    public final TextView tvlocation;
    public final ImageView type;
    public final TextView userLoc;

    private CustomThanaDetailsBinding(LinearLayout rootView, TextView districtHqLabel, TextView districtHqNo, TextView locatinLabel, TextView spLabel, TextView spNo, Button textView10, TextView textView5, TextView textView7, TextView thanano, TextView thananolabel, TextView tvACName, TextView tvBLOName, TextView tvlocation, ImageView type, TextView userLoc) {
        this.rootView = rootView;
        this.districtHqLabel = districtHqLabel;
        this.districtHqNo = districtHqNo;
        this.locatinLabel = locatinLabel;
        this.spLabel = spLabel;
        this.spNo = spNo;
        this.textView10 = textView10;
        this.textView5 = textView5;
        this.textView7 = textView7;
        this.thanano = thanano;
        this.thananolabel = thananolabel;
        this.tvACName = tvACName;
        this.tvBLOName = tvBLOName;
        this.tvlocation = tvlocation;
        this.type = type;
        this.userLoc = userLoc;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomThanaDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomThanaDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.custom_thana_details, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static CustomThanaDetailsBinding bind(View rootView) {
        int id = C0594R.id.district_hq_label;
        TextView districtHqLabel = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.district_hq_label);
        if (districtHqLabel != null) {
            id = C0594R.id.district_hq_no;
            TextView districtHqNo = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.district_hq_no);
            if (districtHqNo != null) {
                id = C0594R.id.locatin_label;
                TextView locatinLabel = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.locatin_label);
                if (locatinLabel != null) {
                    id = C0594R.id.sp_label;
                    TextView spLabel = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.sp_label);
                    if (spLabel != null) {
                        id = C0594R.id.sp_no;
                        TextView spNo = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.sp_no);
                        if (spNo != null) {
                            id = C0594R.id.textView10;
                            Button textView10 = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.textView10);
                            if (textView10 != null) {
                                id = C0594R.id.textView5;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textView5);
                                if (textView5 != null) {
                                    id = C0594R.id.textView7;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textView7);
                                    if (textView7 != null) {
                                        id = C0594R.id.thanano;
                                        TextView thanano = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.thanano);
                                        if (thanano != null) {
                                            id = C0594R.id.thananolabel;
                                            TextView thananolabel = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.thananolabel);
                                            if (thananolabel != null) {
                                                id = C0594R.id.tvACName;
                                                TextView tvACName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tvACName);
                                                if (tvACName != null) {
                                                    id = C0594R.id.tvBLOName;
                                                    TextView tvBLOName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tvBLOName);
                                                    if (tvBLOName != null) {
                                                        id = C0594R.id.tvlocation;
                                                        TextView tvlocation = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tvlocation);
                                                        if (tvlocation != null) {
                                                            id = C0594R.id.type;
                                                            ImageView type = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.type);
                                                            if (type != null) {
                                                                id = C0594R.id.user_loc;
                                                                TextView userLoc = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.user_loc);
                                                                if (userLoc != null) {
                                                                    return new CustomThanaDetailsBinding((LinearLayout) rootView, districtHqLabel, districtHqNo, locatinLabel, spLabel, spNo, textView10, textView5, textView7, thanano, thananolabel, tvACName, tvBLOName, tvlocation, type, userLoc);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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