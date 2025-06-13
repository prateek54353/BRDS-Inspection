package bih.p003in.forestdept.utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.entity.UserDetails;
import bih.p003in.forestdept.model.UserDetail;
import bih.p003in.forestdept.model.UserLogin;

/* loaded from: classes4.dex */
public class CommonPref {
    public static final String CIPER_KEY = "DGRC@NIC2020";
    public static final String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    static Context context;

    CommonPref() {
    }

    CommonPref(Context context2) {
        context = context2;
    }

    public static void setUserDetails(Context context2, UserDetails userInfo) {
        SharedPreferences prefs = context2.getSharedPreferences("_USER_DETAILS", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("UserId", userInfo.getUserID());
        editor.putString("UserName", userInfo.getName());
        editor.putString("UserPassword", userInfo.getPassword());
        editor.putString("Role", userInfo.getUserrole());
        editor.putString("DistCode", userInfo.getDistrictCode());
        editor.putString("DistName", userInfo.getDistName());
        editor.putString("BlockCode", userInfo.getBlockCode());
        editor.putString("BlockName", userInfo.getBlockName());
        editor.putString("Degignation", userInfo.getDegignation());
        editor.putString("MobileNo", userInfo.getMobileNo());
        editor.commit();
    }

    public static void setUserDetails(Context context2, UserLogin userInfo) {
        SharedPreferences prefs = context2.getSharedPreferences("_USER_DETAILS", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("UserID", userInfo.getUserId());
        editor.putString("Password", userInfo.getPassword());
        editor.putString("EncriptionKey", userInfo.get_encriptionKey());
        editor.putString(ApiCall.AUTH_BASIC, userInfo.getAuthtoken());
        editor.apply();
    }

    public static UserLogin getUserDetails(Context context2) {
        UserLogin userInfo = new UserLogin();
        SharedPreferences prefs = context2.getSharedPreferences("_USER_DETAILS", 0);
        userInfo.setUserId(prefs.getString("UserID", ""));
        userInfo.setPassword(prefs.getString("Password", ""));
        userInfo.set_encriptionKey(prefs.getString("EncriptionKey", ""));
        userInfo.setAuthtoken(prefs.getString(ApiCall.AUTH_BASIC, ""));
        return userInfo;
    }

    public static UserDetail getLoggedUserDetails(Context context2) {
        UserDetail userInfo = new UserDetail();
        SharedPreferences prefs = context2.getSharedPreferences("_LOGGED_USER_DETAILS", 0);
        userInfo.setUserId(prefs.getString("UserID", ""));
        userInfo.setIsChangePassWord(prefs.getString("isChangePassWord", ""));
        userInfo.setLastVisitedOn(prefs.getString("LastVisitedOn", ""));
        userInfo.setMobileNo(prefs.getString("MobileNo", ""));
        userInfo.setIsMobileUpdated(prefs.getString("IsMobileUpdated", ""));
        userInfo.setEmail(prefs.getString("Email", ""));
        userInfo.setDistrictCode(prefs.getString("DistrictCode", ""));
        userInfo.setDistName(prefs.getString("DistName", ""));
        userInfo.setBlockCode(prefs.getString("BlockCode", ""));
        userInfo.setBlockName(prefs.getString("BlockName", ""));
        userInfo.setPanchayatCode(prefs.getString("PanchayatCode", ""));
        userInfo.setPanchayatName(prefs.getString("PanchayatName", ""));
        userInfo.setUserrole(prefs.getString("Userrole", ""));
        userInfo.setName(prefs.getString("Name", ""));
        userInfo.setDepartment(prefs.getString("Department", ""));
        return userInfo;
    }

    public static void setLoggedUserDetails(Context context2, UserDetail userInfo) {
        SharedPreferences prefs = context2.getSharedPreferences("_LOGGED_USER_DETAILS", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("UserID", userInfo.getUserId());
        editor.putString("isChangePassWord", userInfo.getIsChangePassWord());
        editor.putString("LastVisitedOn", userInfo.getLastVisitedOn());
        editor.putString("MobileNo", userInfo.getMobileNo());
        editor.putString("IsMobileUpdated", userInfo.getIsMobileUpdated());
        editor.putString("Email", userInfo.getEmail());
        editor.putString("DistrictCode", userInfo.getDistrictCode());
        editor.putString("DistName", userInfo.getDistName());
        editor.putString("BlockCode", userInfo.getBlockCode());
        editor.putString("BlockName", userInfo.getBlockName());
        editor.putString("PanchayatCode", userInfo.getPanchayatCode());
        editor.putString("PanchayatName", userInfo.getPanchayatName());
        editor.putString("Userrole", userInfo.getUserrole());
        editor.putString("Name", userInfo.getName());
        editor.putString("Department", userInfo.getDepartment());
        editor.commit();
    }

    public static void setCheckUpdate(Context context2, long dateTime) {
        SharedPreferences prefs = context2.getSharedPreferences("_CheckUpdate", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("LastVisitedDate", dateTime + 3600000);
        editor.commit();
    }

    public static int getCheckUpdate(Context context2) {
        SharedPreferences prefs = context2.getSharedPreferences("_CheckUpdate", 0);
        long a = prefs.getLong("LastVisitedDate", 0L);
        if (System.currentTimeMillis() <= a) {
            return 0;
        }
        return 1;
    }

    public static void setAwcId(Activity activity, String awcid) {
        SharedPreferences prefs = activity.getSharedPreferences("_Awcid", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("code2", awcid);
        editor.commit();
    }

    public static String getAwcId(Activity activity) {
        new UserDetails();
        SharedPreferences prefs = activity.getSharedPreferences("_Awcid", 0);
        String code2 = prefs.getString("code2", "");
        return code2;
    }
}