package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: classes9.dex */
public final class ActivityLoginBinding implements ViewBinding {
    public final ImageView btnCaptcha;
    public final TextInputEditText email;
    public final Button emailSignInButton;
    public final EditText etCaptcha;
    public final ImageView imgCaptcha;
    public final ImageView ivLogo;
    public final LinearLayout llFooter;
    public final LinearLayout llHeader;
    public final TextInputEditText password;
    private final ScrollView rootView;
    public final TextView tvForgotPassword;
    public final TextView txtMobileCountMsg;
    public final TextView txtVersion;

    private ActivityLoginBinding(ScrollView rootView, ImageView btnCaptcha, TextInputEditText email, Button emailSignInButton, EditText etCaptcha, ImageView imgCaptcha, ImageView ivLogo, LinearLayout llFooter, LinearLayout llHeader, TextInputEditText password, TextView tvForgotPassword, TextView txtMobileCountMsg, TextView txtVersion) {
        this.rootView = rootView;
        this.btnCaptcha = btnCaptcha;
        this.email = email;
        this.emailSignInButton = emailSignInButton;
        this.etCaptcha = etCaptcha;
        this.imgCaptcha = imgCaptcha;
        this.ivLogo = ivLogo;
        this.llFooter = llFooter;
        this.llHeader = llHeader;
        this.password = password;
        this.tvForgotPassword = tvForgotPassword;
        this.txtMobileCountMsg = txtMobileCountMsg;
        this.txtVersion = txtVersion;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_login, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityLoginBinding bind(View rootView) {
        int id = C0594R.id.btn_captcha;
        ImageView btnCaptcha = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.btn_captcha);
        if (btnCaptcha != null) {
            id = C0594R.id.email;
            TextInputEditText email = (TextInputEditText) ViewBindings.findChildViewById(rootView, C0594R.id.email);
            if (email != null) {
                id = C0594R.id.email_sign_in_button;
                Button emailSignInButton = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.email_sign_in_button);
                if (emailSignInButton != null) {
                    id = C0594R.id.et_captcha;
                    EditText etCaptcha = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_captcha);
                    if (etCaptcha != null) {
                        id = C0594R.id.img_captcha;
                        ImageView imgCaptcha = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.img_captcha);
                        if (imgCaptcha != null) {
                            id = C0594R.id.iv_logo;
                            ImageView ivLogo = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.iv_logo);
                            if (ivLogo != null) {
                                id = C0594R.id.ll_footer;
                                LinearLayout llFooter = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_footer);
                                if (llFooter != null) {
                                    id = C0594R.id.ll_header;
                                    LinearLayout llHeader = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_header);
                                    if (llHeader != null) {
                                        id = C0594R.id.password;
                                        TextInputEditText password = (TextInputEditText) ViewBindings.findChildViewById(rootView, C0594R.id.password);
                                        if (password != null) {
                                            id = C0594R.id.tv_forgot_password;
                                            TextView tvForgotPassword = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_forgot_password);
                                            if (tvForgotPassword != null) {
                                                id = C0594R.id.txt_mobile_count_msg;
                                                TextView txtMobileCountMsg = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.txt_mobile_count_msg);
                                                if (txtMobileCountMsg != null) {
                                                    id = C0594R.id.txtVersion;
                                                    TextView txtVersion = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.txtVersion);
                                                    if (txtVersion != null) {
                                                        return new ActivityLoginBinding((ScrollView) rootView, btnCaptcha, email, emailSignInButton, etCaptcha, imgCaptcha, ivLogo, llFooter, llHeader, password, tvForgotPassword, txtMobileCountMsg, txtVersion);
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