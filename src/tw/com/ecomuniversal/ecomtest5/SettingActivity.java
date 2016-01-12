package tw.com.ecomuniversal.ecomtest5;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class SettingActivity extends Activity {
//	private static final String TAG = "SettingActivity";
	private Activity activity = this;
	private Context context = this;
	private ScrollView scrollView2;
	private RelativeLayout relativeLayout, relativeLayout2, relativeLayout5;
	private LinearLayout linearLayout3, linearLayout4_2, linearLayout4_4;
	private ImageView imageView6;
	private TextView textView3, textView4_1, textView4_3, textView6;
	
	private final String[] stringArray = {"1","2","3","4","5"};
    private final String[] stringArray2 = {"一", "二", "三", "四"};
    private Integer itemNumbers4_2 = 0, itemNumbers4_4 = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        SharedPreferencesManager.saveFirstTime(context, "false");
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
	}
    
    private void createTextView3() {
		textView3 = new TextView(activity);
    	textView3.setText("Settings");
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
		
		createTextView4_1();
		
		Integer linearLayout4_2_1Number = stringArray.length/3;
    	Integer lastImageViewNumber = stringArray.length%3;
		for (int i = 0; i < linearLayout4_2_1Number; i++) {
			createLinearLayout4_2(3);
		}						
		if (lastImageViewNumber != 0) {
			createLinearLayout4_2(lastImageViewNumber);
		} else {
			//Do Nothing
		}
		
		createTextView4_3();
		
		Integer linearLayout4_4_1Number = stringArray2.length/3;
    	Integer lastImageViewNumber2 = stringArray2.length%3;
		for (int i = 0; i < linearLayout4_4_1Number; i++) {
			createLinearLayout4_4(3);
		}						
		if (lastImageViewNumber2 != 0) {
			createLinearLayout4_4(lastImageViewNumber2);
		} else {
			//Do Nothing
		}
	}
	
	private void createTextView4_1() {
		textView4_1 = new TextView(activity);
		textView4_1.setText("Function1");
		textView4_1.setTextSize(30f);
		textView4_1.setTextColor(0xFFF1F2F3);
		textView4_1.setGravity(Gravity.START);
		linearLayout3.addView(textView4_1);
    	LinearLayout.LayoutParams textViewLayoutParams = (LinearLayout.LayoutParams)textView4_1.getLayoutParams();
    	textViewLayoutParams.setMargins(50, 0, 0, 0);
    	textView4_1.setLayoutParams(textViewLayoutParams);
	}
	
	private void createTextView4_3() {
		textView4_3 = new TextView(activity);
		textView4_3.setText("Function2");
		textView4_3.setTextSize(30f);
		textView4_3.setTextColor(0xFFF1F2F3);
		textView4_3.setGravity(Gravity.START);
		linearLayout3.addView(textView4_3);
    	LinearLayout.LayoutParams textViewLayoutParams = (LinearLayout.LayoutParams)textView4_3.getLayoutParams();
    	textViewLayoutParams.setMargins(50, 0, 0, 0);
    	textView4_3.setLayoutParams(textViewLayoutParams);
	}
	
	private void createLinearLayout4_2(Integer imageViewNumber) {
		linearLayout4_2 = new LinearLayout(activity);
		linearLayout4_2.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayout4_2.setLayoutParams(layoutParams);
		linearLayout3.addView(linearLayout4_2);
		
		for (int i = 0; i < imageViewNumber; i++) {
			createRelativeLayout5(i, 1);
		}
	}
	
	private void createLinearLayout4_4(Integer imageViewNumber) {
		linearLayout4_4 = new LinearLayout(activity);
		linearLayout4_4.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayout4_4.setLayoutParams(layoutParams);
		linearLayout3.addView(linearLayout4_4);
		
		for (int i = 0; i < imageViewNumber; i++) {
			createRelativeLayout5(i, 2);
		}
	}
	
	private void createRelativeLayout5(Integer position, Integer group) {
		relativeLayout5 = new RelativeLayout(activity);
//		relativeLayout5.setBackgroundResource(R.drawable.shape_g);
		Integer width = getRelativeLayout5Width(getScreenWidth());
		Integer height = width * 4/3;
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
		relativeLayout5.setLayoutParams(layoutParams);
		
		createImageView6(position);
		createTextView6(position, group);
		createCheckBox6();
		if (group == 1) {
			linearLayout4_2.addView(relativeLayout5);			
		} else {
			linearLayout4_4.addView(relativeLayout5);
		}
	}

	private void createImageView6(Integer position) {
		imageView6 = new ImageView(activity);
		switch (position) {
		case 0:
			imageView6.setBackgroundResource(R.drawable.shape_r);
			break;
		case 1:
			imageView6.setBackgroundResource(R.drawable.shape_g);
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
    	imageView6.setOnTouchListener(getImageViewOnTouchListener(itemNumbers4_2, imageView6));
	}
	
	private void createTextView6(Integer position, Integer group) {
		textView6 = new TextView(activity);
		textView6.setId(1003);
		if (group == 1) {
			textView6.setText(stringArray[itemNumbers4_2]);			
			itemNumbers4_2++;
		} else {
			textView6.setText(stringArray2[itemNumbers4_4]);
			itemNumbers4_4++;
		}
    	textView6.setTextSize(30f);
    	textView6.setTextColor(0xFF9FA0FF);
    	textView6.setGravity(Gravity.CENTER);
    	relativeLayout5.addView(textView6);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView6.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	textViewLayoutParams.setMargins(0, 0, 0, 0);
    	textView6.setLayoutParams(textViewLayoutParams);	
	}
	
	private void createCheckBox6() {
		CheckBox checkBox = new CheckBox(activity);
		relativeLayout5.addView(checkBox);
		RelativeLayout.LayoutParams checkBoxLayoutParams = (RelativeLayout.LayoutParams) checkBox.getLayoutParams();
		checkBoxLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
		checkBoxLayoutParams.addRule(RelativeLayout.LEFT_OF, 1003);
		
		checkBox.setLayoutParams(checkBoxLayoutParams);
	}
	
	@SuppressLint("ClickableViewAccessibility")
	private ImageView.OnTouchListener getImageViewOnTouchListener(final Integer itemNumbers,final ImageView imageView) {
		ImageView.OnTouchListener imageViewOnTouchListener = new ImageView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					switch (itemNumbers%3) {
					case 0:
						imageView.setBackgroundResource(R.drawable.shape_g);
						break;
					case 1:
						imageView.setBackgroundResource(R.drawable.shape_b);
						break;
					case 2:
						imageView.setBackgroundResource(R.drawable.shape_r);
						break;
					default:
						break;
					}
					break;
				case MotionEvent.ACTION_MOVE:
					break;
				case MotionEvent.ACTION_UP:
					switch (itemNumbers%3) {
					case 0:
						imageView.setBackgroundResource(R.drawable.shape_r);
						break;
					case 1:
						imageView.setBackgroundResource(R.drawable.shape_g);
						break;
					case 2:
						imageView.setBackgroundResource(R.drawable.shape_b);
						break;
					default:
						break;
					}
					break;
				case MotionEvent.ACTION_CANCEL:
					switch (itemNumbers%3) {
					case 0:
						imageView.setBackgroundResource(R.drawable.shape_r);
						break;
					case 1:
						imageView.setBackgroundResource(R.drawable.shape_g);
						break;
					case 2:
						imageView.setBackgroundResource(R.drawable.shape_b);
						break;
					default:
						break;
					}
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
		Integer imageViewWidth = ((screenWidth)/5) + 40;
		return imageViewWidth;
	}
	
	private static Integer convertDpToPixel(Integer dp, Context context){
	    Resources resources = context.getResources();
	    DisplayMetrics metrics = resources.getDisplayMetrics();
	    Integer px = dp * (metrics.densityDpi / 160);
	    return px;
	}
    
}
