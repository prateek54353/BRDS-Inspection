package bih.p003in.forestdept.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.interfaces.CommonFunction;

/* loaded from: classes4.dex */
public class UtilitiesAlertMessasge {
    public static void showInternetAlert(final Context context) {
        AlertDialog.Builder ab = new AlertDialog.Builder(context);
        ab.setCancelable(false);
        ab.setTitle(Html.fromHtml("<font color = '#FF4B4B' ><b>Alert!!</b></font>"));
        ab.setMessage("Your Internet is not working, Kindly check your internet connection");
        ab.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.UtilitiesAlertMessasge.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int whichButton) {
                GlobalVariables.isOffline = false;
                Intent I = new Intent("android.settings.WIRELESS_SETTINGS");
                context.startActivity(I);
            }
        });
        ab.create().getWindow().getAttributes().windowAnimations = C0594R.style.AppTheme;
        ab.show();
    }

    public static void showAlertMessage(Context context, String message) {
        AlertDialog.Builder ab = new AlertDialog.Builder(context);
        ab.setCancelable(false);
        ab.setTitle(Html.fromHtml("<font color = '#FF4B4B' ><b>Alert!!</b></font>"));
        ab.setMessage(message);
        ab.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.UtilitiesAlertMessasge$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UtilitiesAlertMessasge.lambda$showAlertMessage$0(dialogInterface, i);
            }
        });
        ab.create().getWindow().getAttributes().windowAnimations = C0594R.style.AppTheme;
        ab.show();
    }

    static /* synthetic */ void lambda$showAlertMessage$0(DialogInterface dialog, int whichButton) {
    }

    public static void showErrorAlet(Context context, String title, String message) {
        AlertDialog.Builder ab = new AlertDialog.Builder(context);
        ab.setCancelable(false);
        ab.setTitle(title);
        ab.setMessage(message);
        ab.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.UtilitiesAlertMessasge.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        ab.create().getWindow().getAttributes().windowAnimations = C0594R.style.AppTheme;
        ab.show();
    }

    public static void ShowMessage(Context context, String Title, String Message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(Title);
        alertDialog.setMessage(Message);
        alertDialog.show();
    }

    public static void checkAndshowIntenetAlert(final Context context, final CommonFunction commonFunction) {
        if (!Utiilties.isOnline(context)) {
            AlertDialog.Builder ab = new AlertDialog.Builder(context);
            ab.setCancelable(false);
            ab.setTitle(Html.fromHtml("<font color = '#FF4B4B' ><b>!! Alert !!</b></font>"));
            ab.setMessage(Html.fromHtml("<font color=#000000> Internet connection not available... \n Kindly enable network connection </font>"));
            ab.setPositiveButton("Enable network connection", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.UtilitiesAlertMessasge.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int whichButton) {
                    Intent I = new Intent("android.settings.WIRELESS_SETTINGS");
                    context.startActivity(I);
                }
            });
            ab.setNegativeButton("Stay offline", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.UtilitiesAlertMessasge.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int whichButton) {
                    CommonFunction.this.doOffline();
                }
            });
            ab.show();
            return;
        }
        commonFunction.doOnLine();
    }
}