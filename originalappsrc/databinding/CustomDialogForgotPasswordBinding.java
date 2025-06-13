package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class CustomDialogForgotPasswordBinding implements ViewBinding {
    public final ImageView btnCaptcha;
    public final Button btnResetpassword;
    public final Button btnVerifyOtp;
    public final EditText etCaptcha;
    public final EditText etMobile;
    public final EditText etOtp;
    public final EditText etUserid;
    public final FooterBinding footer;
    public final ImageView imgCaptcha;
    public final ImageView ivLogo;
    public final LinearLayout llHeader;
    public final LinearLayout llMobile;
    public final LinearLayout llOtp;
    public final TextView otpTime;
    public final LinearLayout otpmessage;
    private final RelativeLayout rootView;

    private CustomDialogForgotPasswordBinding(RelativeLayout rootView, ImageView btnCaptcha, Button btnResetpassword, Button btnVerifyOtp, EditText etCaptcha, EditText etMobile, EditText etOtp, EditText etUserid, FooterBinding footer, ImageView imgCaptcha, ImageView ivLogo, LinearLayout llHeader, LinearLayout llMobile, LinearLayout llOtp, TextView otpTime, LinearLayout otpmessage) {
        this.rootView = rootView;
        this.btnCaptcha = btnCaptcha;
        this.btnResetpassword = btnResetpassword;
        this.btnVerifyOtp = btnVerifyOtp;
        this.etCaptcha = etCaptcha;
        this.etMobile = etMobile;
        this.etOtp = etOtp;
        this.etUserid = etUserid;
        this.footer = footer;
        this.imgCaptcha = imgCaptcha;
        this.ivLogo = ivLogo;
        this.llHeader = llHeader;
        this.llMobile = llMobile;
        this.llOtp = llOtp;
        this.otpTime = otpTime;
        this.otpmessage = otpmessage;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomDialogForgotPasswordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomDialogForgotPasswordBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.custom_dialog_forgot_password, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static CustomDialogForgotPasswordBinding bind(View rootView) {
        int id = C0594R.id.btn_captcha;
        ImageView btnCaptcha = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.btn_captcha);
        if (btnCaptcha != null) {
            id = C0594R.id.btn_resetpassword;
            Button btnResetpassword = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_resetpassword);
            if (btnResetpassword != null) {
                id = C0594R.id.btn_verifyOtp;
                Button btnVerifyOtp = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_verifyOtp);
                if (btnVerifyOtp != null) {
                    id = C0594R.id.et_captcha;
                    EditText etCaptcha = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_captcha);
                    if (etCaptcha != null) {
                        id = C0594R.id.et_mobile;
                        EditText etMobile = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_mobile);
                        if (etMobile != null) {
                            id = C0594R.id.et_otp;
                            EditText etOtp = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_otp);
                            if (etOtp != null) {
                                id = C0594R.id.et_userid;
                                EditText etUserid = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_userid);
                                if (etUserid != null) {
                                    id = C0594R.id.footer;
                                    View footer = ViewBindings.findChildViewById(rootView, C0594R.id.footer);
                                    if (footer != null) {
                                        FooterBinding binding_footer = FooterBinding.bind(footer);
                                        id = C0594R.id.img_captcha;
                                        ImageView imgCaptcha = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.img_captcha);
                                        if (imgCaptcha != null) {
                                            id = C0594R.id.iv_logo;
                                            ImageView ivLogo = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.iv_logo);
                                            if (ivLogo != null) {
                                                id = C0594R.id.ll_header;
                                                LinearLayout llHeader = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_header);
                                                if (llHeader != null) {
                                                    id = C0594R.id.ll_mobile;
                                                    LinearLayout llMobile = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_mobile);
                                                    if (llMobile != null) {
                                                        id = C0594R.id.ll_otp;
                                                        LinearLayout llOtp = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_otp);
                                                        if (llOtp != null) {
                                                            id = C0594R.id.otp_time;
                                                            TextView otpTime = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.otp_time);
                                                            if (otpTime != null) {
                                                                id = C0594R.id.otpmessage;
                                                                LinearLayout otpmessage = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.otpmessage);
                                                                if (otpmessage != null) {
                                                                    return new CustomDialogForgotPasswordBinding((RelativeLayout) rootView, btnCaptcha, btnResetpassword, btnVerifyOtp, etCaptcha, etMobile, etOtp, etUserid, binding_footer, imgCaptcha, ivLogo, llHeader, llMobile, llOtp, otpTime, otpmessage);
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