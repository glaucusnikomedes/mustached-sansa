package com.app.stocksassignment;

// onServiceConneted isn't called
// Causes NullPointerException

import com.app.stocksassignment.StockService.StockBinder;

import android.support.v7.app.ActionBarActivity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.preference.PreferenceManager;

public class Home extends ActionBarActivity {
	private String chosen;
	private Stock stock;
	private TextView txt;
	private boolean bound = false;
	private SharedPreferences prefs;
	private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                IBinder service) {
            StockBinder binder = (StockBinder) service;
            mService = binder.getService();
            bound = true;
            Toast.makeText(Home.this, "Bound", Toast.LENGTH_SHORT).show();
            
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
        	bound = false;
        }
    };
	private StockService mService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		stock = new Stock();
		stock.price = "-.01";
		
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		prefs.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
			
			@Override
			public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
					String key) {
				updatePrefs();
				
			}
		});
		
		final Spinner spinner = (Spinner) findViewById(R.id.ticker);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.company, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				chosen = spinner.getSelectedItem().toString();
				Intent intent = new Intent(Home.this, StockService.class);
	    		if(getApplicationContext().bindService(intent, mConnection, Context.BIND_AUTO_CREATE)){
	    			Toast.makeText(Home.this, "Bound.", Toast.LENGTH_SHORT).show();
	    		}
	    		else
	    			Toast.makeText(Home.this, "Not bound", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				chosen = "";
				
			}
			
		});
		txt = (TextView) findViewById(R.id.price);
		
		Button button = (Button)findViewById(R.id.update);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateClick();
				
			}
		});
		
		
		
		
	}
	
	public void updateClick(){
		Toast.makeText(Home.this, "Clicked", Toast.LENGTH_SHORT).show();
		if(bound){
    		stock = mService.updateStock(chosen);
    		txt.setText(stock.price);
    		if(prefs.getBoolean("pref_vol", false)){
    			TextView volTxt = (TextView)findViewById(R.id.vol);
    			volTxt.setText(stock.volume);
    		}if(prefs.getBoolean("pref_yield", false)){
    			TextView volTxt = (TextView)findViewById(R.id.yield);
    			volTxt.setText(stock.yield);
    		}if(prefs.getBoolean("pref_change", false)){
    			TextView volTxt = (TextView)findViewById(R.id.change);
    			volTxt.setText(stock.change);
    		}if(prefs.getBoolean("pref_perc_change", false)){
    			TextView volTxt = (TextView)findViewById(R.id.change);
    			volTxt.setText(stock.pChange);
    		}
    		
    		unbindService(mConnection);
    	}
		else
			Toast.makeText(Home.this, "Not Bound", Toast.LENGTH_SHORT).show();
		
	}
	private void updatePrefs(){
		if(prefs.getBoolean("pref_vol", false)){
			TextView volTxt = (TextView)findViewById(R.id.vol);
			volTxt.setVisibility(View.VISIBLE);
		}if(prefs.getBoolean("pref_yield", false)){
			TextView volTxt = (TextView)findViewById(R.id.yield);
			volTxt.setVisibility(View.VISIBLE);
		}if(prefs.getBoolean("pref_change", false)){
			TextView volTxt = (TextView)findViewById(R.id.change);
			volTxt.setVisibility(View.VISIBLE);
		}if(prefs.getBoolean("pref_perc_change", false)){
			TextView volTxt = (TextView)findViewById(R.id.pchange);
			volTxt.setVisibility(View.VISIBLE);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	@Override
	public void onResume(){
		super.onResume();
		updatePrefs();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent = new Intent(Home.this, StockViewPreferences.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onDestroy(){
		mService.stopSelf();
		super.onDestroy();
	}
}
