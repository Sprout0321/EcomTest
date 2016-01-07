package tw.com.ecomuniversal.ecomtest5;


import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class FavoriteMethod {
//	private static final String TAG = "FavoriteMethod";
	public static final String DEFAULT ="N/A";
	
	public static void changeView(Activity activity, Class<?> classA) {
		Intent intent = new Intent();
		intent.setClass(activity, classA);
		activity.startActivity(intent);
	}
	
	public static void changeView(Activity activity, Class<?> cls, String bundle_key, String bundle_value) {
		Intent intent = new Intent();
		intent.setClass(activity, cls);
		Bundle bundle = new Bundle();
		bundle.putString(bundle_key, bundle_value);
		intent.putExtras(bundle);
		activity.startActivity(intent);
	}
	
	public static void changeViewWithBundle(Activity activity, Class<?> cls, String[] bundle_key, String[] bundle_value) {
		Intent intent = new Intent();
		intent.setClass(activity, cls);
		Bundle bundle = new Bundle();																//Log.i(TAG + " > changeViewWithBundle()", "bundle_key 的數量是 " + bundle_key.length);
		for (int i = 0; i < bundle_key.length ; i++) {												//Log.i(TAG + " > changeViewWithBundle()", "bundle_key["+i+"] 是 " + bundle_key[i]);
			bundle.putString(bundle_key[i], bundle_value[i]);										//Log.i(TAG + " > changeViewWithBundle()", "bundle_value["+i+"] 是 " + bundle_value[i]);
		}
		intent.putExtras(bundle);
		activity.startActivity(intent);
	}
	
	public static String[] receiveBundleValue(Activity activity, String[] bundle_key) {
		Intent intent = activity.getIntent();
        Bundle bundle = intent.getExtras();
        String[] bundle_value = new String[bundle_key.length];										//Log.i(TAG + " > receiveBundleValue()", "bundle_key 的數量是 " + bundle_key.length);
        for (int i = 0; i < bundle_key.length ; i++) {												//Log.i(TAG + " > receiveBundleValue()", "bundle_key["+i+"] 是 " + bundle_key[i]);
        	bundle_value[i] = bundle.getString(bundle_key[i], DEFAULT);								//Log.i(TAG + " > receiveBundleValue()", "bundle_value["+i+"] 是 " + bundle_value[i]);
		}
        return bundle_value;
	}
	
	public static void useToast(Context context, String message) {
		Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
//		toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER, 0, 0);
		toast.show();
	}
	
	public static void alertDialog(Context context, String title, String message) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setPositiveButton("確認", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int i) {
				// Do nothing
			}
		});
		alertDialog.setCancelable(false);
		alertDialog.show();
	}
	
	public static void alertDialog(Context context, String title, String message, DialogInterface.OnClickListener positiveListener) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setPositiveButton("確認", positiveListener);
		alertDialog.setCancelable(false);
		alertDialog.show();
	}
	
	public static void alertDialog(Context context, String title, String message,
											String positiveString, DialogInterface.OnClickListener positiveListener,
											String negativeString, DialogInterface.OnClickListener negativeListener) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setPositiveButton(positiveString, positiveListener);
		alertDialog.setNegativeButton(negativeString, negativeListener);
		alertDialog.setCancelable(false);
		alertDialog.show();
		
	}
	
	public static ProgressDialog progressDialog(Activity acttivity, String title, String message) {
		ProgressDialog progressDlg = new ProgressDialog(acttivity);
		progressDlg.setTitle(title);
		progressDlg.setMessage(message);
		progressDlg.setIndeterminate(false);
		progressDlg.setCancelable(false);
		progressDlg.show();
		return progressDlg;
	}
	
	public static void saveSP(Context context, String fileName, String[] key, String[] value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);	//Log.i(TAG + " > SaveSP()", "fileName 是 " + fileName + ".xml");
		SharedPreferences.Editor editor = sharedPreferences.edit();											//Log.i(TAG + " > SaveSP()", "key 的數量是 " + key.length);
		for (int i = 0; i < key.length ; i++) {																//Log.i(TAG + " > SaveSP()", "key["+i+"] 是 " + key[i]);
			editor.putString(key[i], value[i]);																//Log.i(TAG + " > SaveSP()", "value["+i+"] 是 " + value[i]);
		}
		editor.commit();
	}
	
	public static void saveSP(Context context, String fileName, String[] key, int[] value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);	//Log.i(TAG + " > SaveSP()", "fileName 是 " + fileName + ".xml");
		SharedPreferences.Editor editor = sharedPreferences.edit();											//Log.i(TAG + " > SaveSP()", "key 的數量是 " + key.length);
		for (int i = 0; i < key.length ; i++) {																//Log.i(TAG + " > SaveSP()", "key["+i+"] 是 " + key[i]);
			editor.putInt(key[i], value[i]);																//Log.i(TAG + " > SaveSP()", "value["+i+"] 是 " + value[i]);
		}
		editor.commit();
	}
	
	public static void saveSP(Context context, String fileName, String[] key, long[] value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);	//Log.i(TAG + " > SaveSP()", "fileName 是 " + fileName + ".xml");
		SharedPreferences.Editor editor = sharedPreferences.edit();											//Log.i(TAG + " > SaveSP()", "key 的數量是 " + key.length);
		for (int i = 0; i < key.length ; i++) {																//Log.i(TAG + " > SaveSP()", "key["+i+"] 是 " + key[i]);
			editor.putLong(key[i], value[i]);																//Log.i(TAG + " > SaveSP()", "value["+i+"] 是 " + value[i]);
		}
		editor.commit();
	}
	
	public static String[] loadSP(Context context, String fileName, String[] key) {
		SharedPreferences sharedPreferences= context.getSharedPreferences(fileName, Context.MODE_PRIVATE);	//Log.i(TAG + " > LoadSP()", "fileName 是 " + fileName + ".xml");
		String[] value = new String[key.length];															//Log.i(TAG + " > LoadSP()", "key 的數量是 " + key.length);
		//使用 getString() 從 SharedPreferences 抓取相對的值！
		//getString("要抓取值的標頭key", 找不到此標頭時給予的值)
		for (int i = 0; i < key.length ; i++) {																//Log.i(TAG + " > LoadSP()", "key["+i+"] 是 " + key[i]);
			value[i] = sharedPreferences.getString(key[i], DEFAULT);										//Log.i(TAG + " > LoadSP()", "value["+i+"] 是 " + value[i]);
		}
		return value;
	}
	
	public static int[] loadIntSP(Context context, String fileName, String[] key) {
		SharedPreferences sharedPreferences= context.getSharedPreferences(fileName, Context.MODE_PRIVATE);	//Log.i(TAG + " > LoadIntSP()", "fileName 是 " + fileName + ".xml");
		int[] value = new int[key.length];																	//Log.i(TAG + " > LoadIntSP()", "key 的數量是 " + key.length);
		//使用 getString() 從 SharedPreferences 抓取相對的值！
		//getInt("要抓取值的標頭key", 找不到此標頭時給予的值)
		for (int i = 0; i < key.length ; i++) {																//Log.i(TAG + " > LoadIntSP()", "key["+i+"] 是 " + key[i]);
			value[i] = sharedPreferences.getInt(key[i], -1);												//Log.i(TAG + " > LoadIntSP()", "value["+i+"] 是 " + value[i]);
		}
		return value;
	}
	
	public static long[] loadLongSP(Context context, String fileName, String[] key) {
		SharedPreferences sharedPreferences= context.getSharedPreferences(fileName, Context.MODE_PRIVATE);	//Log.i(TAG + " > LoadLongSP()", "fileName 是 " + fileName + ".xml");
		long[] value = new long[key.length];																//Log.i(TAG + " > LoadLongSP()", "key 的數量是 " + key.length);
		//使用 getString() 從 SharedPreferences 抓取相對的值！
		//getLong("要抓取值的標頭key", 找不到此標頭時給予的值)
		for (int i = 0; i < key.length ; i++) {																//Log.i(TAG + " > LoadLongSP()", "key["+i+"] 是 " + key[i]);
			value[i] = sharedPreferences.getLong(key[i], (long) 0);											//Log.i(TAG + " > LoadLongSP()", "value["+i+"] 是 " + value[i]);
		}
		return value;
	}
	
	public static void removeSPFile(Context context, String fileName) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);	//Log.i(TAG + " > removeSPFile()", "fileName 是 " + fileName + ".xml");
		//取得到SharedPreferences.Editor物件
		SharedPreferences.Editor editor = sharedPreferences.edit();
		//清除Preference中的數值，如果用remove可以移除某鍵的值
		editor.clear();
		//最後也要提交commit
		editor.commit();
	}
	
	public static void removeSPKey(Context context, String fileName, String[] key) {
		SharedPreferences sharedPreferences= context.getSharedPreferences(fileName, Context.MODE_PRIVATE);	//Log.i(TAG + " > removeSPKey()", "fileName 是 " + fileName + ".xml");
		SharedPreferences.Editor editor = sharedPreferences.edit();
//		String[] value = new String[key.length];															//Log.i(TAG + " > removeSPKey()", "key 的數量是 " + key.length);
		for (int i = 0; i < key.length ; i++) {
																											//Log.i(TAG + " > removeSPKey()", "key["+i+"] 是 " + key[i]);
																											//Log.i(TAG + " > removeSPKey()", "value["+i+"] 是 " + value[i]);
			editor.remove(key[i]);
		}
		editor.commit();
	}
	
	public static String getSerialID(Context context) {
		String serial = null;
		if(VERSION.SDK_INT >= VERSION_CODES.GINGERBREAD) {
			serial = Build.SERIAL;
		} else {
			// Do Nothing
		}
		return serial;
	}
	
	public static int getAppVersion(Context context) {										//Log.d(TAG + " > getAppVersion()", "getAppVersion()");
		try {
			PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionCode;
		} catch (NameNotFoundException e) {
			// should never happen
			throw new RuntimeException("Could not get package name: " + e);
		}
	}
	
	public static boolean isNetworkAvailable(Context context) {
		return ((ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE))
				.getActiveNetworkInfo() != null;
	}
	
	public static Long getCurrentTime() {
		Long currentTimeMills = System.currentTimeMillis();
//		Log.w(TAG, "currentTimeMills 是 " + currentTimeMills.toString());
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(currentTimeMills);
//		Log.i(TAG + "getCurrentTime()", "現在時間是: " +
//			calendar.get(Calendar.YEAR) + "年" +
//			(calendar.get(Calendar.MONTH) + 1) + "月" +
//			calendar.get(Calendar.DAY_OF_MONTH) + "日 " +
//		    calendar.get(Calendar.HOUR_OF_DAY) + "時" +
//		    calendar.get(Calendar.MINUTE) + "分" +
//		    calendar.get(Calendar.SECOND) + "秒" +
//		    calendar.get(Calendar.MILLISECOND) + "毫秒");
		return currentTimeMills;
	}

}
