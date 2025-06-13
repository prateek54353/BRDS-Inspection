package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ActivityMultiplePhotoBinding implements ViewBinding {
    public final Button btnOk;
    public final FooterBinding footer;
    public final ImageView imageButton1;
    public final ImageView imageButton2;
    public final ImageView imageButton3;
    public final ImageView imageButton4;
    public final ImageView imageButton5;
    public final LinearLayout linearLayout1;
    public final LinearLayout linearLayout2;
    public final RelativeLayout reP2;
    private final RelativeLayout rootView;
    public final TextView textP1;

    private ActivityMultiplePhotoBinding(RelativeLayout rootView, Button btnOk, FooterBinding footer, ImageView imageButton1, ImageView imageButton2, ImageView imageButton3, ImageView imageButton4, ImageView imageButton5, LinearLayout linearLayout1, LinearLayout linearLayout2, RelativeLayout reP2, TextView textP1) {
        this.rootView = rootView;
        this.btnOk = btnOk;
        this.footer = footer;
        this.imageButton1 = imageButton1;
        this.imageButton2 = imageButton2;
        this.imageButton3 = imageButton3;
        this.imageButton4 = imageButton4;
        this.imageButton5 = imageButton5;
        this.linearLayout1 = linearLayout1;
        this.linearLayout2 = linearLayout2;
        this.reP2 = reP2;
        this.textP1 = textP1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMultiplePhotoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMultiplePhotoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_multiple_photo, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMultiplePhotoBinding bind(View rootView) {
        int id = C0594R.id.btnOk;
        Button btnOk = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btnOk);
        if (btnOk != null) {
            id = C0594R.id.footer;
            View footer = ViewBindings.findChildViewById(rootView, C0594R.id.footer);
            if (footer != null) {
                FooterBinding binding_footer = FooterBinding.bind(footer);
                id = C0594R.id.imageButton1;
                ImageView imageButton1 = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.imageButton1);
                if (imageButton1 != null) {
                    id = C0594R.id.imageButton2;
                    ImageView imageButton2 = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.imageButton2);
                    if (imageButton2 != null) {
                        id = C0594R.id.imageButton3;
                        ImageView imageButton3 = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.imageButton3);
                        if (imageButton3 != null) {
                            id = C0594R.id.imageButton4;
                            ImageView imageButton4 = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.imageButton4);
                            if (imageButton4 != null) {
                                id = C0594R.id.imageButton5;
                                ImageView imageButton5 = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.imageButton5);
                                if (imageButton5 != null) {
                                    id = C0594R.id.linearLayout1;
                                    LinearLayout linearLayout1 = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.linearLayout1);
                                    if (linearLayout1 != null) {
                                        id = C0594R.id.linearLayout2;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.linearLayout2);
                                        if (linearLayout2 != null) {
                                            id = C0594R.id.re_p2;
                                            RelativeLayout reP2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, C0594R.id.re_p2);
                                            if (reP2 != null) {
                                                id = C0594R.id.text_p1;
                                                TextView textP1 = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.text_p1);
                                                if (textP1 != null) {
                                                    return new ActivityMultiplePhotoBinding((RelativeLayout) rootView, btnOk, binding_footer, imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, linearLayout1, linearLayout2, reP2, textP1);
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