package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class GeotagItemBinding implements ViewBinding {
    public final TextView adTxtLat;
    public final TextView adTxtLong;
    public final TextView adTxtPlotno;
    public final ImageView iconDelete;
    public final TextView lblTxtChannelNo;
    public final TextView lblTxtPlotno;
    public final CardView rlUserInfo;
    private final RelativeLayout rootView;

    private GeotagItemBinding(RelativeLayout rootView, TextView adTxtLat, TextView adTxtLong, TextView adTxtPlotno, ImageView iconDelete, TextView lblTxtChannelNo, TextView lblTxtPlotno, CardView rlUserInfo) {
        this.rootView = rootView;
        this.adTxtLat = adTxtLat;
        this.adTxtLong = adTxtLong;
        this.adTxtPlotno = adTxtPlotno;
        this.iconDelete = iconDelete;
        this.lblTxtChannelNo = lblTxtChannelNo;
        this.lblTxtPlotno = lblTxtPlotno;
        this.rlUserInfo = rlUserInfo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static GeotagItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static GeotagItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.geotag_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static GeotagItemBinding bind(View rootView) {
        int id = C0594R.id.ad_txt_lat;
        TextView adTxtLat = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.ad_txt_lat);
        if (adTxtLat != null) {
            id = C0594R.id.ad_txt_long;
            TextView adTxtLong = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.ad_txt_long);
            if (adTxtLong != null) {
                id = C0594R.id.ad_txt_plotno;
                TextView adTxtPlotno = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.ad_txt_plotno);
                if (adTxtPlotno != null) {
                    id = C0594R.id.icon_delete;
                    ImageView iconDelete = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.icon_delete);
                    if (iconDelete != null) {
                        id = C0594R.id.lbl_txt_channelNo;
                        TextView lblTxtChannelNo = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.lbl_txt_channelNo);
                        if (lblTxtChannelNo != null) {
                            id = C0594R.id.lbl_txt_plotno;
                            TextView lblTxtPlotno = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.lbl_txt_plotno);
                            if (lblTxtPlotno != null) {
                                id = C0594R.id.rl_user_info;
                                CardView rlUserInfo = (CardView) ViewBindings.findChildViewById(rootView, C0594R.id.rl_user_info);
                                if (rlUserInfo != null) {
                                    return new GeotagItemBinding((RelativeLayout) rootView, adTxtLat, adTxtLong, adTxtPlotno, iconDelete, lblTxtChannelNo, lblTxtPlotno, rlUserInfo);
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