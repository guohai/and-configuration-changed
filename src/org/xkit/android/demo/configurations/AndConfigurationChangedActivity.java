package org.xkit.android.demo.configurations;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

// SEE http://developer.android.com/reference/android/R.attr.html#configChanges

public class AndConfigurationChangedActivity extends Activity {

	private static final String LOG_TAG = "AndConfigurationChangedActivity";

	private int mPrevOrientationState;

	private LinearLayout mRootView; // home_page

	private LinearLayout mMessageview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initRootView();

		Log.e(LOG_TAG, "onCreate");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

		// only concern orientation here

		if (newConfig.orientation == mPrevOrientationState)
			return;

		mPrevOrientationState = newConfig.orientation;
		if (mRootView != null)
			setContentView(mRootView);

		Log.e(LOG_TAG, "onConfigurationChanged");
	}

	private View initRootView() {
		if (mRootView == null) {
			mRootView = (LinearLayout) findViewById(R.id.home_page);
			mMessageview = (LinearLayout) findViewById(R.id.message_view);
		}
		return mRootView;
	}
}