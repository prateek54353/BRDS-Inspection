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
public final class ActivityAddMobileBinding implements ViewBinding {
    public final Button btnProceed;
    public final EditText etMobile;
    public final FooterBinding footer;
    public final HeaderBinding header;
    public final LinearLayout llUsername;
    public final RelativeLayout main;
    public final CardView rlUserInfo;
    private final RelativeLayout rootView;
    public final TextView textSlideshow;
    public final TextView tvUsername;

    private ActivityAddMobileBinding(RelativeLayout rootView, Button btnProceed, EditText etMobile, FooterBinding footer, HeaderBinding header, LinearLayout llUsername, RelativeLayout main, CardView rlUserInfo, TextView textSlideshow, TextView tvUsername) {
        this.rootView = rootView;
        this.btnProceed = btnProceed;
        this.etMobile = etMobile;
        this.footer = footer;
        this.header = header;
        this.llUsername = llUsername;
        this.main = main;
        this.rlUserInfo = rlUserInfo;
        this.textSlideshow = textSlideshow;
        this.tvUsername = tvUsername;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAddMobileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityAddMobileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_add_mobile, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityAddMobileBinding bind(View rootView) {
        int id = C0594R.id.btn_proceed;
        Button btnProceed = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_proceed);
        if (btnProceed != null) {
            id = C0594R.id.et_mobile;
            EditText etMobile = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.et_mobile);
            if (etMobile != null) {
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
                                    id = C0594R.id.tv_username;
                                    TextView tvUsername = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_username);
                                    if (tvUsername != null) {
                                        return new ActivityAddMobileBinding((RelativeLayout) rootView, btnProceed, etMobile, binding_footer, binding_header, llUsername, main, rlUserInfo, textSlideshow, tvUsername);
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