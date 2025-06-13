package bih.p003in.forestdept.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.activity.UpdatePasswordActivity;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.model.PublicKeyResponse;
import bih.p003in.forestdept.model.UpdatePasswordRequest;
import bih.p003in.forestdept.model.UpdatePasswordResponse;
import bih.p003in.forestdept.model.UserLogin;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.security.RSAEncrypter;
import bih.p003in.forestdept.security.RandomString;
import bih.p003in.forestdept.utility.CommonPref;
import bih.p003in.forestdept.utility.Config;
import bih.p003in.forestdept.utility.Utiilties;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class UpdatePasswordActivity extends AppCompatActivity {
    private String _encriptionKey;
    Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt;
    Button btn_proceed;
    String device_id;
    ProgressDialog dialog;
    EditText etConfirmPass;
    EditText etNewPass;
    String ipaddress;
    RSAEncrypter rsaEncrypter;
    String temp32Enc_key;
    TextView tv_password_strenth;
    TextView tv_username;
    UserLogin userLogin;

    /* renamed from: ID */
    String f163ID = "";
    String DeviceID = "";
    String IpAddress = "";
    String UserID = "";
    String _ClientKey = "";
    int finalStrength = 0;
    String tempKey = "";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_change_password_new);
        this.aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.dialog.setMessage(getResources().getString(C0594R.string.loading_data));
        this.userLogin = CommonPref.getUserDetails(this);
        this.btn_proceed = (Button) findViewById(C0594R.id.btn_proceed);
        this.etNewPass = (EditText) findViewById(C0594R.id.et_new_pass);
        this.etConfirmPass = (EditText) findViewById(C0594R.id.et_confirm_pass);
        this.tv_username = (TextView) findViewById(C0594R.id.tv_username);
        this.tv_password_strenth = (TextView) findViewById(C0594R.id.tv_password_strenth);
        this.UserID = getIntent().getStringExtra("UserID");
        this.f163ID = CommonPref.getLoggedUserDetails(this).getUserId();
        this.tv_username.setText(CommonPref.getLoggedUserDetails(this).getName());
        this.device_id = Utiilties.getDeviceIMEI(this);
        this.ipaddress = Utiilties.getLocalIpAddress();
        this.btn_proceed.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.activity.UpdatePasswordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpdatePasswordActivity.this.m76xcea4e822(view);
            }
        });
        this.etNewPass.addTextChangedListener(new TextWatcher() { // from class: bih.in.forestdept.activity.UpdatePasswordActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.toString().trim().length() > 0) {
                    UpdatePasswordActivity.this.checkPasswordStrength(charSequence.toString());
                } else {
                    UpdatePasswordActivity.this.tv_password_strenth.setVisibility(8);
                    UpdatePasswordActivity.this.finalStrength = 0;
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* renamed from: lambda$onCreate$0$bih-in-forestdept-activity-UpdatePasswordActivity */
    /* synthetic */ void m76xcea4e822(View view1) {
        getPublicKey();
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

    private void getPublicKey() {
        Call<PublicKeyResponse> call = ApiCall.getService().getPublicKey();
        call.enqueue(new Callback<PublicKeyResponse>() { // from class: bih.in.forestdept.activity.UpdatePasswordActivity.2
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // retrofit2.Callback
            public void onResponse(Call<PublicKeyResponse> call2, Response<PublicKeyResponse> response) {
                if (UpdatePasswordActivity.this.dialog != null) {
                    UpdatePasswordActivity.this.dialog.dismiss();
                }
                Log.e("PublicKey", response.message());
                if (response.body() == null) {
                    throw new AssertionError();
                }
                if (response.body().isStatus()) {
                    UpdatePasswordActivity.this.tempKey = response.body().getKeyDetails().get(0).getPublicKey();
                    UpdatePasswordActivity updatePasswordActivity = UpdatePasswordActivity.this;
                    updatePasswordActivity.tempKey = updatePasswordActivity.tempKey.replace("-----BEGIN PUBLIC KEY-----", "").replaceAll(System.lineSeparator(), "").replaceAll("\r", "").replace("-----END PUBLIC KEY-----", "");
                    Log.e("PublicKey", UpdatePasswordActivity.this.tempKey);
                    UpdatePasswordActivity updatePasswordActivity2 = UpdatePasswordActivity.this;
                    updatePasswordActivity2.doEncryption(updatePasswordActivity2.tempKey);
                    return;
                }
                Toast.makeText(UpdatePasswordActivity.this, "response null...", 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PublicKeyResponse> call2, Throwable t) {
                if (UpdatePasswordActivity.this.dialog != null) {
                    UpdatePasswordActivity.this.dialog.dismiss();
                }
                Log.e("error", t.getMessage());
                Toast.makeText(UpdatePasswordActivity.this, "Something went wrong...", 0).show();
                t.printStackTrace();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEncryption(String tempKey) {
        this.rsaEncrypter = new RSAEncrypter();
        try {
            String randomAlphaNumeric = RandomString.randomAlphaNumeric(32);
            this._encriptionKey = randomAlphaNumeric;
            RSAEncrypter rSAEncrypter = this.rsaEncrypter;
            byte[] cipherTextArray = rSAEncrypter.encrypt(randomAlphaNumeric, rSAEncrypter.str_to_pub_key(tempKey));
            this._ClientKey = Base64.encodeToString(cipherTextArray, 0);
            changePassword();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changePassword() {
        String newPassword = this.etNewPass.getText().toString().trim();
        String ConfirmPassowrd = this.etConfirmPass.getText().toString().trim();
        if (this.finalStrength > 4) {
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
        UpdatePasswordRequest passwordRequest = new UpdatePasswordRequest();
        passwordRequest.setClientKey(this._ClientKey);
        passwordRequest.setUserid(this.aes256CbcEncryptDecrypt.Encrypt(this.UserID, this._encriptionKey));
        passwordRequest.setPassword(this.aes256CbcEncryptDecrypt.Encrypt(this.etNewPass.getText().toString().trim(), this._encriptionKey));
        passwordRequest.setConfirmPassword(this.aes256CbcEncryptDecrypt.Encrypt(this.etConfirmPass.getText().toString().trim(), this._encriptionKey));
        passwordRequest.setDeviceId(this.aes256CbcEncryptDecrypt.Encrypt(this.device_id, this._encriptionKey));
        passwordRequest.setIpAddress(this.aes256CbcEncryptDecrypt.Encrypt(this.IpAddress, this._encriptionKey));
        Call<UpdatePasswordResponse> call = ApiCall.getService().getUpdatePass(passwordRequest);
        call.enqueue(new C06713());
    }

    /* renamed from: bih.in.forestdept.activity.UpdatePasswordActivity$3 */
    class C06713 implements Callback<UpdatePasswordResponse> {
        C06713() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<UpdatePasswordResponse> call, Response<UpdatePasswordResponse> response) {
            if (UpdatePasswordActivity.this.dialog != null) {
                UpdatePasswordActivity.this.dialog.dismiss();
            }
            if (response.code() == 200) {
                if (response.body().getStatus().booleanValue()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePasswordActivity.this);
                    builder.setIcon(C0594R.drawable.logo);
                    builder.setTitle("Message: " + response.body().getResultMessage());
                    builder.setCancelable(false);
                    builder.setPositiveButton("[Go to Login]", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.activity.UpdatePasswordActivity$3$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            UpdatePasswordActivity.C06713.this.m77x75d50ab6(dialogInterface, i);
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }
                new Config().AlertDialog(UpdatePasswordActivity.this, "Message:-" + response.body().getResultMessage());
            }
        }

        /* renamed from: lambda$onResponse$0$bih-in-forestdept-activity-UpdatePasswordActivity$3 */
        /* synthetic */ void m77x75d50ab6(DialogInterface dialog, int which) {
            dialog.dismiss();
            UpdatePasswordActivity.this.startActivity(new Intent(UpdatePasswordActivity.this, (Class<?>) LoginActivity.class));
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<UpdatePasswordResponse> call, Throwable t) {
            Log.e("TAG1111", "onResponse: on Error " + t.getMessage());
            if (UpdatePasswordActivity.this.dialog != null) {
                UpdatePasswordActivity.this.dialog.dismiss();
            }
        }
    }
}