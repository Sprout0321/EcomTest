package tw.com.ecomuniversal.ecomtest5;

import android.app.Activity;

public class IntentBundleManager {
//	private static final String TAG = "IntentBundleManager";
	public static final String DEFAULT ="N/A";
	
	public static void changeViewToContectActivity(Activity activity, String transferJsonString) {
		String[] bundle_key = {"transferJsonString"};
		String[] bundle_value = {transferJsonString};
		FavoriteMethod.changeViewWithBundle(activity, ContectActivity.class, bundle_key, bundle_value);
	}
	
	public static String receiveOnContectActivity(Activity activity) {
		String[] bundle_key = {"transferJsonString"};
		String[] bundle_value = FavoriteMethod.receiveBundleValue(activity, bundle_key);
		if (bundle_value[0].equals(DEFAULT)) {
			bundle_value[0] = null;
		} else {
			// Do Nothing
		}
		return bundle_value[0];
	}
}
