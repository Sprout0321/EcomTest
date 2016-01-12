package tw.com.ecomuniversal.ecomtest5;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class LogoActivity extends Activity {
	private Activity activity = this;
	private RelativeLayout relativeLayout;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        relativeLayout = new RelativeLayout(activity);
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(layoutparams);
        setContentView(relativeLayout);
        setupViewComponent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void setupViewComponent() {
    	ImageView imageView = new ImageView(activity);
    	imageView.setBackgroundResource(R.drawable.background_logo);
    	relativeLayout.addView(imageView);
		RelativeLayout.LayoutParams imageViewLayoutparams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
		imageViewLayoutparams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	imageViewLayoutparams.width = LayoutParams.MATCH_PARENT;
    	imageViewLayoutparams.height = LayoutParams.MATCH_PARENT;
    	imageViewLayoutparams.setMargins(0, 0, 0, 0);
    	imageView.setLayoutParams(imageViewLayoutparams);
    	
    	TextView textView = new TextView(activity);
    	textView.setText("LOGO");
    	textView.setTextSize(50f);
    	textView.setTextColor(0xFFF1F2F3);
    	textView.setGravity(Gravity.CENTER);
    	relativeLayout.addView(textView);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	textView.setLayoutParams(textViewLayoutParams);
    	delayAndStart(3000);
	}
    
    private void delayAndStart(final int sec) {							//Log.d(TAG + " > delayAndStart()", "delayAndStart()");
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {													//Log.d(TAG + " > delayAndStart()", "延遲 " + (sec) + " 毫秒");
					Thread.sleep(sec);
					changeToHomeActivity();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

	private void changeToHomeActivity() {								//Log.d(TAG + " > changeToHomeActivity()", "changeToHomeActivity()");
		FavoriteMethod.changeView(activity, MainActivity.class);
		finish();
	}
}
