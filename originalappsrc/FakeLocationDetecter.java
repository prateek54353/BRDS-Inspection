package bih.p003in.forestdept;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import androidx.core.content.ContextCompat;
import bih.p003in.forestDept.C0594R;

/* loaded from: classes8.dex */
public class FakeLocationDetecter {
    static Location LastLocation = null;
    private static final int REQUEST_PERMISSION_RESULT_CODE = 42;
    Context context;
    FakeLocatationDetectorListener listener;
    LocationManager mlocManager = null;
    private final LocationListener mlistener = new LocationListener() { // from class: bih.in.forestdept.FakeLocationDetecter.2
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            FakeLocationDetecter fakeLocationDetecter = FakeLocationDetecter.this;
            fakeLocationDetecter.isMockLocationOn(location, fakeLocationDetecter.context);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };

    FakeLocationDetecter(Location location, Context context) {
        this.context = context;
        if (isMockLocationOn(location, context)) {
            new AlertDialog.Builder(context).setIcon(C0594R.drawable.logo1).setTitle("चेतावनी!").setMessage("इस एप्लिकेशन को जारी रखने के लिए, कृपया Mock Location को developer option से disable करें और Fake Location App को बंद करें").setCancelable(false).setPositiveButton("Exit", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.FakeLocationDetecter.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                    FakeLocationDetecter.this.listener.onExit();
                }
            }).show();
        } else {
            this.listener.onContinue();
        }
    }

    public boolean isMockLocationOn(Location location, Context context) {
        if (Build.VERSION.SDK_INT >= 18) {
            return location.isFromMockProvider();
        }
        String mockLocation = "0";
        try {
            mockLocation = Settings.Secure.getString(context.getContentResolver(), "mock_location");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return !mockLocation.equals("0");
    }

    private boolean checkLocationPermission() {
        if (!hasLocationPermission()) {
            Log.e("Tuts+", "Does not have location permission granted");
            return false;
        }
        return true;
    }

    private boolean hasLocationPermission() {
        return ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }
}