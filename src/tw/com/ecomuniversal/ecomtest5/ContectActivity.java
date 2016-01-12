package tw.com.ecomuniversal.ecomtest5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ContectActivity extends Activity {
	private static final String TAG = "MainActivity";
	private Activity activity = this;
	private Context context = this;
	private ScrollView scrollView2;
	private RelativeLayout relativeLayout, relativeLayout2, relativeLayout3, relativeLayout5;
	private LinearLayout linearLayout4;
	private ImageView imageView3_1, imageView3_2, imageView4;
	private TextView textView3, textView3_2, textView4;
	private String receiveString;
//    private final String[] stringArray2 = {"1","2"};
    private Integer itemNumbers = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        relativeLayout = new RelativeLayout(activity);
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(layoutparams);
        setContentView(relativeLayout);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        receiveString = IntentBundleManager.receiveOnContectActivity(activity);
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
    
    @Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
    
    private void setupViewComponent() {
    	createRelativeLayout2();
    	createScrollView2();
	}
    
	private void createRelativeLayout2() {
		relativeLayout2 = new RelativeLayout(activity);
		relativeLayout2.setId(1001);
		relativeLayout2.setBackgroundColor(0xFF010203);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, convertDpToPixel(65, context));
		relativeLayout2.setLayoutParams(layoutParams);
		relativeLayout.addView(relativeLayout2);
		
		RelativeLayout.LayoutParams relativeLayoutLayoutParams = (RelativeLayout.LayoutParams)relativeLayout2.getLayoutParams();
		relativeLayoutLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		relativeLayout2.setLayoutParams(relativeLayoutLayoutParams);
		
		createTextView3();
		createImageView3();
		createTextView3_2();
	}

	private void createTextView3() {
		textView3 = new TextView(activity);
    	textView3.setText("InsidePage");
    	textView3.setTextSize(30f);
    	textView3.setTextColor(0xFFF1F2F3);
    	textView3.setGravity(Gravity.CENTER);
    	relativeLayout2.addView(textView3);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView3.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	textViewLayoutParams.setMargins(0, 0, 0, 0);
    	textView3.setLayoutParams(textViewLayoutParams);
	}

	private void createImageView3() {
		imageView3_1 = new ImageView(activity);
		imageView3_1.setBackgroundResource(R.drawable.shape_b);
		imageView3_1.setId(1002);
		relativeLayout2.addView(imageView3_1);
		RelativeLayout.LayoutParams imageViewLayoutParams = (RelativeLayout.LayoutParams) imageView3_1.getLayoutParams();
		imageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
		imageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 1);
		imageViewLayoutParams.setMargins(20, 0, 0, 0);
    	imageViewLayoutParams.width = 120;
    	imageViewLayoutParams.height = 80;
    	imageView3_1.setLayoutParams(imageViewLayoutParams);
    	imageView3_1.setOnTouchListener(getImageViewOnTouchListener(1, imageView3_1));
	}
	
	private void createTextView3_2() {
		textView3_2 = new TextView(activity);
		textView3_2.setText("Back");
		textView3_2.setTextSize(20f);
		textView3_2.setTextColor(0xFFF1F2F3);
		textView3_2.setGravity(Gravity.LEFT);
    	relativeLayout2.addView(textView3_2);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView3_2.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
    	textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 1);
    	textViewLayoutParams.setMargins(30, 0, 0, 0);
    	textView3_2.setLayoutParams(textViewLayoutParams);
	}

	private void createScrollView2() {
		scrollView2 = new ScrollView(activity);
		scrollView2.setBackgroundResource(R.drawable.background_logo);
		ScrollView.LayoutParams scrollViewLayoutParams = new ScrollView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		scrollView2.setLayoutParams(scrollViewLayoutParams);
		relativeLayout.addView(scrollView2);
		
		RelativeLayout.LayoutParams relativeLayoutLayoutParams = (RelativeLayout.LayoutParams)scrollView2.getLayoutParams();
		relativeLayoutLayoutParams.addRule(RelativeLayout.BELOW, 1001);
		scrollView2.setLayoutParams(relativeLayoutLayoutParams);
		
		createRelativeLayout3();
	}
	
	private void createRelativeLayout3() {
		relativeLayout3 = new RelativeLayout(activity);
//		relativeLayout3.setOrientation(LinearLayout.VERTICAL);
//		linearLayout3.setBackgroundColor(0xFFFA5858);
		RelativeLayout.LayoutParams linearLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		relativeLayout3.setLayoutParams(linearLayoutParams);
		createImageView4();
		createTextView4();
		scrollView2.addView(relativeLayout3);
	}
	
	private void createImageView4() {
		imageView4 = new ImageView(activity);
		imageView4.setBackgroundResource(R.drawable.shape_b);
		relativeLayout3.addView(imageView4);
		RelativeLayout.LayoutParams imageViewLayoutParams = (RelativeLayout.LayoutParams) imageView4.getLayoutParams();
		imageViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
		imageViewLayoutParams.setMargins(0, 50, 0, 0);
    	imageViewLayoutParams.width = getImageView6Width(getScreenWidth());
    	imageViewLayoutParams.height = getImageView6Width(getScreenWidth());
    	imageView4.setLayoutParams(imageViewLayoutParams);
	}
	
	private void createTextView4() {
		textView4 = new TextView(activity);
		textView4.setText(Html.fromHtml("<u>"+receiveString+"</u>"));
		textView4.setTextSize(30f);
		textView4.setTextColor(0xFFF1F2F3);
		textView4.setGravity(Gravity.CENTER);
		relativeLayout3.addView(textView4);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView4.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	textViewLayoutParams.setMargins(0, 0, 0, 0);
    	textView4.setLayoutParams(textViewLayoutParams);
	}
	
	@SuppressLint("ClickableViewAccessibility")
	private ImageView.OnTouchListener getImageViewOnTouchListener(final Integer itemNumbers,final ImageView imageView) {
		ImageView.OnTouchListener imageViewOnTouchListener = new ImageView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					imageView.setBackgroundResource(R.drawable.shape_g);
					Log.d(TAG + " > getImageViewOnTouchListener()", "action 是 ACTION_DOWN");
					break;
				case MotionEvent.ACTION_MOVE:
					Log.d(TAG + " > getImageViewOnTouchListener()", "action 是 ACTION_MOVE");
					break;
				case MotionEvent.ACTION_UP:
					imageView.setBackgroundResource(R.drawable.shape_b);
					Log.d(TAG + " > getImageViewOnTouchListener()", "action 是 ACTION_UP");
					onBackPressed();
					break;
				case MotionEvent.ACTION_CANCEL:
					imageView.setBackgroundResource(R.drawable.shape_b);
					Log.d(TAG + " > getImageViewOnTouchListener()", "action 是 ACTION_CANCEL");
					break;
				default:
					break;
				}
				return true;
			}
		};
		return imageViewOnTouchListener;
	}
	
	
	private int getScreenWidth() {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int screenWidth = displaymetrics.widthPixels;
		return screenWidth;
	}
	
	private Integer getRelativeLayout5Width(Integer screenWidth) {
		Integer imageViewWidth = (screenWidth)/3;
		return imageViewWidth;
	}
	
	private Integer getImageView6Width(Integer screenWidth) {
		Integer imageViewWidth = (screenWidth)/3;
		return imageViewWidth;
	}
	
	private static Integer convertDpToPixel(Integer dp, Context context){
	    Resources resources = context.getResources();
	    DisplayMetrics metrics = resources.getDisplayMetrics();
	    Integer px = dp * (metrics.densityDpi / 160);
	    return px;
	}
    
}
