package bih.p003in.forestdept.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.MarshmallowPermission;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.entity.Block;
import bih.p003in.forestdept.entity.District;
import bih.p003in.forestdept.entity.SignUp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class SignUpActivity extends Activity {
    static ArrayList<String> blockstlist;
    private static String imei;
    ArrayList<String> blkNameArray;
    ArrayAdapter<String> blockadapter;
    Button btn_cancel;
    Button btn_signUp;
    public Context context;
    DataBaseHelper dataBaseHelper;
    ArrayList<String> districtNameArray;
    ArrayAdapter<String> districtadapter;
    EditText et_address;
    EditText et_confirm_password;
    EditText et_designation;
    EditText et_fname;
    EditText et_mobile;
    EditText et_name;
    EditText et_password;
    Spinner spn_block;
    Spinner spn_dist;
    String st_Desig;
    String st_et_address;
    String st_et_confirm_password;
    String st_et_fname;
    String st_et_mobile;
    String st_et_name;
    String st_et_password;
    String st_spn_block;
    String st_spn_dist;

    /* renamed from: tm */
    TelephonyManager f161tm;
    String st_spn_dist_code = "";
    String st_spn_block_code = "";
    ArrayList<District> distList = new ArrayList<>();
    ArrayList<Block> BlkList = new ArrayList<>();
    String version = "";

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_sign_up);
        Initialization();
        this.dataBaseHelper = new DataBaseHelper(this);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        this.dataBaseHelper = dataBaseHelper;
        try {
            dataBaseHelper.createDataBase();
            try {
                this.dataBaseHelper.openDataBase();
                loadDistrictSpinner();
                this.spn_dist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: bih.in.forestdept.activity.SignUpActivity.1
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            SignUpActivity signUpActivity = SignUpActivity.this;
                            signUpActivity.st_spn_dist_code = signUpActivity.distList.get(position - 1).get_DistCode();
                            SignUpActivity signUpActivity2 = SignUpActivity.this;
                            signUpActivity2.st_spn_dist = signUpActivity2.distList.get(position - 1).get_DistName();
                            SignUpActivity signUpActivity3 = SignUpActivity.this;
                            signUpActivity3.BlkList = signUpActivity3.dataBaseHelper.getBlock(SignUpActivity.this.st_spn_dist_code);
                            if (SignUpActivity.this.BlkList.size() > 0) {
                                SignUpActivity.this.setBlockData();
                            }
                        }
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                this.spn_block.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: bih.in.forestdept.activity.SignUpActivity.2
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            SignUpActivity signUpActivity = SignUpActivity.this;
                            signUpActivity.st_spn_block_code = signUpActivity.BlkList.get(position - 1).getBlockCode();
                            SignUpActivity signUpActivity2 = SignUpActivity.this;
                            signUpActivity2.st_spn_block = signUpActivity2.BlkList.get(position - 1).getBlockName();
                        }
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                this.btn_signUp.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.SignUpActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        SignUpActivity.this.SignUpEntry();
                    }
                });
                this.btn_cancel.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.SignUpActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        SignUpActivity.this.finish();
                    }
                });
            } catch (SQLException sqle) {
                throw sqle;
            }
        } catch (IOException e) {
            throw new Error("Unable to create database");
        }
    }

    public void Initialization() {
        this.spn_dist = (Spinner) findViewById(C0594R.id.spn_dist);
        this.spn_block = (Spinner) findViewById(C0594R.id.spn_block);
        this.et_name = (EditText) findViewById(C0594R.id.et_farmer_name);
        this.et_fname = (EditText) findViewById(C0594R.id.et_father_husband);
        this.et_address = (EditText) findViewById(C0594R.id.et_adress);
        this.et_mobile = (EditText) findViewById(C0594R.id.et_mobile_number);
        this.et_designation = (EditText) findViewById(C0594R.id.et_designation);
        this.et_confirm_password = (EditText) findViewById(C0594R.id.et_conform_password);
        this.btn_signUp = (Button) findViewById(C0594R.id.btn_signUp);
        this.btn_cancel = (Button) findViewById(C0594R.id.reg_cancel);
    }

    public void loadDistrictSpinner() {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getApplicationContext());
        this.dataBaseHelper = dataBaseHelper;
        this.distList = dataBaseHelper.getDistrict();
        ArrayList<String> arrayList = new ArrayList<>();
        this.districtNameArray = arrayList;
        arrayList.add("-select-");
        int i = 0;
        Iterator<District> it = this.distList.iterator();
        while (it.hasNext()) {
            District district_list = it.next();
            this.districtNameArray.add(district_list.get_DistName());
            i++;
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, this.districtNameArray);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spn_dist.setAdapter((SpinnerAdapter) this.districtadapter);
    }

    private void loadBlockData(ArrayList<Block> pList) {
        ArrayList<String> arrayList = new ArrayList<>();
        blockstlist = arrayList;
        arrayList.add("-Select Block-");
        for (int i = 0; i < pList.size(); i++) {
            blockstlist.add(pList.get(i).getBlockName());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, blockstlist);
        this.blockadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spn_block.setAdapter((SpinnerAdapter) this.blockadapter);
    }

    public void setBlockData() {
        DataBaseHelper placeData = new DataBaseHelper(this);
        ArrayList<Block> block = placeData.getBlock(this.st_spn_dist_code);
        this.BlkList = block;
        if (block.size() > 0) {
            loadBlockData(this.BlkList);
        }
    }

    public void SignUpEntry() {
        setValue();
        SignUp signUp = new SignUp();
        if (Validate()) {
            signUp.setDist_code(this.st_spn_dist_code);
            signUp.setBlock_code(this.st_spn_block_code);
            signUp.setName(this.st_et_name);
            signUp.setDesignation(this.st_Desig);
            signUp.setMobile(this.st_et_mobile);
        }
    }

    public void setValue() {
        this.st_et_name = this.et_name.getText().toString();
        this.st_et_mobile = this.et_mobile.getText().toString();
        this.st_Desig = this.et_designation.getText().toString();
    }

    private boolean Validate() {
        boolean validate = true;
        if (TextUtils.isEmpty(this.st_et_name)) {
            View focusview = this.et_name;
            validate = false;
            this.et_name.setError("please enter name");
        }
        if (TextUtils.isEmpty(this.st_et_mobile)) {
            View focusview2 = this.et_mobile;
            validate = false;
            this.et_mobile.setError("please enter mobile number");
        } else if (this.st_et_mobile.length() != 10) {
            this.et_mobile.setError(getString(C0594R.string.Invalid_Number));
            View focusview3 = this.et_mobile;
            validate = false;
        }
        if (TextUtils.isEmpty(this.st_Desig)) {
            View focusview4 = this.et_designation;
            validate = false;
            this.et_designation.setError("please enter password");
        }
        if (this.st_spn_dist_code.equals("")) {
            View focusview5 = this.spn_dist;
            validate = false;
            Toast.makeText(getApplicationContext(), "please select district", 1).show();
        }
        if (this.st_spn_block_code.equals("")) {
            View focusview6 = this.spn_block;
            Toast.makeText(getApplicationContext(), "please select Block", 1).show();
            return false;
        }
        return validate;
    }

    private void getIMEI() {
        this.context = this;
        this.dataBaseHelper = new DataBaseHelper(this);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        this.dataBaseHelper = dataBaseHelper;
        try {
            dataBaseHelper.createDataBase();
            try {
                this.dataBaseHelper.openDataBase();
                MarshmallowPermission permission = new MarshmallowPermission(this, "android.permission.READ_PHONE_STATE");
                if (permission.result == -1 || permission.result == 0) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
                        this.f161tm = telephonyManager;
                        if (telephonyManager != null) {
                            imei = telephonyManager.getDeviceId();
                        }
                    } catch (Exception e) {
                    }
                } else if (permission.result == 1) {
                    TelephonyManager telephonyManager2 = (TelephonyManager) getSystemService("phone");
                    this.f161tm = telephonyManager2;
                    if (telephonyManager2 != null) {
                        imei = telephonyManager2.getDeviceId();
                    }
                }
                try {
                    this.version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                }
            } catch (SQLException sqle) {
                throw sqle;
            }
        } catch (IOException e3) {
            throw new Error("Unable to create database");
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        getIMEI();
    }
}