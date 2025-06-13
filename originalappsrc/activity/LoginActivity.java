package bih.p003in.forestdept.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.Captcha.Captcha;
import bih.p003in.forestdept.Captcha.TextCaptcha;
import bih.p003in.forestdept.activity.LoginActivity;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.model.ForgetPasswordResponse;
import bih.p003in.forestdept.model.PublicKeyResponse;
import bih.p003in.forestdept.model.SendOPTForLoginReq;
import bih.p003in.forestdept.model.UserLogin;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.security.RSAEncrypter;
import bih.p003in.forestdept.security.RandomString;
import bih.p003in.forestdept.utility.CommonPref;
import bih.p003in.forestdept.utility.Config;
import bih.p003in.forestdept.utility.GlobalVariables;
import bih.p003in.forestdept.utility.Utiilties;
import com.google.android.material.card.MaterialCardViewHelper;
import java.security.NoSuchAlgorithmException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class LoginActivity extends Activity {
    private static final int PERMISSION_ALL = 108;
    public static SharedPreferences getPref;
    private String _encriptionKey;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;
    private AlertDialog alertDialog;
    ImageView btn_captcha;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    Context context;
    CustomDialogForgotPasswordClass customDialog;
    DataBaseHelper dataBaseHelper;
    String device_id;
    ProgressDialog dialog;
    EditText et_captcha;
    EditText et_userName;
    EditText et_userPass;
    ImageView img_captcha;
    String ipaddress;
    Button loginBtn;
    String[] param;
    RSAEncrypter rsaEncrypter;
    TextView tv_forgot_password;
    TextView txt_mobile_count_msg;
    String version;
    String username = "";
    String password = "";
    String _encUserId = "";
    String _encPassword = "";
    String _ClientKey = "";
    String tempKey = "";
    String ansCaptcha = "○";
    int remainAttemptCounter = 2;
    int counter = 2;
    String DeviceID = "";
    String IpAddress = "";

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_login);
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        this.dataBaseHelper = new DataBaseHelper(this);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.dialog.setMessage(getResources().getString(C0594R.string.authenticating));
        TextView textView = (TextView) findViewById(C0594R.id.tv_forgot_password);
        this.tv_forgot_password = textView;
        setOnclicklistner(textView);
        this.et_userName = (EditText) findViewById(C0594R.id.email);
        this.et_userPass = (EditText) findViewById(C0594R.id.password);
        this.loginBtn = (Button) findViewById(C0594R.id.email_sign_in_button);
        this.btn_captcha = (ImageView) findViewById(C0594R.id.btn_captcha);
        this.et_captcha = (EditText) findViewById(C0594R.id.et_captcha);
        this.img_captcha = (ImageView) findViewById(C0594R.id.img_captcha);
        this.txt_mobile_count_msg = (TextView) findViewById(C0594R.id.txt_mobile_count_msg);
        this.device_id = Utiilties.getDeviceIMEI(this);
        this.ipaddress = Utiilties.getLocalIpAddress();
        createCaptcha();
        this.btn_captcha.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.LoginActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m304lambda$onCreate$0$bihinforestdeptactivityLoginActivity(view);
            }
        });
        if (getPref == null) {
            getPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        }
        if (!getPref.getBoolean("firstTime", false)) {
            callPermissionDialog();
            SharedPreferences.Editor editor = getPref.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        }
        this.loginBtn.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.LoginActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m306lambda$onCreate$2$bihinforestdeptactivityLoginActivity(view);
            }
        });
    }

    /* renamed from: lambda$onCreate$0$bih-in-forestdept-activity-LoginActivity, reason: not valid java name */
    /* synthetic */ void m304lambda$onCreate$0$bihinforestdeptactivityLoginActivity(View view) {
        createCaptcha();
    }

    /* renamed from: lambda$onCreate$2$bih-in-forestdept-activity-LoginActivity, reason: not valid java name */
    /* synthetic */ void m306lambda$onCreate$2$bihinforestdeptactivityLoginActivity(View v) {
        this.username = this.et_userName.getText().toString();
        this.password = this.et_userPass.getText().toString();
        this.et_userName.setError(null);
        this.et_userPass.setError(null);
        if (this.username.length() == 0) {
            this.et_userName.setError("कृपया आईडी भरे");
            Toast.makeText(getApplicationContext(), "Enter User Name", 1).show();
            return;
        }
        if (this.password.length() == 0) {
            this.et_userPass.setError("कृप्या पास्वर्ड भरे");
            Toast.makeText(getApplicationContext(), "Enter Password", 1).show();
            return;
        }
        this.et_captcha.setError(null);
        if (this.et_captcha.getText().length() > 0) {
            if (this.et_captcha.getText().toString().equalsIgnoreCase(this.ansCaptcha)) {
                if (this.remainAttemptCounter == 0) {
                    StartTimerMobile();
                    this.loginBtn.setVisibility(8);
                    Toast alert = Toast.makeText(this, "Login Disabled for 30 Seconds", 0);
                    alert.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() { // from class: bih.in.forestdept.activity.LoginActivity$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            LoginActivity.this.m305lambda$onCreate$1$bihinforestdeptactivityLoginActivity();
                        }
                    }, 30000L);
                    return;
                }
                try {
                    getLogin(this.username, this.password);
                    return;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            }
            this.et_captcha.setError("कैप्चा त्रुटि!");
            this.et_captcha.getText().clear();
            createCaptcha();
            Toast.makeText(getApplicationContext(), "Enter Correct Captcha", 1).show();
            return;
        }
        this.et_captcha.setError("आवश्यक!");
        Toast.makeText(getApplicationContext(), "Enter Captcha", 1).show();
    }

    /* renamed from: lambda$onCreate$1$bih-in-forestdept-activity-LoginActivity, reason: not valid java name */
    /* synthetic */ void m305lambda$onCreate$1$bihinforestdeptactivityLoginActivity() {
        this.loginBtn.setVisibility(0);
        this.remainAttemptCounter = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callPermissionDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(C0594R.layout.dialog_layout, (ViewGroup) null);
        this.checkBox1 = (CheckBox) dialogView.findViewById(C0594R.id.checkbox1);
        this.checkBox2 = (CheckBox) dialogView.findViewById(C0594R.id.checkbox2);
        this.checkBox3 = (CheckBox) dialogView.findViewById(C0594R.id.checkbox3);
        this.checkBox4 = (CheckBox) dialogView.findViewById(C0594R.id.checkbox4);
        this.checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: bih.in.forestdept.activity.LoginActivity$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoginActivity.this.m60xb39f1e2c(compoundButton, z);
            }
        });
        this.checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: bih.in.forestdept.activity.LoginActivity$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoginActivity.this.m61xbb04534b(compoundButton, z);
            }
        });
        this.checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: bih.in.forestdept.activity.LoginActivity$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoginActivity.this.m62xc269886a(compoundButton, z);
            }
        });
        this.checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: bih.in.forestdept.activity.LoginActivity$$ExternalSyntheticLambda4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoginActivity.this.m63xc9cebd89(compoundButton, z);
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView).setNeutralButton("Exit App", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.LoginActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LoginActivity.this.m64xd133f2a8(dialogInterface, i);
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.LoginActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LoginActivity.this.m65xd89927c7(dialogInterface, i);
            }
        }).setNegativeButton("Deny", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.LoginActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this, "All permissions are required to continue", 0).show();
                LoginActivity.this.callPermissionDialog();
                dialog.dismiss();
            }
        });
        AlertDialog create = builder.create();
        this.alertDialog = create;
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: bih.in.forestdept.activity.LoginActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (LoginActivity.this.alertDialog == null || LoginActivity.this.alertDialog.isShowing()) {
                    LoginActivity.this.alertDialog.setCancelable(false);
                    LoginActivity.this.alertDialog.setCanceledOnTouchOutside(false);
                } else {
                    LoginActivity.this.alertDialog.show();
                }
            }
        });
        if (shouldShowDialog()) {
            this.alertDialog.show();
        }
        updatePositiveButton();
    }

    /* renamed from: lambda$callPermissionDialog$3$bih-in-forestdept-activity-LoginActivity */
    /* synthetic */ void m60xb39f1e2c(CompoundButton buttonView, boolean isChecked) {
        updatePositiveButton();
    }

    /* renamed from: lambda$callPermissionDialog$4$bih-in-forestdept-activity-LoginActivity */
    /* synthetic */ void m61xbb04534b(CompoundButton buttonView, boolean isChecked) {
        updatePositiveButton();
    }

    /* renamed from: lambda$callPermissionDialog$5$bih-in-forestdept-activity-LoginActivity */
    /* synthetic */ void m62xc269886a(CompoundButton buttonView, boolean isChecked) {
        updatePositiveButton();
    }

    /* renamed from: lambda$callPermissionDialog$6$bih-in-forestdept-activity-LoginActivity */
    /* synthetic */ void m63xc9cebd89(CompoundButton buttonView, boolean isChecked) {
        updatePositiveButton();
    }

    /* renamed from: lambda$callPermissionDialog$7$bih-in-forestdept-activity-LoginActivity */
    /* synthetic */ void m64xd133f2a8(DialogInterface dialog, int which) {
        finishAffinity();
    }

    /* renamed from: lambda$callPermissionDialog$8$bih-in-forestdept-activity-LoginActivity */
    /* synthetic */ void m65xd89927c7(DialogInterface dialog, int which) {
        SharedPreferences.Editor editor = getPref.edit();
        editor.putBoolean("firstTime", true);
        editor.apply();
        dialog.dismiss();
        requestRequiredPermission();
    }

    private void updatePositiveButton() {
        boolean allChecked = areAllCheckboxesChecked();
        this.alertDialog.getButton(-1).setEnabled(allChecked);
    }

    private boolean areAllCheckboxesChecked() {
        return this.checkBox1.isChecked() && this.checkBox2.isChecked() && this.checkBox3.isChecked() && this.checkBox4.isChecked();
    }

    private boolean shouldShowDialog() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null && !alertDialog.isShowing()) {
            this.alertDialog.show();
            return true;
        }
        return false;
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

    private void requestRequiredPermission() {
        if (Build.VERSION.SDK_INT > 32) {
            String[] PERMISSIONS_33 = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES", "android.permission.POST_NOTIFICATIONS"};
            if (!hasPermissions(this, PERMISSIONS_33)) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_33, 108);
                return;
            }
            SharedPreferences.Editor editor = getPref.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
            return;
        }
        String[] PERMISSIONS = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, 108);
            return;
        }
        SharedPreferences.Editor editor2 = getPref.edit();
        editor2.putBoolean("firstTime", true);
        editor2.apply();
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [bih.in.forestdept.activity.LoginActivity$3] */
    private void StartTimerMobile() {
        new CountDownTimer(30000L, 1000L) { // from class: bih.in.forestdept.activity.LoginActivity.3
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                LoginActivity.this.txt_mobile_count_msg.setVisibility(0);
                LoginActivity.this.txt_mobile_count_msg.setText("Re-Attempt open in " + (millisUntilFinished / 1000) + " Sec");
                LoginActivity.this.counter++;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                LoginActivity.this.txt_mobile_count_msg.setVisibility(8);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCaptcha() {
        Captcha c;
        if (Utiilties.validateUserDeveloper(this)) {
            c = new TextCaptcha(MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION, 100, 1, TextCaptcha.TextOptions.NUMBERS_ONLY);
        } else {
            c = new TextCaptcha(MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION, 100, 4, TextCaptcha.TextOptions.NUMBERS_AND_LETTERS);
        }
        this.img_captcha.setImageBitmap(c.getImage());
        this.img_captcha.setLayoutParams(new LinearLayout.LayoutParams(400, 130));
        this.ansCaptcha = c.getAnswer();
    }

    private void getLogin(String username, String password) throws NoSuchAlgorithmException {
        this.dialog.show();
        getPublicKey(username, password);
    }

    private void getPublicKey(final String username, final String password) {
        Call<PublicKeyResponse> call = ApiCall.getService().getPublicKey();
        call.enqueue(new Callback<PublicKeyResponse>() { // from class: bih.in.forestdept.activity.LoginActivity.4
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // retrofit2.Callback
            public void onResponse(Call<PublicKeyResponse> call2, Response<PublicKeyResponse> response) {
                if (LoginActivity.this.dialog != null) {
                    LoginActivity.this.dialog.dismiss();
                }
                Log.e("PublicKey", response.message());
                if (response.body() == null) {
                    throw new AssertionError();
                }
                if (response.body().isStatus()) {
                    LoginActivity.this.tempKey = response.body().getKeyDetails().get(0).getPublicKey();
                    LoginActivity loginActivity = LoginActivity.this;
                    loginActivity.tempKey = loginActivity.tempKey.replace("-----BEGIN PUBLIC KEY-----", "").replaceAll(System.lineSeparator(), "").replaceAll("\r", "").replace("-----END PUBLIC KEY-----", "");
                    Log.e("PublicKey", LoginActivity.this.tempKey);
                    try {
                        LoginActivity loginActivity2 = LoginActivity.this;
                        loginActivity2.doEncryption(loginActivity2.tempKey, username, password);
                        return;
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                Toast.makeText(LoginActivity.this, "response null...", 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PublicKeyResponse> call2, Throwable t) {
                if (LoginActivity.this.dialog != null) {
                    LoginActivity.this.dialog.dismiss();
                }
                Log.e("error", t.getMessage());
                Toast.makeText(LoginActivity.this, "Something went wrong...", 0).show();
                t.printStackTrace();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEncryption(String key, String username, String password) throws NoSuchAlgorithmException {
        this.rsaEncrypter = new RSAEncrypter();
        try {
            String randomAlphaNumeric = RandomString.randomAlphaNumeric(32);
            this._encriptionKey = randomAlphaNumeric;
            this._encUserId = this.aes256CbcEncryptDecrypt.Encrypt(username, randomAlphaNumeric);
            this._encPassword = this.aes256CbcEncryptDecrypt.Encrypt(password, this._encriptionKey);
            this.DeviceID = this.aes256CbcEncryptDecrypt.Encrypt(this.device_id, this._encriptionKey);
            this.IpAddress = this.aes256CbcEncryptDecrypt.Encrypt(this.ipaddress, this._encriptionKey);
            RSAEncrypter rSAEncrypter = this.rsaEncrypter;
            byte[] cipherTextArray = rSAEncrypter.encrypt(this._encriptionKey, rSAEncrypter.str_to_pub_key(key));
            this._ClientKey = Base64.encodeToString(cipherTextArray, 0);
            doLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doLogin() {
        this.dialog.show();
        UserLogin userlogin = new UserLogin(this._ClientKey, this._encUserId, this._encPassword, this.DeviceID, this.IpAddress);
        Call<UserLogin> call = ApiCall.getService().getUserLogin(userlogin);
        call.enqueue(new C06335());
    }

    /* renamed from: bih.in.forestdept.activity.LoginActivity$5 */
    class C06335 implements Callback<UserLogin> {
        C06335() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
            Log.d("RESPONSE: ", String.valueOf(response));
            UserLogin body = response.body();
            LoginActivity loginActivity = LoginActivity.this;
            final UserLogin user = new UserLogin(body, loginActivity, loginActivity._encriptionKey);
            if (LoginActivity.this.dialog != null) {
                LoginActivity.this.dialog.dismiss();
            }
            if (response.code() == 200) {
                try {
                    if (response.body() != null) {
                        if (user.getMessage() != null && user.getMessage().equalsIgnoreCase("Success")) {
                            if (user.getStatus().equalsIgnoreCase("true")) {
                                PreferenceManager.getDefaultSharedPreferences(LoginActivity.this.getApplicationContext()).edit().putString("uid", user.getUserDetails().getUserId()).commit();
                                GlobalVariables.LoggedUser = user;
                                GlobalVariables.LoggedUser.setUserId(LoginActivity.this.et_userName.getText().toString().trim());
                                GlobalVariables.LoggedUser.setPassword(LoginActivity.this.et_userPass.getText().toString().trim());
                                GlobalVariables.LoggedUser.set_encriptionKey(LoginActivity.this._encriptionKey);
                                GlobalVariables.LoggedUser.setClientkey(LoginActivity.this._ClientKey);
                                GlobalVariables.LoggedUser.setDeviceId(LoginActivity.this.DeviceID);
                                GlobalVariables.LoggedUser.setIpAddress(LoginActivity.this.IpAddress);
                                GlobalVariables.LoggedUser.setAuthtoken(response.headers().get(ApiCall.AUTH_BASIC));
                                CommonPref.setUserDetails(LoginActivity.this.getApplicationContext(), GlobalVariables.LoggedUser);
                                GlobalVariables.LoggedUserDetails = user.getUserDetails();
                                GlobalVariables.LoggedUserDetails.setUserId(user.getUserDetails().getUserId());
                                GlobalVariables.LoggedUserDetails.setLastVisitedOn(user.getUserDetails().getLastVisitedOn());
                                GlobalVariables.LoggedUserDetails.setMobileNo(user.getUserDetails().getMobileNo());
                                GlobalVariables.LoggedUserDetails.setEmail(user.getUserDetails().getEmail());
                                GlobalVariables.LoggedUserDetails.setDistrictCode(user.getUserDetails().getDistrictCode());
                                GlobalVariables.LoggedUserDetails.setDistName(user.getUserDetails().getDistName());
                                GlobalVariables.LoggedUserDetails.setBlockCode(user.getUserDetails().getBlockCode());
                                GlobalVariables.LoggedUserDetails.setBlockName(user.getUserDetails().getBlockName());
                                GlobalVariables.LoggedUserDetails.setPanchayatCode(user.getUserDetails().getPanchayatCode());
                                GlobalVariables.LoggedUserDetails.setPanchayatName(user.getUserDetails().getPanchayatName());
                                GlobalVariables.LoggedUserDetails.setUserrole(user.getUserDetails().getUserrole());
                                GlobalVariables.LoggedUserDetails.setName(user.getUserDetails().getName());
                                GlobalVariables.LoggedUserDetails.setDepartment(user.getUserDetails().getDepartment());
                                CommonPref.setLoggedUserDetails(LoginActivity.this.getApplicationContext(), GlobalVariables.LoggedUserDetails);
                                LoginActivity.this.dataBaseHelper = new DataBaseHelper(LoginActivity.this.getApplicationContext());
                                LoginActivity.this.dataBaseHelper.insertUserDetails(user.getUserDetails());
                                if (!user.getUserDetails().getIsChangePassWord().equalsIgnoreCase("Y") || user.getUserDetails().getMobileNo().isEmpty() || user.getUserDetails().getMobileNo().equalsIgnoreCase("NA") || user.getUserDetails().getIsMobileUpdated().equalsIgnoreCase("NA")) {
                                    if (user.getUserDetails().getIsChangePassWord().equalsIgnoreCase("Y") && (user.getUserDetails().getIsMobileUpdated().equalsIgnoreCase("NA") || user.getUserDetails().getIsMobileUpdated().equalsIgnoreCase(""))) {
                                        String encUserRole = LoginActivity.this.aes256CbcEncryptDecrypt.Encrypt(user.getUserDetails().getUserrole(), LoginActivity.this._encriptionKey);
                                        final Intent iUserHome = new Intent(LoginActivity.this.getApplicationContext(), (Class<?>) AddMobileActivity.class);
                                        iUserHome.putExtra("_encUserId", LoginActivity.this._encUserId);
                                        iUserHome.putExtra("device_id", LoginActivity.this.DeviceID);
                                        iUserHome.putExtra("ip_address", LoginActivity.this.IpAddress);
                                        iUserHome.putExtra("clientKey", LoginActivity.this._ClientKey);
                                        iUserHome.putExtra("UserRole", encUserRole);
                                        if (!user.getUserDetails().getMobileNo().isEmpty() && !user.getUserDetails().getMobileNo().equalsIgnoreCase("NA") && !user.getUserDetails().getMobileNo().equalsIgnoreCase("0")) {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                            builder.setTitle("Verify/Change Your Mobile No.");
                                            builder.setMessage("Your Mobile Number is  : " + user.getUserDetails().getMobileNo());
                                            builder.setCancelable(false);
                                            builder.setPositiveButton("[Verify Mobile]", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.LoginActivity$5$$ExternalSyntheticLambda0
                                                @Override // android.content.DialogInterface.OnClickListener
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    LoginActivity.C06335.this.m307lambda$onResponse$0$bihinforestdeptactivityLoginActivity$5(iUserHome, user, dialogInterface, i);
                                                }
                                            });
                                            AlertDialog dialog = builder.create();
                                            dialog.show();
                                        }
                                        iUserHome.putExtra("UserMobile", "");
                                        iUserHome.setFlags(268468224);
                                        LoginActivity.this.startActivity(iUserHome);
                                    } else {
                                        LoginActivity.this.startActivity(new Intent(LoginActivity.this, (Class<?>) ChangePasswordActivity.class));
                                    }
                                } else if (!user.getUserDetails().getUserId().equalsIgnoreCase("107335")) {
                                    String encMobileNo = LoginActivity.this.aes256CbcEncryptDecrypt.Encrypt(user.getUserDetails().getMobileNo(), LoginActivity.this._encriptionKey);
                                    LoginActivity loginActivity2 = LoginActivity.this;
                                    loginActivity2.CallSendOPTForLogin(loginActivity2._encUserId, encMobileNo, LoginActivity.this.DeviceID, LoginActivity.this.IpAddress, response.headers().get(ApiCall.AUTH_BASIC));
                                } else {
                                    Intent iUserHome2 = new Intent(LoginActivity.this, (Class<?>) DashboardActivity.class);
                                    iUserHome2.setFlags(268468224);
                                    LoginActivity.this.startActivity(iUserHome2);
                                }
                                return;
                            }
                            new Config().AlertDialog(LoginActivity.this, user.getResultMessage());
                            LoginActivity.this.createCaptcha();
                            LoginActivity.this.et_captcha.getText().clear();
                            return;
                        }
                        new Config().AlertDialog(LoginActivity.this, "Invalid username or password!");
                        LoginActivity.this.createCaptcha();
                        LoginActivity.this.et_captcha.getText().clear();
                        return;
                    }
                    Toast.makeText(LoginActivity.this, user.getResultMessage(), 0).show();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            Toast.makeText(LoginActivity.this.getApplicationContext(), "Server Error", 1).show();
        }

        /* renamed from: lambda$onResponse$0$bih-in-forestdept-activity-LoginActivity$5, reason: not valid java name */
        /* synthetic */ void m307lambda$onResponse$0$bihinforestdeptactivityLoginActivity$5(Intent iUserHome, UserLogin user, DialogInterface dialog, int which) {
            dialog.dismiss();
            iUserHome.putExtra("UserMobile", user.getUserDetails().getMobileNo());
            iUserHome.setFlags(268468224);
            LoginActivity.this.startActivity(iUserHome);
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<UserLogin> call, Throwable t) {
            if (LoginActivity.this.dialog != null) {
                LoginActivity.this.dialog.dismiss();
            }
            Toast.makeText(LoginActivity.this.getApplicationContext(), t.getMessage(), 1).show();
        }
    }

    private void setOnclicklistner(TextView onclicklistner) {
        onclicklistner.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.LoginActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m66x13846f3f(view);
            }
        });
    }

    /* renamed from: lambda$setOnclicklistner$9$bih-in-forestdept-activity-LoginActivity */
    /* synthetic */ void m66x13846f3f(View view) {
        CustomDialogForgotPasswordClass customDialogForgotPasswordClass = new CustomDialogForgotPasswordClass(this);
        this.customDialog = customDialogForgotPasswordClass;
        customDialogForgotPasswordClass.setCanceledOnTouchOutside(false);
        this.customDialog.show();
    }

    private void getIMEI() {
        this.context = this;
        try {
            this.version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            TextView tv = (TextView) findViewById(C0594R.id.txtVersion);
            tv.setText(getResources().getString(C0594R.string.app_version) + " " + this.version);
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        getIMEI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CallSendOPTForLogin(final String _encUserId, final String encMobileNo, final String deviceID, final String ipAddress, String _AuthToken) {
        this.dialog.setMessage("Loading.....");
        this.dialog.show();
        SendOPTForLoginReq sendOPTForLoginReq = new SendOPTForLoginReq();
        sendOPTForLoginReq.setUserId(_encUserId);
        sendOPTForLoginReq.setMobileNo(encMobileNo);
        sendOPTForLoginReq.setDeviceId(deviceID);
        sendOPTForLoginReq.setIpAddress(ipAddress);
        Call<ForgetPasswordResponse> call = ApiCall.getService().getSendOPTForLogin(_AuthToken, sendOPTForLoginReq);
        call.enqueue(new Callback<ForgetPasswordResponse>() { // from class: bih.in.forestdept.activity.LoginActivity.6
            @Override // retrofit2.Callback
            public void onResponse(Call<ForgetPasswordResponse> call2, Response<ForgetPasswordResponse> response) {
                if (LoginActivity.this.dialog != null) {
                    LoginActivity.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body() != null && !response.body().equals("")) {
                        if (response.body().getStatus().booleanValue()) {
                            if (response.body().getMsg().startsWith("1")) {
                                Intent iUserHome = new Intent(LoginActivity.this.getApplicationContext(), (Class<?>) OTPLogin_Activity.class);
                                iUserHome.putExtra("_encUserId", _encUserId);
                                iUserHome.putExtra("mobile_no", encMobileNo);
                                iUserHome.putExtra("device_id", deviceID);
                                iUserHome.putExtra("ip_address", ipAddress);
                                iUserHome.putExtra("clientKey", LoginActivity.this._ClientKey);
                                iUserHome.setFlags(268468224);
                                LoginActivity.this.startActivity(iUserHome);
                                return;
                            }
                            Toast.makeText(LoginActivity.this, response.body().getResultMessage(), 0).show();
                            return;
                        }
                        Toast.makeText(LoginActivity.this, response.body().getResultMessage(), 0).show();
                        return;
                    }
                    new Config().AlertDialog(LoginActivity.this, "Server OTP Generate Error!");
                    return;
                }
                Toast.makeText(LoginActivity.this, response.message(), 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ForgetPasswordResponse> call2, Throwable t) {
                if (LoginActivity.this.dialog != null) {
                    LoginActivity.this.dialog.dismiss();
                }
            }
        });
    }
}