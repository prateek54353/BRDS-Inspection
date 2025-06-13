package bih.p003in.forestdept.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.model.ForgetPasswordResponse;
import bih.p003in.forestdept.model.SendOPTForLoginReq;
import bih.p003in.forestdept.model.VerifyOtpRequest;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import bih.p003in.forestdept.utility.Config;
import bih.p003in.forestdept.utility.Utiilties;
import com.chaos.view.PinView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class OTPLogin_Activity extends AppCompatActivity {
    private static final int MAX_ATTEMPTS = 3;
    String ClientKey;
    String Token;
    String _AuthToken;
    String _encriptionKey;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;
    String device_id;
    ProgressDialog dialog;
    String ipaddress;
    String mobileNo;
    TextView mobileText;
    String otp;
    String password;
    PinView pinView;
    TextView resendOTP;
    TextView txt_mobile_count_msg;
    String useridStr;
    Button verifyOTP;
    private int attemptCount = 0;
    String DeviceID = "";
    String IpAddress = "";
    int counter = 2;
    int remainAttemptCounter = 2;

    static /* synthetic */ int access$108(OTPLogin_Activity x0) {
        int i = x0.attemptCount;
        x0.attemptCount = i + 1;
        return i;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_otplogin);
        this._encriptionKey = CommonPref.getUserDetails(getApplicationContext()).get_encriptionKey();
        this._AuthToken = CommonPref.getUserDetails(getApplicationContext()).getAuthtoken();
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.dialog.setMessage("Please Wait...");
        this.pinView = (PinView) findViewById(C0594R.id.pinview);
        this.verifyOTP = (Button) findViewById(C0594R.id.verifyOTP);
        this.resendOTP = (TextView) findViewById(C0594R.id.resendOTP);
        this.mobileText = (TextView) findViewById(C0594R.id.mobileText);
        this.txt_mobile_count_msg = (TextView) findViewById(C0594R.id.txt_mobile_count_msg);
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        Intent intent = getIntent();
        this.useridStr = intent.getStringExtra("_encUserId");
        this.mobileNo = intent.getStringExtra("mobile_no");
        this.device_id = intent.getStringExtra("device_id");
        this.ipaddress = intent.getStringExtra("ip_address");
        this.ClientKey = intent.getStringExtra("clientKey");
        String Mobile_no = this.aes256CbcEncryptDecrypt.Decrypt(this.mobileNo, this._encriptionKey);
        StartTimerMobile();
        try {
            String lastThreeDigits = Utiilties.getLastThreeDigits(Mobile_no);
            this.mobileText.setText("..." + lastThreeDigits);
        } catch (Exception e) {
        }
        this.verifyOTP.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.OTPLogin_Activity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!OTPLogin_Activity.this.pinView.getText().toString().isEmpty()) {
                    OTPLogin_Activity oTPLogin_Activity = OTPLogin_Activity.this;
                    oTPLogin_Activity.verify_OTP(oTPLogin_Activity.pinView.getText().toString());
                } else {
                    Toast.makeText(OTPLogin_Activity.this, "OTP should not be blank", 1).show();
                }
            }
        });
        this.resendOTP.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.OTPLogin_Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                OTPLogin_Activity.access$108(OTPLogin_Activity.this);
                if (OTPLogin_Activity.this.attemptCount < 3) {
                    OTPLogin_Activity.this.CallSendOPTForLogin("" + OTPLogin_Activity.this.useridStr, "" + OTPLogin_Activity.this.mobileNo, "" + OTPLogin_Activity.this.device_id, "" + OTPLogin_Activity.this.ipaddress, "" + OTPLogin_Activity.this._AuthToken);
                    return;
                }
                OTPLogin_Activity.this.resendOTP.setEnabled(false);
                OTPLogin_Activity.this.resendOTP.setVisibility(8);
                Toast.makeText(OTPLogin_Activity.this, "Maximum attempts reached.", 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verify_OTP(String otp) {
        this.dialog.setMessage("Loading.....");
        this.dialog.show();
        VerifyOtpRequest verifyOtpRequest = new VerifyOtpRequest(this.useridStr, this.mobileNo, this.aes256CbcEncryptDecrypt.Encrypt(otp, this._encriptionKey), this.ClientKey, this.device_id, this.ipaddress);
        Call<String> call = ApiCall.getService().getVerifyOtp(verifyOtpRequest);
        call.enqueue(new Callback<String>() { // from class: bih.in.forestdept.activity.OTPLogin_Activity.3
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call2, Response<String> response) {
                if (OTPLogin_Activity.this.dialog != null) {
                    OTPLogin_Activity.this.dialog.dismiss();
                }
                OTPLogin_Activity.this.pinView.setText("");
                if (response.code() == 200) {
                    if (response.body() != null) {
                        String[] separated = response.body().split(",");
                        if (separated[0].equalsIgnoreCase("1")) {
                            Intent iUserHome = new Intent(OTPLogin_Activity.this, (Class<?>) DashboardActivity.class);
                            iUserHome.setFlags(268468224);
                            OTPLogin_Activity.this.startActivity(iUserHome);
                            return;
                        } else if (separated[0].equalsIgnoreCase(ExifInterface.GPS_MEASUREMENT_2D)) {
                            Toast.makeText(OTPLogin_Activity.this, separated[1], 0).show();
                            return;
                        } else {
                            if (separated[0].equalsIgnoreCase("0")) {
                                Toast.makeText(OTPLogin_Activity.this, separated[1], 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    Toast.makeText(OTPLogin_Activity.this, "null record", 0).show();
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call2, Throwable t) {
                if (OTPLogin_Activity.this.dialog != null) {
                    OTPLogin_Activity.this.dialog.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CallSendOPTForLogin(String _encUserId, String encMobileNo, String deviceID, String ipAddress, String _AuthToken) {
        this.pinView.setText("");
        this.dialog.setMessage("Loading......");
        this.dialog.show();
        SendOPTForLoginReq sendOPTForLoginReq = new SendOPTForLoginReq();
        sendOPTForLoginReq.setUserId(_encUserId);
        sendOPTForLoginReq.setMobileNo(encMobileNo);
        sendOPTForLoginReq.setDeviceId(deviceID);
        sendOPTForLoginReq.setIpAddress(ipAddress);
        Call<ForgetPasswordResponse> call = ApiCall.getService().getSendOPTForLogin(_AuthToken, sendOPTForLoginReq);
        call.enqueue(new Callback<ForgetPasswordResponse>() { // from class: bih.in.forestdept.activity.OTPLogin_Activity.4
            @Override // retrofit2.Callback
            public void onResponse(Call<ForgetPasswordResponse> call2, Response<ForgetPasswordResponse> response) {
                if (OTPLogin_Activity.this.dialog != null) {
                    OTPLogin_Activity.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body() != null && !response.body().equals("")) {
                        if (response.body().getStatus().booleanValue()) {
                            if (response.body().getResultMessage().startsWith("1")) {
                                String[] separated = response.body().getResultMessage().split(",");
                                if (separated[0].equalsIgnoreCase("1")) {
                                    OTPLogin_Activity.this.StartTimerMobile();
                                    return;
                                } else {
                                    if (separated[0].equalsIgnoreCase("0")) {
                                        Toast.makeText(OTPLogin_Activity.this, separated[1], 0).show();
                                        return;
                                    }
                                    return;
                                }
                            }
                            Toast.makeText(OTPLogin_Activity.this, response.body().getResultMessage(), 0).show();
                            return;
                        }
                        Toast.makeText(OTPLogin_Activity.this, response.body().getResultMessage(), 0).show();
                        return;
                    }
                    new Config().AlertDialog(OTPLogin_Activity.this, "Server OTP Generate Error!");
                    return;
                }
                Toast.makeText(OTPLogin_Activity.this, response.message(), 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ForgetPasswordResponse> call2, Throwable t) {
                if (OTPLogin_Activity.this.dialog != null) {
                    OTPLogin_Activity.this.dialog.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r6v0, types: [bih.in.forestdept.activity.OTPLogin_Activity$5] */
    public void StartTimerMobile() {
        new CountDownTimer(60000L, 1000L) { // from class: bih.in.forestdept.activity.OTPLogin_Activity.5
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                OTPLogin_Activity.this.txt_mobile_count_msg.setVisibility(0);
                OTPLogin_Activity.this.txt_mobile_count_msg.setText((millisUntilFinished / 1000) + " Sec");
                OTPLogin_Activity.this.counter++;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                OTPLogin_Activity.this.txt_mobile_count_msg.setVisibility(8);
                OTPLogin_Activity.this.resendOTP.setVisibility(0);
            }
        }.start();
    }
}