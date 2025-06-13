package bih.p003in.forestdept.utility;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

/* loaded from: classes4.dex */
public class LocationTracker {
    private final Context context;
    private final FusedLocationProviderClient fusedClient;
    private LocationCallback locationCallback;

    public interface OnLocationResultListener {
        void onLocationResult(double d, double d2);
    }

    public LocationTracker(Context context) {
        this.context = context;
        this.fusedClient = LocationServices.getFusedLocationProviderClient(context);
    }

    public void getCurrentLocation(final OnLocationResultListener listener) {
        if (ActivityCompat.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            Context context = this.context;
            if (context instanceof Activity) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 101);
                return;
            }
            return;
        }
        LocationRequest request = LocationRequest.create().setPriority(100).setInterval(1000L).setFastestInterval(500L).setMaxWaitTime(3000L).setNumUpdates(1);
        LocationCallback locationCallback = new LocationCallback() { // from class: bih.in.forestdept.utility.LocationTracker.1
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null || locationResult.getLastLocation() == null) {
                    listener.onLocationResult(0.0d, 0.0d);
                    return;
                }
                Location location = locationResult.getLastLocation();
                listener.onLocationResult(location.getLatitude(), location.getLongitude());
                LocationTracker.this.fusedClient.removeLocationUpdates(LocationTracker.this.locationCallback);
            }
        };
        this.locationCallback = locationCallback;
        this.fusedClient.requestLocationUpdates(request, locationCallback, Looper.getMainLooper());
    }
}