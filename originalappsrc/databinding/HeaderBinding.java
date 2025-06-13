package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class HeaderBinding implements ViewBinding {
    public final ImageView imageView1;
    public final ImageView imgUploade;
    private final RelativeLayout rootView;

    private HeaderBinding(RelativeLayout rootView, ImageView imageView1, ImageView imgUploade) {
        this.rootView = rootView;
        this.imageView1 = imageView1;
        this.imgUploade = imgUploade;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HeaderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HeaderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static HeaderBinding bind(View rootView) {
        int id = C0594R.id.imageView1;
        ImageView imageView1 = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.imageView1);
        if (imageView1 != null) {
            id = C0594R.id.img_uploade;
            ImageView imgUploade = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.img_uploade);
            if (imgUploade != null) {
                return new HeaderBinding((RelativeLayout) rootView, imageView1, imgUploade);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}