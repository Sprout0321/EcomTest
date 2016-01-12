package tw.com.ecomuniversal.ecomtest5;

import android.content.Context;

public class SharedPreferencesManager {
//	private static final String TAG = "SharedPreferencesManager";
	public static final String DEFAULT ="N/A";
	
//==InternalData=======================================================================================
	
	public static void saveFirstTime(Context context, String firstTime) {
		String[] key = {"firstTime"};
		String[] value = {firstTime};										//Log.w(TAG + " > saveFirstTime()", "firstTime 是 " + firstTime);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getFirstTime(Context context) {
		String[] key = {"firstTime"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String firstTime = value[0];											//Log.w(TAG + " > getFirstTime()", "firstTime 是 " + firstTime);
		if (firstTime.equals(DEFAULT)) {
			return "true";
		} else {
			return firstTime;
		}
	}
	
	public static void saveDeviceId(Context context, String deviceId) {
		String[] key = {"deviceId"};
		String[] value = {deviceId};										//Log.w(TAG + " > saveDeviceId()", "deviceId 是 " + deviceId);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getDeviceId(Context context) {
		String[] key = {"deviceId"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String deviceId = value[0];											//Log.w(TAG + " > getDeviceId()", "deviceId 是 " + deviceId);
		if (deviceId.equals(DEFAULT)) {
			return null;
		} else {
			return deviceId;
		}
	}
	
	public static void saveBrandAndModel(Context context, String brandAndModel) {
		String[] key = {"brandAndModel"};
		String[] value = {brandAndModel};									//Log.w(TAG + " > saveBrandAndModel()", "brandAndModel 是 " + brandAndModel);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getBrandAndModel(Context context) {
		String[] key = {"brandAndModel"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String brandAndModel = value[0];									//Log.w(TAG + " > getBrandAndModel()", "brandAndModel 是 " + brandAndModel);
		if (brandAndModel.equals(DEFAULT)) {
			return null;
		} else {
			return brandAndModel;
		}
	}
	
	public static void savePlatFormVersion(Context context, String platFormVersion) {
		String[] key = {"platFormVersion"};
		String[] value = {platFormVersion};									//Log.w(TAG + " > saveBrandAndModel()", "platFormVersion 是 " + platFormVersion);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getPlatFormVersion(Context context) {
		String[] key = {"platFormVersion"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String platFormVersion = value[0];									//Log.w(TAG + " > getBrandAndModel()", "platFormVersion 是 " + platFormVersion);
		if (platFormVersion.equals(DEFAULT)) {
			return null;
		} else {
			return platFormVersion;
		}
	}
	
	public static void saveRegistrationId(Context context, String registrationId) {
		String appVersion = Integer.toString(FavoriteMethod.getAppVersion(context));
		String[] key = {"registrationId", "appVersion"};
		String[] value = {registrationId, appVersion};									//Log.w(TAG + " > saveRegistrationId()", "registrationId 是 " + registrationId);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getRegistrationId(Context context) {
		String[] key = {"registrationId", "appVersion"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String registrationId = value[0];									 					//Log.w(TAG + " > getRegistrationId()", "registrationId 是 " + registrationId);
		if (registrationId.equals(DEFAULT)) {
			return null;
		} else {
			String registeredVersion = value[1];												//Log.i(TAG + " > getRegistrationId", "registeredVersion = " + registeredVersion);
			String currentVersion = Integer.toString(FavoriteMethod.getAppVersion(context));	//Log.i(TAG + " > getRegistrationId", "currentVersion = " + currentVersion);
			if (!registeredVersion.equals(currentVersion)) {									//Log.d(TAG + " > getRegistrationId", "App version changed.");
				return null;
			} else {																			//Log.d(TAG + " > getRegistrationId", "registeredVersion = currentVersion");
				// Do Nothing
			}
			return registrationId;
		}
	}
	
	public static void saveAppVersion(Context context, String appVersion) {
		String[] key = {"appVersion"};
		String[] value = {appVersion};										//Log.w(TAG + " > saveAppVersion()", "appVersion 是 " + appVersion);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getAppVersion(Context context) {
		String[] key = {"appVersion"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String appVersion = value[0];									 	//Log.w(TAG + " > getAppVersion()", "appVersion 是 " + appVersion);
		if (appVersion.equals(DEFAULT)) {
			return null;
		} else {
			return appVersion;
		}
	}
	
	public static void saveNetCheck(Context context, String netCheck) {
		String[] key = {"netCheck"};
		String[] value = {netCheck};										//Log.w(TAG + " > saveNetCheck()", "netCheck 是 " + netCheck);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getNetCheck(Context context) {
		String[] key = {"netCheck"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String netCheck = value[0];											//Log.w(TAG + " > getNetCheck()", "netCheck 是 " + netCheck);
		if (netCheck.equals(DEFAULT)) {
			return null;
		} else {
			return netCheck;
		}
	}
	
	public static void saveCheckBox(Context context, String checkBox) {
		String[] key = {"checkBox"};
		String[] value = {checkBox};										//Log.w(TAG + " > saveCheckBox()", "checkBox 是 " + checkBox);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getCheckBox(Context context) {
		String[] key = {"checkBox"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String checkBox = value[0];											//Log.w(TAG + " > getCheckBox()", "checkBox 是 " + checkBox);
		if (checkBox.equals(DEFAULT)) {
			return "noCheck";
		} else {
			return checkBox;
		}
	}
	
	public static void saveLogin(Context context, String login) {
		String[] key = {"login"};
		String[] value = {login};										//Log.w(TAG + " > saveLogin()", "login 是 " + login);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getLogin(Context context) {
		String[] key = {"login"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String login = value[0];										//Log.w(TAG + " > getLogin()", "login 是 " + login);
		if (login.equals(DEFAULT)) {
			return "noLogin";
		} else {
			return login;
		}
	}
	
	public static void saveVip(Context context, String vip) {
		String[] key = {"vip"};
		String[] value = {vip};										//Log.w(TAG + " > saveVip()", "vip 是 " + vip);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getVip(Context context) {
		String[] key = {"vip"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String vip = value[0];										//Log.w(TAG + " > getVip()", "vip 是 " + vip);
		if (vip.equals(DEFAULT)) {
			return "noVip";
		} else {
			return vip;
		}
	}
	
	// Detail頁若是從Home頁的主動應徵點進去的要隱藏"關閉日期"
	// 用來記錄Home頁點了哪個按鈕
	public static void saveHomeOnClick(Context context, String homeOnClick) {
		String[] key = {"homeOnClick"};
		String[] value = {homeOnClick};										//Log.w(TAG + " > saveHomeOnClick()", "homeOnClick 是 " + homeOnClick);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getHomeOnClick(Context context) {
		String[] key = {"homeOnClick"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String homeOnClick = value[0];										//Log.w(TAG + " > getHomeOnClick()", "homeOnClick 是 " + homeOnClick);
		if (homeOnClick.equals(DEFAULT)) {
			return "search";
		} else {
			return homeOnClick;
		}
	}
	
	public static void saveLoginTime(Context context, Long loginTime) {
		String[] key = {"loginTime"};
		long[] value = {loginTime};										//Log.w(TAG + " > saveLoginTime()", "loginTime 是 " + loginTime.toString());
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static Long getLoginTime(Context context) {
		String[] key = {"loginTime"};
		long[] value = FavoriteMethod.loadLongSP(context, "InternalData", key);
		long loginTime = value[0];										//Log.w(TAG + " > getLoginTime()", "loginTime 是 " + loginTime);
		if (loginTime == (long) 0) {
			return (long) 0;
		} else {
			return loginTime;
		}
	}
	
	public static void saveLoginPostEncryptString(Context context, String loginPostEncryptString) {
		String[] key = {"loginPostEncryptString"};
		String[] value = {loginPostEncryptString};										//Log.w(TAG + " > saveLoginPostEncryptString()", "loginPostEncryptString 是 " + loginPostEncryptString);
		FavoriteMethod.saveSP(context, "InternalData", key, value);
	}
	
	public static String getLoginPostEncryptString(Context context) {
		String[] key = {"loginPostEncryptString"};
		String[] value = FavoriteMethod.loadSP(context, "InternalData", key);
		String loginPostEncryptString = value[0];										//Log.w(TAG + " > getLoginPostEncryptString()", "loginPostEncryptString 是 " + loginPostEncryptString);
		if (loginPostEncryptString.equals(DEFAULT)) {
			return "";
		} else {
			return loginPostEncryptString;
		}
	}
//====================================================================================================
	
}
