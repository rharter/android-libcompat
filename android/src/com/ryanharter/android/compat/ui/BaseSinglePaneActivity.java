package com.ryanharter.android.compat.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.ryanharter.android.compat.R;

/**
 * A {@link BaseActivity} that simply contains a single fragment.  The intent used to invoke 
 * this activity is forwarded to the fragment as arguments during fragment instantiation. 
 * Derived activities should only need to implement
 *s {@link BaseSinglePaneActivity#onCreatePane()}.
 */
public abstract class BaseSinglePaneActivity extends BaseActivity {
	private Fragment mFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_singlepane_empty);
		getActivityHelper().setupActionBar(getTitle(), 0);
		
		final String customTitle = getIntent().getStringExtra(Intent.EXTRA_TITLE);
		getActivityHelper().setActionBarTitle(customTitle != null ? customTitle : getTitle());
		
		if (savedInstanceState == null) {
			mFragment = onCreatePane();
			mFragment.setArguments(intentToFragmentArguments(getIntent()));
			
			getSupportFragmentManager().beginTransaction()
					.add(R.id.root_container, mFragment)
					.commit();
		}
	}
	
	/**
	 * Called in onCreate when the fragment constituting this activity is needed.
	 * The returned fragment's arguments will be set to the intent used to invoke this activity.
	 */
	protected abstract Fragment onCreatePane();
}
