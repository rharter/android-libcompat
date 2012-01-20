package com.ryanharter.android.compat.util;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.ryanharter.android.compat.R;

public class ActivityHelperHoneycomb extends ActivityHelper {
	private Menu mOptionsMenu;
	
	protected ActivityHelperHoneycomb(Activity activity) {
		super(activity);
	}
	
	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		// We don't have to do anything for Honeycomb and up
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		mOptionsMenu = menu;
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				// goHome();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void setupHomeActivity() {
		super.setupHomeAcitivty();
		if (UIUtils.isTablet(mActivity)) {
			mActivity.getActionBar().setDisplayOptions(
				0,
				ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
		} else {
			mActivity.getActionBar().setDisplayOptions(
				ActionBar.DISPLAY_USE_LOGO,
				ActionBar.DISPLAY_USE_LOGO | ActionBar.DISPLAY_SHOW_TITLE);
		}
	}
	
	@Override
	public void setupSubActivity() {
		super.setupSubActivity();
		if (UIUtils.isTablet(mActivity)) {
			mAcitvity.getActionBar().setDisplayOptions(
					ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_USE_LOGO,
					ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_USE_LOGO);
		} else {
			mActivity.getActionBar().setDisplayOptions(
					0,
					ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_USE_LOGO);
		}
	}
	
	/**
	 * No-op on Honeycomb. The action bar title always remains the same.
	 */
	@Override
	public void setActionBarTitle(CharSequence title) {
	}
	
	/**
	 * No-op on Honeycomb. The action bar color always remains the same.
	 */
	@Override
	public void setActionBarColor(int color) {
		if (!UIUtils.isTablet(mActivity)) {
			super.setActionBarColor(color);
		}
	}
	
	@Override
	public void setRefreshActionButtonCompatState(boolean refreshing) {
		// On Honeycomb, we can set the state of the refresh button by giving it a custom
		// action view.
		if (mOptionsMenu == null) {
			return;
		}
		
		final MenuItem refreshItem = mOptionsMenu.findItem(R.id.menu_refresh);
		if (refreshItem != null) {
			if (refreshing) {
				refreshItem.setActionView(R.layout.actionbar_indeterminate_progress);
			} else {
				refreshItem.setActionView(null);
			}
		}
	}
}
