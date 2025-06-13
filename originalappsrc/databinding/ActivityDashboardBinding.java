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
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes9.dex */
public final class ActivityDashboardBinding implements ViewBinding {
    public final Button btnLogout;
    public final Button btnSyncManrega;
    public final Button btnSyncOther;
    public final Button btnSyncPanchayat;
    public final Button btnSyncPond;
    public final Button btnSyncWell;
    public final FooterBinding footer;
    public final HeaderBinding header;
    public final ImageView ivPlantationDrpdwn;
    public final ImageView ivSync;
    public final LinearLayout linlayoutLogout;
    public final LinearLayout linlayoutSync;
    public final LinearLayout llBlock;
    public final LinearLayout llHeading;
    public final LinearLayout llOthArea;
    public final LinearLayout llPanchayat;
    public final LinearLayout llPlantationClick;
    public final LinearLayout llPlantationReportData;
    public final LinearLayout llPlantationUpload;
    public final LinearLayout llPlantatoinMenu;
    public final MaterialCardView mcvOtherAreaIncharge;
    public final TextView pendingSudharPlantation;
    public final TextView pendingUploadPond;
    public final LinearLayout plantatoinListLayout;
    public final TextView pondtextView;
    public final RelativeLayout rlSyncData;
    private final RelativeLayout rootView;
    public final TextView tvBlock;
    public final TextView tvBlockOth;
    public final TextView tvChangePassword;
    public final TextView tvDistrict;
    public final TextView tvDistrictOth;
    public final TextView tvLoadOthData;
    public final TextView tvPanchayat;
    public final TextView tvPanchayatOth;
    public final TextView tvRole;
    public final TextView tvUserName;
    public final TextView txtVersion;

