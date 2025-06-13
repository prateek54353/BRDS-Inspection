package bih.p003in.forestdept.utility;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes4.dex */
public class Config {
    public static final String ENGLISH = "en";
    public static final String INDONESIA = "in";
    public static final String LANGUAGE = "language";
    public static final String USER_SHARED_PARAM = "userinfo";

    public void AlertDialog(Context context, String message) {
        new AlertDialog.Builder(context).setMessage(message).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.utility.Config$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Config.lambda$AlertDialog$0(dialogInterface, i);
            }
        }).show();
    }

    static /* synthetic */ void lambda$AlertDialog$0(DialogInterface dialog, int which) {
    }

    public String CapsSentences(String tagName) {
        String[] splits = tagName.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            String eachWord = splits[i];
            if (i > 0 && eachWord.length() > 0) {
                sb.append(" ");
            }
            String cap = eachWord.substring(0, 1).toUpperCase() + eachWord.substring(1);
            sb.append(cap);
        }
        return sb.toString();
    }

    public String changeDateFormat(String mdate) {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy");
        try {
            Date date = format1.parse(mdate);
            String newdat = formatter.format(date);
            return newdat;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String convertDateFormat(String inputDate) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat format2 = new SimpleDateFormat();
            Date date = format1.parse(inputDate.trim());
            String outputDate = format2.format(date);
            return outputDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String CurrentDateTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String outputDate = dateformat.format(c.getTime());
        return outputDate;
    }
}