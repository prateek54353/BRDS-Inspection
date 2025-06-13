package bih.p003in.forestDept.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes9.dex */
public final class ActivityCameraBinding implements ViewBinding {
    public final LinearLayout RelLayoutLat;
    public final LinearLayout RelLayoutLon;
    public final LinearLayout RelLayoutTimer;
    public final Button btnCamType;
    public final Button btnCapture;
    public final FrameLayout cameraPreview;
    public final Chronometer chronometer1;
    public final FooterBinding footer;
    public final ProgressBar progressFindingLocation;
    private final RelativeLayout rootView;
    public final TextView textLatLabel;
    public final TextView textLonLabel;
    public final TextView textTimerLabel;
    public final TextView tvAcuracy;
    public final TextView tvLat;
    public final TextView tvLon;

    private ActivityCameraBinding(RelativeLayout rootView, LinearLayout RelLayoutLat, LinearLayout RelLayoutLon, LinearLayout RelLayoutTimer, Button btnCamType, Button btnCapture, FrameLayout cameraPreview, Chronometer chronometer1, FooterBinding footer, ProgressBar progressFindingLocation, TextView textLatLabel, TextView textLonLabel, TextView textTimerLabel, TextView tvAcuracy, TextView tvLat, TextView tvLon) {
        this.rootView = rootView;
        this.RelLayoutLat = RelLayoutLat;
        this.RelLayoutLon = RelLayoutLon;
        this.RelLayoutTimer = RelLayoutTimer;
        this.btnCamType = btnCamType;
        this.btnCapture = btnCapture;
        this.cameraPreview = cameraPreview;
        this.chronometer1 = chronometer1;
        this.footer = footer;
        this.progressFindingLocation = progressFindingLocation;
        this.textLatLabel = textLatLabel;
        this.textLonLabel = textLonLabel;
        this.textTimerLabel = textTimerLabel;
        this.tvAcuracy = tvAcuracy;
        this.tvLat = tvLat;
        this.tvLon = tvLon;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCameraBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCameraBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_camera, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityCameraBinding bind(View rootView) {
        int id = C0594R.id.Rel_Layout_Lat;
        LinearLayout RelLayoutLat = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.Rel_Layout_Lat);
        if (RelLayoutLat != null) {
            id = C0594R.id.Rel_Layout_Lon;
            LinearLayout RelLayoutLon = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.Rel_Layout_Lon);
            if (RelLayoutLon != null) {
                id = C0594R.id.Rel_Layout_Timer;
                LinearLayout RelLayoutTimer = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.Rel_Layout_Timer);
                if (RelLayoutTimer != null) {
                    id = C0594R.id.btnCamType;
                    Button btnCamType = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btnCamType);
                    if (btnCamType != null) {
                        id = C0594R.id.btnCapture;
                        Button btnCapture = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btnCapture);
                        if (btnCapture != null) {
                            id = C0594R.id.camera_preview;
                            FrameLayout cameraPreview = (FrameLayout) ViewBindings.findChildViewById(rootView, C0594R.id.camera_preview);
                            if (cameraPreview != null) {
                                id = C0594R.id.chronometer1;
                                Chronometer chronometer1 = (Chronometer) ViewBindings.findChildViewById(rootView, C0594R.id.chronometer1);
                                if (chronometer1 != null) {
                                    id = C0594R.id.footer;
                                    View footer = ViewBindings.findChildViewById(rootView, C0594R.id.footer);
                                    if (footer != null) {
                                        FooterBinding binding_footer = FooterBinding.bind(footer);
                                        id = C0594R.id.progress_finding_location;
                                        ProgressBar progressFindingLocation = (ProgressBar) ViewBindings.findChildViewById(rootView, C0594R.id.progress_finding_location);
                                        if (progressFindingLocation != null) {
                                            id = C0594R.id.textLatLabel;
                                            TextView textLatLabel = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textLatLabel);
                                            if (textLatLabel != null) {
                                                id = C0594R.id.textLonLabel;
                                                TextView textLonLabel = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textLonLabel);
                                                if (textLonLabel != null) {
                                                    id = C0594R.id.textTimerLabel;
                                                    TextView textTimerLabel = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.textTimerLabel);
                                                    if (textTimerLabel != null) {
                                                        id = C0594R.id.tvAcuracy;
                                                        TextView tvAcuracy = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tvAcuracy);
                                                        if (tvAcuracy != null) {
                                                            id = C0594R.id.tvLat;
                                                            TextView tvLat = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tvLat);
                                                            if (tvLat != null) {
                                                                id = C0594R.id.tvLon;
                                                                TextView tvLon = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tvLon);
                                                                if (tvLon != null) {
                                                                    return new ActivityCameraBinding((RelativeLayout) rootView, RelLayoutLat, RelLayoutLon, RelLayoutTimer, btnCamType, btnCapture, cameraPreview, chronometer1, binding_footer, progressFindingLocation, textLatLabel, textLonLabel, textTimerLabel, tvAcuracy, tvLat, tvLon);
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