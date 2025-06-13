package bih.p003in.forestdept;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.Toast;
import bih.p003in.forestdept.activity.LoginActivity;
import bih.p003in.forestdept.activity.SplashActivity;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.model.SessionLogoutResponse;
import bih.p003in.forestdept.utility.CommonPref;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes8.dex */
public class SessionManager {
    private static final long SESSION_TIMEOUT = 1800000;
    Activity activity;
    private ProgressDialog dialog;
    private Handler sessionHandler = new Handler();
    private Runnable sessionRunnable = new Runnable() { // from class: bih.in.forestdept.SessionManager.1
        @Override // java.lang.Runnable
        public void run() {
            SessionManager.this.logoutUser();
        }
    };

    public void startSessionTimer() {
        this.sessionHandler.removeCallbacks(this.sessionRunnable);
        this.sessionHandler.postDelayed(this.sessionRunnable, SESSION_TIMEOUT);
    }

    public void resetSessionTimer() {
        this.sessionHandler.removeCallbacks(this.sessionRunnable);
        startSessionTimer();
    }

    public void stopSessionTimer() {
        this.sessionHandler.removeCallbacks(this.sessionRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logoutUser() {
        LogOut();
    }

    private void LogOut() {
        this.dialog.setMessage("Loading......");
        this.dialog.show();
        Call<List<SessionLogoutResponse>> call = ApiCall.getService().getSessionLogOut(CommonPref.getUserDetails(this.activity).getAuthtoken());
        call.enqueue(new Callback<List<SessionLogoutResponse>>() { // from class: bih.in.forestdept.SessionManager.2
            @Override // retrofit2.Callback
            public void onResponse(Call<List<SessionLogoutResponse>> call2, Response<List<SessionLogoutResponse>> response) {
                response.body();
                if (SessionManager.this.dialog != null) {
                    SessionManager.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body().get(0).getStatus().booleanValue()) {
                        SessionManager.this.confirmLogout();
                    } else {
                        Toast.makeText(SessionManager.this.activity, response.body().get(0).getMsg(), 0).show();
                        SessionManager.this.confirmLogout();
                    }
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<List<SessionLogoutResponse>> call2, Throwable t) {
                if (SessionManager.this.dialog != null) {
                    SessionManager.this.dialog.dismiss();
                }
                Toast.makeText(SessionManager.this.activity, t.getMessage(), 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmLogout() {
        SplashActivity.prefs = PreferenceManager.getDefaultSharedPreferences(this.activity);
        SharedPreferences.Editor editor = SplashActivity.prefs.edit();
        editor.putBoolean("username", false);
        editor.putBoolean("password", false);
        editor.commit();
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this.activity);
        dataBaseHelper.deleteAllPlantationRecord();
        Intent intent = new Intent(this.activity, (Class<?>) LoginActivity.class);
        intent.setFlags(268468224);
        this.activity.startActivity(intent);
        this.activity.finish();
    }
}