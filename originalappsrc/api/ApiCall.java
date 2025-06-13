package bih.p003in.forestdept.api;

import bih.p003in.forestdept.model.ADDMobileRequest;
import bih.p003in.forestdept.model.AppDetailsResponse;
import bih.p003in.forestdept.model.BlockRequest;
import bih.p003in.forestdept.model.BlockResponse;
import bih.p003in.forestdept.model.ChangePasswordRequest;
import bih.p003in.forestdept.model.ChangePasswordResponse;
import bih.p003in.forestdept.model.DistrictResponse;
import bih.p003in.forestdept.model.ForgetPasswordRequest;
import bih.p003in.forestdept.model.ForgetPasswordResponse;
import bih.p003in.forestdept.model.LatLongRequest;
import bih.p003in.forestdept.model.LatLongResponse;
import bih.p003in.forestdept.model.OtherAreaInchargeRequest;
import bih.p003in.forestdept.model.OtherAreaInchargeResponse;
import bih.p003in.forestdept.model.PanchayatRequest;
import bih.p003in.forestdept.model.PanchayatResponse;
import bih.p003in.forestdept.model.PlantationDetailRequest;
import bih.p003in.forestdept.model.PlantationDetailsResponse;
import bih.p003in.forestdept.model.PlantationInspDetails_Request;
import bih.p003in.forestdept.model.PlantationReportRequest;
import bih.p003in.forestdept.model.PlantationReportResponse;
import bih.p003in.forestdept.model.PlantationSiteResponse;
import bih.p003in.forestdept.model.PublicKeyResponse;
import bih.p003in.forestdept.model.SearchPlantationDetailRequest;
import bih.p003in.forestdept.model.SendOPTForLoginReq;
import bih.p003in.forestdept.model.SendOTPForNewMobileRequest;
import bih.p003in.forestdept.model.SessionLogoutResponse;
import bih.p003in.forestdept.model.TokencheckResponse;
import bih.p003in.forestdept.model.UpdatePasswordRequest;
import bih.p003in.forestdept.model.UpdatePasswordResponse;
import bih.p003in.forestdept.model.UserLogin;
import bih.p003in.forestdept.model.VerifyOtpForNewMobileRequest;
import bih.p003in.forestdept.model.VerifyOtpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/* loaded from: classes4.dex */
public class ApiCall {
    public static final String AUTH_BASIC = "AuthToken";
    private static final String ROOT_URL = "http://10.133.20.157:8083/API/";
    public static ApiSingleCall apiSingleCall = null;
    public static Gson gson = new GsonBuilder().setLenient().create();

    public interface ApiSingleCall {
        @POST("ADDMobile")
        Call<ForgetPasswordResponse> getADDMobile(@Header("AuthToken") String str, @Body ADDMobileRequest aDDMobileRequest);

        @GET("AppVersion")
        Call<AppDetailsResponse> getAppDetails();

        @POST("Block")
        Call<BlockResponse> getBlockData(@Header("AuthToken") String str, @Body BlockRequest blockRequest);

        @POST("ChangePassword")
        Call<ChangePasswordResponse> getChangePassword(@Header("AuthToken") String str, @Body ChangePasswordRequest changePasswordRequest);

        @POST("District")
        Call<DistrictResponse> getDistData(@Header("AuthToken") String str);

        @POST("ForgetPassword")
        Call<String> getForgetPassword(@Body ForgetPasswordRequest forgetPasswordRequest);

        @POST("getInitialDetailRDDPlantation_New_WithWorkCode")
        Call<PlantationDetailsResponse> getInitialDetailRDDPlantation_New_WithWorkCode(@Header("AuthToken") String str, @Body SearchPlantationDetailRequest searchPlantationDetailRequest);

        @POST("getInitialDetailRDDPlantation_New")
        Call<PlantationDetailsResponse> getInitialRDDPlantationDetail(@Header("AuthToken") String str, @Body PlantationDetailRequest plantationDetailRequest);

        @POST("getLatLong")
        Call<LatLongResponse> getLatLong(@Body LatLongRequest latLongRequest);

        @POST("getOtherAreaInchargeList")
        Call<OtherAreaInchargeResponse> getOtherAreaInchargeDetail(@Header("AuthToken") String str, @Body OtherAreaInchargeRequest otherAreaInchargeRequest);

        @POST("PanchyatList")
        Call<PanchayatResponse> getPanchayat(@Header("AuthToken") String str, @Body PanchayatRequest panchayatRequest);

        @POST("getPlantationInspdetailsNew")
        Call<PlantationReportResponse> getPlantationReport(@Header("AuthToken") String str, @Body PlantationReportRequest plantationReportRequest);

        @POST("GetCategaryMasterList")
        Call<PlantationSiteResponse> getPlantationSiteData(@Header("AuthToken") String str);

        @GET("GetPublicKey")
        Call<PublicKeyResponse> getPublicKey();

        @POST("SendOPTForLogin_New")
        Call<ForgetPasswordResponse> getSendOPTForLogin(@Header("AuthToken") String str, @Body SendOPTForLoginReq sendOPTForLoginReq);

        @POST("SendOTPForNewMobile")
        Call<ForgetPasswordResponse> getSendOTPForNewMobile(@Header("AuthToken") String str, @Body SendOTPForNewMobileRequest sendOTPForNewMobileRequest);

        @POST("SessionLogOut")
        Call<List<SessionLogoutResponse>> getSessionLogOut(@Header("AuthToken") String str);

        @POST("TokenCheck")
        Call<TokencheckResponse> getTokenCheck(@Header("AuthToken") String str);

        @POST("UpdatePass")
        Call<UpdatePasswordResponse> getUpdatePass(@Body UpdatePasswordRequest updatePasswordRequest);

        @POST("Authenticate")
        Call<UserLogin> getUserLogin(@Body UserLogin userLogin);

        @POST("VerifyOtp")
        Call<String> getVerifyOtp(@Body VerifyOtpRequest verifyOtpRequest);

        @POST("VerifyOtpForNewMobile")
        Call<ForgetPasswordResponse> getVerifyOtpForNewMobile(@Header("AuthToken") String str, @Body VerifyOtpForNewMobileRequest verifyOtpForNewMobileRequest);

        @POST("PlantationInspDetails_New")
        Call<String> uploadPlantationData(@Header("AuthToken") String str, @Body PlantationInspDetails_Request plantationInspDetails_Request);
    }

    public static ApiSingleCall getService() {
        if (apiSingleCall == null) {
            apiSingleCall = (ApiSingleCall) RetrofitClient.getClient(ROOT_URL).create(ApiSingleCall.class);
        }
        return apiSingleCall;
    }
}