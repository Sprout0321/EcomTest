package tw.com.ecomuniversal.ecomtest5;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
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

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private Activity activity = this;
	private Context context = this;
	private ScrollView scrollView2;
	private RelativeLayout relativeLayout, relativeLayout2, relativeLayout5;
	private LinearLayout linearLayout3, linearLayout4;
	private ImageView imageView3_1, imageView3_2, imageView6;
	private TextView textView3, textView6;
    private final String[] stringArray = {"設定","b","c","d","e","f","g","h","i","j",
			"k","l","m","n","o","p","q","r","s","t",
			"u","v","w","x","y","z"};
//    private final String[] stringArray2 = {"1","2"};
    private Integer itemNumbers = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String firstTime = SharedPreferencesManager.getFirstTime(context);
        if (firstTime.matches("true")) {
			FavoriteMethod.changeView(activity, SettingActivity.class);
		} else {
			// Do Nothing
		}
        relativeLayout = new RelativeLayout(activity);
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(layoutparams);
        setContentView(relativeLayout);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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
    	scrollView = (ScrollView) activity.findViewById(R.id.activity_main_scroll_view);
    	createLinearLayout1(stringArray);
	}
    
    private void createLinearLayout1(String[] stringArray) {
    	Integer LinearLayout1_1Number = stringArray.length/3;
    	Integer lastImageViewNumber = stringArray.length%3;
		LinearLayout linearLayout1 = new LinearLayout(activity);
		LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayout1.setOrientation(LinearLayout.VERTICAL);
		linearLayout1.setLayoutParams(layoutparams);
		scrollView.addView(linearLayout1);
		for (int i = 0; i < LinearLayout1_1Number; i++) {
			createLinearLayout1_1(linearLayout1, 3);
		}						
		if (lastImageViewNumber != 0) {
			createLinearLayout1_1(linearLayout1, lastImageViewNumber);
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
	}

	private void createTextView3() {
		textView3 = new TextView(activity);
    	textView3.setText("HomePage");
    	textView3.setTextSize(30f);
    	textView3.setTextColor(0xFFF1F2F3);
    	textView3.setGravity(Gravity.CENTER);
    	relativeLayout2.addView(textView3);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView3.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
    	textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 1);
    	textViewLayoutParams.setMargins(50, 0, 0, 0);
    	textView3.setLayoutParams(textViewLayoutParams);
	}

	private void createImageView3() {
		imageView3_1 = new ImageView(activity);
		imageView3_1.setBackgroundResource(R.drawable.shape_b);
		imageView3_1.setId(1002);
		relativeLayout2.addView(imageView3_1);
		RelativeLayout.LayoutParams imageViewLayoutParams = (RelativeLayout.LayoutParams) imageView3_1.getLayoutParams();
		imageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
		imageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 1);
		imageViewLayoutParams.setMargins(0, 0, 50, 0);
    	imageViewLayoutParams.width = 80;
    	imageViewLayoutParams.height = 80;
    	imageView3_1.setLayoutParams(imageViewLayoutParams);
    	imageView3_1.setOnTouchListener(getImageViewOnTouchListener(-1, imageView3_1));
    	
    	imageView3_2 = new ImageView(activity);
		imageView3_2.setBackgroundResource(R.drawable.shape_b);
		relativeLayout2.addView(imageView3_2);
		imageViewLayoutParams = (RelativeLayout.LayoutParams) imageView3_2.getLayoutParams();
		imageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
		imageViewLayoutParams.setMargins(0, 0, 50, 0);
    	imageViewLayoutParams.width = 80;
    	imageViewLayoutParams.height = 80;
    	
    	imageViewLayoutParams.addRule(RelativeLayout.LEFT_OF, 1002);
		
    	imageView3_2.setLayoutParams(imageViewLayoutParams);
    	imageView3_2.setOnTouchListener(getImageViewOnTouchListener(-1, imageView3_2));
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
		
		createLinearLayout3();
	}
	
	private void createLinearLayout3() {
		linearLayout3 = new LinearLayout(activity);
		linearLayout3.setOrientation(LinearLayout.VERTICAL);
//		linearLayout3.setBackgroundColor(0xFFFA5858);
		LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayout3.setLayoutParams(linearLayoutParams);
		scrollView2.addView(linearLayout3);
		
		Integer linearLayout4_1Number = stringArray.length/3;
    	Integer lastImageViewNumber = stringArray.length%3;
		
		for (int i = 0; i < linearLayout4_1Number; i++) {
			createLinearLayout4(3);
		}						
		if (lastImageViewNumber != 0) {
			createLinearLayout4(lastImageViewNumber);
		} else {
			//Do Nothing
		}
	}
	
	private void createLinearLayout1_1(LinearLayout linearLayout1, Integer imageViewNumber) {
		LinearLayout linearLayout1_1 = new LinearLayout(activity);
		LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayout1_1.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout1_1.setLayoutParams(layoutparams);
		linearLayout1.addView(linearLayout1_1);
		for (int i = 0; i < imageViewNumber; i++) {
			createImageView(linearLayout1_1, i);
		}
	}
	
	private void createImageView(LinearLayout linearLayout1_1, Integer position) {
		RelativeLayout relativeLayout = new RelativeLayout(activity);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		relativeLayout.setLayoutParams(layoutParams);
		ImageView imageView = new ImageView(activity);
		switch (position) {
		case 0:
			imageView.setBackgroundResource(R.drawable.shape_b);
			break;
		case 1:
			imageView.setBackgroundResource(R.drawable.shape_b);
			break;
		case 2:
			imageView.setBackgroundResource(R.drawable.shape_b);
			
	private void createLinearLayout4(Integer imageViewNumber) {
		linearLayout4 = new LinearLayout(activity);
//		linearLayout4.setBackgroundResource(R.drawable.shape_r);
		linearLayout4.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//		layoutParams.setMargins(10, 10, 10, 10);
		linearLayout4.setLayoutParams(layoutParams);
		linearLayout3.addView(linearLayout4);
		
		for (int i = 0; i < imageViewNumber; i++) {
			createRelativeLayout5(i);
		}
	}
	
	private void createRelativeLayout5(Integer position) {
		relativeLayout5 = new RelativeLayout(activity);
//		relativeLayout5.setBackgroundResource(R.drawable.shape_g);
		Integer width = getRelativeLayout5Width(getScreenWidth());
		Integer height = width * 4/3;
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
		relativeLayout5.setLayoutParams(layoutParams);
		
		createImageView6(position);
		createTextView6(position);
    	
    	linearLayout4.addView(relativeLayout5);
	}

	private void createImageView6(Integer position) {
		imageView6 = new ImageView(activity);
		switch (position) {
		case 0:
			imageView6.setBackgroundResource(R.drawable.shape_b);
			break;
		case 1:
			imageView6.setBackgroundResource(R.drawable.shape_b);
			break;
		case 2:
			imageView6.setBackgroundResource(R.drawable.shape_b);
			break;
		default:
			break;
		}
		relativeLayout5.addView(imageView6);
		RelativeLayout.LayoutParams imageViewLayoutParams = (RelativeLayout.LayoutParams) imageView6.getLayoutParams();
		imageViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
		imageViewLayoutParams.setMargins(0, 0, 0, 0);
    	imageViewLayoutParams.width = getImageView6Width(getScreenWidth());
    	imageViewLayoutParams.height = getImageView6Width(getScreenWidth());
    	imageView6.setLayoutParams(imageViewLayoutParams);
    	imageView6.setOnTouchListener(getImageViewOnTouchListener(itemNumbers, imageView6));
	}
	
	private void createTextView6(Integer position) {
		textView6 = new TextView(activity);
    	textView6.setText(stringArray[itemNumbers]);
    	itemNumbers++;
    	textView6.setTextSize(30f);
    	textView6.setTextColor(0xFF9FA0FF);
    	textView6.setGravity(Gravity.CENTER);
    	relativeLayout5.addView(textView6);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView6.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	textViewLayoutParams.setMargins(0, 0, 0, 0);
    	textView6.setLayoutParams(textViewLayoutParams);
    	
	}

//	private ImageView.OnClickListener getImageViewOnClickListener(final Integer itemNumbers) {
//		ImageView.OnClickListener imageViewOnClickListener = new ImageView.OnClickListener() {
//			public void onClick(View v) {
//				FavoriteMethod.useToast(context, stringArray[itemNumbers]);
//			}
//		};
//		return imageViewOnClickListener;
//	}
	
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
					FavoriteMethod.useToast(context, stringArray[itemNumbers]);
					setImageViewListener(itemNumbers);
					if (itemNumbers < 0) {
						// Do NOthing
					} else {
						FavoriteMethod.useToast(context, stringArray[itemNumbers]);
						setImageViewListener(itemNumbers);
					}
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
	
	private void setImageViewListener(Integer itemNumbers) {
		if (itemNumbers == 0) {
			FavoriteMethod.changeView(activity, SettingActivity.class);			
		} else {
			IntentBundleManager.changeViewToContectActivity(activity, stringArray[itemNumbers]);
		}
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
		Integer imageViewWidth = (screenWidth)/5;
		return imageViewWidth;
	}
	
	private static Integer convertDpToPixel(Integer dp, Context context){
	    Resources resources = context.getResources();
	    DisplayMetrics metrics = resources.getDisplayMetrics();
	    Integer px = dp * (metrics.densityDpi / 160);
	    return px;
	}
    
}
