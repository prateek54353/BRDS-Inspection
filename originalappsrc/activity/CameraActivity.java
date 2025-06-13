package bih.p003in.forestdept.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.MarshmallowPermission;
import bih.p003in.forestdept.utility.GlobalVariables;
import bih.p003in.forestdept.utility.Utiilties;
import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/* loaded from: classes4.dex */
public class CameraActivity extends Activity {
    private static final int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private static Bitmap CompressedImage = null;
    private static byte[] CompressedImageByteArray = null;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 300;
    private static final long MIN_TIME_BW_UPDATES = 60000;
    private static final int REQUEST_PERMISSION_RESULT_CODE = 42;
    private static final String TAG = "MyActivity";
    AlertDialog.Builder alert;
    Button btnCamType;
    int camType;
    Chronometer chronometer;
    boolean init;
    private Camera mCamera;
    private CameraPreview mPreview;
    MarshmallowPermission permission;
    FrameLayout preview;
    ProgressBar progress_finding_location;
    Button takePhoto;
    static double latitude = 0.0d;
    static double longitude = 0.0d;
    static Location LastLocation = null;
    boolean backCam = true;
    LocationManager mlocManager = null;
    private final int UPDATE_ADDRESS = 1;
    private final int UPDATE_LATLNG = 2;
    private boolean isTimerStarted = false;
    Camera.PictureCallback mPicture = new Camera.PictureCallback() { // from class: bih.in.forestdept.activity.CameraActivity.2
        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] data, Camera camera) {
            try {
                Log.e("pic callback", "Yes");
                Log.d(CameraActivity.TAG, "Start");
                Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                Matrix mat = new Matrix();
                if (CameraActivity.this.camType == 1) {
                    mat.postRotate(-90.0f);
                } else {
                    mat.postRotate(90.0f);
                }
                Bitmap bMapRotate = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), mat, true);
                Date d = new Date(GlobalVariables.glocation.getTime());
                String dat = d.toLocaleString();
                Bitmap bitmap2 = Utiilties.DrawText(CameraActivity.this, bMapRotate, "Lat:" + Double.toString(GlobalVariables.glocation.getLatitude()), "Long:" + Double.toString(GlobalVariables.glocation.getLongitude()), "Accurecy:" + Float.toString(GlobalVariables.glocation.getAccuracy()), "GpsTime:" + dat);
                CameraActivity.this.setCameraImage(Utiilties.GenerateThumbnail(bitmap2, 500, 500));
            } catch (Exception ex) {
                Log.e(CameraActivity.TAG, ex.getMessage());
            }
        }
    };
    Camera.ShutterCallback shutterCallback = new Camera.ShutterCallback() { // from class: bih.in.forestdept.activity.CameraActivity.3
        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            Log.d(CameraActivity.TAG, "onShutter'd");
        }
    };
    Camera.PictureCallback rawCallback = new Camera.PictureCallback() { // from class: bih.in.forestdept.activity.CameraActivity.4
        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] data, Camera camera) {
            Log.d(CameraActivity.TAG, "onPictureTaken - raw");
        }
    };
    Handler mHandler = new Handler() { // from class: bih.in.forestdept.activity.CameraActivity.5
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                case 2:
                    String[] LatLon = ((String) msg.obj).split("-");
                    TextView tv_Lat = (TextView) CameraActivity.this.findViewById(C0594R.id.tvLat);
                    TextView tv_Lon = (TextView) CameraActivity.this.findViewById(C0594R.id.tvLon);
                    tv_Lat.setText("" + CameraActivity.latitude);
                    tv_Lon.setText("" + CameraActivity.longitude);
                    Log.e("", "Lat-Long" + LatLon[0] + "   " + LatLon[1]);
                    if (!CameraActivity.this.isTimerStarted) {
                        CameraActivity.this.startTimer();
                        break;
                    }
                    break;
            }
        }
    };
    private final LocationListener mlistener = new LocationListener() { // from class: bih.in.forestdept.activity.CameraActivity.6
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            CameraActivity cameraActivity = CameraActivity.this;
            if (!cameraActivity.isMockLocationOn(location, cameraActivity)) {
                if (Utiilties.isGPSEnabled(CameraActivity.this)) {
                    CameraActivity.LastLocation = location;
                    if (location.getLatitude() > 0.0d) {
                        GlobalVariables.glocation = location;
                        CameraActivity.this.updateUILocation(GlobalVariables.glocation);
                        if (location.getAccuracy() > 0.0f && location.getAccuracy() < 150.0f) {
                            CameraActivity.this.takePhoto.setText(" Take Photo ");
                            CameraActivity.this.progress_finding_location.setVisibility(8);
                            CameraActivity.this.takePhoto.setEnabled(true);
                            return;
                        } else {
                            CameraActivity.this.takePhoto.setText(" Wait for GPS to Stable ");
                            CameraActivity.this.progress_finding_location.setVisibility(0);
                            CameraActivity.this.takePhoto.setEnabled(false);
                            return;
                        }
                    }
                    return;
                }
                Message.obtain(CameraActivity.this.mHandler, 2, new DecimalFormat("#.0000000").format(location.getLatitude()) + "-" + new DecimalFormat("#.0000000").format(location.getLongitude()) + "-" + location.getAccuracy() + "-" + location.getTime()).sendToTarget();
                CameraActivity.this.takePhoto.setText(" Take Photo ");
                CameraActivity.this.progress_finding_location.setVisibility(8);
                return;
            }
            new AlertDialog.Builder(CameraActivity.this).setIcon(C0594R.drawable.logo1).setTitle("चेतावनी!").setMessage("कृपया Mock Location को developer option से disable करें और Fake Location App को बंद करें").setCancelable(false).setPositiveButton("Exit", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.CameraActivity.6.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                    CameraActivity.this.finish();
                }
            }).show();
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

    @Override // android.app.Activity
    protected void onResume() {
        this.init = false;
        MarshmallowPermission marshmallowPermission = new MarshmallowPermission(this, "android.permission.CAMERA");
        this.permission = marshmallowPermission;
        if (marshmallowPermission.result == -1 || this.permission.result == 0) {
            try {
                if (!this.init) {
                    initializeCamera(this.camType);
                }
            } catch (Exception e) {
            }
        } else if (this.permission.result == 1 && !this.init) {
            initializeCamera(this.camType);
        }
        MarshmallowPermission marshmallowPermission2 = new MarshmallowPermission(this, "android.permission.ACCESS_FINE_LOCATION");
        this.permission = marshmallowPermission2;
        if (marshmallowPermission2.result == -1 || this.permission.result == 0) {
            try {
                if (!this.init) {
                    initializeCamera(this.camType);
                }
            } catch (Exception e2) {
            }
        } else if (this.permission.result == 1 && !this.init) {
            initializeCamera(this.camType);
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_camera);
        this.takePhoto = (Button) findViewById(C0594R.id.btnCapture);
        this.btnCamType = (Button) findViewById(C0594R.id.btnCamType);
        this.progress_finding_location = (ProgressBar) findViewById(C0594R.id.progress_finding_location);
        if (Utiilties.isfrontCameraAvalable() && getIntent().getStringExtra("KEY_PIC").equals(ExifInterface.GPS_MEASUREMENT_2D)) {
            this.camType = 1;
        } else {
            this.camType = 0;
        }
        this.preview = (FrameLayout) findViewById(C0594R.id.camera_preview);
        this.btnCamType.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.CameraActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (CameraActivity.this.mCamera != null) {
                    CameraActivity.this.mCamera.stopPreview();
                }
                if (CameraActivity.this.camType == 0) {
                    CameraActivity.this.camType = 1;
                } else {
                    CameraActivity.this.camType = 0;
                }
                CameraActivity.this.preview.removeAllViews();
                CameraActivity cameraActivity = CameraActivity.this;
                cameraActivity.initializeCamera(cameraActivity.camType);
            }
        });
    }

    private void locationManager() {
        if (GlobalVariables.glocation == null) {
            if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return;
            }
            this.takePhoto.setEnabled(false);
            LocationManager locationManager = (LocationManager) getSystemService("location");
            this.mlocManager = locationManager;
            locationManager.requestLocationUpdates("gps", 5000L, 10.0f, this.mlistener);
            this.mlocManager.requestLocationUpdates("network", 0L, 0.01f, this.mlistener);
            this.mlocManager.requestLocationUpdates("network", 5000L, 10.0f, this.mlistener);
            return;
        }
        this.takePhoto.setEnabled(true);
        this.progress_finding_location.setVisibility(8);
        this.takePhoto.setText(" Take Photo ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeCamera(int camType) {
        this.init = true;
        this.chronometer = (Chronometer) findViewById(C0594R.id.chronometer1);
        this.isTimerStarted = false;
        Camera cameraInstance = getCameraInstance(camType);
        this.mCamera = cameraInstance;
        if (cameraInstance != null) {
            Camera.Parameters param = cameraInstance.getParameters();
            List<Camera.Size> sizes = param.getSupportedPictureSizes();
            int iTarget = 0;
            int i = 0;
            while (true) {
                if (i >= sizes.size()) {
                    break;
                }
                Camera.Size size = sizes.get(i);
                if (size.width >= 1024 && size.width <= 1280) {
                    iTarget = i;
                    break;
                } else {
                    if (size.width < 1024) {
                        iTarget = i;
                    }
                    i++;
                }
            }
            param.setJpegQuality(100);
            param.setPictureSize(sizes.get(iTarget).width, sizes.get(iTarget).height);
            this.mCamera.setParameters(param);
            this.alert = new AlertDialog.Builder(this);
            Display getOrient = getWindowManager().getDefaultDisplay();
            int rotation = getOrient.getRotation();
            switch (rotation) {
                case 0:
                    this.mCamera.setDisplayOrientation(90);
                    break;
                case 2:
                    this.mCamera.setDisplayOrientation(0);
                    break;
                case 3:
                    this.mCamera.setDisplayOrientation(90);
                    break;
            }
            try {
                CameraPreview cameraPreview = new CameraPreview(this, this.mCamera);
                this.mPreview = cameraPreview;
                this.preview.addView(cameraPreview);
            } catch (Exception e) {
                finish();
            }
            locationManager();
        }
    }

    public String setCriteria() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(2);
        String provider = this.mlocManager.getBestProvider(criteria, true);
        return provider;
    }

    public void startTimer() {
        this.chronometer.setBase(SystemClock.elapsedRealtime());
        this.chronometer.start();
        this.isTimerStarted = true;
    }

    public static Camera getCameraInstance(int cameraType) {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            int cameraId = 0;
            int i = 0;
            while (true) {
                if (i >= numberOfCameras) {
                    break;
                }
                Camera.CameraInfo info = new Camera.CameraInfo();
                Camera.getCameraInfo(i, info);
                if (info.facing != cameraType) {
                    i++;
                } else {
                    cameraId = i;
                    break;
                }
            }
            return Camera.open(cameraId);
        } catch (Exception e) {
            return null;
        }
    }

    public void onCaptureClick(View view) {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.takePicture(this.shutterCallback, this.rawCallback, this.mPicture);
        }
        Log.e("pic taken", "Yes");
        this.chronometer.setBase(SystemClock.elapsedRealtime());
        this.chronometer.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCameraImage(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, stream);
        byte[] byte_arr = stream.toByteArray();
        CompressedImageByteArray = byte_arr;
        bitmap.recycle();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("CapturedImage", CompressedImageByteArray);
        returnIntent.putExtra("Lat", new DecimalFormat("#.0000000").format(GlobalVariables.glocation.getLatitude()));
        returnIntent.putExtra("Lng", new DecimalFormat("#.0000000").format(GlobalVariables.glocation.getLongitude()));
        try {
            returnIntent.putExtra("CapturedTime", Utiilties.getCurrentDateWithTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date d = new Date(GlobalVariables.glocation.getTime());
        String dat = d.toLocaleString();
        returnIntent.putExtra("GPSTime", dat);
        returnIntent.putExtra("KEY_PIC", Integer.parseInt(getIntent().getStringExtra("KEY_PIC")));
        setResult(-1, returnIntent);
        Log.e("Set camera image", "Yes");
        finish();
    }

    public static byte[] getCompressedImage() {
        return CompressedImageByteArray;
    }

    public static void setCompressedImage(byte[] compressedImageByteArray) {
        CompressedImageByteArray = compressedImageByteArray;
    }

    public static Bitmap getCompressedBitmap() {
        return CompressedImage;
    }

    public static void setCompressedBitmap(Bitmap compressedImage) {
        CompressedImage = compressedImage;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        Log.v(getClass().getSimpleName(), "onPause()");
    }

    private boolean checkLocationPermission() {
        if (!hasLocationPermission()) {
            Log.e("Tuts+", "Does not have location permission granted");
            requestLocationPermission();
            return false;
        }
        return true;
    }

    private boolean hasLocationPermission() {
        return ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private void requestLocationPermission() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 42);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUILocation(Location location) {
        Message.obtain(this.mHandler, 2, new DecimalFormat("#.0000000").format(location.getLatitude()) + "-" + new DecimalFormat("#.0000000").format(location.getLongitude()) + "-" + location.getAccuracy() + "-" + location.getTime()).sendToTarget();
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
}