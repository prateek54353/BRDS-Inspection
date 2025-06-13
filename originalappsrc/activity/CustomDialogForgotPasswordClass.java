package bih.p003in.forestdept.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.Captcha.Captcha;
import bih.p003in.forestdept.Captcha.TextCaptcha;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.model.ForgetPasswordRequest;
import bih.p003in.forestdept.model.PublicKeyResponse;
import bih.p003in.forestdept.model.VerifyOtpRequest;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.security.RSAEncrypter;
import bih.p003in.forestdept.security.RandomString;
import bih.p003in.forestdept.utility.Config;
import bih.p003in.forestdept.utility.Utiilties;
import com.google.android.material.card.MaterialCardViewHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class CustomDialogForgotPasswordClass extends Dialog implements View.OnClickListener {
    String DeviceID;
    String IpAddress;
    String Mobile_No;
    String ValidateOtp;
    String _ClientKey;
    String _encMobileNo;
    String _encUserId;
    private String _encriptionKey;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;
    String ansCaptcha;
    ImageView btn_captcha;
    Button btn_resetpassword;
    Button btn_verifyOtp;

    /* renamed from: c */
    public Activity f158c;
    int counter;

    /* renamed from: d */
    public Dialog f159d;
    String device_id;
    ProgressDialog dialog;
    EditText et_captcha;
    EditText et_mobile;
    EditText et_otp;
    EditText et_userid;
    ImageView img_captcha;
    String ipaddress;
    boolean isVerifiedMobile;
    LinearLayout ll_mobile;
    LinearLayout ll_otp;
    TextView otp_time;
    LinearLayout otpmessage;
    int remainAttemptCounter;
    RSAEncrypter rsaEncrypter;
    String temp32Enc_key;
    String tempKey;

    public CustomDialogForgotPasswordClass(Activity a) {
        super(a);
        this.counter = 2;
        this.DeviceID = "";
        this.IpAddress = "";
        this._encUserId = "";
        this._encMobileNo = "";
        this.ValidateOtp = "";
        this._ClientKey = "";
        this.tempKey = "";
        this.isVerifiedMobile = false;
        this.ansCaptcha = "○";
        this.remainAttemptCounter = 2;
        this.f158c = a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(C0594R.layout.custom_dialog_forgot_password);
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.dialog = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.dialog.setMessage(getContext().getString(C0594R.string.loading_data));
        this.device_id = Utiilties.getDeviceIMEI(this.f158c);
        this.ipaddress = Utiilties.getLocalIpAddress();
        this.btn_captcha = (ImageView) findViewById(C0594R.id.btn_captcha);
        this.et_captcha = (EditText) findViewById(C0594R.id.et_captcha);
        this.img_captcha = (ImageView) findViewById(C0594R.id.img_captcha);
        this.otpmessage = (LinearLayout) findViewById(C0594R.id.otpmessage);
        this.otp_time = (TextView) findViewById(C0594R.id.otp_time);
        LinearLayout linearLayout = (LinearLayout) findViewById(C0594R.id.ll_otp);
        this.ll_otp = linearLayout;
        linearLayout.setVisibility(8);
        this.et_userid = (EditText) findViewById(C0594R.id.et_userid);
        this.btn_resetpassword = (Button) findViewById(C0594R.id.btn_resetpassword);
        this.btn_verifyOtp = (Button) findViewById(C0594R.id.btn_verifyOtp);
        this.et_mobile = (EditText) findViewById(C0594R.id.et_mobile);
        this.et_otp = (EditText) findViewById(C0594R.id.et_otp);
        this.ll_mobile = (LinearLayout) findViewById(C0594R.id.ll_mobile);
        createCaptcha();
        this.btn_captcha.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.CustomDialogForgotPasswordClass$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomDialogForgotPasswordClass.this.m56x9a3ef6d2(view);
            }
        });
        this.btn_verifyOtp.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.CustomDialogForgotPasswordClass$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomDialogForgotPasswordClass.this.m57xa042c231(view);
            }
        });
        this.btn_resetpassword.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.CustomDialogForgotPasswordClass$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomDialogForgotPasswordClass.this.m59xac4a58ef(view);
            }
        });
    }

    /* renamed from: lambda$onCreate$0$bih-in-forestdept-activity-CustomDialogForgotPasswordClass */
    /* synthetic */ void m56x9a3ef6d2(View view) {
        createCaptcha();
    }

    /* renamed from: lambda$onCreate$1$bih-in-forestdept-activity-CustomDialogForgotPasswordClass */
    /* synthetic */ void m57xa042c231(View view) {
        if (!this.et_userid.getText().toString().trim().isEmpty() && !this.et_otp.getText().toString().trim().isEmpty()) {
            call_otp(this.et_userid.getText().toString(), this.et_mobile.getText().toString(), this.et_otp.getText().toString());
        } else {
            Toast.makeText(this.f158c, "User ID and OTP should not be blank", 1).show();
        }
    }

    /* renamed from: lambda$onCreate$3$bih-in-forestdept-activity-CustomDialogForgotPasswordClass */
    /* synthetic */ void m59xac4a58ef(View view) {
        if (this.et_userid.getText().toString().isEmpty()) {
            new Config().AlertDialog(getContext(), "Enter User ID");
            return;
        }
        this.et_captcha.setError(null);
        if (this.et_captcha.getText().length() > 0) {
            if (this.et_captcha.getText().toString().equalsIgnoreCase(this.ansCaptcha)) {
                if (this.remainAttemptCounter == 0) {
                    this.btn_resetpassword.setVisibility(8);
                    Toast alert = Toast.makeText(this.f158c, "Disabled for 30 Seconds", 0);
                    alert.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() { // from class: bih.in.forestdept.activity.CustomDialogForgotPasswordClass$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            CustomDialogForgotPasswordClass.this.m58xa6468d90();
                        }
                    }, 30000L);
                    return;
                }
                getPublicKey();
                StartTimerMobile();
                return;
            }
            this.et_captcha.setError("कैप्चा त्रुटि!");
            this.et_captcha.getText().clear();
            createCaptcha();
            Toast.makeText(this.f158c, "Enter Correct Captcha", 1).show();
            return;
        }
        this.et_captcha.setError("आवश्यक!");
        Toast.makeText(this.f158c, "Enter Captcha", 1).show();
    }

    /* renamed from: lambda$onCreate$2$bih-in-forestdept-activity-CustomDialogForgotPasswordClass */
    /* synthetic */ void m58xa6468d90() {
        this.btn_resetpassword.setVisibility(0);
        this.remainAttemptCounter = 2;
    }

    private void createCaptcha() {
        Captcha c = new TextCaptcha(MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION, 100, 4, TextCaptcha.TextOptions.NUMBERS_AND_LETTERS);
        this.img_captcha.setImageBitmap(c.getImage());
        this.img_captcha.setLayoutParams(new LinearLayout.LayoutParams(400, 130));
        this.ansCaptcha = c.getAnswer();
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [bih.in.forestdept.activity.CustomDialogForgotPasswordClass$1] */
    private void StartTimerMobile() {
        new CountDownTimer(60000L, 1000L) { // from class: bih.in.forestdept.activity.CustomDialogForgotPasswordClass.1
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                CustomDialogForgotPasswordClass.this.otp_time.setVisibility(0);
                CustomDialogForgotPasswordClass.this.otp_time.setText("" + (millisUntilFinished / 1000) + " Sec.");
                CustomDialogForgotPasswordClass.this.counter++;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                CustomDialogForgotPasswordClass.this.otp_time.setVisibility(8);
            }
        }.start();
    }

    private void getPublicKey() {
        Call<PublicKeyResponse> call = ApiCall.getService().getPublicKey();
        call.enqueue(new Callback<PublicKeyResponse>() { // from class: bih.in.forestdept.activity.CustomDialogForgotPasswordClass.2
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // retrofit2.Callback
            public void onResponse(Call<PublicKeyResponse> call2, Response<PublicKeyResponse> response) {
                if (CustomDialogForgotPasswordClass.this.dialog != null) {
                    CustomDialogForgotPasswordClass.this.dialog.dismiss();
                }
                Log.e("PublicKey", response.message());
                if (response.body() == null) {
                    throw new AssertionError();
                }
                if (response.body().isStatus()) {
                    CustomDialogForgotPasswordClass.this.tempKey = response.body().getKeyDetails().get(0).getPublicKey();
                    CustomDialogForgotPasswordClass customDialogForgotPasswordClass = CustomDialogForgotPasswordClass.this;
                    customDialogForgotPasswordClass.tempKey = customDialogForgotPasswordClass.tempKey.replace("-----BEGIN PUBLIC KEY-----", "").replaceAll(System.lineSeparator(), "").replaceAll("\r", "").replace("-----END PUBLIC KEY-----", "");
                    Log.e("PublicKey", CustomDialogForgotPasswordClass.this.tempKey);
                    CustomDialogForgotPasswordClass customDialogForgotPasswordClass2 = CustomDialogForgotPasswordClass.this;
                    customDialogForgotPasswordClass2.doEncryption(customDialogForgotPasswordClass2.tempKey);
                    return;
                }
                Toast.makeText(CustomDialogForgotPasswordClass.this.f158c, "response null...", 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PublicKeyResponse> call2, Throwable t) {
                if (CustomDialogForgotPasswordClass.this.dialog != null) {
                    CustomDialogForgotPasswordClass.this.dialog.dismiss();
                }
                Log.e("error", t.getMessage());
                Toast.makeText(CustomDialogForgotPasswordClass.this.f158c, "Something went wrong...", 0).show();
                t.printStackTrace();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEncryption(String tempKey) {
        this.rsaEncrypter = new RSAEncrypter();
        try {
            this._encriptionKey = RandomString.randomAlphaNumeric(32);
            this._encUserId = this.aes256CbcEncryptDecrypt.Encrypt(this.et_userid.getText().toString(), this._encriptionKey);
            this._encMobileNo = this.aes256CbcEncryptDecrypt.Encrypt(this.et_mobile.getText().toString(), this._encriptionKey);
            this.DeviceID = this.aes256CbcEncryptDecrypt.Encrypt(this.device_id, this._encriptionKey);
            this.IpAddress = this.aes256CbcEncryptDecrypt.Encrypt(this.ipaddress, this._encriptionKey);
            RSAEncrypter rSAEncrypter = this.rsaEncrypter;
            byte[] cipherTextArray = rSAEncrypter.encrypt(this._encriptionKey, rSAEncrypter.str_to_pub_key(tempKey));
            String encodeToString = Base64.encodeToString(cipherTextArray, 0);
            this._ClientKey = encodeToString;
            forgotPassword(this._encUserId, this._encMobileNo, this.DeviceID, this.IpAddress, encodeToString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void forgotPassword(String _encUserId, String _encMobileNo, String deviceID, String ipAddress, String client_key) {
        this.dialog.setMessage("Loading......");
        this.dialog.show();
        ForgetPasswordRequest forgetPasswordRequest = new ForgetPasswordRequest();
        forgetPasswordRequest.setUserId(_encUserId);
        forgetPasswordRequest.setMobileNo(_encMobileNo);
        forgetPasswordRequest.setClientKey(client_key);
        forgetPasswordRequest.setDeviceId(deviceID);
        forgetPasswordRequest.setIpAddress(ipAddress);
        Call<String> call = ApiCall.getService().getForgetPassword(forgetPasswordRequest);
        call.enqueue(new Callback<String>() { // from class: bih.in.forestdept.activity.CustomDialogForgotPasswordClass.3
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call2, Response<String> response) {
                if (CustomDialogForgotPasswordClass.this.dialog != null) {
                    CustomDialogForgotPasswordClass.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body() != null) {
                        String[] separated = response.body().split(",");
                        if (separated[0].equalsIgnoreCase("1")) {
                            Toast.makeText(CustomDialogForgotPasswordClass.this.f158c, separated[1], 0).show();
                            CustomDialogForgotPasswordClass.this.btn_resetpassword.setVisibility(8);
                            CustomDialogForgotPasswordClass.this.ll_otp.setVisibility(0);
                            CustomDialogForgotPasswordClass.this.et_userid.setEnabled(false);
                            CustomDialogForgotPasswordClass.this.et_userid.setClickable(false);
                            CustomDialogForgotPasswordClass.this.et_mobile.setEnabled(false);
                            CustomDialogForgotPasswordClass.this.et_mobile.setClickable(false);
                            return;
                        }
                        if (separated[0].equalsIgnoreCase("0")) {
                            Toast.makeText(CustomDialogForgotPasswordClass.this.f158c, separated[1], 0).show();
                            new Config().AlertDialog(CustomDialogForgotPasswordClass.this.f158c, separated[1]);
                            return;
                        }
                        return;
                    }
                    Toast.makeText(CustomDialogForgotPasswordClass.this.f158c, "null record", 0).show();
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call2, Throwable t) {
                if (CustomDialogForgotPasswordClass.this.dialog != null) {
                    CustomDialogForgotPasswordClass.this.dialog.dismiss();
                }
            }
        });
    }

    private void call_otp(String userid, String mobileno, String otp) {
        this.dialog.setMessage("Loading......");
        this.dialog.show();
        VerifyOtpRequest verifyOtpRequest = new VerifyOtpRequest(this.aes256CbcEncryptDecrypt.Encrypt(userid, this._encriptionKey), this.aes256CbcEncryptDecrypt.Encrypt(mobileno, this._encriptionKey), this.aes256CbcEncryptDecrypt.Encrypt(otp, this._encriptionKey), this._ClientKey, this.DeviceID, this.IpAddress);
        Call<String> call = ApiCall.getService().getVerifyOtp(verifyOtpRequest);
        call.enqueue(new Callback<String>() { // from class: bih.in.forestdept.activity.CustomDialogForgotPasswordClass.4
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call2, Response<String> response) {
                if (CustomDialogForgotPasswordClass.this.dialog != null) {
                    CustomDialogForgotPasswordClass.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body() != null) {
                        String[] separated = response.body().split(",");
                        if (separated[0].equalsIgnoreCase("1")) {
                            CustomDialogForgotPasswordClass.this.et_otp.setEnabled(false);
                            CustomDialogForgotPasswordClass.this.btn_verifyOtp.setVisibility(8);
                            Intent iUserHome = new Intent(CustomDialogForgotPasswordClass.this.f158c, (Class<?>) UpdatePasswordActivity.class);
                            iUserHome.putExtra("UserID", CustomDialogForgotPasswordClass.this.et_userid.getText().toString());
                            iUserHome.setFlags(268468224);
                            CustomDialogForgotPasswordClass.this.f158c.startActivity(iUserHome);
                            return;
                        }
                        if (separated[0].equalsIgnoreCase(ExifInterface.GPS_MEASUREMENT_2D)) {
                            Toast.makeText(CustomDialogForgotPasswordClass.this.f158c, separated[1], 0).show();
                            return;
                        } else {
                            if (separated[0].equalsIgnoreCase("0")) {
                                Toast.makeText(CustomDialogForgotPasswordClass.this.f158c, separated[1], 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    Toast.makeText(CustomDialogForgotPasswordClass.this.f158c, "null record", 0).show();
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call2, Throwable t) {
                if (CustomDialogForgotPasswordClass.this.dialog != null) {
                    CustomDialogForgotPasswordClass.this.dialog.dismiss();
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}