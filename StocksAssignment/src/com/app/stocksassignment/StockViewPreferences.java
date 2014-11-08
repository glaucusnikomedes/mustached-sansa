package com.app.stocksassignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;

public class StockViewPreferences extends PreferenceActivity{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}
}
