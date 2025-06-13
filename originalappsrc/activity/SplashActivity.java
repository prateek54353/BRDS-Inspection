package bih.p003in.forestdept.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.MarshmallowPermission;
import bih.p003in.forestdept.activity.SplashActivity;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.interfaces.CommonFunction;
import bih.p003in.forestdept.model.AppDetailsResponse;
import bih.p003in.forestdept.model.AppVersion;
import bih.p003in.forestdept.utility.GlobalVariables;
import bih.p003in.forestdept.utility.Utiilties;
import com.google.android.gms.common.ConnectionResult;
import com.scottyab.rootbeer.RootBeer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class SplashActivity extends Activity implements CommonFunction {
    private static final int PERMISSION_ALL = 33;
    public static SharedPreferences prefs;
    DataBaseHelper databaseHelper;

    /* renamed from: db */
    SQLiteDatabase f162db;
    MarshmallowPermission permission;
    RootBeer rootBeer = new RootBeer(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_splash);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        this.databaseHelper = dataBaseHelper;
        try {
            dataBaseHelper.createDataBase();
            try {
                this.databaseHelper.openDataBase();
                createTable();
            } catch (SQLException sqle) {
                throw sqle;
            }
        } catch (IOException e) {
            throw new Error("Unable to create database");
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (Utiilties.validateUserDeveloper(this)) {
            Utiilties.openExitDialogToFinish(this);
            return;
        }
        boolean isRunningOnEmulator = Utiilties.isEmulator();
        if (!isRunningOnEmulator) {
            Log.d("Emulator Check", "Running on a real device");
            if (!this.rootBeer.isRooted()) {
                Log.d("Root Check", "Running on a real device");
                new Handler().postDelayed(new Runnable() { // from class: bih.in.forestdept.activity.SplashActivity$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        SplashActivity.this.requestRequiredPermission();
                    }
                }, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                checkAppUseMode();
                return;
            }
            Utiilties.rootDevice(this);
            return;
        }
        Utiilties.emulatorDevice(this);
        Log.d("Emulator Check", "Running on an emulator");
    }

    private void checkAppUseMode() {
        if (!Utiilties.isGPSEnabled(this)) {
            Utiilties.displayPromptForEnablingGPS(this);
            return;
        }
        boolean net = false;
        MarshmallowPermission marshmallowPermission = new MarshmallowPermission(this, "android.permission.ACCESS_NETWORK_STATE");
        this.permission = marshmallowPermission;
        if (marshmallowPermission.result == -1 || this.permission.result == 0) {
            net = Utiilties.isOnline(this);
        }
        if (net) {
            checkAppVersion();
            return;
        }
        if (!prefs.getBoolean("firstTime", false)) {
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle(getResources().getString(C0594R.string.no_internet_connection));
            alertDialog.setMessage(getResources().getString(C0594R.string.enable_internet_for_firsttime));
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.SplashActivity.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    GlobalVariables.isOffline = false;
                    Intent I = new Intent("android.settings.WIRELESS_SETTINGS");
                    SplashActivity.this.startActivity(I);
                    alertDialog.cancel();
                }
            });
            alertDialog.show();
            return;
        }
        if (prefs.getBoolean("firstTime", false)) {
            checkOnline();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestRequiredPermission() {
        if (Build.VERSION.SDK_INT > 32) {
            String[] PERMISSIONS_33 = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.CAMERA"};
            if (!hasPermissions(this, PERMISSIONS_33)) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_33, 33);
                return;
            } else {
                checkOnline();
                return;
            }
        }
        String[] PERMISSIONS = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, 33);
        } else {
            checkOnline();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        int index = 0;
        Map<String, Integer> PermissionsMap = new HashMap<>();
        for (String permission : permissions) {
            PermissionsMap.put(permission, Integer.valueOf(grantResults[index]));
            index++;
        }
        if (Build.VERSION.SDK_INT > 32) {
            if (PermissionsMap.get("android.permission.ACCESS_FINE_LOCATION") != null && PermissionsMap.get("android.permission.CAMERA") != null && PermissionsMap.get("android.permission.ACCESS_COARSE_LOCATION") != null) {
                if (PermissionsMap.get("android.permission.ACCESS_FINE_LOCATION").intValue() != 0 || PermissionsMap.get("android.permission.ACCESS_COARSE_LOCATION").intValue() != 0 || PermissionsMap.get("android.permission.CAMERA").intValue() != 0) {
                    Toast.makeText(this, "All permissions are required", 0).show();
                    requestRequiredPermission();
                    return;
                } else {
                    checkOnline();
                    return;
                }
            }
            finish();
            return;
        }
        if (PermissionsMap.get("android.permission.ACCESS_FINE_LOCATION") != null && PermissionsMap.get("android.permission.ACCESS_COARSE_LOCATION") != null && PermissionsMap.get("android.permission.CAMERA") != null && PermissionsMap.get("android.permission.WRITE_EXTERNAL_STORAGE") != null) {
            if (PermissionsMap.get("android.permission.ACCESS_FINE_LOCATION").intValue() != 0 || PermissionsMap.get("android.permission.ACCESS_COARSE_LOCATION").intValue() != 0 || PermissionsMap.get("android.permission.CAMERA").intValue() != 0 || PermissionsMap.get("android.permission.WRITE_EXTERNAL_STORAGE").intValue() != 0) {
                Toast.makeText(this, "All permissions are required", 0).show();
                requestRequiredPermission();
                return;
            } else {
                checkOnline();
                return;
            }
        }
        finish();
    }

    public boolean hasPermissions(Context context, String... allPermissionNeeded) {
        if (Build.VERSION.SDK_INT >= 23 && context != null && allPermissionNeeded != null) {
            for (String permission : allPermissionNeeded) {
                if (ActivityCompat.checkSelfPermission(context, permission) != 0) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public String getimeinumber() {
        TelephonyManager tm = (TelephonyManager) getSystemService("phone");
        String identifier = tm != null ? tm.getDeviceId() : null;
        if (identifier == null || identifier.length() == 0) {
            return Settings.Secure.getString(getContentResolver(), "android_id");
        }
        return identifier;
    }

    protected void checkOnline() {
        super.onResume();
        boolean net = false;
        MarshmallowPermission permission = new MarshmallowPermission(this, "android.permission.READ_PHONE_STATE");
        if (permission.result == -1 || permission.result == 0) {
            net = Utiilties.isOnline(this);
        }
        if (!net) {
            AlertDialog.Builder ab = new AlertDialog.Builder(this);
            ab.setMessage(getResources().getString(C0594R.string.no_internet_connection));
            ab.setPositiveButton(getResources().getString(C0594R.string.turnon_internet), new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.SplashActivity$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SplashActivity.this.m308lambda$checkOnline$0$bihinforestdeptactivitySplashActivity(dialogInterface, i);
                }
            });
            ab.setNegativeButton(getResources().getString(C0594R.string.continue_offline), new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.SplashActivity$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SplashActivity.this.m309lambda$checkOnline$1$bihinforestdeptactivitySplashActivity(dialogInterface, i);
                }
            });
            ab.show();
            return;
        }
        GlobalVariables.isOffline = false;
        checkAppVersion();
    }

    /* renamed from: lambda$checkOnline$0$bih-in-forestdept-activity-SplashActivity, reason: not valid java name */
    /* synthetic */ void m308lambda$checkOnline$0$bihinforestdeptactivitySplashActivity(DialogInterface dialog, int whichButton) {
        GlobalVariables.isOffline = false;
        Intent I = new Intent("android.settings.WIRELESS_SETTINGS");
        startActivity(I);
    }

    /* renamed from: lambda$checkOnline$1$bih-in-forestdept-activity-SplashActivity, reason: not valid java name */
    /* synthetic */ void m309lambda$checkOnline$1$bihinforestdeptactivitySplashActivity(DialogInterface dialog, int whichButton) {
        GlobalVariables.isOffline = true;
        start();
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

    public void validateAppVersion(final AppVersion versioninfo) {
        if (versioninfo != null) {
            String currentVersion = Utiilties.getAppVersion(this);
            if (Double.parseDouble(versioninfo.getVersion().trim()) > Double.parseDouble(currentVersion.trim())) {
                AlertDialog.Builder ab = new AlertDialog.Builder(this);
                if (versioninfo.getPriority().intValue() == 0) {
                    dothis();
                    return;
                }
                if (versioninfo.getPriority().intValue() == 1) {
                    ab.setTitle(versioninfo.getUpdateTitle());
                    ab.setMessage(versioninfo.getUpdateMsg());
                    ab.setPositiveButton("Update", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.SplashActivity$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SplashActivity.this.m73xdfc42fb9(versioninfo, dialogInterface, i);
                        }
                    });
                    ab.setNegativeButton("Ignore", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.SplashActivity$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SplashActivity.this.m74xc5059e7a(dialogInterface, i);
                        }
                    });
                    ab.show();
                    return;
                }
                if (versioninfo.getPriority().intValue() == 2) {
                    ab.setTitle(versioninfo.getUpdateTitle());
                    ab.setMessage(versioninfo.getUpdateMsg());
                    ab.setPositiveButton("Update", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.SplashActivity$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SplashActivity.this.m75xaa470d3b(versioninfo, dialogInterface, i);
                        }
                    });
                    ab.show();
                    return;
                }
                return;
            }
            dothis();
            return;
        }
        dothis();
    }

    /* renamed from: lambda$validateAppVersion$2$bih-in-forestdept-activity-SplashActivity */
    /* synthetic */ void m73xdfc42fb9(AppVersion versioninfo, DialogInterface dialog, int whichButton) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
        ComponentName comp = new ComponentName("com.android.vending", "com.google.android.finsky.activities.LaunchUrlHandlerActivity");
        launchIntent.setComponent(comp);
        launchIntent.setData(Uri.parse("market://details?id=" + getPackageName()));
        try {
            startActivity(launchIntent);
            finish();
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(versioninfo.getAppUrl())));
            finish();
        }
        dialog.dismiss();
    }

    /* renamed from: lambda$validateAppVersion$3$bih-in-forestdept-activity-SplashActivity */
    /* synthetic */ void m74xc5059e7a(DialogInterface dialog, int whichButton) {
        dialog.dismiss();
        dothis();
    }

    /* renamed from: lambda$validateAppVersion$4$bih-in-forestdept-activity-SplashActivity */
    /* synthetic */ void m75xaa470d3b(AppVersion versioninfo, DialogInterface dialog, int whichButton) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
        ComponentName comp = new ComponentName("com.android.vending", "com.google.android.finsky.activities.LaunchUrlHandlerActivity");
        launchIntent.setComponent(comp);
        launchIntent.setData(Uri.parse("market://details?id=" + getPackageName()));
        try {
            startActivity(launchIntent);
            finish();
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(versioninfo.getAppUrl())));
            finish();
        }
        dialog.dismiss();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void dothis() {
        if (!Utiilties.isOnline(this)) {
            AlertDialog.Builder ab = new AlertDialog.Builder(this);
            ab.setMessage(Html.fromHtml("<font color=#000000>Internet Connection is not avaliable..Please Turn ON Network Connection </font>"));
            ab.setPositiveButton("Turn On Network Connection", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.SplashActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int whichButton) {
                    Intent I = new Intent("android.settings.WIRELESS_SETTINGS");
                    SplashActivity.this.startActivity(I);
                }
            });
            ab.create();
            ab.show();
            return;
        }
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        prefs = defaultSharedPreferences;
        if (defaultSharedPreferences.getBoolean("username", false) && prefs.getBoolean("password", false)) {
            Intent i = new Intent(getApplicationContext(), (Class<?>) DashboardActivity.class);
            startActivity(i);
            finish();
        } else {
            Intent i2 = new Intent(getApplicationContext(), (Class<?>) LoginActivity.class);
            startActivity(i2);
            finish();
        }
    }

    /* renamed from: bih.in.forestdept.activity.SplashActivity$3 */
    class C06683 implements Callback<AppDetailsResponse> {
        C06683() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<AppDetailsResponse> call, Response<AppDetailsResponse> response) {
            if (response.body() != null && response.body().getStatus().booleanValue()) {
                if (response.body().getData() != null) {
                    SplashActivity.this.validateAppVersion(response.body().getData().get(0));
                    return;
                }
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SplashActivity.this);
                alertDialog.setTitle("Server Data Null Error");
                alertDialog.setIcon(C0594R.drawable.logo);
                alertDialog.setMessage("Temporarily Server Down");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.SplashActivity$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SplashActivity.C06683.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                alertDialog.setNegativeButton("Proceed", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.SplashActivity$3$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SplashActivity.C06683.this.m310lambda$onResponse$1$bihinforestdeptactivitySplashActivity$3(dialogInterface, i);
                    }
                });
                alertDialog.show();
                return;
            }
            AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(SplashActivity.this);
            alertDialog2.setTitle("Server Down");
            alertDialog2.setIcon(C0594R.drawable.logo);
            alertDialog2.setMessage("Temporarily Server Down");
            alertDialog2.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.SplashActivity$3$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SplashActivity.C06683.lambda$onResponse$2(dialogInterface, i);
                }
            });
            alertDialog2.show();
        }

        static /* synthetic */ void lambda$onResponse$0(DialogInterface dialog, int which) {
        }

        /* renamed from: lambda$onResponse$1$bih-in-forestdept-activity-SplashActivity$3, reason: not valid java name */
        /* synthetic */ void m310lambda$onResponse$1$bihinforestdeptactivitySplashActivity$3(DialogInterface dialog, int which) {
            SplashActivity.this.start();
        }

        static /* synthetic */ void lambda$onResponse$2(DialogInterface dialog, int which) {
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<AppDetailsResponse> call, Throwable t) {
            Log.e("error", t.getMessage());
            Toast.makeText(SplashActivity.this, "Something went wrong...", 0).show();
            t.printStackTrace();
            SplashActivity.this.start();
        }
    }

    public void checkAppVersion() {
        Call<AppDetailsResponse> call = ApiCall.getService().getAppDetails();
        call.enqueue(new C06683());
    }

    public void createTable() {
        SQLiteDatabase readableDatabase = this.databaseHelper.getReadableDatabase();
        this.f162db = readableDatabase;
        try {
            readableDatabase.execSQL("CREATE TABLE IF NOT EXISTS Plantation_Lat_Lng (A_Id INTEGER PRIMARY KEY AUTOINCREMENT, Insp_Id TEXT, GeoSeqID TEXT, GeoFenLatitude TEXT,GeoFenLongitude TEXT)");
            Log.e("Table Created", "tableName -Plantation_Lat_Lng");
        } catch (Exception e) {
            Log.e("Creation Failed", "Plantation_Lat_Lng");
        }
    }

    @Override // bih.p003in.forestdept.interfaces.CommonFunction
    public void doOffline() {
        start();
    }

    @Override // bih.p003in.forestdept.interfaces.CommonFunction
    public void doOnLine() {
        checkAppVersion();
    }
}