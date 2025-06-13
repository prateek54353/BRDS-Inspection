package bih.p003in.forestdept.activity;

import android.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.adapter.PlantationAdapter;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.entity.Block;
import bih.p003in.forestdept.entity.District;
import bih.p003in.forestdept.model.BlockList;
import bih.p003in.forestdept.model.BlockRequest;
import bih.p003in.forestdept.model.BlockResponse;
import bih.p003in.forestdept.model.DistrictList;
import bih.p003in.forestdept.model.DistrictResponse;
import bih.p003in.forestdept.model.PanchayatList;
import bih.p003in.forestdept.model.PanchayatRequest;
import bih.p003in.forestdept.model.PanchayatResponse;
import bih.p003in.forestdept.model.PlantationDetailList;
import bih.p003in.forestdept.model.PlantationDetailRequest;
import bih.p003in.forestdept.model.PlantationDetailsResponse;
import bih.p003in.forestdept.model.PlantationInspDetails_Request;
import bih.p003in.forestdept.model.SearchPlantationDetailRequest;
import bih.p003in.forestdept.model.UserDetail;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import bih.p003in.forestdept.utility.Config;
import bih.p003in.forestdept.utility.Utiilties;
import java.util.ArrayList;
import java.util.Iterator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class PlantationListActivity extends Activity implements AdapterView.OnItemSelectedListener {
    String Pacs_Code;
    String Role;
    PlantationAdapter adaptor_showedit_listDetail;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;
    String blockCode;
    String blockName;
    ArrayList<String> blockNameArray;
    ArrayAdapter<String> blockadapter;
    Button btn_add_pond;
    Button btn_search;
    Button btn_view_pond_map;
    ArrayList<PlantationInspDetails_Request> data;
    DataBaseHelper dataBaseHelper;
    ProgressDialog dialog;
    String districtCode;
    String districtName;
    ArrayList<String> districtNameArray;
    ArrayAdapter<String> districtadapter;
    EditText et_work_code;
    ListView listView;
    LinearLayout ll_block_section;
    LinearLayout ll_btn;
    LinearLayout ll_district_section;
    LinearLayout ll_panchayat_section;
    LinearLayout ll_work_Code;
    String panchayatCode;
    ArrayList<String> panchayatNameArray;
    ArrayAdapter<String> panchayatadapter;
    Spinner spin_block;
    Spinner spin_district;
    Spinner spin_panchayat;
    TextView tv_Norecord;
    TextView tv_header;
    UserDetail userInfo;
    String userRole;
    String user_ID;
    ArrayList<Block> blockList = new ArrayList<>();
    ArrayList<District> districtList = new ArrayList<>();
    ArrayList<PanchayatList> panchayatList = new ArrayList<>();
    String AuthToken = "";
    String _encriptionKey = "";
    String Dist_Code = "";
    String Block_Code = "";
    String panchayatName = "";

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_plantation_list);
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        this.AuthToken = CommonPref.getUserDetails(this).getAuthtoken();
        this._encriptionKey = CommonPref.getUserDetails(this).get_encriptionKey();
        this.dialog = new ProgressDialog(this);
        this.listView = (ListView) findViewById(C0594R.id.listviewshow);
        this.tv_Norecord = (TextView) findViewById(C0594R.id.tv_Norecord);
        this.tv_header = (TextView) findViewById(C0594R.id.tv_header);
        LinearLayout linearLayout = (LinearLayout) findViewById(C0594R.id.ll_work_Code);
        this.ll_work_Code = linearLayout;
        linearLayout.setVisibility(8);
        this.et_work_code = (EditText) findViewById(C0594R.id.et_work_code);
        this.btn_search = (Button) findViewById(C0594R.id.btn_search);
        this.spin_block = (Spinner) findViewById(C0594R.id.spin_block);
        this.spin_panchayat = (Spinner) findViewById(C0594R.id.spin_panchayat);
        this.spin_district = (Spinner) findViewById(C0594R.id.spin_district);
        this.ll_district_section = (LinearLayout) findViewById(C0594R.id.ll_district_section);
        this.ll_block_section = (LinearLayout) findViewById(C0594R.id.ll_block_section);
        this.ll_panchayat_section = (LinearLayout) findViewById(C0594R.id.ll_panchayat_section);
        this.spin_block.setOnItemSelectedListener(this);
        this.spin_panchayat.setOnItemSelectedListener(this);
        this.spin_district.setOnItemSelectedListener(this);
        DistrictData();
        this.dataBaseHelper = new DataBaseHelper(this);
        Intent intent = getIntent();
        this.districtCode = intent.getStringExtra("DistrictCode");
        this.blockCode = intent.getStringExtra("blockCode");
        this.panchayatCode = intent.getStringExtra("panchayatCode");
        this.userRole = intent.getStringExtra("userRole");
        this.Dist_Code = this.aes256CbcEncryptDecrypt.Encrypt(this.districtCode, this._encriptionKey);
        this.Block_Code = this.aes256CbcEncryptDecrypt.Encrypt(this.blockCode, this._encriptionKey);
        this.Pacs_Code = this.aes256CbcEncryptDecrypt.Encrypt(this.panchayatCode, this._encriptionKey);
        this.Role = this.aes256CbcEncryptDecrypt.Encrypt(this.userRole, this._encriptionKey);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String username = prefs.getString("uid", "user");
        String password = prefs.getString("pass", "password");
        this.userInfo = this.dataBaseHelper.getUserDetails(username.toLowerCase(), password);
        if (!this.userRole.contains("STATEADM")) {
            if (this.userRole.contains("STATE")) {
                loadDistrictSpinner();
                this.ll_district_section.setVisibility(0);
                this.ll_block_section.setVisibility(0);
                this.ll_panchayat_section.setVisibility(0);
            } else if (this.userRole.contains("DST")) {
                loadBlockSpinner();
                this.ll_district_section.setVisibility(8);
                this.ll_block_section.setVisibility(0);
                this.ll_panchayat_section.setVisibility(0);
            } else if (this.userRole.contains("BLK")) {
                loadPanchayatSpinner();
                this.ll_district_section.setVisibility(8);
                this.ll_block_section.setVisibility(8);
                this.ll_panchayat_section.setVisibility(0);
            } else if (this.userRole.contains("PANADM")) {
                populateLocalData();
                this.ll_district_section.setVisibility(8);
                this.ll_block_section.setVisibility(8);
                this.ll_panchayat_section.setVisibility(8);
            }
        }
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: bih.in.forestdept.activity.PlantationListActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(PlantationListActivity.this.getApplicationContext(), (Class<?>) PlantationInspectionActivity.class);
                PlantationInspDetails_Request detail = PlantationListActivity.this.data.get(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable("data", detail);
                i.putExtras(bundle);
                PlantationListActivity.this.startActivity(i);
            }
        });
        this.btn_search.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.PlantationListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlantationListActivity.this.m72x3b7410c6(view);
            }
        });
    }

    /* renamed from: lambda$onCreate$0$bih-in-forestdept-activity-PlantationListActivity */
    /* synthetic */ void m72x3b7410c6(View view) {
        Search_PlantationData(this.districtCode, this.blockCode, this.panchayatCode, this.userRole, this.et_work_code.getText().toString());
    }

    private void Search_PlantationData(String districtCode, String blockCode, String panchayatCode, String userRole, String workCode) {
        this.dialog.show();
        this.dialog.setMessage("Wait...");
        String _DistID = this.aes256CbcEncryptDecrypt.Encrypt(districtCode, this._encriptionKey);
        String _BlockId = this.aes256CbcEncryptDecrypt.Encrypt(blockCode, this._encriptionKey);
        String _PacsId = this.aes256CbcEncryptDecrypt.Encrypt(panchayatCode, this._encriptionKey);
        String _Role = this.aes256CbcEncryptDecrypt.Encrypt(userRole, this._encriptionKey);
        String _WorkCode = this.aes256CbcEncryptDecrypt.Encrypt(workCode, this._encriptionKey);
        String _DeviceID = this.aes256CbcEncryptDecrypt.Encrypt(Utiilties.getDeviceIMEI(this), this._encriptionKey);
        String _IpAddress = this.aes256CbcEncryptDecrypt.Encrypt(Utiilties.getLocalIpAddress(), this._encriptionKey);
        SearchPlantationDetailRequest request = new SearchPlantationDetailRequest(_DistID, _BlockId, _PacsId, _Role, _WorkCode, _DeviceID, _IpAddress);
        Call<PlantationDetailsResponse> call = ApiCall.getService().getInitialDetailRDDPlantation_New_WithWorkCode(this.AuthToken, request);
        call.enqueue(new Callback<PlantationDetailsResponse>() { // from class: bih.in.forestdept.activity.PlantationListActivity.2
            @Override // retrofit2.Callback
            public void onResponse(Call<PlantationDetailsResponse> call2, Response<PlantationDetailsResponse> response) {
                if (PlantationListActivity.this.dialog != null) {
                    PlantationListActivity.this.dialog.dismiss();
                }
                String temp32Enc_key = CommonPref.getUserDetails(PlantationListActivity.this).get_encriptionKey();
                if (response.code() == 200) {
                    ArrayList<PlantationDetailList> data = new ArrayList<>();
                    if (!response.body().getStatus().booleanValue()) {
                        PlantationListActivity.this.setuprecyclerdata(data);
                        Toast.makeText(PlantationListActivity.this, response.body().getMsg(), 0).show();
                        return;
                    }
                    if (!response.body().getData().isEmpty()) {
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            PlantationDetailList tempData = new PlantationDetailList(response.body().getData().get(i), temp32Enc_key);
                            data.add(tempData);
                        }
                    }
                    PlantationListActivity.this.setuprecyclerdata(data);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PlantationDetailsResponse> call2, Throwable t) {
                if (PlantationListActivity.this.dialog != null) {
                    PlantationListActivity.this.dialog.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setuprecyclerdata(final ArrayList<PlantationDetailList> detailsLists) {
        runOnUiThread(new Runnable() { // from class: bih.in.forestdept.activity.PlantationListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = detailsLists;
                if (arrayList != null && arrayList.size() > 0) {
                    PlantationListActivity.this.tv_header.setText("वृक्षारोपण उत्तरजीविता प्रतिवेदन (" + PlantationListActivity.this.data.size() + ")");
                    PlantationListActivity.this.tv_Norecord.setVisibility(8);
                    ArrayList<PlantationInspDetails_Request> data_value = new ArrayList<>();
                    for (int i = 0; i < detailsLists.size(); i++) {
                        PlantationInspDetails_Request req = new PlantationInspDetails_Request();
                        req.setDistCode(((PlantationDetailList) detailsLists.get(i)).getDistID());
                        req.setBlockCode(((PlantationDetailList) detailsLists.get(i)).getBlockID());
                        req.setPanchayatCode(((PlantationDetailList) detailsLists.get(i)).getPanchayatID());
                        req.setInspectionID(((PlantationDetailList) detailsLists.get(i)).getInspectionID());
                        req.setIsInspectedBy(((PlantationDetailList) detailsLists.get(i)).getIsInspectedBy());
                        req.setIsInspectedDate(((PlantationDetailList) detailsLists.get(i)).getIsInspectedDate());
                        req.setAgencyName(((PlantationDetailList) detailsLists.get(i)).getAgencyName());
                        req.setWorkCode(((PlantationDetailList) detailsLists.get(i)).getWorkCode());
                        req.setWorkName(((PlantationDetailList) detailsLists.get(i)).getWorkName());
                        req.setWorktype(((PlantationDetailList) detailsLists.get(i)).getWorktype());
                        req.setWorkStateFyear(((PlantationDetailList) detailsLists.get(i)).getWorkStateFyear());
                        req.setVerifiedDate(((PlantationDetailList) detailsLists.get(i)).getVerifiedDate());
                        req.setVerifiedBy(((PlantationDetailList) detailsLists.get(i)).getVerifiedBy());
                        req.setUserrole(((PlantationDetailList) detailsLists.get(i)).getUserRole());
                        req.setIsInspectedByDSTAE(((PlantationDetailList) detailsLists.get(i)).getIsInspectedByDSTAE());
                        req.setIsInspectedByDSTDDC(((PlantationDetailList) detailsLists.get(i)).getIsInspectedByDSTDDC());
                        req.setIsInspectedByDSTDRDA(((PlantationDetailList) detailsLists.get(i)).getIsInspectedByDSTDRDA());
                        req.setIsInspectedByDSTEE(((PlantationDetailList) detailsLists.get(i)).getIsInspectedByDSTEE());
                        data_value.add(req);
                    }
                    PlantationListActivity.this.adaptor_showedit_listDetail = new PlantationAdapter(PlantationListActivity.this, data_value);
                    PlantationListActivity.this.listView.setAdapter((ListAdapter) PlantationListActivity.this.adaptor_showedit_listDetail);
                    PlantationListActivity.this.adaptor_showedit_listDetail.notifyDataSetChanged();
                    return;
                }
                PlantationListActivity.this.tv_Norecord.setVisibility(0);
            }
        });
    }

    public void populateLocalData() {
        this.data = this.dataBaseHelper.getPlantationDetail(this.panchayatCode);
        this.tv_header.setText("वृक्षारोपण उत्तरजीविता प्रतिवेदन (" + this.data.size() + ")");
        ArrayList<PlantationInspDetails_Request> arrayList = this.data;
        if (arrayList != null && arrayList.size() > 0) {
            setData();
            return;
        }
        this.listView.setVisibility(8);
        this.tv_Norecord.setVisibility(0);
        new Config().AlertDialog(this, "सर्वर से डेटा लोड करें");
    }

    private void SyncPlantationData(String DistID, String BlockId, String PanchayatId, String Role) {
        this.dialog.show();
        this.dialog.setMessage("Loading Plantation Data...");
        String _DistID = this.aes256CbcEncryptDecrypt.Encrypt(DistID, this._encriptionKey);
        String _BlockId = this.aes256CbcEncryptDecrypt.Encrypt(BlockId, this._encriptionKey);
        String _PanchayatId = this.aes256CbcEncryptDecrypt.Encrypt(PanchayatId, this._encriptionKey);
        String _Role = this.aes256CbcEncryptDecrypt.Encrypt(Role, this._encriptionKey);
        String _DeviceID = this.aes256CbcEncryptDecrypt.Encrypt(Utiilties.getDeviceIMEI(this), this._encriptionKey);
        String _IpAddress = this.aes256CbcEncryptDecrypt.Encrypt(Utiilties.getLocalIpAddress(), this._encriptionKey);
        PlantationDetailRequest plantationrequest = new PlantationDetailRequest(_DistID, _BlockId, _PanchayatId, _Role, _DeviceID, _IpAddress);
        Call<PlantationDetailsResponse> call = ApiCall.getService().getInitialRDDPlantationDetail(this.AuthToken, plantationrequest);
        call.enqueue(new Callback<PlantationDetailsResponse>() { // from class: bih.in.forestdept.activity.PlantationListActivity.4
            @Override // retrofit2.Callback
            public void onResponse(Call<PlantationDetailsResponse> call2, Response<PlantationDetailsResponse> response) {
                if (PlantationListActivity.this.dialog != null) {
                    PlantationListActivity.this.dialog.dismiss();
                }
                String temp32Enc_key = CommonPref.getUserDetails(PlantationListActivity.this).get_encriptionKey();
                if (response.code() == 200) {
                    if (response.body().getStatus().booleanValue()) {
                        ArrayList<PlantationDetailList> data = new ArrayList<>();
                        if (!response.body().getData().isEmpty()) {
                            for (int i = 0; i < response.body().getData().size(); i++) {
                                PlantationDetailList tempData = new PlantationDetailList(response.body().getData().get(i), temp32Enc_key);
                                data.add(tempData);
                            }
                            DataBaseHelper helper = new DataBaseHelper(PlantationListActivity.this.getApplicationContext());
                            long i2 = helper.setPlantationDataToLocal(data);
                            if (i2 > 0) {
                                PlantationListActivity.this.populateLocalData();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Toast.makeText(PlantationListActivity.this, response.body().getMsg(), 0).show();
                    Toast.makeText(PlantationListActivity.this.getApplicationContext(), "कोई डेटा नहीं मिला!", 0).show();
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PlantationDetailsResponse> call2, Throwable t) {
                if (PlantationListActivity.this.dialog != null) {
                    PlantationListActivity.this.dialog.dismiss();
                }
                Toast.makeText(PlantationListActivity.this.getApplicationContext(), t.getMessage(), 1).show();
            }
        });
    }

    public void setData() {
        Log.e("data", "" + this.data.size());
        this.tv_Norecord.setVisibility(8);
        this.listView.setVisibility(0);
        this.ll_work_Code.setVisibility(0);
        PlantationAdapter plantationAdapter = new PlantationAdapter(this, this.data);
        this.adaptor_showedit_listDetail = plantationAdapter;
        this.listView.setAdapter((ListAdapter) plantationAdapter);
        this.adaptor_showedit_listDetail.notifyDataSetChanged();
    }

    private void DistrictData() {
        this.dialog.setMessage("Loading District Data...");
        this.dialog.show();
        Call<DistrictResponse> call = ApiCall.getService().getDistData(this.AuthToken);
        call.enqueue(new Callback<DistrictResponse>() { // from class: bih.in.forestdept.activity.PlantationListActivity.5
            @Override // retrofit2.Callback
            public void onResponse(Call<DistrictResponse> call2, Response<DistrictResponse> response) {
                if (PlantationListActivity.this.dialog != null) {
                    PlantationListActivity.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body().getStatus().booleanValue()) {
                        ArrayList<DistrictList> data = new ArrayList<>();
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            data.add(new DistrictList(response.body().getData().get(i), PlantationListActivity.this));
                        }
                        PlantationListActivity.this.loadDistrictSpinner();
                        return;
                    }
                    Toast.makeText(PlantationListActivity.this, response.body().getMsg(), 0).show();
                    return;
                }
                Toast.makeText(PlantationListActivity.this, response.body().getMsg(), 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<DistrictResponse> call2, Throwable t) {
                if (PlantationListActivity.this.dialog != null) {
                    PlantationListActivity.this.dialog.dismiss();
                }
                Toast.makeText(PlantationListActivity.this.getApplicationContext(), t.getMessage(), 1).show();
            }
        });
    }

    private void BlockData(String dist_Code) {
        this.dialog.show();
        this.dialog.setMessage("Loading Block Data...");
        BlockRequest blockRequest = new BlockRequest(dist_Code);
        Call<BlockResponse> call = ApiCall.getService().getBlockData(this.AuthToken, blockRequest);
        call.enqueue(new Callback<BlockResponse>() { // from class: bih.in.forestdept.activity.PlantationListActivity.6
            @Override // retrofit2.Callback
            public void onResponse(Call<BlockResponse> call2, Response<BlockResponse> response) {
                if (PlantationListActivity.this.dialog != null) {
                    PlantationListActivity.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body().getStatus().booleanValue()) {
                        ArrayList<BlockList> pdata = new ArrayList<>();
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            pdata.add(new BlockList(response.body().getData().get(i), PlantationListActivity.this));
                        }
                        PlantationListActivity.this.loadBlockSpinner();
                        return;
                    }
                    Toast.makeText(PlantationListActivity.this, response.body().getMsg(), 0).show();
                    return;
                }
                Toast.makeText(PlantationListActivity.this, response.body().getMsg(), 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<BlockResponse> call2, Throwable t) {
                if (PlantationListActivity.this.dialog != null) {
                    PlantationListActivity.this.dialog.dismiss();
                }
                Toast.makeText(PlantationListActivity.this.getApplicationContext(), t.getMessage(), 1).show();
            }
        });
    }

    private void SyncPanchayatData(String dist_id, String block_id) {
        this.dialog.show();
        this.dialog.setMessage("Loading Panchayat Data...");
        PanchayatRequest panchayatRequest = new PanchayatRequest(dist_id, block_id);
        Call<PanchayatResponse> call = ApiCall.getService().getPanchayat(this.AuthToken, panchayatRequest);
        call.enqueue(new Callback<PanchayatResponse>() { // from class: bih.in.forestdept.activity.PlantationListActivity.7
            @Override // retrofit2.Callback
            public void onResponse(Call<PanchayatResponse> call2, Response<PanchayatResponse> response) {
                if (PlantationListActivity.this.dialog != null) {
                    PlantationListActivity.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body().getStatus().booleanValue()) {
                        ArrayList<PanchayatList> pdata = new ArrayList<>();
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            pdata.add(new PanchayatList(response.body().getData().get(i), PlantationListActivity.this));
                        }
                        PlantationListActivity.this.loadPanchayatSpinner();
                        PlantationListActivity.this.populateLocalData();
                        return;
                    }
                    Toast.makeText(PlantationListActivity.this, response.body().getMsg(), 0).show();
                    return;
                }
                Toast.makeText(PlantationListActivity.this, response.body().getMsg(), 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PanchayatResponse> call2, Throwable t) {
                if (PlantationListActivity.this.dialog != null) {
                    PlantationListActivity.this.dialog.dismiss();
                }
                Toast.makeText(PlantationListActivity.this.getApplicationContext(), t.getMessage(), 1).show();
            }
        });
    }

    public void loadPanchayatSpinner() {
        this.panchayatList = this.dataBaseHelper.getPanchayt(this.blockCode);
        ArrayList<String> arrayList = new ArrayList<>();
        this.panchayatNameArray = arrayList;
        arrayList.add("-select-");
        int i = 0;
        Iterator<PanchayatList> it = this.panchayatList.iterator();
        while (it.hasNext()) {
            PanchayatList panchayat_list = it.next();
            this.panchayatNameArray.add(panchayat_list.getPanchayat());
            i++;
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, this.panchayatNameArray);
        this.panchayatadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spin_panchayat.setAdapter((SpinnerAdapter) this.panchayatadapter);
    }

    public void loadBlockSpinner() {
        this.blockList = this.dataBaseHelper.getBlock(this.districtCode);
        ArrayList<String> arrayList = new ArrayList<>();
        this.blockNameArray = arrayList;
        arrayList.add("-select-");
        int i = 0;
        Iterator<Block> it = this.blockList.iterator();
        while (it.hasNext()) {
            Block block_list = it.next();
            this.blockNameArray.add(block_list.getBlockName());
            i++;
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, this.blockNameArray);
        this.blockadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spin_block.setAdapter((SpinnerAdapter) this.blockadapter);
    }

    public void loadDistrictSpinner() {
        this.districtList = this.dataBaseHelper.getDistrict();
        ArrayList<String> arrayList = new ArrayList<>();
        this.districtNameArray = arrayList;
        arrayList.add("-select-");
        int i = 0;
        Iterator<District> it = this.districtList.iterator();
        while (it.hasNext()) {
            District district_list = it.next();
            this.districtNameArray.add(district_list.get_DistName());
            i++;
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, this.districtNameArray);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spin_district.setAdapter((SpinnerAdapter) this.districtadapter);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.blockCode != null) {
            ArrayList<PlantationInspDetails_Request> arrayList = this.data;
            if (arrayList != null && arrayList.size() > 0) {
                this.tv_Norecord.setVisibility(8);
                this.listView.setVisibility(0);
                this.listView.invalidate();
                PlantationAdapter plantationAdapter = new PlantationAdapter(this, this.data);
                this.adaptor_showedit_listDetail = plantationAdapter;
                this.listView.setAdapter((ListAdapter) plantationAdapter);
                return;
            }
            this.listView.setVisibility(8);
            this.tv_Norecord.setVisibility(0);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case C0594R.id.spin_block /* 2131231339 */:
                if (position > 0) {
                    this.blockCode = this.blockList.get(position - 1).getBlockCode().trim();
                    this.blockName = this.blockList.get(position - 1).getBlockName().trim();
                    loadPanchayatSpinner();
                    SyncPanchayatData(this.Dist_Code, this.Block_Code);
                    this.panchayatCode = "";
                    break;
                }
                break;
            case C0594R.id.spin_district /* 2131231341 */:
                if (position > 0) {
                    this.districtCode = this.districtList.get(position - 1).get_DistCode().trim();
                    this.districtName = this.districtList.get(position - 1).get_DistName().trim();
                    Log.d("district", "District Code: " + this.districtCode);
                    BlockData(this.Dist_Code);
                    loadBlockSpinner();
                    break;
                }
                break;
            case C0594R.id.spin_panchayat /* 2131231346 */:
                if (position > 0) {
                    this.panchayatCode = this.panchayatList.get(position - 1).getPanchayat_Code().trim();
                    this.panchayatName = this.panchayatList.get(position - 1).getPanchayat().trim();
                    Log.d("pond", "Panchayat Code: " + this.panchayatCode);
                    switch (this.userInfo.getUserrole()) {
                        case "BLKPO":
                        case "STATEADM":
                        case "BLKPTA":
                        case "BLKJE":
                        case "DSTAE":
                        case "DSTEE":
                        case "DSTPO":
                        case "DSTDRDA":
                        case "DSTDDC":
                            SyncPlantationData(this.districtCode, this.blockCode, this.panchayatCode, this.userRole);
                            break;
                        default:
                            populateLocalData();
                            break;
                    }
                }
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }
}