    private ActivityDashboardBinding(RelativeLayout rootView, Button btnLogout, Button btnSyncManrega, Button btnSyncOther, Button btnSyncPanchayat, Button btnSyncPond, Button btnSyncWell, FooterBinding footer, HeaderBinding header, ImageView ivPlantationDrpdwn, ImageView ivSync, LinearLayout linlayoutLogout, LinearLayout linlayoutSync, LinearLayout llBlock, LinearLayout llHeading, LinearLayout llOthArea, LinearLayout llPanchayat, LinearLayout llPlantationClick, LinearLayout llPlantationReportData, LinearLayout llPlantationUpload, LinearLayout llPlantatoinMenu, MaterialCardView mcvOtherAreaIncharge, TextView pendingSudharPlantation, TextView pendingUploadPond, LinearLayout plantatoinListLayout, TextView pondtextView, RelativeLayout rlSyncData, TextView tvBlock, TextView tvBlockOth, TextView tvChangePassword, TextView tvDistrict, TextView tvDistrictOth, TextView tvLoadOthData, TextView tvPanchayat, TextView tvPanchayatOth, TextView tvRole, TextView tvUserName, TextView txtVersion) {
        this.rootView = rootView;
        this.btnLogout = btnLogout;
        this.btnSyncManrega = btnSyncManrega;
        this.btnSyncOther = btnSyncOther;
        this.btnSyncPanchayat = btnSyncPanchayat;
        this.btnSyncPond = btnSyncPond;
        this.btnSyncWell = btnSyncWell;
        this.footer = footer;
        this.header = header;
        this.ivPlantationDrpdwn = ivPlantationDrpdwn;
        this.ivSync = ivSync;
        this.linlayoutLogout = linlayoutLogout;
        this.linlayoutSync = linlayoutSync;
        this.llBlock = llBlock;
        this.llHeading = llHeading;
        this.llOthArea = llOthArea;
        this.llPanchayat = llPanchayat;
        this.llPlantationClick = llPlantationClick;
        this.llPlantationReportData = llPlantationReportData;
        this.llPlantationUpload = llPlantationUpload;
        this.llPlantatoinMenu = llPlantatoinMenu;
        this.mcvOtherAreaIncharge = mcvOtherAreaIncharge;
        this.pendingSudharPlantation = pendingSudharPlantation;
        this.pendingUploadPond = pendingUploadPond;
        this.plantatoinListLayout = plantatoinListLayout;
        this.pondtextView = pondtextView;
        this.rlSyncData = rlSyncData;
        this.tvBlock = tvBlock;
        this.tvBlockOth = tvBlockOth;
        this.tvChangePassword = tvChangePassword;
        this.tvDistrict = tvDistrict;
        this.tvDistrictOth = tvDistrictOth;
        this.tvLoadOthData = tvLoadOthData;
        this.tvPanchayat = tvPanchayat;
        this.tvPanchayatOth = tvPanchayatOth;
        this.tvRole = tvRole;
        this.tvUserName = tvUserName;
        this.txtVersion = txtVersion;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDashboardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityDashboardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C0594R.layout.activity_dashboard, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityDashboardBinding bind(View rootView) {
        int id = C0594R.id.btn_logout;
        Button btnLogout = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_logout);
        if (btnLogout != null) {
            id = C0594R.id.btn_sync_manrega;
            Button btnSyncManrega = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_sync_manrega);
            if (btnSyncManrega != null) {
                id = C0594R.id.btn_sync_other;
                Button btnSyncOther = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_sync_other);
                if (btnSyncOther != null) {
                    id = C0594R.id.btn_sync_panchayat;
                    Button btnSyncPanchayat = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_sync_panchayat);
                    if (btnSyncPanchayat != null) {
                        id = C0594R.id.btn_sync_pond;
                        Button btnSyncPond = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_sync_pond);
                        if (btnSyncPond != null) {
                            id = C0594R.id.btn_sync_well;
                            Button btnSyncWell = (Button) ViewBindings.findChildViewById(rootView, C0594R.id.btn_sync_well);
                            if (btnSyncWell != null) {
                                id = C0594R.id.footer;
                                View footer = ViewBindings.findChildViewById(rootView, C0594R.id.footer);
                                if (footer != null) {
                                    FooterBinding binding_footer = FooterBinding.bind(footer);
                                    id = C0594R.id.header;
                                    View header = ViewBindings.findChildViewById(rootView, C0594R.id.header);
                                    if (header != null) {
                                        HeaderBinding binding_header = HeaderBinding.bind(header);
                                        id = C0594R.id.iv_plantation_drpdwn;
                                        ImageView ivPlantationDrpdwn = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.iv_plantation_drpdwn);
                                        if (ivPlantationDrpdwn != null) {
                                            id = C0594R.id.iv_sync;
                                            ImageView ivSync = (ImageView) ViewBindings.findChildViewById(rootView, C0594R.id.iv_sync);
                                            if (ivSync != null) {
                                                id = C0594R.id.linlayout_logout;
                                                LinearLayout linlayoutLogout = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.linlayout_logout);
                                                if (linlayoutLogout != null) {
                                                    id = C0594R.id.linlayout_sync;
                                                    LinearLayout linlayoutSync = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.linlayout_sync);
                                                    if (linlayoutSync != null) {
                                                        id = C0594R.id.ll_block;
                                                        LinearLayout llBlock = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_block);
                                                        if (llBlock != null) {
                                                            id = C0594R.id.ll_heading;
                                                            LinearLayout llHeading = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_heading);
                                                            if (llHeading != null) {
                                                                id = C0594R.id.ll_oth_area;
                                                                LinearLayout llOthArea = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_oth_area);
                                                                if (llOthArea != null) {
                                                                    id = C0594R.id.ll_panchayat;
                                                                    LinearLayout llPanchayat = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_panchayat);
                                                                    if (llPanchayat != null) {
                                                                        id = C0594R.id.ll_plantation_click;
                                                                        LinearLayout llPlantationClick = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_plantation_click);
                                                                        if (llPlantationClick != null) {
                                                                            id = C0594R.id.ll_plantation_report_data;
                                                                            LinearLayout llPlantationReportData = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_plantation_report_data);
                                                                            if (llPlantationReportData != null) {
                                                                                id = C0594R.id.ll_plantation_upload;
                                                                                LinearLayout llPlantationUpload = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_plantation_upload);
                                                                                if (llPlantationUpload != null) {
                                                                                    id = C0594R.id.ll_plantatoin_menu;
                                                                                    LinearLayout llPlantatoinMenu = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.ll_plantatoin_menu);
                                                                                    if (llPlantatoinMenu != null) {
                                                                                        id = C0594R.id.mcv_other_area_incharge;
                                                                                        MaterialCardView mcvOtherAreaIncharge = (MaterialCardView) ViewBindings.findChildViewById(rootView, C0594R.id.mcv_other_area_incharge);
                                                                                        if (mcvOtherAreaIncharge != null) {
                                                                                            id = C0594R.id.pending_sudhar_plantation;
                                                                                            TextView pendingSudharPlantation = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.pending_sudhar_plantation);
                                                                                            if (pendingSudharPlantation != null) {
                                                                                                id = C0594R.id.pending_upload_pond;
                                                                                                TextView pendingUploadPond = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.pending_upload_pond);
                                                                                                if (pendingUploadPond != null) {
                                                                                                    id = C0594R.id.plantatoin_list_layout;
                                                                                                    LinearLayout plantatoinListLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, C0594R.id.plantatoin_list_layout);
                                                                                                    if (plantatoinListLayout != null) {
                                                                                                        id = C0594R.id.pondtextView;
                                                                                                        TextView pondtextView = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.pondtextView);
                                                                                                        if (pondtextView != null) {
                                                                                                            id = C0594R.id.rl_sync_data;
                                                                                                            RelativeLayout rlSyncData = (RelativeLayout) ViewBindings.findChildViewById(rootView, C0594R.id.rl_sync_data);
                                                                                                            if (rlSyncData != null) {
                                                                                                                id = C0594R.id.tv_block;
                                                                                                                TextView tvBlock = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_block);
                                                                                                                if (tvBlock != null) {
                                                                                                                    id = C0594R.id.tv_block_oth;
                                                                                                                    TextView tvBlockOth = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_block_oth);
                                                                                                                    if (tvBlockOth != null) {
                                                                                                                        id = C0594R.id.tv_change_password;
                                                                                                                        TextView tvChangePassword = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_change_password);
                                                                                                                        if (tvChangePassword != null) {
                                                                                                                            id = C0594R.id.tv_district;
                                                                                                                            TextView tvDistrict = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_district);
                                                                                                                            if (tvDistrict != null) {
                                                                                                                                id = C0594R.id.tv_district_oth;
                                                                                                                                TextView tvDistrictOth = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_district_oth);
                                                                                                                                if (tvDistrictOth != null) {
                                                                                                                                    id = C0594R.id.tv_load_oth_data;
                                                                                                                                    TextView tvLoadOthData = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_load_oth_data);
                                                                                                                                    if (tvLoadOthData != null) {
                                                                                                                                        id = C0594R.id.tv_panchayat;
                                                                                                                                        TextView tvPanchayat = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_panchayat);
                                                                                                                                        if (tvPanchayat != null) {
                                                                                                                                            id = C0594R.id.tv_panchayat_oth;
                                                                                                                                            TextView tvPanchayatOth = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_panchayat_oth);
                                                                                                                                            if (tvPanchayatOth != null) {
                                                                                                                                                id = C0594R.id.tv_role;
                                                                                                                                                TextView tvRole = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_role);
                                                                                                                                                if (tvRole != null) {
                                                                                                                                                    id = C0594R.id.tv_userName;
                                                                                                                                                    TextView tvUserName = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.tv_userName);
                                                                                                                                                    if (tvUserName != null) {
                                                                                                                                                        id = C0594R.id.txtVersion;
                                                                                                                                                        TextView txtVersion = (TextView) ViewBindings.findChildViewById(rootView, C0594R.id.txtVersion);
                                                                                                                                                        if (txtVersion != null) {
                                                                                                                                                            return new ActivityDashboardBinding((RelativeLayout) rootView, btnLogout, btnSyncManrega, btnSyncOther, btnSyncPanchayat, btnSyncPond, btnSyncWell, binding_footer, binding_header, ivPlantationDrpdwn, ivSync, linlayoutLogout, linlayoutSync, llBlock, llHeading, llOthArea, llPanchayat, llPlantationClick, llPlantationReportData, llPlantationUpload, llPlantatoinMenu, mcvOtherAreaIncharge, pendingSudharPlantation, pendingUploadPond, plantatoinListLayout, pondtextView, rlSyncData, tvBlock, tvBlockOth, tvChangePassword, tvDistrict, tvDistrictOth, tvLoadOthData, tvPanchayat, tvPanchayatOth, tvRole, tvUserName, txtVersion);
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