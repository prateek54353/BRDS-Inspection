package bih.p003in.forestdept.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.model.OtherAreaInchargeList;
import bih.p003in.forestdept.model.OtherAreaInchargeRequest;
import bih.p003in.forestdept.model.OtherAreaInchargeResponse;
import bih.p003in.forestdept.model.PanchayatList;
import bih.p003in.forestdept.model.PanchayatRequest;
import bih.p003in.forestdept.model.PanchayatResponse;
import bih.p003in.forestdept.model.PlantationDetailList;
import bih.p003in.forestdept.model.PlantationDetailRequest;
import bih.p003in.forestdept.model.PlantationDetailsResponse;
import bih.p003in.forestdept.model.PlantationSiteList;
import bih.p003in.forestdept.model.PlantationSiteResponse;
import bih.p003in.forestdept.model.SessionLogoutResponse;
import bih.p003in.forestdept.model.TokencheckResponse;
import bih.p003in.forestdept.model.UserDetail;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import bih.p003in.forestdept.utility.Utiilties;
import com.google.android.material.card.MaterialCardView;
import com.scottyab.rootbeer.RootBeer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class DashboardActivity extends Activity implements View.OnClickListener {
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;
    Button btn_logout;
    DataBaseHelper dataBaseHelper;
    String device_id;
    private ProgressDialog dialog;
    String ipaddress;
    ImageView iv_plantation_drpdwn;
    LinearLayout ll_block;
    LinearLayout ll_oth_area;
    LinearLayout ll_panchayat;
    LinearLayout ll_plantation_click;
    LinearLayout ll_plantation_report_data;
    LinearLayout ll_plantation_upload;
    LinearLayout ll_plantatoin_menu;
    MaterialCardView mcv_other_area_incharge;
    String mergedParams;
    TextView pending_sudhar_plantation;
    TextView pending_upload_pond;
    LinearLayout plantatoin_list_layout;
    RelativeLayout rl_sync_data;
    TextView tv_block;
    TextView tv_block_oth;
    TextView tv_change_password;
    TextView tv_district;
    TextView tv_district_oth;
    TextView tv_load_oth_data;
    TextView tv_panchayat;
    TextView tv_panchayat_oth;
    TextView tv_role;
    TextView tv_userName;
    UserDetail userInfo;
    Boolean isShowPlantation = true;
    ArrayList<OtherAreaInchargeList> areaList = new ArrayList<>();
    OtherAreaInchargeList selectedOtherArea = new OtherAreaInchargeList();
    Boolean isAreaSelected = false;
    String _encriptionKey = "";
    String AuthToken = "";
    String UserID = "";
    String Dist_id = "";
    String Block_id = "";
    String Pacs_id = "";
    String Role = "";
    String DeviceID = "";
    String IpAddress = "";
    RootBeer rootBeer = new RootBeer(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_dashboard);
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        this.AuthToken = CommonPref.getUserDetails(this).getAuthtoken();
        this._encriptionKey = CommonPref.getUserDetails(this).get_encriptionKey();
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.tv_change_password = (TextView) findViewById(C0594R.id.tv_change_password);
        this.ll_plantation_click = (LinearLayout) findViewById(C0594R.id.ll_plantation_click);
        this.ll_plantatoin_menu = (LinearLayout) findViewById(C0594R.id.ll_plantatoin_menu);
        this.plantatoin_list_layout = (LinearLayout) findViewById(C0594R.id.plantatoin_list_layout);
        this.ll_plantation_upload = (LinearLayout) findViewById(C0594R.id.ll_plantation_upload);
        this.ll_plantation_report_data = (LinearLayout) findViewById(C0594R.id.ll_plantation_report_data);
        this.ll_oth_area = (LinearLayout) findViewById(C0594R.id.ll_oth_area);
        this.rl_sync_data = (RelativeLayout) findViewById(C0594R.id.rl_sync_data);
        this.btn_logout = (Button) findViewById(C0594R.id.btn_logout);
        this.tv_userName = (TextView) findViewById(C0594R.id.tv_userName);
        this.pending_sudhar_plantation = (TextView) findViewById(C0594R.id.pending_sudhar_plantation);
        this.pending_upload_pond = (TextView) findViewById(C0594R.id.pending_upload_pond);
        this.iv_plantation_drpdwn = (ImageView) findViewById(C0594R.id.iv_plantation_drpdwn);
        this.tv_district = (TextView) findViewById(C0594R.id.tv_district);
        this.tv_block = (TextView) findViewById(C0594R.id.tv_block);
        this.tv_panchayat = (TextView) findViewById(C0594R.id.tv_panchayat);
        this.tv_role = (TextView) findViewById(C0594R.id.tv_role);
        this.tv_district_oth = (TextView) findViewById(C0594R.id.tv_district_oth);
        this.tv_block_oth = (TextView) findViewById(C0594R.id.tv_block_oth);
        this.tv_panchayat_oth = (TextView) findViewById(C0594R.id.tv_panchayat_oth);
        this.tv_load_oth_data = (TextView) findViewById(C0594R.id.tv_load_oth_data);
        this.mcv_other_area_incharge = (MaterialCardView) findViewById(C0594R.id.mcv_other_area_incharge);
        this.ll_block = (LinearLayout) findViewById(C0594R.id.ll_block);
        this.ll_panchayat = (LinearLayout) findViewById(C0594R.id.ll_panchayat);
        this.ll_plantation_click.setOnClickListener(this);
        this.plantatoin_list_layout.setOnClickListener(this);
        this.ll_plantation_upload.setOnClickListener(this);
        this.ll_plantation_report_data.setOnClickListener(this);
        this.rl_sync_data.setOnClickListener(this);
        this.dataBaseHelper = new DataBaseHelper(this);
        this.dialog = new ProgressDialog(this);
        this.mcv_other_area_incharge.setVisibility(8);
        this.ll_oth_area.setVisibility(8);
        this.tv_load_oth_data.setVisibility(8);
        if (this.rootBeer.isRooted()) {
            Utiilties.rootDevice(this);
        }
        if (this.userInfo != null) {
            Toast.makeText(this, "User Detail Null", 0).show();
        } else {
            getUserDetail();
        }
        this.btn_logout.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.DashboardActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DashboardActivity.this.logout();
            }
        });
        this.tv_change_password.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.DashboardActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DashboardActivity.this.startActivity(new Intent(DashboardActivity.this, (Class<?>) ChangePasswordActivity.class));
            }
        });
        showPending();
        handlePlantationMenu();
        setAppVersion();
    }

    public void setAppVersion() {
        try {
            String version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            TextView tv = (TextView) findViewById(C0594R.id.txtVersion);
            tv.setText(getResources().getString(C0594R.string.app_version) + " " + version);
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "Failed to get App Version", 0).show();
        }
    }

    private void showPending() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String user_ = prefs.getString("uid", "user");
        String plantaionCount = this.dataBaseHelper.getPlantationUpdatedDataCount(user_);
        this.pending_sudhar_plantation.setText(plantaionCount);
        if (Integer.parseInt(plantaionCount) > 0) {
            this.isShowPlantation = true;
            handlePlantationMenu();
        } else {
            this.pending_sudhar_plantation.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LogOut() {
        this.dialog.setMessage("Loading......");
        this.dialog.show();
        Call<List<SessionLogoutResponse>> call = ApiCall.getService().getSessionLogOut(this.AuthToken);
        call.enqueue(new Callback<List<SessionLogoutResponse>>() { // from class: bih.in.forestdept.activity.DashboardActivity.3
            @Override // retrofit2.Callback
            public void onResponse(Call<List<SessionLogoutResponse>> call2, Response<List<SessionLogoutResponse>> response) {
                response.body();
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body().get(0).getStatus().booleanValue()) {
                        Toast.makeText(DashboardActivity.this, "" + response.body().get(0).getMsg(), 0).show();
                        DashboardActivity.this.deletePref_and_Logout();
                    } else {
                        Toast.makeText(DashboardActivity.this, "" + response.body().get(0).getMsg(), 0).show();
                        DashboardActivity.this.deletePref_and_Logout();
                    }
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<List<SessionLogoutResponse>> call2, Throwable t) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                Toast.makeText(DashboardActivity.this.getApplicationContext(), t.getMessage(), 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePref_and_Logout() {
        SplashActivity.prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = SplashActivity.prefs.edit();
        editor.putBoolean("username", false);
        editor.putBoolean("password", false);
        editor.commit();
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.deleteAllPlantationRecord();
        Intent intent = new Intent(this, (Class<?>) LoginActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logout() {
        new AlertDialog.Builder(this).setTitle(C0594R.string.confirmation).setIcon(C0594R.drawable.headerbrds).setMessage("कृपया लॉगआउट करने से पहले सभी निरीक्षण रिकॉर्ड अपलोड कर लें, अन्यथा आप उन रिकॉर्ड को खो सकते हैं").setCancelable(false).setPositiveButton("हाँ", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.DashboardActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                DashboardActivity.this.LogOut();
            }
        }).setNegativeButton("नहीं", (DialogInterface.OnClickListener) null).show();
    }

    private void getUserDetail() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String username = prefs.getString("uid", "user");
        UserDetail userDetails = this.dataBaseHelper.getUserDetails(username, "");
        this.userInfo = userDetails;
        this.tv_userName.setText(userDetails.getName());
        this.tv_role.setText("विभाग: " + this.userInfo.getDepartment());
        if (this.userInfo.getUserrole().contains("STATEADM")) {
            this.tv_district.setVisibility(8);
            this.tv_block.setVisibility(8);
            this.tv_panchayat.setVisibility(8);
        } else if (this.userInfo.getUserrole().contains("STATE")) {
            this.tv_district.setVisibility(8);
            this.tv_block.setVisibility(8);
            this.tv_panchayat.setVisibility(8);
        } else if (this.userInfo.getUserrole().contains("DST")) {
            this.tv_district.setText("जिला: " + this.userInfo.getDistName());
            this.tv_district.setVisibility(0);
            this.tv_block.setVisibility(8);
            this.tv_panchayat.setVisibility(8);
        } else if (this.userInfo.getUserrole().contains("BLK")) {
            this.tv_district.setText("जिला: " + this.userInfo.getDistName());
            this.tv_block.setText("प्रखंड: " + this.userInfo.getBlockName());
            this.tv_panchayat.setVisibility(0);
            this.tv_block.setVisibility(0);
            this.tv_panchayat.setVisibility(8);
        } else if (this.userInfo.getUserrole().contains("PANADM")) {
            this.tv_district.setText("जिला: " + this.userInfo.getDistName());
            this.tv_block.setText("प्रखंड: " + this.userInfo.getBlockName());
            this.tv_panchayat.setText("पंचायत: " + this.userInfo.getPanchayatName());
            this.tv_district.setVisibility(0);
            this.tv_block.setVisibility(0);
            this.tv_panchayat.setVisibility(0);
        }
        this.device_id = Utiilties.getDeviceIMEI(this);
        this.ipaddress = Utiilties.getLocalIpAddress();
        this.DeviceID = this.aes256CbcEncryptDecrypt.Encrypt(this.device_id, this._encriptionKey);
        this.IpAddress = this.aes256CbcEncryptDecrypt.Encrypt(this.ipaddress, this._encriptionKey);
        this.Dist_id = this.aes256CbcEncryptDecrypt.Encrypt(this.userInfo.getDistrictCode(), this._encriptionKey);
        this.Block_id = this.aes256CbcEncryptDecrypt.Encrypt(this.userInfo.getBlockCode(), this._encriptionKey);
        this.Pacs_id = this.aes256CbcEncryptDecrypt.Encrypt(this.userInfo.getPanchayatCode(), this._encriptionKey);
        if (Utiilties.isOnline(this)) {
            SyncOtherAreaInchargeData();
        } else {
            Utiilties.showAlet(this);
        }
    }

    public void setOtherAreaDetail() {
        if (this.areaList.size() > 0) {
            this.mcv_other_area_incharge.setVisibility(0);
            updateOtherAreaSelected();
            if (!isSelectedAreaValid().booleanValue()) {
                this.isAreaSelected = false;
                SharedPreferences.Editor prefs = PreferenceManager.getDefaultSharedPreferences(this).edit();
                prefs.putBoolean("selectedArea", false);
                prefs.putString("_DistrictCode", "");
                prefs.putString("_DistrictName", "");
                prefs.putString("_BlockCode", "");
                prefs.putString("_BlockName", "");
                prefs.putString("_PanchayatCode", "");
                prefs.putString("_PanchayatName", "");
                prefs.commit();
                this.ll_oth_area.setVisibility(8);
                return;
            }
            return;
        }
        invalidateOtherArea();
    }

    public void invalidateOtherArea() {
        this.isAreaSelected = false;
        this.mcv_other_area_incharge.setVisibility(8);
        SharedPreferences.Editor prefs = PreferenceManager.getDefaultSharedPreferences(this).edit();
        prefs.putBoolean("selectedArea", false);
        prefs.remove("_DistrictCode");
        prefs.remove("_DistrictName");
        prefs.remove("_BlockCode");
        prefs.remove("_BlockName");
        prefs.remove("_PanchayatCode");
        prefs.remove("_PanchayatName");
        prefs.commit();
    }

    public void updateOtherAreaSelected() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean valueOf = Boolean.valueOf(prefs.getBoolean("selectedArea", false));
        this.isAreaSelected = valueOf;
        if (valueOf.booleanValue()) {
            OtherAreaInchargeList otherAreaInchargeList = new OtherAreaInchargeList();
            this.selectedOtherArea = otherAreaInchargeList;
            otherAreaInchargeList.set_DistrictCode(prefs.getString("_DistrictCode", ""));
            this.selectedOtherArea.set_DistrictName(prefs.getString("_DistrictName", "NA"));
            this.selectedOtherArea.set_BlockCode(prefs.getString("_BlockCode", ""));
            this.selectedOtherArea.set_BlockName(prefs.getString("_BlockName", "NA"));
            this.selectedOtherArea.set_PanchayatCode(prefs.getString("_PanchayatCode", ""));
            this.selectedOtherArea.set_PanchayatName(prefs.getString("_PanchayatName", "NA"));
            this.tv_district_oth.setText(this.selectedOtherArea.get_DistrictName());
            this.tv_block_oth.setText(this.selectedOtherArea.get_BlockName());
            this.tv_panchayat_oth.setText(this.selectedOtherArea.get_PanchayatName());
            this.ll_oth_area.setVisibility(0);
            String role = this.userInfo.getUserrole();
            if (role.equals("DSTPO") || role.equals("DSTAE") || role.equals("DSTEE") || role.equals("DSTDRDA") || role.equals("DSTDDC")) {
                this.ll_block.setVisibility(4);
                this.ll_panchayat.setVisibility(4);
                return;
            } else {
                if (role.equals("BLKPO") || role.equals("BLKJE") || role.equals("BLKPTA")) {
                    this.ll_panchayat.setVisibility(4);
                    return;
                }
                return;
            }
        }
        this.ll_oth_area.setVisibility(8);
    }

    public Boolean isSelectedAreaValid() {
        String role = this.userInfo.getUserrole();
        if (this.selectedOtherArea != null) {
            Iterator<OtherAreaInchargeList> it = this.areaList.iterator();
            while (it.hasNext()) {
                OtherAreaInchargeList area = it.next();
                if (role.equals("DSTPO") || role.equals("DSTAE") || role.equals("DSTEE") || role.equals("DSTDRDA") || role.equals("DSTDDC")) {
                    if (area.get_DistrictCode().equals(this.selectedOtherArea.get_DistrictCode())) {
                        return true;
                    }
                } else if (role.equals("BLKPO") || role.equals("BLKJE") || role.equals("BLKPTA")) {
                    if (area.get_DistrictCode().equals(this.selectedOtherArea.get_DistrictCode()) && area.get_BlockCode().equals(this.selectedOtherArea.get_BlockCode())) {
                        return true;
                    }
                } else if (area.get_DistrictCode().equals(this.selectedOtherArea.get_DistrictCode()) && area.get_BlockCode().equals(this.selectedOtherArea.get_BlockCode()) && area.get_PanchayatCode().equals(this.selectedOtherArea.get_PanchayatCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isDataValid() {
        if (this.isAreaSelected.booleanValue()) {
            OtherAreaInchargeList otherAreaInchargeList = this.selectedOtherArea;
            return (otherAreaInchargeList == null || otherAreaInchargeList.get_BlockCode() == null || this.selectedOtherArea.get_BlockCode().isEmpty() || this.selectedOtherArea.get_DistrictCode() == null || this.selectedOtherArea.get_DistrictCode().isEmpty() || this.selectedOtherArea.get_PanchayatCode() == null || this.selectedOtherArea.get_PanchayatCode().isEmpty()) ? false : true;
        }
        UserDetail userDetail = this.userInfo;
        return (userDetail == null || userDetail.getBlockCode() == null || this.userInfo.getBlockCode().isEmpty() || this.userInfo.getDistrictCode() == null || this.userInfo.getDistrictCode().isEmpty() || this.userInfo.getPanchayatCode() == null || this.userInfo.getPanchayatCode().isEmpty()) ? false : true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case C0594R.id.ll_plantation_click /* 2131231109 */:
                this.isShowPlantation = Boolean.valueOf(!this.isShowPlantation.booleanValue());
                handlePlantationMenu();
                break;
            case C0594R.id.ll_plantation_report_data /* 2131231110 */:
                Intent iReport = new Intent(this, (Class<?>) PlantationReportActivity.class);
                iReport.putExtra("userId", this.userInfo.getUserId());
                startActivity(iReport);
                break;
            case C0594R.id.ll_plantation_upload /* 2131231111 */:
                Intent iPondEdit = new Intent(this, (Class<?>) PlantationListEditActivity.class);
                iPondEdit.putExtra("UserID", this.userInfo.getUserId());
                startActivity(iPondEdit);
                break;
            case C0594R.id.plantatoin_list_layout /* 2131231252 */:
                Intent i = new Intent(this, (Class<?>) PlantationListActivity.class);
                if (this.isAreaSelected.booleanValue()) {
                    i.putExtra("blockCode", this.selectedOtherArea.get_BlockCode());
                    i.putExtra("DistrictCode", this.selectedOtherArea.get_DistrictCode());
                    i.putExtra("panchayatCode", this.selectedOtherArea.get_PanchayatCode());
                } else {
                    i.putExtra("blockCode", this.userInfo.getBlockCode());
                    i.putExtra("DistrictCode", this.userInfo.getDistrictCode());
                    i.putExtra("panchayatCode", this.userInfo.getPanchayatCode());
                }
                i.putExtra("userRole", this.userInfo.getUserrole());
                startActivity(i);
                break;
            case C0594R.id.rl_sync_data /* 2131231285 */:
                if (Utiilties.isOnline(this)) {
                    if (!this.userInfo.getUserrole().contains("STATEADM")) {
                        if (this.isAreaSelected.booleanValue()) {
                            new AlertDialog.Builder(this).setTitle("Sync Plantation Data").setMessage("Plantation data is syncing. This may take up to 5 minutes.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.DashboardActivity$$ExternalSyntheticLambda0
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    DashboardActivity.this.m302lambda$onClick$0$bihinforestdeptactivityDashboardActivity(dialogInterface, i2);
                                }
                            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.DashboardActivity$$ExternalSyntheticLambda1
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    dialogInterface.dismiss();
                                }
                            }).show();
                            break;
                        } else {
                            new AlertDialog.Builder(this).setTitle("Sync Plantation Data").setMessage("Plantation data is syncing. This may take up to 5 minutes.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.DashboardActivity$$ExternalSyntheticLambda2
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    DashboardActivity.this.m303lambda$onClick$2$bihinforestdeptactivityDashboardActivity(dialogInterface, i2);
                                }
                            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.DashboardActivity$$ExternalSyntheticLambda3
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    dialogInterface.dismiss();
                                }
                            }).show();
                            break;
                        }
                    } else {
                        SyncPanchayatData();
                        break;
                    }
                } else {
                    Utiilties.alertForInternet(this);
                    break;
                }
        }
    }

    /* renamed from: lambda$onClick$0$bih-in-forestdept-activity-DashboardActivity, reason: not valid java name */
    /* synthetic */ void m302lambda$onClick$0$bihinforestdeptactivityDashboardActivity(DialogInterface dialog, int which) {
        SyncPlantationData();
    }

    /* renamed from: lambda$onClick$2$bih-in-forestdept-activity-DashboardActivity, reason: not valid java name */
    /* synthetic */ void m303lambda$onClick$2$bihinforestdeptactivityDashboardActivity(DialogInterface dialog, int which) {
        SyncPlantationData();
    }

    private void handlePlantationMenu() {
        if (this.isShowPlantation.booleanValue()) {
            this.iv_plantation_drpdwn.setImageDrawable(getResources().getDrawable(C0594R.drawable.ic_arrow_drop_up_black_24dp));
            this.ll_plantatoin_menu.setVisibility(0);
        } else {
            this.iv_plantation_drpdwn.setImageDrawable(getResources().getDrawable(C0594R.drawable.ic_arrow_drop_down_black_24dp));
            this.ll_plantatoin_menu.setVisibility(8);
        }
    }

    public void onClickOtherArea(View view) {
        Intent intent = new Intent(this, (Class<?>) SelectOtherAreaActivity.class);
        intent.putExtra("data", this.areaList);
        startActivity(intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(C0594R.drawable.headerbrds).setTitle(C0594R.string.appTitle).setMessage("क्या आप एैप से बाहर निकलना चाहते हैं?").setCancelable(false).setPositiveButton(C0594R.string.yes, new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.DashboardActivity.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                DashboardActivity.this.finish();
            }
        }).setNegativeButton(C0594R.string.f129no, (DialogInterface.OnClickListener) null).show();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        get_TokenCheck();
        showPending();
        updateOtherAreaSelected();
    }

    private void get_TokenCheck() {
        this.dialog.setMessage("Loading......");
        this.dialog.show();
        Call<TokencheckResponse> call = ApiCall.getService().getTokenCheck(this.AuthToken);
        call.enqueue(new Callback<TokencheckResponse>() { // from class: bih.in.forestdept.activity.DashboardActivity.6
            @Override // retrofit2.Callback
            public void onResponse(Call<TokencheckResponse> call2, Response<TokencheckResponse> response) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body().getStatus().booleanValue()) {
                        Intent intent = new Intent(DashboardActivity.this, (Class<?>) LoginActivity.class);
                        intent.setFlags(268468224);
                        DashboardActivity.this.startActivity(intent);
                        Toast.makeText(DashboardActivity.this, response.body().getMsg(), 0).show();
                        return;
                    }
                    Toast.makeText(DashboardActivity.this, response.body().getMsg(), 0).show();
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<TokencheckResponse> call2, Throwable t) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
            }
        });
    }

    private String encryptField(String fieldValue) {
        return this.aes256CbcEncryptDecrypt.Encrypt(fieldValue, this._encriptionKey);
    }

    private void SyncPlantationData() {
        this.dialog.show();
        this.dialog.setMessage("Loading Plantation Data...");
        if (this.isAreaSelected.booleanValue()) {
            this.Dist_id = encryptField(this.selectedOtherArea.get_DistrictCode());
            this.Block_id = encryptField(this.selectedOtherArea.get_BlockCode());
            this.Pacs_id = encryptField(this.selectedOtherArea.get_PanchayatCode());
        } else {
            this.Dist_id = encryptField(this.userInfo.getDistrictCode());
            this.Block_id = encryptField(this.userInfo.getBlockCode());
            this.Pacs_id = encryptField(this.userInfo.getPanchayatCode());
        }
        this.Role = encryptField(this.userInfo.getUserrole());
        PlantationDetailRequest plantation_request = new PlantationDetailRequest(this.Dist_id, this.Block_id, this.Pacs_id, this.Role, this.DeviceID, this.IpAddress);
        Call<PlantationDetailsResponse> call = ApiCall.getService().getInitialRDDPlantationDetail(this.AuthToken, plantation_request);
        call.enqueue(new Callback<PlantationDetailsResponse>() { // from class: bih.in.forestdept.activity.DashboardActivity.7
            @Override // retrofit2.Callback
            public void onResponse(Call<PlantationDetailsResponse> call2, Response<PlantationDetailsResponse> response) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                String temp32Enc_key = CommonPref.getUserDetails(DashboardActivity.this).get_encriptionKey();
                if (response.code() == 200 && response.body().getStatus().booleanValue()) {
                    ArrayList<PlantationDetailList> data = new ArrayList<>();
                    if (!response.body().getData().isEmpty()) {
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            PlantationDetailList tempData = new PlantationDetailList(response.body().getData().get(i), temp32Enc_key);
                            data.add(tempData);
                        }
                        DashboardActivity.this.new SavePlantationDataToLocal(data).execute("");
                    }
                    DashboardActivity.this.SyncPanchayatData();
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PlantationDetailsResponse> call2, Throwable t) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                Toast.makeText(DashboardActivity.this.getApplicationContext(), t.getMessage(), 1).show();
            }
        });
    }

    private void SyncOtherAreaInchargeData() {
        this.dialog.show();
        this.dialog.setMessage("Loading Other Area Detail...");
        this.UserID = encryptField(this.userInfo.getUserId());
        OtherAreaInchargeRequest InchargeRequest = new OtherAreaInchargeRequest(this.UserID);
        Call<OtherAreaInchargeResponse> call = ApiCall.getService().getOtherAreaInchargeDetail(this.AuthToken, InchargeRequest);
        call.enqueue(new Callback<OtherAreaInchargeResponse>() { // from class: bih.in.forestdept.activity.DashboardActivity.8
            @Override // retrofit2.Callback
            public void onResponse(Call<OtherAreaInchargeResponse> call2, Response<OtherAreaInchargeResponse> response) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    try {
                        if (response.body().getStatus().booleanValue()) {
                            if (response.body().getData() != null) {
                                for (int i = 0; i < response.body().getData().size(); i++) {
                                    DashboardActivity.this.areaList.add(new OtherAreaInchargeList(response.body().getData().get(i), DashboardActivity.this.getApplicationContext()));
                                }
                                DashboardActivity.this.setOtherAreaDetail();
                                return;
                            }
                            Toast.makeText(DashboardActivity.this.getApplicationContext(), "No Data Found", 1).show();
                            return;
                        }
                        Toast.makeText(DashboardActivity.this, response.body().getMsg(), 0).show();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                Toast.makeText(DashboardActivity.this.getApplicationContext(), "Server Error", 1).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<OtherAreaInchargeResponse> call2, Throwable t) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                Toast.makeText(DashboardActivity.this.getApplicationContext(), t.getMessage(), 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SyncPanchayatData() {
        this.dialog.show();
        this.dialog.setMessage("Loading Panchayat...");
        PanchayatRequest panchayatRequest = new PanchayatRequest(this.Dist_id, this.Block_id);
        Call<PanchayatResponse> call = ApiCall.getService().getPanchayat(this.AuthToken, panchayatRequest);
        call.enqueue(new Callback<PanchayatResponse>() { // from class: bih.in.forestdept.activity.DashboardActivity.9
            @Override // retrofit2.Callback
            public void onResponse(Call<PanchayatResponse> call2, Response<PanchayatResponse> response) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                if (response.code() == 200 && response.body().getStatus().booleanValue()) {
                    ArrayList<PanchayatList> pdata = new ArrayList<>();
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        pdata.add(new PanchayatList(response.body().getData().get(i), DashboardActivity.this));
                    }
                    long i2 = DashboardActivity.this.dataBaseHelper.setPanchayatDataToLocal(DashboardActivity.this.userInfo, pdata);
                    if (i2 > 0) {
                        Toast.makeText(DashboardActivity.this.getApplicationContext(), "Panchayat Data Synced Successfully", 0).show();
                    } else {
                        Toast.makeText(DashboardActivity.this.getApplicationContext(), "Failed to update panchayat", 0).show();
                    }
                    DashboardActivity.this.SyncPlantationSiteData();
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PanchayatResponse> call2, Throwable t) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                Toast.makeText(DashboardActivity.this.getApplicationContext(), t.getMessage(), 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SyncPlantationSiteData() {
        this.dialog.setMessage("Loading...");
        this.dialog.show();
        Call<PlantationSiteResponse> call = ApiCall.getService().getPlantationSiteData(this.AuthToken);
        call.enqueue(new Callback<PlantationSiteResponse>() { // from class: bih.in.forestdept.activity.DashboardActivity.10
            @Override // retrofit2.Callback
            public void onResponse(Call<PlantationSiteResponse> call2, Response<PlantationSiteResponse> response) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                if (response.code() == 200 && response.body().getStatus().booleanValue()) {
                    ArrayList<PlantationSiteList> data = new ArrayList<>();
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        data.add(new PlantationSiteList(response.body().getData().get(i), DashboardActivity.this));
                    }
                    long i2 = DashboardActivity.this.dataBaseHelper.setPlantationSiteDataToLocal(data);
                    if (i2 > 0) {
                        Toast.makeText(DashboardActivity.this.getApplicationContext(), "Plantation Site Data Synced Successfully", 0).show();
                    } else {
                        Toast.makeText(DashboardActivity.this.getApplicationContext(), "Failed to update Plantation Site Data", 0).show();
                    }
                    PreferenceManager.getDefaultSharedPreferences(DashboardActivity.this.getApplicationContext()).edit().putBoolean("SyncPlantationData", true);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PlantationSiteResponse> call2, Throwable t) {
                if (DashboardActivity.this.dialog != null) {
                    DashboardActivity.this.dialog.dismiss();
                }
                Toast.makeText(DashboardActivity.this.getApplicationContext(), t.getMessage(), 1).show();
            }
        });
    }

    private class SavePlantationDataToLocal extends AsyncTask<String, Void, Long> {
        ArrayList<PlantationDetailList> data;

        SavePlantationDataToLocal(ArrayList<PlantationDetailList> data) {
            this.data = data;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            DashboardActivity.this.dialog.setCanceledOnTouchOutside(false);
            DashboardActivity.this.dialog.setMessage("Saving Data...");
            DashboardActivity.this.dialog.show();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Long doInBackground(String... strings) {
            DataBaseHelper helper = new DataBaseHelper(DashboardActivity.this.getApplicationContext());
            long i = helper.setPlantationDataToLocal(this.data);
            return Long.valueOf(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Long aLong) {
            if (DashboardActivity.this.dialog.isShowing()) {
                DashboardActivity.this.dialog.dismiss();
            }
            if (aLong.longValue() > 0) {
                Toast.makeText(DashboardActivity.this.getApplicationContext(), "Plantation Data Synced Successfully", 0).show();
            } else {
                Toast.makeText(DashboardActivity.this.getApplicationContext(), "कोई डेटा नहीं मिला!", 0).show();
            }
        }
    }
}