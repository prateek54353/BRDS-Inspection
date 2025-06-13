package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ActivitySplashBinding implements ViewBinding {
    public final ImageView frame1;
    public final LinearLayout ll11;
    public final ProgressBar progress1;
    private final RelativeLayout rootView;
    public final TextView textView2;
    public final TextView textView3;

    private ActivitySplashBinding(RelativeLayout rootView, ImageView frame1, LinearLayout ll11, ProgressBar progress1, TextView textView2, TextView textView3) {
        this.rootView = rootView;
        this.frame1 = frame1;
        this.ll11 = ll11;
        this.progress1 = progress1;
        this.textView2 = textView2;
        this.textView3 = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySplashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySplashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_splash, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivitySplashBinding bind(View rootView) {
        int id = C0594R.id.frame1;
        ImageView frame1 = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.frame1);
        if (frame1 != null) {
            id = C0594R.id.ll11;
            LinearLayout ll11 = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll11);
            if (ll11 != null) {
                id = C0594R.id.progress1;
                ProgressBar progress1 = (ProgressBar) ViewBindings.findChildViewById(rootView, C0594R.id.progress1);
                if (progress1 != null) {
                    id = C0594R.id.textView2;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textView2);
                    if (textView2 != null) {
                        id = C0594R.id.textView3;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textView3);
                        if (textView3 != null) {
                            return new ActivitySplashBinding((RelativeLayout) rootView, frame1, ll11, progress1, textView2, textView3);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}