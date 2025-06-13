package bih.p003in.forestdept.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.exifinterface.media.ExifInterface;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.database.feedEntry;
import bih.p003in.forestdept.utility.Utiilties;

/* loaded from: classes4.dex */
public class MultiplePhotoActivity extends Activity implements View.OnClickListener {
    private static final int CAMERA_PIC = 99;
    Button btnOk;
    Intent imageData1;
    Intent imageData2;
    Intent imageData3;
    Intent imageData4;
    Intent imageData5;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    LinearLayout linearLayout2;
    RelativeLayout re_p2;
    TextView text_p1;
    int ThumbnailSize = 0;
    int exitCount = 1;
    String PID = "0";
    String AREA = "";
    String isOpen = "";
    String purpose = "";
    Boolean hasImg1 = false;
    Boolean hasImg2 = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_multiple_photo);
        this.PID = getIntent().getStringExtra("KEY_PID");
        this.isOpen = getIntent().getStringExtra("isOpen");
        this.purpose = getIntent().getStringExtra("pupose");
        if (this.PID == null) {
            this.PID = "0";
        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        this.img1 = (ImageView) findViewById(C0594R.id.imageButton1);
        this.img2 = (ImageView) findViewById(C0594R.id.imageButton2);
        this.img3 = (ImageView) findViewById(C0594R.id.imageButton3);
        this.img4 = (ImageView) findViewById(C0594R.id.imageButton4);
        this.img5 = (ImageView) findViewById(C0594R.id.imageButton5);
        this.linearLayout2 = (LinearLayout) findViewById(C0594R.id.linearLayout2);
        this.re_p2 = (RelativeLayout) findViewById(C0594R.id.re_p2);
        this.text_p1 = (TextView) findViewById(C0594R.id.text_p1);
        Button button = (Button) findViewById(C0594R.id.btnOk);
        this.btnOk = button;
        button.setOnClickListener(this);
        if (!this.purpose.equalsIgnoreCase("edit")) {
            this.btnOk.setEnabled(true);
            this.btnOk.setBackgroundResource(C0594R.drawable.buttonbackshape1);
        }
        if (displaymetrics.widthPixels < displaymetrics.heightPixels) {
            this.ThumbnailSize = displaymetrics.widthPixels / 2;
        } else {
            this.ThumbnailSize = displaymetrics.widthPixels / 4;
            ViewGroup.LayoutParams layoutParams = this.img1.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.img2.getLayoutParams();
            ViewGroup.LayoutParams layoutParams3 = this.img3.getLayoutParams();
            ViewGroup.LayoutParams layoutParams4 = this.img4.getLayoutParams();
            ViewGroup.LayoutParams layoutParams5 = this.img5.getLayoutParams();
            int i = this.ThumbnailSize;
            layoutParams5.height = i;
            layoutParams4.height = i;
            layoutParams3.height = i;
            layoutParams2.height = i;
            layoutParams.height = i;
        }
        if (this.isOpen.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
            this.text_p1.setText("बंद केंद्र की फोटो");
            this.linearLayout2.setVisibility(8);
            this.re_p2.setVisibility(8);
        }
        DataBaseHelper placeData = new DataBaseHelper(this);
        SQLiteDatabase db = placeData.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT photo,Photo1 FROM PlantationDetail where InspectionID =?", new String[]{String.valueOf(this.PID)});
        Log.e("PID  ", this.PID);
        if (cursor.moveToNext()) {
            if (!cursor.isNull(0)) {
                byte[] imgData = cursor.getBlob(cursor.getColumnIndex("photo"));
                Bitmap bmp = BitmapFactory.decodeByteArray(imgData, 0, imgData.length);
                ImageView imageView = this.img1;
                int i2 = this.ThumbnailSize;
                imageView.setImageBitmap(Utiilties.GenerateThumbnail(bmp, i2, i2));
                this.img1.setOnClickListener(this);
                this.hasImg1 = true;
            } else {
                this.img1.setOnClickListener(this);
                this.img2.setEnabled(false);
                this.img3.setEnabled(false);
                this.img4.setEnabled(false);
                this.img5.setEnabled(false);
            }
            if (!cursor.isNull(1)) {
                byte[] imgData2 = cursor.getBlob(cursor.getColumnIndex(feedEntry.Phtot1));
                Bitmap bmp2 = BitmapFactory.decodeByteArray(imgData2, 0, imgData2.length);
                ImageView imageView2 = this.img2;
                int i3 = this.ThumbnailSize;
                imageView2.setImageBitmap(Utiilties.GenerateThumbnail(bmp2, i3, i3));
                this.img2.setOnClickListener(this);
                this.hasImg2 = true;
                this.btnOk.setEnabled(true);
                this.btnOk.setBackgroundResource(C0594R.drawable.buttonbackshape);
            } else {
                this.img2.setOnClickListener(this);
                this.img5.setOnClickListener(this);
                this.img3.setEnabled(false);
                this.img4.setEnabled(false);
            }
        }
        cursor.close();
        db.close();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0594R.menu.activity_multiple_photo, menu);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.btnOk)) {
            if (!this.hasImg1.booleanValue() || !this.hasImg2.booleanValue()) {
                Toast.makeText(this, "कृपया दोनों फोटो लें", 0).show();
                return;
            }
            saveImage();
            Intent iUserHome = new Intent(getApplicationContext(), (Class<?>) DashboardActivity.class);
            iUserHome.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            startActivity(iUserHome);
            return;
        }
        LocationManager manager = (LocationManager) getSystemService("location");
        if (!manager.isProviderEnabled("gps")) {
            buildAlertMessageNoGps();
        }
        if (manager.isProviderEnabled("gps")) {
            Intent iCamera = new Intent(getApplicationContext(), (Class<?>) CameraActivity.class);
            if (view.equals(this.img1)) {
                iCamera.putExtra("KEY_PIC", "1");
            } else if (view.equals(this.img2)) {
                iCamera.putExtra("KEY_PIC", ExifInterface.GPS_MEASUREMENT_2D);
            } else if (view.equals(this.img3)) {
                iCamera.putExtra("KEY_PIC", ExifInterface.GPS_MEASUREMENT_3D);
            } else if (view.equals(this.img4)) {
                iCamera.putExtra("KEY_PIC", "4");
            } else if (view.equals(this.img5)) {
                iCamera.putExtra("KEY_PIC", "5");
            }
            startActivityForResult(iCamera, 99);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 99 && resultCode == -1) {
            byte[] imgData = data.getByteArrayExtra("CapturedImage");
            if (this.isOpen.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                this.btnOk.setEnabled(true);
            }
            switch (data.getIntExtra("KEY_PIC", 0)) {
                case 1:
                    this.imageData1 = data;
                    Bitmap bmp = BitmapFactory.decodeByteArray(imgData, 0, imgData.length);
                    this.img1.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.img1.setImageBitmap(Utiilties.GenerateThumbnail(bmp, 500, 500));
                    this.hasImg1 = true;
                    if (!this.isOpen.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                        this.img2.setEnabled(true);
                        break;
                    }
                    break;
                case 2:
                    this.imageData2 = data;
                    this.img2.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.img2.setImageBitmap(Utiilties.GenerateThumbnail(BitmapFactory.decodeByteArray(imgData, 0, imgData.length), 500, 500));
                    this.img3.setEnabled(true);
                    this.hasImg2 = true;
                    this.btnOk.setEnabled(true);
                    this.btnOk.setBackgroundResource(C0594R.drawable.buttonbackshape);
                    break;
                case 3:
                    this.imageData3 = data;
                    this.img3.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.img3.setImageBitmap(Utiilties.GenerateThumbnail(BitmapFactory.decodeByteArray(imgData, 0, imgData.length), 500, 500));
                    this.img4.setEnabled(true);
                    this.btnOk.setEnabled(true);
                    this.btnOk.setBackgroundResource(C0594R.drawable.buttonbackshape);
                    break;
                case 4:
                    this.imageData4 = data;
                    this.img4.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.img4.setImageBitmap(Utiilties.GenerateThumbnail(BitmapFactory.decodeByteArray(imgData, 0, imgData.length), 500, 500));
                    this.img5.setEnabled(true);
                    this.btnOk.setEnabled(true);
                    this.btnOk.setBackgroundResource(C0594R.drawable.buttonbackshape);
                    break;
                case 5:
                    this.imageData5 = data;
                    this.img5.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.img5.setImageBitmap(Utiilties.GenerateThumbnail(BitmapFactory.decodeByteArray(imgData, 0, imgData.length), 500, 500));
                    break;
            }
        }
    }

    private void saveImage() {
        DataBaseHelper placeData = new DataBaseHelper(this);
        SQLiteDatabase db = placeData.getWritableDatabase();
        for (int i = 0; i < 5; i++) {
            ContentValues values = new ContentValues();
            switch (i) {
                case 0:
                    Intent intent = this.imageData1;
                    if (intent != null) {
                        byte[] imgData = intent.getByteArrayExtra("CapturedImage");
                        values.put("photo", imgData);
                        values.put("Latitude_Mob", String.valueOf(this.imageData1.getStringExtra("Lat")));
                        values.put("Longitude_Mob", String.valueOf(this.imageData1.getStringExtra("Lng")));
                        Log.e("lat", String.valueOf(this.imageData1.getStringExtra("Lat")));
                        Log.e("LNG", String.valueOf(this.imageData1.getStringExtra("Lng")));
                        String[] whereArgs = {String.valueOf(this.PID)};
                        long c = db.update("PlantationDetail", values, "InspectionID=?", whereArgs);
                        this.btnOk.setEnabled(true);
                        if (c > 0) {
                            Log.e("IMAGEE", "Updated");
                            break;
                        } else {
                            Log.e("IMAGEE", "not updttad");
                            break;
                        }
                    } else {
                        break;
                    }
                case 1:
                    Intent intent2 = this.imageData2;
                    if (intent2 != null) {
                        byte[] imgData2 = intent2.getByteArrayExtra("CapturedImage");
                        values.put(feedEntry.Phtot1, imgData2);
                        String[] whereArgs2 = {String.valueOf(this.PID)};
                        db.update("PlantationDetail", values, "InspectionID=?", whereArgs2);
                        break;
                    } else {
                        break;
                    }
            }
        }
        db.close();
    }

    private void buildAlertMessageNoGps() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GPS");
        builder.setMessage("GPS is turned OFF...\nDo U Want Turn On GPS..").setCancelable(false).setPositiveButton("Turn on GPS", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.MultiplePhotoActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                MultiplePhotoActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.MultiplePhotoActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.exitCount < 4) {
            Toast.makeText(this, "कृपया दोनों फोटो लें अन्यथा सत्यापन/सर्वेक्षण पूर्ण नहीं होगा (" + this.exitCount + ")", 0).show();
            this.exitCount++;
        } else {
            DataBaseHelper db = new DataBaseHelper(this);
            db.resetPlantationInspectionUpdatedData(String.valueOf(this.PID));
            finish();
        }
    }
}