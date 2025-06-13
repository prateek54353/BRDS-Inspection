package bih.p003in.forestdept.utility;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.util.Base64;
import android.view.Window;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.MarshmallowPermission;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class Utiilties {
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;

    public static long getDateDifferenceFromCurrentDate(String fdate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date fromDate = null;
        try {
            fromDate = dateFormat.parse(fdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (fromDate == null) {
            return 0L;
        }
        Calendar cCal = Calendar.getInstance();
        cCal.setTime(fromDate);
        long msDiff = Calendar.getInstance().getTimeInMillis() - cCal.getTimeInMillis();
        long daysDiff = TimeUnit.MILLISECONDS.toDays(msDiff);
        return daysDiff;
    }

    public static void ShowMessage(Context context, String Title, String Message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(Title);
        alertDialog.setMessage(Message);
        alertDialog.show();
    }

    public static void setSpinText(Spinner spin, String text) {
        for (int i = 0; i < spin.getAdapter().getCount(); i++) {
            try {
                if (spin.getAdapter().getItem(i).toString().toLowerCase().contains(text.toLowerCase())) {
                    spin.setSelection(i);
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    public static String getAppVersion(Context context) {
        try {
            String version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "NA";
        }
    }

    public static void showAlet(final Context context) {
        AlertDialog.Builder ab = new AlertDialog.Builder(context);
        ab.setCancelable(false);
        ab.setMessage(Html.fromHtml("<font color=#000000>Internet Connection is not avaliable..Please Turn ON Network Connection OR Continue With Off-line Mode..\nTo Turn ON Network Connection Press Yes Button else To Continue With Off-Line Mode Press No Button..</font>"));
        ab.setPositiveButton("Turn On Network Connection", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.Utiilties.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int whichButton) {
                GlobalVariables.isOffline = false;
                Intent I = new Intent("android.settings.WIRELESS_SETTINGS");
                context.startActivity(I);
            }
        });
        ab.create().getWindow().getAttributes().windowAnimations = C0594R.style.AppBaseTheme;
        ab.show();
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static Bitmap GenerateThumbnail(Bitmap imageBitmap, int THUMBNAIL_HEIGHT, int THUMBNAIL_WIDTH) {
        Float width = new Float(imageBitmap.getWidth());
        Float height = new Float(imageBitmap.getHeight());
        Float ratio = Float.valueOf(width.floatValue() / height.floatValue());
        Bitmap CompressedBitmap = Bitmap.createScaledBitmap(imageBitmap, (int) (THUMBNAIL_HEIGHT * ratio.floatValue()), THUMBNAIL_WIDTH, false);
        return CompressedBitmap;
    }

    public static boolean isRooted(Context context) {
        boolean isEmulator = isEmulator(context);
        String buildTags = Build.TAGS;
        if (!isEmulator && buildTags != null && buildTags.contains("test-keys")) {
            return true;
        }
        File file = new File("/system/app/Superuser.apk");
        if (file.exists()) {
            return true;
        }
        File file2 = new File("/system/xbin/su");
        return !isEmulator && file2.exists();
    }

    public static boolean isEmulator(Context context) {
        String androidId = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || androidId == null;
    }

    public static void openExitDialogToFinish(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Alert!").setMessage("Developer mode is On, Kindly disable the Developer mode to use Application!").setCancelable(false).setIcon(C0594R.drawable.ic_warning).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.Utiilties$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                activity.finish();
            }
        }).show();
    }

    public static void emulatorDevice(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Alert!").setMessage("Emulator Device").setCancelable(false).setIcon(C0594R.drawable.ic_warning).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.Utiilties$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                activity.finish();
            }
        }).show();
    }

    public static void rootDevice(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Alert!").setMessage("Root Device").setCancelable(false).setIcon(C0594R.drawable.ic_warning).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.Utiilties$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                activity.finish();
            }
        }).show();
    }

    public static boolean isEmulator() {
        String fingerprint = Build.FINGERPRINT;
        String model = Build.MODEL;
        String brand = Build.BRAND;
        String product = Build.PRODUCT;
        return fingerprint.startsWith("generic") || fingerprint.startsWith(EnvironmentCompat.MEDIA_UNKNOWN) || model.contains("google_sdk") || model.contains("Emulator") || model.contains("Android SDK built for x86") || brand.startsWith("generic") || product.contains("sdk_google") || product.contains("google_sdk") || product.contains("sdk") || product.contains("vbox") || product.contains("test-keys");
    }

    public static boolean validateUserDeveloper(Context context) {
        return (Integer.valueOf(Build.VERSION.SDK_INT).intValue() == 16 || Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17 || Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) == 0) ? false : true;
    }

    public static Bitmap DrawText(Activity activity, Bitmap mBitmap, String displaytext1, String displaytext2, String displaytext3, String displaytext4) {
        Bitmap bmOverlay = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bmOverlay);
        Paint paint = new Paint();
        paint.setColor(activity.getResources().getColor(C0594R.color.holo_red_dark));
        paint.setTextSize(40.0f);
        paint.setFlags(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        paint.setFakeBoldText(false);
        paint.setShadowLayer(1.0f, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        canvas.drawBitmap(mBitmap, 0.0f, 0.0f, paint);
        canvas.drawText(displaytext1, 10.0f, mBitmap.getHeight() - 100, paint);
        canvas.drawText(displaytext2, 10.0f, mBitmap.getHeight() - 50, paint);
        canvas.drawText(displaytext3, 10.0f, mBitmap.getHeight() - 150, paint);
        canvas.drawText(displaytext4, 10.0f, mBitmap.getHeight() - 200, paint);
        return bmOverlay;
    }

    public static String getLastThreeDigits(String number) {
        if (number.length() > 4) {
            return number.substring(number.length() - 4);
        }
        return number;
    }

    public static Object deserialize(byte[] data) {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);
            return is.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getDateString() {
        SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
        String newDateStr = postFormater.format(Calendar.getInstance().getTime());
        return newDateStr;
    }

    public static String getDateString(String Formats) {
        SimpleDateFormat postFormater = new SimpleDateFormat(Formats);
        String newDateStr = postFormater.format(Calendar.getInstance().getTime());
        return newDateStr;
    }

    public static String trimAnyTypeValue(String value) {
        if (value.equals("anyType{}")) {
            return "";
        }
        return value;
    }

    public static void setActionBarBackground(Activity activity) {
        ActionBar actionBar = activity.getActionBar();
        Resources res = activity.getResources();
        Drawable drawable = res.getDrawable(C0594R.drawable.digitallogo2);
        actionBar.setBackgroundDrawable(drawable);
    }

    public static void setStatusBarColor(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#1565a9"));
        }
    }

    public static String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(5);
        int month = cal.get(2);
        int year = cal.get(1);
        cal.get(10);
        cal.get(12);
        cal.get(13);
        String date = (month + 1) + "/" + day + "/" + year;
        return date;
    }

    public static String getCurrentDateWithTime() throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("MMM d,yyyy HH:mm");
        Date date = f.parse(getDateString());
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d,yyyy HH:mm a");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getDateTime() {
        String date = getDateString();
        String a = "";
        StringTokenizer st = new StringTokenizer(date, " ");
        while (st.hasMoreTokens()) {
            a = st.nextToken();
        }
        if (a.equals("a.m.")) {
            date = date.replace(a, "AM");
        }
        if (a.equals("p.m.")) {
            return date.replace(a, "PM");
        }
        return date;
    }

    public static String getshowCurrentDate() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(5);
        int month = cal.get(2);
        int year = cal.get(1);
        cal.get(10);
        cal.get(12);
        cal.get(13);
        String date = day + "/" + (month + 1) + "/" + year;
        return date;
    }

    public static String parseDate(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        String month = "";
        String day = "";
        String year = "";
        try {
            month = st.nextToken();
            day = st.nextToken();
            year = st.nextToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return day + "/" + month + "/" + year;
    }

    public static void displayPromptForEnablingGPS(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("Do you want open GPS setting?").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.Utiilties.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface d, int id) {
                activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                d.dismiss();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.Utiilties.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface d, int id) {
                d.cancel();
                activity.finish();
            }
        });
        builder.create().show();
    }

    public static boolean isGPSEnabled(Context mContext) {
        LocationManager locationManager = (LocationManager) mContext.getSystemService("location");
        return locationManager.isProviderEnabled("gps");
    }

    public static boolean isfrontCameraAvalable() {
        int numCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (1 == info.facing) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, 0);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static byte[] bitmaptoByte(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public static String BitArrayToString(byte[] b1) {
        String temp = Base64.encodeToString(b1, 0);
        return temp;
    }

    public static String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, 0);
        return temp;
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface intf = en.nextElement();
                Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
                while (enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getDeviceIMEI(Context context) {
        new MarshmallowPermission(context, "android.permission.READ_PHONE_STATE");
        if (Build.VERSION.SDK_INT >= 24) {
            String imei = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return imei;
        }
        TelephonyManager mTelephony = (TelephonyManager) context.getSystemService("phone");
        if (mTelephony.getDeviceId() != null) {
            String imei2 = mTelephony.getDeviceId();
            return imei2;
        }
        String imei3 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return imei3;
    }

    public static void alertForInternet(final Context context) {
        AlertDialog.Builder ab = new AlertDialog.Builder(context);
        ab.setTitle("Internet Unavailable !!!");
        ab.setMessage(Html.fromHtml("<font color=#000000>Internet Connection is not avaliable... \n Please Turn ON Network Connection.</font>"));
        ab.setPositiveButton("Turn On Network Connection", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.Utiilties.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int whichButton) {
                GlobalVariables.isOffline = false;
                Intent I = new Intent("android.settings.WIRELESS_SETTINGS");
                context.startActivity(I);
            }
        });
        ab.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.Utiilties.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        ab.show();
    }
}