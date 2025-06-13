package bih.p003in.forestdept.activity;

import android.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.adapter.GeoTag_Adapter;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.entity.PondLakeDepartmentEntity;
import bih.p003in.forestdept.entity.VillageListEntity;
import bih.p003in.forestdept.interfaces.RecyclerViewItemDelete;
import bih.p003in.forestdept.model.GeoFencing;
import bih.p003in.forestdept.model.LatLongEntityUpload;
import bih.p003in.forestdept.model.LatLongList;
import bih.p003in.forestdept.model.LatLongRequest;
import bih.p003in.forestdept.model.LatLongResponse;
import bih.p003in.forestdept.model.PlantationInspDetails_Request;
import bih.p003in.forestdept.model.PlantationSiteList;
import bih.p003in.forestdept.model.PlantationSiteResponse;
import bih.p003in.forestdept.model.UserDetail;
import bih.p003in.forestdept.utility.CommonPref;
import bih.p003in.forestdept.utility.GpsTracker;
import bih.p003in.forestdept.utility.LocationTracker;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class PlantationInspectionActivity extends Activity implements AdapterView.OnItemSelectedListener, RecyclerViewItemDelete {
    private static final int[] VALID_VALUES = {ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 400, 600, 800, 1000, 1200, 1400, 1600, 1800, 2000};
    ArrayAdapter bhugtanMonthAdaptor;
    ArrayAdapter bhugtanYearAdaptor;
    String blockCode;
    String blockID;
    String blockName;
    Button btn_reg;
    DataBaseHelper dataBaseHelper;
    private ProgressDialog dialog;
    String distID;
    String distName;
    TextView errorTextView;
    EditText et_50_75_per;
    EditText et_75_90_per;
    EditText et_above_90_per;
    EditText et_average_height_of_plant;
    EditText et_below_25_per;
    EditText et_gawyan_per;
    EditText et_live_pant_no;
    EditText et_live_pant_percent;
    EditText et_planted_no;
    EditText et_plnt_agnst_dealplnt;
    EditText et_remark;
    GpsTracker gpsTracker;

    /* renamed from: id */
    int f160id;
    String inspectionID;
    String landType;
    String latitude;
    LinearLayout ll_land_type;
    LinearLayout ll_plant_scheme_no;
    private LocationTracker locationTracker;
    String longitude;
    GeoTag_Adapter mAdapter;
    String panchayatCode;
    ArrayList<String> plantatiionNameArray;
    ArrayAdapter plantationAdapter;
    PlantationInspDetails_Request plantationInfo;
    String rajswaThanaNumber;
    RecyclerView recyclerView_location;
    Spinner spin_bhugtan_plant_month;
    Spinner spin_bhugtan_plant_year;
    EditText spin_forest_poshak_pant_no;
    Spinner spin_plantation_site;
    Spinner spin_year;
    Button take_location;
    TextView tv_agency_name;
    TextView tv_forest_poshak_bhugtan_pant_no;
    TextView tv_forest_poshak_pant_no;
    TextView tv_fyear;
    TextView tv_plantation_site;
    TextView tv_work_code;
    TextView tv_work_name;
    TextView tv_work_type;
    TextView tv_year;
    UserDetail userInfo;
    ArrayAdapter vanPoshakhoAdaptor;
    String villageName;
    String work_code;
    ArrayList<String> yearArray;
    String yearId;
    private final Boolean fistTime = false;
    String villageID = "";
    String panchayatName = "";
    String isUpdated = "0";
    String landTypeValue = "";
    String yearValue = "";
    String workCode = "";
    ArrayList<PondLakeDepartmentEntity> deptList = new ArrayList<>();
    ArrayList<PlantationSiteList> plantationSiteList = new ArrayList<>();
    ArrayList<VillageListEntity> villageList = new ArrayList<>();
    String[] landTypeOption = {"-चयन करे-", "सरकारी", "निजी"};
    String[] yearOption = {"-चयन करे-", "2014-2015", "2015-2016", "2016-2017", "2017-2018", "2018-2019"};
    String[] vanPoshakhoOption = {"-चयन करे-", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10"};
    String[] bhugtanMonthOption = {"-चयन करे-", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] bhugtanYearOption = {"-चयन करे-", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"};
    String s1_data = "";
    String siteId = "";
    String site_hname = "";
    String site_ename = "";
    String AuthToken = "";
    ArrayList<GeoFencing> list_saved_gps = new ArrayList<>();
    private double previousLatitude = 0.0d;
    private double previousLongitude = 0.0d;
    private double take_latitude = 0.0d;
    private double take_longitude = 0.0d;
    private boolean isInsideRange = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_plantation_inspection);
        final ProgressBar locationProgress = (ProgressBar) findViewById(C0594R.id.location_progress);
        this.take_location = (Button) findViewById(C0594R.id.take_location);
        this.recyclerView_location = (RecyclerView) findViewById(C0594R.id.recyclerView_location);
        this.dataBaseHelper = new DataBaseHelper(this);
        this.AuthToken = CommonPref.getUserDetails(this).getAuthtoken();
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        Initialization();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_item, this.yearOption);
        this.plantationAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spin_year.setAdapter((SpinnerAdapter) this.bhugtanMonthAdaptor);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, R.layout.simple_spinner_item, this.vanPoshakhoOption);
        this.vanPoshakhoAdaptor = arrayAdapter2;
        arrayAdapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, R.layout.simple_spinner_item, this.bhugtanMonthOption);
        this.bhugtanMonthAdaptor = arrayAdapter3;
        arrayAdapter3.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spin_bhugtan_plant_month.setAdapter((SpinnerAdapter) this.bhugtanMonthAdaptor);
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(this, R.layout.simple_spinner_item, this.bhugtanYearOption);
        this.bhugtanYearAdaptor = arrayAdapter4;
        arrayAdapter4.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spin_bhugtan_plant_year.setAdapter((SpinnerAdapter) this.bhugtanYearAdaptor);
        this.take_location.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlantationInspectionActivity.this.m68xaecc61dd(view);
            }
        });
        this.take_location.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlantationInspectionActivity.this.m71x1f887ce0(locationProgress, view);
            }
        });
        this.et_live_pant_no.addTextChangedListener(new TextWatcher() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String green_weight = PlantationInspectionActivity.this.et_planted_no.getText().toString();
                if (PlantationInspectionActivity.this.et_live_pant_no.getText().toString().length() <= 0 || green_weight.length() <= 0 || green_weight.equals(PlantationInspectionActivity.this.et_live_pant_no.getText().toString())) {
                    return;
                }
                if (Float.parseFloat(green_weight) < Float.parseFloat(PlantationInspectionActivity.this.et_live_pant_no.getText().toString())) {
                    PlantationInspectionActivity.this.et_live_pant_no.setError("उत्तरजीवित पौधों की संख्या रोपित पौधों की संख्या से कम और बराबर होना चाहिए!");
                    PlantationInspectionActivity.this.et_live_pant_no.setText((CharSequence) null);
                } else {
                    PlantationInspectionActivity.this.et_live_pant_no.setError(null);
                }
            }
        });
        this.et_planted_no.addTextChangedListener(new TextWatcher() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    float totalPlant = Float.parseFloat(s.toString().trim());
                    String livePlantNo = PlantationInspectionActivity.this.et_live_pant_no.getText().toString().trim();
                    if (!livePlantNo.isEmpty()) {
                        try {
                            float livePlant = Float.parseFloat(livePlantNo);
                            float livePlantPercent = (100.0f * livePlant) / totalPlant;
                            PlantationInspectionActivity.this.et_live_pant_percent.setText(String.format("%.2f", Float.valueOf(livePlantPercent)));
                            PlantationInspectionActivity.this.et_live_pant_percent.setError(null);
                        } catch (Exception e) {
                            Log.e("exception", e.getLocalizedMessage());
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }
        });
        this.et_live_pant_no.addTextChangedListener(new TextWatcher() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    float livePlant = Float.parseFloat(s.toString().trim());
                    String totalPlantNo = PlantationInspectionActivity.this.et_planted_no.getText().toString().trim();
                    if (!totalPlantNo.isEmpty()) {
                        try {
                            float totalPlant = Float.parseFloat(totalPlantNo);
                            float livePlantPercent = (100.0f * livePlant) / totalPlant;
                            PlantationInspectionActivity.this.et_live_pant_percent.setText(String.format("%.2f", Float.valueOf(livePlantPercent)));
                            PlantationInspectionActivity.this.et_live_pant_percent.setError(null);
                        } catch (Exception e) {
                            Log.e("exception", e.getLocalizedMessage());
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }
        });
        this.et_plnt_agnst_dealplnt.addTextChangedListener(new TextWatcher() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.length() > 0) {
                    String totalPlantNo = PlantationInspectionActivity.this.et_planted_no.getText().toString().trim();
                    if (!totalPlantNo.isEmpty()) {
                        try {
                            double firstValue = Double.parseDouble(totalPlantNo);
                            double secondValue = 0.1d * firstValue;
                            double myValue = Double.parseDouble(s.toString());
                            if (myValue > secondValue) {
                                PlantationInspectionActivity.this.et_plnt_agnst_dealplnt.setError("मृत पौधों के स्थान पर लगाये गये पौधों की संख्या रोपित पौधों की संख्या से 10% होना चाहिए!");
                                PlantationInspectionActivity.this.et_plnt_agnst_dealplnt.setText((CharSequence) null);
                            } else {
                                PlantationInspectionActivity.this.et_plnt_agnst_dealplnt.setError(null);
                            }
                        } catch (Exception e) {
                            Log.e("exception", e.getLocalizedMessage());
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.btn_reg.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PlantationInspectionActivity.this.isInsideRange) {
                    if (PlantationInspectionActivity.this.validateData()) {
                        PlantationInspectionActivity.this.UpdateInspectionDetail();
                        return;
                    } else {
                        Toast.makeText(PlantationInspectionActivity.this, "Please fill all required fields.", 0).show();
                        return;
                    }
                }
                Toast.makeText(PlantationInspectionActivity.this, "You are outside the valid point location range.", 1).show();
            }
        });
        getUserDetail();
        loadPlantationSiteSpinner();
        extractDataFromIntent();
    }

    /* renamed from: lambda$onCreate$1$bih-in-forestdept-activity-PlantationInspectionActivity */
    /* synthetic */ void m68xaecc61dd(View view) {
        LocationTracker locationTracker = new LocationTracker(this);
        this.locationTracker = locationTracker;
        locationTracker.getCurrentLocation(new LocationTracker.OnLocationResultListener() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity$$ExternalSyntheticLambda4
            @Override // bih.in.forestdept.utility.LocationTracker.OnLocationResultListener
            public final void onLocationResult(double d, double d2) {
                PlantationInspectionActivity.this.m67x893858dc(d, d2);
            }
        });
    }

    /* renamed from: lambda$onCreate$0$bih-in-forestdept-activity-PlantationInspectionActivity */
    /* synthetic */ void m67x893858dc(double lat, double lon) {
        this.take_latitude = lat;
        this.take_longitude = lon;
        if (lat == this.previousLatitude && lon == this.previousLongitude) {
            Toast.makeText(getApplicationContext(), "Location has not changed, please move.", 0).show();
            return;
        }
        if (lat > 0.0d && Math.abs(lon) > 0.0d) {
            checkPointLocationAndEnablePhoto(this.take_latitude, this.take_longitude);
            if (this.list_saved_gps.size() > 11) {
                Toast.makeText(getApplicationContext(), "Capture Maximum 12 GPS Points.", 0).show();
            } else {
                AddLatLong(this.take_latitude, this.take_longitude);
            }
            this.previousLatitude = this.take_latitude;
            this.previousLongitude = this.take_longitude;
            return;
        }
        Toast.makeText(getApplicationContext(), "Wait for GPS to become stable", 1).show();
    }

    /* renamed from: lambda$onCreate$4$bih-in-forestdept-activity-PlantationInspectionActivity */
    /* synthetic */ void m71x1f887ce0(final ProgressBar locationProgress, View view) {
        this.take_location.setEnabled(false);
        locationProgress.setVisibility(0);
        LocationTracker locationTracker = new LocationTracker(this);
        this.locationTracker = locationTracker;
        locationTracker.getCurrentLocation(new LocationTracker.OnLocationResultListener() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity$$ExternalSyntheticLambda2
            @Override // bih.in.forestdept.utility.LocationTracker.OnLocationResultListener
            public final void onLocationResult(double d, double d2) {
                PlantationInspectionActivity.this.m69xd4606ade(locationProgress, d, d2);
            }
        });
        new Handler().postDelayed(new Runnable() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PlantationInspectionActivity.this.m70xf9f473df(locationProgress);
            }
        }, 5000L);
    }

    /* renamed from: lambda$onCreate$2$bih-in-forestdept-activity-PlantationInspectionActivity */
    /* synthetic */ void m69xd4606ade(ProgressBar locationProgress, double lat, double lon) {
        this.take_latitude = lat;
        this.take_longitude = lon;
        locationProgress.setVisibility(8);
        this.take_location.setEnabled(true);
        if (this.take_latitude <= 0.0d || Math.abs(this.take_longitude) <= 0.0d) {
            Toast.makeText(getApplicationContext(), "Wait for GPS to become stable", 1).show();
            return;
        }
        double d = this.take_latitude;
        if (d != this.previousLatitude || this.take_longitude != this.previousLongitude) {
            checkPointLocationAndEnablePhoto(d, this.take_longitude);
            if (this.list_saved_gps.size() > 11) {
                Toast.makeText(getApplicationContext(), "Capture Maximum 12 GPS Points.", 0).show();
            } else {
                AddLatLong(this.take_latitude, this.take_longitude);
            }
            this.previousLatitude = this.take_latitude;
            this.previousLongitude = this.take_longitude;
            return;
        }
        Toast.makeText(getApplicationContext(), "Location has not changed, please move.", 0).show();
    }

    /* renamed from: lambda$onCreate$3$bih-in-forestdept-activity-PlantationInspectionActivity */
    /* synthetic */ void m70xf9f473df(ProgressBar locationProgress) {
        if (locationProgress.getVisibility() == 0) {
            locationProgress.setVisibility(8);
            this.take_location.setEnabled(true);
            Toast.makeText(getApplicationContext(), "Wait for GPS to become stable", 0).show();
        }
    }

    private void AddLatLong(double take_latitude, double take_longitude) {
        GeoFencing detailsModel = new GeoFencing();
        detailsModel.setGeoSeqID("" + (this.list_saved_gps.size() + 1));
        detailsModel.setGeoFenLatitude(String.valueOf(take_latitude));
        detailsModel.setGeoFenLongitude(String.valueOf(take_longitude));
        this.list_saved_gps.add(detailsModel);
        this.mAdapter = new GeoTag_Adapter(this, this.list_saved_gps);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        this.recyclerView_location.setLayoutManager(mLayoutManager);
        this.recyclerView_location.setAdapter(this.mAdapter);
    }

    public String getLocation() {
        this.gpsTracker = null;
        GpsTracker gpsTracker = new GpsTracker(this);
        this.gpsTracker = gpsTracker;
        double latitude = 0.0d;
        double longitude = 0.0d;
        if (gpsTracker.canGetLocation()) {
            latitude = this.gpsTracker.getLatitude();
            longitude = this.gpsTracker.getLongitude();
        } else {
            this.gpsTracker.showSettingsAlert();
        }
        String location = latitude + "," + longitude;
        this.take_latitude = latitude;
        this.take_longitude = longitude;
        return location;
    }

    private void Initialization() {
        this.tv_work_code = (TextView) findViewById(C0594R.id.tv_work_code);
        this.tv_work_name = (TextView) findViewById(C0594R.id.tv_work_name);
        this.tv_work_type = (TextView) findViewById(C0594R.id.tv_work_type);
        this.tv_agency_name = (TextView) findViewById(C0594R.id.tv_agency_name);
        this.tv_fyear = (TextView) findViewById(C0594R.id.tv_fyear);
        this.tv_forest_poshak_pant_no = (TextView) findViewById(C0594R.id.tv_forest_poshak_pant_no);
        this.tv_forest_poshak_bhugtan_pant_no = (TextView) findViewById(C0594R.id.tv_forest_poshak_bhugtan_pant_no);
        this.tv_plantation_site = (TextView) findViewById(C0594R.id.tv_plantation_site);
        this.tv_year = (TextView) findViewById(C0594R.id.tv_year);
        this.spin_year = (Spinner) findViewById(C0594R.id.spin_year);
        this.ll_land_type = (LinearLayout) findViewById(C0594R.id.ll_land_type);
        this.ll_plant_scheme_no = (LinearLayout) findViewById(C0594R.id.ll_plant_scheme_no);
        this.et_planted_no = (EditText) findViewById(C0594R.id.et_planted_no);
        this.errorTextView = (TextView) findViewById(C0594R.id.errorTextView);
        this.et_live_pant_no = (EditText) findViewById(C0594R.id.et_live_pant_no);
        this.et_live_pant_percent = (EditText) findViewById(C0594R.id.et_live_pant_percent);
        this.et_above_90_per = (EditText) findViewById(C0594R.id.et_above_90_per);
        this.et_75_90_per = (EditText) findViewById(C0594R.id.et_75_90_per);
        this.et_50_75_per = (EditText) findViewById(C0594R.id.et_50_75_per);
        this.et_below_25_per = (EditText) findViewById(C0594R.id.et_below_25_per);
        this.et_gawyan_per = (EditText) findViewById(C0594R.id.et_gawyan_per);
        this.et_average_height_of_plant = (EditText) findViewById(C0594R.id.et_average_height_of_plant);
        this.et_remark = (EditText) findViewById(C0594R.id.et_remark);
        this.et_plnt_agnst_dealplnt = (EditText) findViewById(C0594R.id.et_plnt_agnst_dealplnt);
        this.spin_plantation_site = (Spinner) findViewById(C0594R.id.spin_plantation_site);
        this.spin_forest_poshak_pant_no = (EditText) findViewById(C0594R.id.spin_forest_poshak_pant_no);
        this.spin_bhugtan_plant_month = (Spinner) findViewById(C0594R.id.spin_bhugtan_plant_month);
        this.spin_bhugtan_plant_year = (Spinner) findViewById(C0594R.id.spin_bhugtan_plant_year);
        this.spin_plantation_site.setOnItemSelectedListener(this);
        this.spin_bhugtan_plant_month.setOnItemSelectedListener(this);
        this.spin_bhugtan_plant_year.setOnItemSelectedListener(this);
        this.btn_reg = (Button) findViewById(C0594R.id.btn_reg);
        this.et_average_height_of_plant.setFilters(new InputFilter[]{new MinMaxFilter("1", "20")});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateData() {
        View focusView = null;
        boolean validate = true;
        if (this.siteId.equalsIgnoreCase("")) {
            validate = false;
            focusView = this.spin_plantation_site;
            Toast.makeText(this, "कृपया वृक्षारोपण का स्थल चयन करें", 0).show();
            this.spin_plantation_site.performClick();
        } else if (this.et_planted_no.getText().toString().equals("")) {
            this.et_planted_no.setError(getString(C0594R.string.fieldRequired));
            focusView = this.et_planted_no;
            validate = false;
        } else if (this.et_live_pant_no.getText().toString().equals("")) {
            this.et_live_pant_no.setError(getString(C0594R.string.fieldRequired));
            focusView = this.et_live_pant_no;
            validate = false;
        } else if (this.work_code.equalsIgnoreCase("DP") && Double.parseDouble(this.et_planted_no.getText().toString()) > 1200.0d) {
            this.et_planted_no.setError("रोपित पौधों की संख्या 1200 से ज्यादा नहीं होना चाहिए!");
            focusView = this.et_planted_no;
            validate = false;
        } else if (this.work_code.equalsIgnoreCase("IF") && Double.parseDouble(this.et_planted_no.getText().toString()) > 4000.0d) {
            this.et_planted_no.setError("रोपित पौधों की संख्या 4000 से ज्यादा नहीं होना चाहिए!");
            focusView = this.et_planted_no;
            validate = false;
        } else if (this.et_plnt_agnst_dealplnt.getText().toString().equals("")) {
            this.et_plnt_agnst_dealplnt.setError(getString(C0594R.string.fieldRequired));
            focusView = this.et_plnt_agnst_dealplnt;
            validate = false;
        } else if (Double.parseDouble(this.et_live_pant_no.getText().toString()) > Double.parseDouble(this.et_planted_no.getText().toString())) {
            this.et_live_pant_no.setError("उत्तरजीवित पौधों की संख्या रोपित पौधों की संख्या से कम और बराबर होना चाहिए!");
            validate = false;
            focusView = this.et_planted_no;
        } else if (this.plantationInfo.getPosak_bhugtaanMonth() == null) {
            this.tv_forest_poshak_bhugtan_pant_no.setError(getString(C0594R.string.fieldRequired));
            this.spin_bhugtan_plant_month.performClick();
            focusView = this.spin_bhugtan_plant_month;
            validate = false;
        } else if (this.plantationInfo.getPosak_bhugtaanYear() == null) {
            this.tv_forest_poshak_bhugtan_pant_no.setError(getString(C0594R.string.fieldRequired));
            this.spin_bhugtan_plant_year.performClick();
            focusView = this.spin_bhugtan_plant_year;
            validate = false;
        } else if (this.et_average_height_of_plant.getText().toString().equals("")) {
            this.et_average_height_of_plant.setError(getString(C0594R.string.fieldRequired));
            focusView = this.et_average_height_of_plant;
            validate = false;
        } else if (this.et_remark.getText().toString().equals("")) {
            this.et_remark.setError(getString(C0594R.string.fieldRequired));
            focusView = this.et_remark;
            validate = false;
        } else if (this.list_saved_gps.size() < 3) {
            validate = false;
            focusView = this.take_location;
            Toast.makeText(this, "Minimum 3 GPS Points are Required", 0).show();
        } else if (this.list_saved_gps.size() > 12) {
            validate = false;
            focusView = this.take_location;
            Toast.makeText(this, "You Can save Maximum 12 GPS Points", 0).show();
        }
        if (!validate) {
            focusView.requestFocus();
        }
        return validate;
    }

    private void getUserDetail() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String username = prefs.getString("uid", "user");
        String password = prefs.getString("pass", "password");
        this.userInfo = this.dataBaseHelper.getUserDetails(username, password);
    }

    public String getappversion() {
        String versionCode = null;
        PackageManager manager = getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(getPackageName(), 0);
            String str = info.packageName;
            versionCode = String.valueOf(info.versionCode);
            String str2 = info.versionName;
            return versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return versionCode;
        }
    }

    public void loadPlantationSiteSpinner() {
        ArrayList<PlantationSiteList> plantationSiteDetail = this.dataBaseHelper.getPlantationSiteDetail();
        this.plantationSiteList = plantationSiteDetail;
        if (plantationSiteDetail.size() > 0) {
            setPlantaionSite();
        } else {
            SyncPlantationSiteData();
        }
    }

    public void setPlantaionSite() {
        this.plantationSiteList.add(0, new PlantationSiteList("", "", "-चयन करे-"));
        ArrayAdapter<PlantationSiteList> spndist = new ArrayAdapter<>(this, R.layout.simple_spinner_dropdown_item, this.plantationSiteList);
        this.spin_plantation_site.setAdapter((SpinnerAdapter) spndist);
    }

    private void SyncPlantationSiteData() {
        this.dialog.setMessage("Loading...");
        this.dialog.show();
        Call<PlantationSiteResponse> call = ApiCall.getService().getPlantationSiteData(this.AuthToken);
        call.enqueue(new Callback<PlantationSiteResponse>() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity.6
            @Override // retrofit2.Callback
            public void onResponse(Call<PlantationSiteResponse> call2, Response<PlantationSiteResponse> response) {
                if (PlantationInspectionActivity.this.dialog != null) {
                    PlantationInspectionActivity.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body().getStatus().booleanValue()) {
                        ArrayList<PlantationSiteList> data = new ArrayList<>();
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            data.add(new PlantationSiteList(response.body().getData().get(i), PlantationInspectionActivity.this));
                        }
                        long i2 = PlantationInspectionActivity.this.dataBaseHelper.setPlantationSiteDataToLocal(data);
                        PlantationInspectionActivity.this.setPlantaionSite();
                        if (i2 > 0) {
                            Toast.makeText(PlantationInspectionActivity.this.getApplicationContext(), "Plantation Site Data Synced Successfully", 0).show();
                            return;
                        } else {
                            Toast.makeText(PlantationInspectionActivity.this.getApplicationContext(), "Failed to update Plantation Site Data", 0).show();
                            return;
                        }
                    }
                    Toast.makeText(PlantationInspectionActivity.this, response.body().getMsg(), 0).show();
                    return;
                }
                Toast.makeText(PlantationInspectionActivity.this, response.body().getMsg(), 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PlantationSiteResponse> call2, Throwable t) {
                if (PlantationInspectionActivity.this.dialog != null) {
                    PlantationInspectionActivity.this.dialog.dismiss();
                }
                Toast.makeText(PlantationInspectionActivity.this.getApplicationContext(), t.getMessage(), 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateInspectionDetail() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        this.plantationInfo.setIsUpdated("1");
        this.plantationInfo.setBhumiType(this.landTypeValue);
        this.plantationInfo.setFyear(this.yearValue);
        this.plantationInfo.setYears(this.yearValue);
        this.plantationInfo.setRemarks(this.et_remark.getText().toString());
        this.plantationInfo.setRopit_PlantNo(this.et_planted_no.getText().toString().trim());
        this.plantationInfo.setUtarjibit_PlantNo(this.et_live_pant_no.getText().toString().trim());
        this.plantationInfo.setUtarjibitaPercent(this.et_live_pant_percent.getText().toString().trim());
        this.plantationInfo.setVerifiedBy(this.userInfo.getUserId());
        this.plantationInfo.setIsInspectedBy(this.userInfo.getUserId());
        this.plantationInfo.setVerifiedDate(currentDate);
        this.plantationInfo.setIsInspectedDate(currentDate);
        this.plantationInfo.setPlantation_Site_Id(this.siteId);
        this.plantationInfo.setPlantation_Site_Name(this.site_hname);
        this.plantationInfo.setPlantAgainstDeadPlnt(this.et_plnt_agnst_dealplnt.getText().toString().trim());
        this.plantationInfo.setGavyan_percentage("");
        this.plantationInfo.setAverage_height_Plant(this.et_average_height_of_plant.getText().toString().trim());
        this.plantationInfo.setVan_Posako_No(this.spin_forest_poshak_pant_no.getText().toString().trim());
        this.plantationInfo.setAppVersion(getappversion());
        this.plantationInfo.setUserrole(this.userInfo.getUserrole());
        long result = new DataBaseHelper(this).UpdatePlantationInspectionDetail(this.plantationInfo, this.list_saved_gps);
        if (result > 0) {
            Toast.makeText(getApplicationContext(), "डाटा सफलतापूर्वक सेव हो गया", 1).show();
            Intent intent = new Intent(this, (Class<?>) MultiplePhotoActivity.class);
            intent.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            intent.putExtra("KEY_PID", this.plantationInfo.getInspectionID());
            intent.putExtra("pupose", "edit");
            intent.putExtra("isOpen", this.s1_data);
            startActivity(intent);
            return;
        }
        Toast.makeText(getApplicationContext(), "डाटा सेव नहीं हुआ, कृपया पुन: प्रयास करें", 0).show();
    }

    public void extractDataFromIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.plantationInfo = (PlantationInspDetails_Request) bundle.getParcelable("data");
        }
        Log.e("InspectId", this.plantationInfo.getInspectionID());
        this.tv_work_code.setText(this.plantationInfo.getWorkCode());
        this.tv_work_name.setText(this.plantationInfo.getWorkName());
        this.tv_work_type.setText(this.plantationInfo.getWorktype());
        this.tv_agency_name.setText(this.plantationInfo.getAgencyName());
        this.tv_fyear.setText(this.plantationInfo.getWorkStateFyear());
        String workCode = this.plantationInfo.getWorkCode();
        this.workCode = workCode;
        if (!workCode.equals("")) {
            String[] separated = this.workCode.split("/");
            String trim = separated[1].trim();
            this.work_code = trim;
            Log.d("WorkCode", trim);
        }
        if (this.plantationInfo.getIsUpdated() != null && this.plantationInfo.getIsInspectedBy() != null && this.plantationInfo.getIsInspectedBy().equalsIgnoreCase(this.userInfo.getUserId())) {
            this.spin_plantation_site.setSelection(getIndex(this.plantationSiteList, this.plantationInfo.getPlantation_Site_Name()));
            this.et_planted_no.setText(this.plantationInfo.getRopit_PlantNo());
            this.et_live_pant_no.setText(this.plantationInfo.getUtarjibit_PlantNo());
            this.et_plnt_agnst_dealplnt.setText(this.plantationInfo.getPlantAgainstDeadPlnt());
            this.et_average_height_of_plant.setText(this.plantationInfo.getAverage_height_Plant());
            this.et_remark.setText(this.plantationInfo.getRemarks());
            Spinner spinner = this.spin_bhugtan_plant_month;
            spinner.setSelection(((ArrayAdapter) spinner.getAdapter()).getPosition(this.plantationInfo.getPosak_bhugtaanMonth()));
            Spinner spinner2 = this.spin_bhugtan_plant_year;
            spinner2.setSelection(((ArrayAdapter) spinner2.getAdapter()).getPosition(this.plantationInfo.getPosak_bhugtaanYear()));
            this.landTypeValue = this.plantationInfo.getBhumiType();
            this.yearValue = this.plantationInfo.getFyear();
            this.list_saved_gps = new DataBaseHelper(this).getPlantation_Lat_Lng(this.plantationInfo.getInspectionID());
            this.mAdapter = new GeoTag_Adapter(this, this.list_saved_gps);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            this.recyclerView_location.setLayoutManager(mLayoutManager);
            this.recyclerView_location.setAdapter(this.mAdapter);
            this.spin_forest_poshak_pant_no.setText(this.plantationInfo.getVan_Posako_No());
            this.landType = this.landTypeValue == "1" ? "सरकारी" : "निजी";
            String str = this.yearValue;
            if (str != null) {
                if (str.contains("2014-2015")) {
                    this.spin_year.setSelection(1);
                    return;
                }
                if (this.yearValue.contains("2015-2016")) {
                    this.spin_year.setSelection(2);
                    return;
                }
                if (this.yearValue.contains("2016-2017")) {
                    this.spin_year.setSelection(3);
                } else if (this.yearValue.contains("2017-2018")) {
                    this.spin_year.setSelection(4);
                } else if (this.yearValue.contains("2018-2019")) {
                    this.spin_year.setSelection(5);
                }
            }
        }
    }

    private int getIndex(ArrayList<PlantationSiteList> dataList, String value) {
        if (dataList.size() > 0 && !value.equals("")) {
            int i = 0;
            while (i < dataList.size() && !value.equals(dataList.get(i).getPlantationNameHindi())) {
                i++;
            }
            if (i < dataList.size()) {
                return i;
            }
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        if (r0.equals("2015-2016") != false) goto L25;
     */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onItemSelected(android.widget.AdapterView<?> r8, android.view.View r9, int r10, long r11) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bih.p003in.forestdept.activity.PlantationInspectionActivity.onItemSelected(android.widget.AdapterView, android.view.View, int, long):void");
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidValue(int value) {
        for (int validValue : VALID_VALUES) {
            if (value == validValue) {
                return true;
            }
        }
        return false;
    }

    @Override // bih.p003in.forestdept.interfaces.RecyclerViewItemDelete
    public void doOnDeleteRecyclerItem(LatLongEntityUpload latLongEntityUpload) {
    }

    private void checkPointLocationAndEnablePhoto(double lat, double lng) {
        LatLongRequest latLongRequest = new LatLongRequest(this.plantationInfo.getDistCode(), this.plantationInfo.getBlockCode(), this.plantationInfo.getPanchayatCode(), String.valueOf(lat), String.valueOf(lng));
        Call<LatLongResponse> call = ApiCall.getService().getLatLong(latLongRequest);
        call.enqueue(new Callback<LatLongResponse>() { // from class: bih.in.forestdept.activity.PlantationInspectionActivity.8
            @Override // retrofit2.Callback
            public void onResponse(Call<LatLongResponse> call2, Response<LatLongResponse> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    PlantationInspectionActivity.this.isInsideRange = false;
                    Toast.makeText(PlantationInspectionActivity.this, "Invalid response from server", 0).show();
                    return;
                }
                ArrayList<LatLongList> dataList = response.body().getData();
                if (dataList == null || dataList.isEmpty()) {
                    PlantationInspectionActivity.this.isInsideRange = false;
                    return;
                }
                String pointLocation = dataList.get(0).getPointLocation();
                PlantationInspectionActivity.this.isInsideRange = "Inside".equalsIgnoreCase(pointLocation);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<LatLongResponse> call2, Throwable t) {
                PlantationInspectionActivity.this.isInsideRange = false;
                Toast.makeText(PlantationInspectionActivity.this, "Network error: " + t.getMessage(), 0).show();
            }
        });
    }
}