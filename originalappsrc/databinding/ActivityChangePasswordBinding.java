package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ActivityChangePasswordBinding implements ViewBinding {
    public final Button btnProceed;
    public final EditText etConfirmPass;
    public final EditText etNewPass;
    public final EditText etOldPass;
    public final FooterBinding footer;
    public final HeaderBinding header;
    public final LinearLayout llUsername;
    public final RelativeLayout main;
    public final CardView rlUserInfo;
    private final RelativeLayout rootView;
    public final TextView textSlideshow;
    public final TextView tvPasswordStrenth;
    public final TextView tvUsername;

    private ActivityChangePasswordBinding(RelativeLayout rootView, Button btnProceed, EditText etConfirmPass, EditText etNewPass, EditText etOldPass, FooterBinding footer, HeaderBinding header, LinearLayout llUsername, RelativeLayout main, CardView rlUserInfo, TextView textSlideshow, TextView tvPasswordStrenth, TextView tvUsername) {
        this.rootView = rootView;
        this.btnProceed = btnProceed;
        this.etConfirmPass = etConfirmPass;
        this.etNewPass = etNewPass;
        this.etOldPass = etOldPass;
        this.footer = footer;
        this.header = header;
        this.llUsername = llUsername;
        this.main = main;
        this.rlUserInfo = rlUserInfo;
        this.textSlideshow = textSlideshow;
        this.tvPasswordStrenth = tvPasswordStrenth;
        this.tvUsername = tvUsername;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityChangePasswordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityChangePasswordBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_change_password, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityChangePasswordBinding bind(View rootView) {
        int id = C0594R.id.btn_proceed;
        Button btnProceed = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_proceed);
        if (btnProceed != null) {
            id = C0594R.id.et_confirm_pass;
            EditText etConfirmPass = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_confirm_pass);
            if (etConfirmPass != null) {
                id = C0594R.id.et_new_pass;
                EditText etNewPass = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_new_pass);
                if (etNewPass != null) {
                    id = C0594R.id.et_old_pass;
                    EditText etOldPass = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_old_pass);
                    if (etOldPass != null) {
                        id = C0594R.id.footer;
                        View footer = ViewBindings.findChildViewById(rootView, C0594R.id.footer);
                        if (footer != null) {
                            FooterBinding binding_footer = FooterBinding.bind(footer);
                            id = C0594R.id.header;
                            View header = ViewBindings.findChildViewById(rootView, C0594R.id.header);
                            if (header != null) {
                                HeaderBinding binding_header = HeaderBinding.bind(header);
                                id = C0594R.id.ll_username;
                                LinearLayout llUsername = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_username);
                                if (llUsername != null) {
                                    RelativeLayout main = (RelativeLayout) rootView;
                                    id = C0594R.id.rl_user_info;
                                    CardView rlUserInfo = (CardView) ViewBindings.findChildViewById(rootView, C0594R.id.rl_user_info);
                                    if (rlUserInfo != null) {
                                        id = C0594R.id.text_slideshow;
                                        TextView textSlideshow = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.text_slideshow);
                                        if (textSlideshow != null) {
                                            id = C0594R.id.tv_password_strenth;
                                            TextView tvPasswordStrenth = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_password_strenth);
                                            if (tvPasswordStrenth != null) {
                                                id = C0594R.id.tv_username;
                                                TextView tvUsername = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_username);
                                                if (tvUsername != null) {
                                                    return new ActivityChangePasswordBinding((RelativeLayout) rootView, btnProceed, etConfirmPass, etNewPass, etOldPass, binding_footer, binding_header, llUsername, main, rlUserInfo, textSlideshow, tvPasswordStrenth, tvUsername);
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