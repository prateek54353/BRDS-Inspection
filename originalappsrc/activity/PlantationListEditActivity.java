package bih.p003in.forestdept.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.adapter.PlantationEditAdaptor;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.model.PlantationInspDetails_Request;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class PlantationListEditActivity extends Activity {
    PlantationEditAdaptor adaptor_showedit_listDetail;
    DataBaseHelper dataBaseHelper;
    ProgressDialog dialog;
    ListView listView;
    String listid;
    LinearLayout ll_panchayat;
    ArrayList<PlantationInspDetails_Request> plantationInspDetailsRequestArray_data;
    TextView tv_Norecord;
    TextView tv_title;
    String version = "";
    String userID = "";

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_pond_list_edit);
        this.listView = (ListView) findViewById(C0594R.id.listviewshow);
        this.tv_Norecord = (TextView) findViewById(C0594R.id.tv_Norecord);
        this.tv_title = (TextView) findViewById(C0594R.id.tv_title);
        Intent intent = getIntent();
        this.userID = intent.getStringExtra("UserID");
        this.dataBaseHelper = new DataBaseHelper(this);
        this.version = getAppVersion();
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.dialog.setMessage("Loading...");
        setReportListViewData();
        if (this.plantationInspDetailsRequestArray_data.size() > 0) {
            this.tv_Norecord.setVisibility(8);
            this.listView.setVisibility(0);
            this.listView.invalidate();
            PlantationEditAdaptor plantationEditAdaptor = new PlantationEditAdaptor(this, this.plantationInspDetailsRequestArray_data, this.version);
            this.adaptor_showedit_listDetail = plantationEditAdaptor;
            plantationEditAdaptor.dataBaseHelper = this.dataBaseHelper;
            this.listView.setAdapter((ListAdapter) this.adaptor_showedit_listDetail);
        } else {
            this.listView.setVisibility(8);
            this.tv_Norecord.setVisibility(0);
        }
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: bih.in.forestdept.activity.PlantationListEditActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    public String getAppVersion() {
        try {
            String version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void updateTitle() {
        this.tv_title.setText("जल संरचनाओं का सत्यापन/सर्वेक्षण  (" + this.plantationInspDetailsRequestArray_data.size() + ")");
    }

    private void removeFromAdapter(String position) {
        this.plantationInspDetailsRequestArray_data.remove(position);
        this.adaptor_showedit_listDetail.notifyDataSetChanged();
    }

    private void setReportListViewData() {
        this.plantationInspDetailsRequestArray_data = this.dataBaseHelper.getPlantationInspectionUpdatedDetail(this.userID);
        PlantationEditAdaptor plantationEditAdaptor = new PlantationEditAdaptor(this, this.plantationInspDetailsRequestArray_data, this.version);
        this.adaptor_showedit_listDetail = plantationEditAdaptor;
        this.listView.setAdapter((ListAdapter) plantationEditAdaptor);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.plantationInspDetailsRequestArray_data.size() > 0) {
            this.tv_Norecord.setVisibility(8);
            this.listView.setVisibility(0);
            this.listView.invalidate();
            PlantationEditAdaptor plantationEditAdaptor = new PlantationEditAdaptor(this, this.plantationInspDetailsRequestArray_data, this.version);
            this.adaptor_showedit_listDetail = plantationEditAdaptor;
            this.listView.setAdapter((ListAdapter) plantationEditAdaptor);
            return;
        }
        this.listView.setVisibility(8);
        this.tv_Norecord.setVisibility(0);
    }

    public void deletePondData() {
    }
}