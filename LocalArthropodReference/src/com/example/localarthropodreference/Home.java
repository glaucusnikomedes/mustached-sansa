package com.example.localarthropodreference;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
	}
	
	public void onClick(final View view) {
		switch (view.getId()) {
			case R.id.btn1:
				Intent intent = new Intent(this, DisplayList.class);
				startActivity(intent);
				break;
			case R.id.btn2:
				final String[] habitats = getResources().getStringArray(R.array.habitats);
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Choose habitat type");
			    builder.setItems(habitats, new DialogInterface.OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						choose(1, habitats[which]);
					}
			    });
			    builder.show();
				break;
			case R.id.btn3:
				final String[] taxa = getResources().getStringArray(R.array.taxa);
				AlertDialog.Builder b2 = new AlertDialog.Builder(this);
				b2.setTitle("Choose taxon");
			    b2.setItems(taxa, new DialogInterface.OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						choose(2, taxa[which]);
					}
			    });
			    b2.show();
				break;
		}
		
	}
	public void choose(int choice, String choiceString) {
		Intent intent = new Intent(this, DisplayList.class);
		intent.putExtra("which", choice);
		intent.putExtra("string", choiceString);
		startActivity(intent);
	}
	
}
