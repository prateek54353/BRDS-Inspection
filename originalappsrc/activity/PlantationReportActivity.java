package bih.p003in.forestdept.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.adapter.PlantationReportAdapter;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.model.PlantationReportList;
import bih.p003in.forestdept.model.PlantationReportRequest;
import bih.p003in.forestdept.model.PlantationReportResponse;
import bih.p003in.forestdept.model.UserDetail;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import bih.p003in.forestdept.utility.Utiilties;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class PlantationReportActivity extends Activity implements AdapterView.OnItemSelectedListener {
    String DistrictCode;
    String Pacs_id;
    String _Role;
    PlantationReportAdapter adaptor_showedit_listDetail;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;
    String blockCode;
    Button btn_add_pond;
    Button btn_view_pond_map;
    DataBaseHelper dataBaseHelper;
    String device_id;
    ProgressDialog dialog;
    String ipaddress;
    ListView listView;
    String listid;
    LinearLayout ll_btn;
    String panchayatCode;
    Spinner spin_panchayat;
    TextView tv_Norecord;
    TextView tv_header;
    String userId;
    UserDetail userInfo;
    String UserID = "";
    String Dist_id = "";
    String Block_id = "";
    ArrayList<PlantationReportList> data = new ArrayList<>();
    String _encriptionKey = "";
    String AuthToken = "";
    String DeviceID = "";
    String IpAddress = "";
    String Role = "";

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_pond_report);
        this.listView = (ListView) findViewById(C0594R.id.listviewshow);
        this.tv_Norecord = (TextView) findViewById(C0594R.id.tv_Norecord);
        this.tv_header = (TextView) findViewById(C0594R.id.tv_header);
        this.dialog = new ProgressDialog(this);
        this.dataBaseHelper = new DataBaseHelper(this);
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        this.AuthToken = CommonPref.getUserDetails(this).getAuthtoken();
        this._encriptionKey = CommonPref.getUserDetails(this).get_encriptionKey();
        Intent intent = getIntent();
        this.userId = intent.getStringExtra("userId");
        this.DistrictCode = CommonPref.getLoggedUserDetails(this).getDistrictCode();
        this.blockCode = CommonPref.getLoggedUserDetails(this).getBlockCode();
        this.panchayatCode = CommonPref.getLoggedUserDetails(this).getPanchayatCode();
        this.Role = CommonPref.getLoggedUserDetails(this).getUserrole();
        Log.e("userID", this.userId);
        this.UserID = this.aes256CbcEncryptDecrypt.Encrypt(CommonPref.getLoggedUserDetails(this).getDistrictCode(), this._encriptionKey);
        this.Dist_id = this.aes256CbcEncryptDecrypt.Encrypt(CommonPref.getLoggedUserDetails(this).getDistrictCode(), this._encriptionKey);
        this.Block_id = this.aes256CbcEncryptDecrypt.Encrypt(CommonPref.getLoggedUserDetails(this).getBlockCode(), this._encriptionKey);
        this.Pacs_id = this.aes256CbcEncryptDecrypt.Encrypt(CommonPref.getLoggedUserDetails(this).getPanchayatCode(), this._encriptionKey);
        this._Role = this.aes256CbcEncryptDecrypt.Encrypt(CommonPref.getLoggedUserDetails(this).getUserrole(), this._encriptionKey);
        this.device_id = Utiilties.getDeviceIMEI(this);
        this.ipaddress = Utiilties.getLocalIpAddress();
        this.DeviceID = this.aes256CbcEncryptDecrypt.Encrypt(this.device_id, this._encriptionKey);
        this.IpAddress = this.aes256CbcEncryptDecrypt.Encrypt(this.ipaddress, this._encriptionKey);
        this.tv_Norecord.setVisibility(8);
        if (Utiilties.isOnline(this)) {
            if (!this.Role.equalsIgnoreCase("")) {
                if (this.Role.equalsIgnoreCase("DSTPO") || this.Role.equalsIgnoreCase("DSTAE") || this.Role.equalsIgnoreCase("DSTEE") || this.Role.equalsIgnoreCase("DSTDRDA") || this.Role.equalsIgnoreCase("DSTDDC")) {
                    FetchPlantationReport(this.UserID, this._Role, this.Dist_id, "", "", this.DeviceID, this.IpAddress);
                } else if (this.Role.equalsIgnoreCase("BLKPO") || this.Role.equalsIgnoreCase("BLKJE") || this.Role.equalsIgnoreCase("BLKPTA")) {
                    FetchPlantationReport(this.UserID, this._Role, this.Dist_id, this.Block_id, "", this.DeviceID, this.IpAddress);
                } else if (this.Role.equalsIgnoreCase("PANADM")) {
                    FetchPlantationReport(this.UserID, this._Role, this.Dist_id, this.Block_id, this.Pacs_id, this.DeviceID, this.IpAddress);
                }
            } else {
                Toast.makeText(this, "Role Not Found", 0).show();
            }
        } else {
            Toast.makeText(this, C0594R.string.no_internet_connection, 0).show();
        }
        if (this.userInfo == null) {
            getUserDetail();
        } else {
            Toast.makeText(this, "User Detail Null", 0).show();
        }
    }

    private void getUserDetail() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String username = prefs.getString("uid", "user");
        this.userInfo = this.dataBaseHelper.getUserDetails(username, "");
    }

    public void chk_msg_save(String msg) {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setCancelable(false);
        ab.setIcon(C0594R.drawable.logo1);
        ab.setTitle("Data Saved");
        ab.setMessage(C0594R.string.no_internet_connection);
        Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(false);
        ab.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.PlantationReportActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int whichButton) {
                dialog2.dismiss();
            }
        });
        ab.show();
    }

    public void populateLocalData() {
        if (this.data.size() > 0) {
            this.tv_header.setText("वृक्षारोपण उत्तरजीविता प्रतिवेदन का रिपोर्ट  (" + this.data.size() + ")");
            this.tv_Norecord.setVisibility(8);
            this.listView.setVisibility(0);
            this.listView.invalidate();
            PlantationReportAdapter plantationReportAdapter = new PlantationReportAdapter(this, this.data);
            this.adaptor_showedit_listDetail = plantationReportAdapter;
            this.listView.setAdapter((ListAdapter) plantationReportAdapter);
            return;
        }
        this.listView.setVisibility(8);
        this.tv_Norecord.setVisibility(0);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ArrayList<PlantationReportList> arrayList = this.data;
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                this.tv_Norecord.setVisibility(8);
                this.listView.setVisibility(0);
                this.listView.invalidate();
                PlantationReportAdapter plantationReportAdapter = new PlantationReportAdapter(this, this.data);
                this.adaptor_showedit_listDetail = plantationReportAdapter;
                this.listView.setAdapter((ListAdapter) plantationReportAdapter);
                return;
            }
            this.listView.setVisibility(8);
            this.tv_Norecord.setVisibility(0);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void FetchPlantationReport(String userId, String role, String districtCode, String blockCode, String panchayatCode, String deviceid, String ipaddress) {
        this.dialog.show();
        this.dialog.setMessage("वृक्षारोपण का रिपोर्ट लोड हो रहा है...");
        PlantationReportRequest plantationrequest = new PlantationReportRequest(userId, role, districtCode, blockCode, panchayatCode, deviceid, ipaddress);
        Call<PlantationReportResponse> call = ApiCall.getService().getPlantationReport(this.AuthToken, plantationrequest);
        call.enqueue(new Callback<PlantationReportResponse>() { // from class: bih.in.forestdept.activity.PlantationReportActivity.2
            @Override // retrofit2.Callback
            public void onResponse(Call<PlantationReportResponse> call2, Response<PlantationReportResponse> response) {
                if (PlantationReportActivity.this.dialog != null) {
                    PlantationReportActivity.this.dialog.dismiss();
                }
                if (response.body() != null) {
                    if (response.body().getStatus().booleanValue()) {
                        ArrayList<PlantationReportList> reportLists = new ArrayList<>();
                        if (reportLists.size() > 0) {
                            for (int i = 0; i < response.body().getData().size(); i++) {
                                reportLists.add(new PlantationReportList(response.body().getData().get(i), PlantationReportActivity.this));
                            }
                            PlantationReportActivity.this.populateLocalData();
                            return;
                        }
                        Toast.makeText(PlantationReportActivity.this.getApplicationContext(), "कोई रिकॉर्ड अपलोड नहीं हुआ है", 0).show();
                        PlantationReportActivity.this.listView.setVisibility(8);
                        PlantationReportActivity.this.tv_Norecord.setVisibility(0);
                        return;
                    }
                    Toast.makeText(PlantationReportActivity.this, response.body().getMsg(), 0).show();
                    return;
                }
                Toast.makeText(PlantationReportActivity.this, response.body().getMsg(), 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PlantationReportResponse> call2, Throwable t) {
                if (PlantationReportActivity.this.dialog != null) {
                    PlantationReportActivity.this.dialog.dismiss();
                }
            }
        });
    }
}