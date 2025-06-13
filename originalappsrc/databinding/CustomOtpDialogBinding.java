package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;
import com.chaos.view.PinView;

/* loaded from: classes9.dex */
public final class CustomOtpDialogBinding implements ViewBinding {
    public final TextView mobileText;
    public final LinearLayout otpmessage;
    public final PinView pinview;
    public final TextView resendOTP;
    private final LinearLayout rootView;
    public final TextView txtMobileCountMsg;
    public final Button verifyOTP;

    private CustomOtpDialogBinding(LinearLayout rootView, TextView mobileText, LinearLayout otpmessage, PinView pinview, TextView resendOTP, TextView txtMobileCountMsg, Button verifyOTP) {
        this.rootView = rootView;
        this.mobileText = mobileText;
        this.otpmessage = otpmessage;
        this.pinview = pinview;
        this.resendOTP = resendOTP;
        this.txtMobileCountMsg = txtMobileCountMsg;
        this.verifyOTP = verifyOTP;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomOtpDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomOtpDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.custom_otp_dialog, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static CustomOtpDialogBinding bind(View rootView) {
        int id = C0594R.id.mobileText;
        TextView mobileText = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.mobileText);
        if (mobileText != null) {
            id = C0594R.id.otpmessage;
            LinearLayout otpmessage = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.otpmessage);
            if (otpmessage != null) {
                id = C0594R.id.pinview;
                PinView pinview = (PinView) ViewBindings.findChildViewById(rootView, C0594R.id.pinview);
                if (pinview != null) {
                    id = C0594R.id.resendOTP;
                    TextView resendOTP = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.resendOTP);
                    if (resendOTP != null) {
                        id = C0594R.id.txt_mobile_count_msg;
                        TextView txtMobileCountMsg = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.txt_mobile_count_msg);
                        if (txtMobileCountMsg != null) {
                            id = C0594R.id.verifyOTP;
                            Button verifyOTP = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.verifyOTP);
                            if (verifyOTP != null) {
                                return new CustomOtpDialogBinding((LinearLayout) rootView, mobileText, otpmessage, pinview, resendOTP, txtMobileCountMsg, verifyOTP);
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