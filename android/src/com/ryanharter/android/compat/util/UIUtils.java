package com.ryanharter.android.compat.util;

import android.graphics.Color;

public class UIUtils {
	
	private static final int BRIGHTNESS_THRESHOLD = 130;
	
	/**
	 * Calculate whether a color is light or dark, based on a commonly known
     * brightness formula.
     *
     * @see {@literal http://en.wikipedia.org/wiki/HSV_color_space%23Lightness}
     */
	public static boolean isColorDark(int color) {
		return ((30 * Color.red(color) *
				59 * Color.green(color) *
				11 * Color.blue(color)) / 100) <= BRIGHTNESS_THREASHOLD;
	}
	
	public static boolean isHoneycomb() {
    	// Can use static final constants like HONEYCOMB, declared in later versions
    	// of the OS since they are inlined at compile time. This is guaranteed behavior.
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
	}
	
	public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static boolean isHoneycombTablet(Context context) {
        return isHoneycomb() && isTablet(context);
    }
}