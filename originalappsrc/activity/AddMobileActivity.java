package bih.p003in.forestdept.activity;

import android.R;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.activity.AddMobileActivity;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.model.ForgetPasswordResponse;
import bih.p003in.forestdept.model.SendOTPForNewMobileRequest;
import bih.p003in.forestdept.model.VerifyOtpForNewMobileRequest;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import bih.p003in.forestdept.utility.Utiilties;
import com.chaos.view.PinView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class AddMobileActivity extends AppCompatActivity {
    private static final int MAX_ATTEMPTS = 3;
    String ClientKey;
    String Token;
    String UserRole;
    String _encriptionKey;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;
    AlertDialog alertDialog_inter;
    Button btn_proceed;
    String device_id;
    ProgressDialog dialog;
    EditText et_mobile;
    String ipaddress;
    LayoutInflater layoutInflater;
    String otp;
    String password;
    PinView pinView;
    TextView tv_username;
    String useridStr;
    private int attemptCount = 0;
    int counter = 2;
    int remainAttemptCounter = 2;
    String AuthToken = "";

    static /* synthetic */ int access$208(AddMobileActivity x0) {
        int i = x0.attemptCount;
        x0.attemptCount = i + 1;
        return i;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_add_mobile);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.dialog.setMessage("Please Wait...");
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        this.AuthToken = CommonPref.getUserDetails(this).getAuthtoken();
        this._encriptionKey = CommonPref.getUserDetails(this).get_encriptionKey();
        this.btn_proceed = (Button) findViewById(C0594R.id.btn_proceed);
        this.et_mobile = (EditText) findViewById(C0594R.id.et_mobile);
        TextView textView = (TextView) findViewById(C0594R.id.tv_username);
        this.tv_username = textView;
        textView.setText(CommonPref.getLoggedUserDetails(this).getName());
        Intent intent = getIntent();
        this.useridStr = intent.getStringExtra("_encUserId");
        this.device_id = intent.getStringExtra("device_id");
        this.ipaddress = intent.getStringExtra("ip_address");
        this.ClientKey = intent.getStringExtra("clientKey");
        this.UserRole = intent.getStringExtra("UserRole");
        intent.getStringExtra("UserID");
        this.et_mobile.setText("" + intent.getStringExtra("UserMobile"));
        this.btn_proceed.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.AddMobileActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AddMobileActivity.this.et_mobile.getText().toString().isEmpty()) {
                    AddMobileActivity addMobileActivity = AddMobileActivity.this;
                    addMobileActivity.RequestOTPForNewMobile(addMobileActivity.aes256CbcEncryptDecrypt.Encrypt(AddMobileActivity.this.et_mobile.getText().toString().trim(), AddMobileActivity.this._encriptionKey));
                } else {
                    Toast.makeText(AddMobileActivity.this, "Mobile Number should not be blank", 1).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RequestOTPForNewMobile(String mobile_no) {
        this.dialog.setMessage("Please Wait...");
        this.dialog.show();
        SendOTPForNewMobileRequest request = new SendOTPForNewMobileRequest("" + this.useridStr, "" + mobile_no, "" + this.UserRole, "" + this.device_id, "" + this.ipaddress);
        Call<ForgetPasswordResponse> call = ApiCall.getService().getSendOTPForNewMobile(this.AuthToken, request);
        call.enqueue(new Callback<ForgetPasswordResponse>() { // from class: bih.in.forestdept.activity.AddMobileActivity.2
            @Override // retrofit2.Callback
            public void onResponse(Call<ForgetPasswordResponse> call2, Response<ForgetPasswordResponse> response) {
                if (AddMobileActivity.this.dialog != null) {
                    AddMobileActivity.this.dialog.dismiss();
                }
                if (response.code() == 200) {
                    if (response.body().getStatus().booleanValue() && response.body().getMsg() != null) {
                        AddMobileActivity.this.btn_showOtpDialog();
                    } else {
                        Toast.makeText(AddMobileActivity.this, "" + response.body().getMsg(), 0).show();
                    }
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ForgetPasswordResponse> call2, Throwable t) {
                if (AddMobileActivity.this.dialog != null) {
                    AddMobileActivity.this.dialog.dismiss();
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r14v0, types: [bih.in.forestdept.activity.AddMobileActivity$3] */
    public void btn_showOtpDialog() {
        ViewGroup view_Group = (ViewGroup) findViewById(R.id.content);
        View view = getLayoutInflater().inflate(C0594R.layout.custom_otp_dialog, view_Group, false);
        AlertDialog create = new AlertDialog.Builder(this).create();
        this.alertDialog_inter = create;
        create.setTitle("Enter Your OTP");
        this.alertDialog_inter.setCancelable(false);
        this.pinView = (PinView) view.findViewById(C0594R.id.pinview);
        Button button_otp = (Button) view.findViewById(C0594R.id.verifyOTP);
        final TextView sendOTP = (TextView) view.findViewById(C0594R.id.resendOTP);
        TextView mobileText = (TextView) view.findViewById(C0594R.id.mobileText);
        final TextView txt_mobile_count_msg = (TextView) view.findViewById(C0594R.id.txt_mobile_count_msg);
        new CountDownTimer(60000L, 1000L) { // from class: bih.in.forestdept.activity.AddMobileActivity.3
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                txt_mobile_count_msg.setVisibility(0);
                txt_mobile_count_msg.setText((millisUntilFinished / 1000) + " Sec");
                AddMobileActivity.this.counter++;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                txt_mobile_count_msg.setVisibility(8);
                sendOTP.setVisibility(0);
            }
        }.start();
        String Mobile_no = this.et_mobile.getText().toString().trim();
        String lastThreeDigits = Utiilties.getLastThreeDigits(Mobile_no);
        mobileText.setText("..." + lastThreeDigits);
        button_otp.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.AddMobileActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!AddMobileActivity.this.pinView.getText().toString().isEmpty()) {
                    AddMobileActivity addMobileActivity = AddMobileActivity.this;
                    addMobileActivity.call_VerifyOtpForNewMobile(addMobileActivity.aes256CbcEncryptDecrypt.Encrypt(AddMobileActivity.this.pinView.getText().toString(), AddMobileActivity.this._encriptionKey));
                } else {
                    Toast.makeText(AddMobileActivity.this, "OTP should not be blank", 1).show();
                }
            }
        });
        sendOTP.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.AddMobileActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AddMobileActivity.access$208(AddMobileActivity.this);
                if (AddMobileActivity.this.attemptCount >= 3) {
                    sendOTP.setEnabled(false);
                    sendOTP.setVisibility(8);
                    Toast.makeText(AddMobileActivity.this, "Maximum attempts reached.", 0).show();
                } else {
                    AddMobileActivity addMobileActivity = AddMobileActivity.this;
                    addMobileActivity.RequestOTPForNewMobile(addMobileActivity.aes256CbcEncryptDecrypt.Encrypt(AddMobileActivity.this.et_mobile.getText().toString().trim(), AddMobileActivity.this._encriptionKey));
                }
            }
        });
        this.alertDialog_inter.setView(view);
        this.alertDialog_inter.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void call_VerifyOtpForNewMobile(String otp) {
        String end_mobile = this.aes256CbcEncryptDecrypt.Encrypt(this.et_mobile.getText().toString().trim(), this._encriptionKey);
        this.dialog.setMessage("Loading.....");
        this.dialog.show();
        VerifyOtpForNewMobileRequest verifyOtpRequest = new VerifyOtpForNewMobileRequest("" + this.useridStr, "" + end_mobile, "" + otp, "" + this.UserRole, "" + this.device_id, "" + this.ipaddress);
        Call<ForgetPasswordResponse> call = ApiCall.getService().getVerifyOtpForNewMobile(this.AuthToken, verifyOtpRequest);
        call.enqueue(new C06066());
    }

    /* renamed from: bih.in.forestdept.activity.AddMobileActivity$6 */
    class C06066 implements Callback<ForgetPasswordResponse> {
        C06066() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ForgetPasswordResponse> call, Response<ForgetPasswordResponse> response) {
            if (AddMobileActivity.this.dialog != null) {
                AddMobileActivity.this.dialog.dismiss();
            }
            AddMobileActivity.this.pinView.setText("");
            if (response.code() == 200) {
                if (response.body() != null) {
                    AddMobileActivity.this.alertDialog_inter.dismiss();
                    String[] separated = response.body().getMsg().split(",");
                    if (separated[0].equalsIgnoreCase("1")) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() { // from class: bih.in.forestdept.activity.AddMobileActivity$6$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                AddMobileActivity.C06066.this.m53x3bca4f30();
                            }
                        }, 30000L);
                        Intent iUserHome = new Intent(AddMobileActivity.this, (Class<?>) DashboardActivity.class);
                        iUserHome.setFlags(268468224);
                        AddMobileActivity.this.startActivity(iUserHome);
                        return;
                    }
                    if (separated[0].equalsIgnoreCase(ExifInterface.GPS_MEASUREMENT_2D)) {
                        Toast.makeText(AddMobileActivity.this, separated[1], 0).show();
                        return;
                    } else {
                        if (separated[0].equalsIgnoreCase("0")) {
                            Toast.makeText(AddMobileActivity.this, separated[1], 0).show();
                            return;
                        }
                        return;
                    }
                }
                Toast.makeText(AddMobileActivity.this, "null record", 0).show();
            }
        }

        /* renamed from: lambda$onResponse$0$bih-in-forestdept-activity-AddMobileActivity$6 */
        /* synthetic */ void m53x3bca4f30() {
            AddMobileActivity.this.remainAttemptCounter = 2;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ForgetPasswordResponse> call, Throwable t) {
            if (AddMobileActivity.this.dialog != null) {
                AddMobileActivity.this.dialog.dismiss();
            }
        }
    }
}