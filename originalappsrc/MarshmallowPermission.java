package bih.p003in.forestdept;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;

/* loaded from: classes8.dex */
public class MarshmallowPermission {
    public int result;
    final int state = 0;

    public MarshmallowPermission(Context context, String permission) {
        this.result = -1;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (ActivityCompat.checkSelfPermission(context, permission) != 0) {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, 0);
                } else {
                    this.result = 0;
                }
            }
        } catch (Exception e) {
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 0:
                if (grantResults.length > 0 && grantResults[0] == 0) {
                    this.result = 1;
                    break;
                }
                break;
        }
    }
}