package bih.p003in.forestdept.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.activity.ChangePasswordActivity;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.model.ChangePasswordRequest;
import bih.p003in.forestdept.model.ChangePasswordResponse;
import bih.p003in.forestdept.model.UserLogin;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import bih.p003in.forestdept.utility.Config;
import bih.p003in.forestdept.utility.Utiilties;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class ChangePasswordActivity extends AppCompatActivity {
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;
    Button btn_proceed;
    String device_id;
    ProgressDialog dialog;
    EditText etConfirmPass;
    EditText etNewPass;
    EditText etOldPass;
    String ipaddress;
    String temp32Enc_key;
    TextView tv_password_strenth;
    TextView tv_username;
    UserLogin userLogin;

    /* renamed from: ID */
    String f157ID = "";
    String DeviceID = "";
    String IpAddress = "";
    int finalStrength = 0;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_change_password);
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        this.temp32Enc_key = CommonPref.getUserDetails(this).get_encriptionKey();
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.dialog.setMessage(getResources().getString(C0594R.string.loading_data));
        this.userLogin = CommonPref.getUserDetails(this);
        this.btn_proceed = (Button) findViewById(C0594R.id.btn_proceed);
        this.etOldPass = (EditText) findViewById(C0594R.id.et_old_pass);
        this.etNewPass = (EditText) findViewById(C0594R.id.et_new_pass);
        this.etConfirmPass = (EditText) findViewById(C0594R.id.et_confirm_pass);
        this.tv_username = (TextView) findViewById(C0594R.id.tv_username);
        this.tv_password_strenth = (TextView) findViewById(C0594R.id.tv_password_strenth);
        this.f157ID = CommonPref.getLoggedUserDetails(this).getUserId();
        this.tv_username.setText(CommonPref.getLoggedUserDetails(this).getName());
        this.device_id = Utiilties.getDeviceIMEI(this);
        this.ipaddress = Utiilties.getLocalIpAddress();
        this.DeviceID = this.aes256CbcEncryptDecrypt.Encrypt(this.device_id, this.temp32Enc_key);
        this.IpAddress = this.aes256CbcEncryptDecrypt.Encrypt(this.ipaddress, this.temp32Enc_key);
        this.btn_proceed.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.ChangePasswordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangePasswordActivity.this.m54xb3cf1509(view);
            }
        });
        this.etNewPass.addTextChangedListener(new TextWatcher() { // from class: bih.in.forestdept.activity.ChangePasswordActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.toString().trim().length() > 0) {
                    ChangePasswordActivity.this.checkPasswordStrength(charSequence.toString());
                } else {
                    ChangePasswordActivity.this.tv_password_strenth.setVisibility(8);
                    ChangePasswordActivity.this.finalStrength = 0;
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* renamed from: lambda$onCreate$0$bih-in-forestdept-activity-ChangePasswordActivity */
    /* synthetic */ void m54xb3cf1509(View view1) {
        changePassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPasswordStrength(String password) {
        boolean containsUppercase = !password.equals(password.toLowerCase());
        boolean containsLowercase = !password.equals(password.toUpperCase());
        boolean containsDigit = password.matches(".*\\d.*");
        boolean containsSpecialChar = !password.matches("[A-Za-z0-9 ]*");
        int strength = 0;
        if (password.length() >= 8) {
            strength = 0 + 1;
        }
        if (containsUppercase) {
            strength++;
        }
        if (containsLowercase) {
            strength++;
        }
        if (containsDigit) {
            strength++;
        }
        if (containsSpecialChar) {
            strength++;
        }
        updateStrengthTextView(strength);
    }

    private void updateStrengthTextView(int strength) {
        this.tv_password_strenth.setVisibility(0);
        this.finalStrength = strength;
        switch (strength) {
            case 0:
                this.tv_password_strenth.setText("Very Weak");
                this.tv_password_strenth.setTextColor(ContextCompat.getColor(this, C0594R.color.holo_red_dark));
                break;
            case 1:
                this.tv_password_strenth.setText("Weak");
                this.tv_password_strenth.setTextColor(ContextCompat.getColor(this, C0594R.color.holo_red_dark));
                break;
            case 2:
                this.tv_password_strenth.setText("Low");
                this.tv_password_strenth.setTextColor(ContextCompat.getColor(this, C0594R.color.holo_red_dark));
                break;
            case 3:
                this.tv_password_strenth.setText("Moderate");
                this.tv_password_strenth.setTextColor(ContextCompat.getColor(this, C0594R.color.holo_red_dark));
                break;
            case 4:
                this.tv_password_strenth.setText("Strong");
                this.tv_password_strenth.setTextColor(ContextCompat.getColor(this, C0594R.color.colortextgreen));
                break;
            default:
                this.tv_password_strenth.setText("Password Strength");
                this.tv_password_strenth.setTextColor(ContextCompat.getColor(this, C0594R.color.colortextgreen));
                break;
        }
    }

    private void changePassword() {
        String oldpass = this.etOldPass.getText().toString().trim();
        String newPassword = this.etNewPass.getText().toString().trim();
        String ConfirmPassowrd = this.etConfirmPass.getText().toString().trim();
        if (this.finalStrength > 4) {
            if (oldpass == null || oldpass.isEmpty()) {
                new Config().AlertDialog(this, "Enter Old Password");
                return;
            }
            if (newPassword == null || newPassword.isEmpty()) {
                new Config().AlertDialog(this, "Enter New Password");
                return;
            }
            if (ConfirmPassowrd == null || ConfirmPassowrd.isEmpty()) {
                new Config().AlertDialog(this, "Enter Confirm password");
                return;
            } else if (!newPassword.equals(ConfirmPassowrd)) {
                new Config().AlertDialog(this, "Password not matched");
                return;
            } else {
                call_APIchangePassword();
                return;
            }
        }
        Toast.makeText(getApplicationContext(), "Password length must be at least 8 with at least 1 uppercase, 1 lowercase, 1 number and one special character", 1).show();
    }

    private void call_APIchangePassword() {
        this.dialog.setMessage("Loading......");
        this.dialog.show();
        ChangePasswordRequest PasswordRequest = new ChangePasswordRequest();
        PasswordRequest.setOldPassword(this.aes256CbcEncryptDecrypt.Encrypt(this.etOldPass.getText().toString().trim(), this.temp32Enc_key));
        PasswordRequest.setNewPassword(this.aes256CbcEncryptDecrypt.Encrypt(this.etNewPass.getText().toString().trim(), this.temp32Enc_key));
        PasswordRequest.setConfirmNewPassword(this.aes256CbcEncryptDecrypt.Encrypt(this.etConfirmPass.getText().toString().trim(), this.temp32Enc_key));
        PasswordRequest.setDeviceId(this.DeviceID);
        PasswordRequest.setIpAddress(this.IpAddress);
        Call<ChangePasswordResponse> call = ApiCall.getService().getChangePassword(CommonPref.getUserDetails(this).getAuthtoken(), PasswordRequest);
        call.enqueue(new C06142());
    }

    /* renamed from: bih.in.forestdept.activity.ChangePasswordActivity$2 */
    class C06142 implements Callback<ChangePasswordResponse> {
        C06142() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
            if (ChangePasswordActivity.this.dialog != null) {
                ChangePasswordActivity.this.dialog.dismiss();
            }
            if (response.code() == 200) {
                if (response.body().getStatus().booleanValue()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChangePasswordActivity.this);
                    builder.setIcon(C0594R.drawable.logo);
                    builder.setTitle("Message: " + response.body().getResultMessage());
                    builder.setCancelable(false);
                    builder.setPositiveButton("[Go to Login]", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.ChangePasswordActivity$2$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ChangePasswordActivity.C06142.this.m55xb92799dc(dialogInterface, i);
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }
                new Config().AlertDialog(ChangePasswordActivity.this, "Message:-" + response.body().getResultMessage());
            }
        }

        /* renamed from: lambda$onResponse$0$bih-in-forestdept-activity-ChangePasswordActivity$2 */
        /* synthetic */ void m55xb92799dc(DialogInterface dialog, int which) {
            dialog.dismiss();
            ChangePasswordActivity.this.startActivity(new Intent(ChangePasswordActivity.this, (Class<?>) LoginActivity.class));
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ChangePasswordResponse> call, Throwable t) {
            Log.e("TAG1111", "onResponse: on Error " + t.getMessage());
            if (ChangePasswordActivity.this.dialog != null) {
                ChangePasswordActivity.this.dialog.dismiss();
            }
        }
    }
}