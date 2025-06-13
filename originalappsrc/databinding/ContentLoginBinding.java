package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ContentLoginBinding implements ViewBinding {
    public final AutoCompleteTextView email;
    public final Button emailSignInButton;
    public final FooterBinding footer;
    public final LinearLayout ll11;
    public final EditText password;
    private final RelativeLayout rootView;
    public final TextView textView2;
    public final TextView textView3;
    public final TextView txtVersion;

    private ContentLoginBinding(RelativeLayout rootView, AutoCompleteTextView email, Button emailSignInButton, FooterBinding footer, LinearLayout ll11, EditText password, TextView textView2, TextView textView3, TextView txtVersion) {
        this.rootView = rootView;
        this.email = email;
        this.emailSignInButton = emailSignInButton;
        this.footer = footer;
        this.ll11 = ll11;
        this.password = password;
        this.textView2 = textView2;
        this.textView3 = textView3;
        this.txtVersion = txtVersion;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ContentLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ContentLoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.content_login, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ContentLoginBinding bind(View rootView) {
        int id = C0594R.id.email;
        AutoCompleteTextView email = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, C0594R.id.email);
        if (email != null) {
            id = C0594R.id.email_sign_in_button;
            Button emailSignInButton = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.email_sign_in_button);
            if (emailSignInButton != null) {
                id = C0594R.id.footer;
                View footer = ViewBindings.findChildViewById(rootView, C0594R.id.footer);
                if (footer != null) {
                    FooterBinding binding_footer = FooterBinding.bind(footer);
                    id = C0594R.id.ll11;
                    LinearLayout ll11 = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll11);
                    if (ll11 != null) {
                        id = C0594R.id.password;
                        EditText password = (EditText) ViewBindings.findChildViewById(rootView, C0594R.id.password);
                        if (password != null) {
                            id = C0594R.id.textView2;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textView2);
                            if (textView2 != null) {
                                id = C0594R.id.textView3;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textView3);
                                if (textView3 != null) {
                                    id = C0594R.id.txtVersion;
                                    TextView txtVersion = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.txtVersion);
                                    if (txtVersion != null) {
                                        return new ContentLoginBinding((RelativeLayout) rootView, email, emailSignInButton, binding_footer, ll11, password, textView2, textView3, txtVersion);
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