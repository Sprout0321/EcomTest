package tw.com.ecomuniversal.ecomtest5;

import android.app.Activity;
import android.content.Context;
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
    private ScrollView scrollView;
    private final String[] stringArray = {"設定","b","c","d","e","f","g","h","i","j",
			"k","l","m","n","o","p","q","r","s","t",
			"u","v","w","x","y","z"};
//    private final String[] stringArray2 = {"1","2"};
    private Integer itemNumbers = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
			break;
		default:
			break;
		}
		relativeLayout.addView(imageView);
		RelativeLayout.LayoutParams imageViewLayoutparams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
    	imageViewLayoutparams.width = getImageViewWidth(getScreenWidth());
    	imageViewLayoutparams.height = getImageViewWidth(getScreenWidth());
    	imageViewLayoutparams.setMargins(10, 10, 10, 10);
    	imageView.setLayoutParams(imageViewLayoutparams);
//    	imageView.setOnClickListener(getImageViewOnClickListener(itemNumbers));
    	imageView.setOnTouchListener(getImageViewOnTouchListener(itemNumbers, imageView));
    	
    	TextView textView = new TextView(activity);
    	textView.setText(stringArray[itemNumbers]);
    	itemNumbers++;
    	textView.setTextSize(30f);
    	textView.setTextColor(0xFF9FA0FF);
    	textView.setGravity(Gravity.CENTER);
    	relativeLayout.addView(textView);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	textView.setLayoutParams(textViewLayoutParams);
    	linearLayout1_1.addView(relativeLayout);
	}
	
	private ImageView.OnClickListener getImageViewOnClickListener(final Integer itemNumbers) {
		ImageView.OnClickListener imageViewOnClickListener = new ImageView.OnClickListener() {
			public void onClick(View v) {
				FavoriteMethod.useToast(context, stringArray[itemNumbers]);
			}
		};
		return imageViewOnClickListener;
	}
	
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
		switch (itemNumbers) {
		case 0:
			FavoriteMethod.changeView(activity, SettingActivity.class);
			break;
		default:
			break;
		}
	}
	
	
	
	private int getScreenWidth() {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int screenWidth = displaymetrics.widthPixels;
		return screenWidth;
	}
	
	private Integer getImageViewWidth(Integer screenWidth) {
		Integer imageViewWidth = (screenWidth - 80)/3; 
		return imageViewWidth;
	}
    
}
