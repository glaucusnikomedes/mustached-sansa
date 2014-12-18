package com.example.localarthropodreference;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Species extends Activity {
	private Bug bug;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_species);
		Intent receive = getIntent();
		int position = receive.getIntExtra("BugPos", -1);
		if(position!=-1) {
			bug = BugApplication.getInstance().allBugs.get(position);
			setTitle(bug.getComName());
			ImageView imgV = (ImageView) findViewById(R.id.img);
			imgV.setImageResource(imgToId(bug.getImg()));
			TextView sciView = (TextView) findViewById(R.id.sci);
			sciView.setText(bug.getSciName());
			TextView taxView = (TextView) findViewById(R.id.tax);
			taxView.setText(bug.getTaxon());
			TextView habView = (TextView) findViewById(R.id.habitat);
			habView.setText(Bug.convertArrayToString(bug.getHabitat()));
			TextView descView = (TextView) findViewById(R.id.description);
			descView.setText(bug.getDescr());
		}		
	}
	public int imgToId(int num) {
		int id = 0;
		switch(num) {
		case 1:
			id = R.drawable.tarant;
			break;
		case 2:
			id = R.drawable.dysdera_crocata;
			break;
		case 3:
			id = R.drawable.latrodectus_hesperus;
			break;
		case 4:
			id = R.drawable.latrodectus_geometricus;
			break;
		case 5:
			id = R.drawable.steatoda_grossa;
			break;
		case 6:
			id = R.drawable.peucetia;
			break;
		case 7:
			id = R.drawable.phidippus;
			break;
		case 8:
			id = R.drawable.anuroctonus;
			break;
		case 9:
			id = R.drawable.eremobates;
			break;
		case 10:
			id = R.drawable.painted;
			break;
		case 11:
			id = R.drawable.plex_fem;
			break;
		case 12:
			id = R.drawable.pogonomyrmex;
			break;
		case 13:
			id = R.drawable.cicada;
			break;
		case 14:
			id = R.drawable.microcentrum;
			break;
		case 15:
			id = R.drawable.abedus;
			break;
		case 16:
			id = R.drawable.apiomerus;
			break;
		case 17:
			id = R.drawable.cotinis;
			break;
		case 18:
			id = R.drawable.hiltonius;
			break;
		case 19:
			id = R.drawable.pepsis;
			break;
		case 20:
			id = R.drawable.prionus;
			break;
		case 21:
			id = R.drawable.scolopendra;
			break;
		case 22:
			id = R.drawable.scudderia;
			break;
		case 23:
			id = R.drawable.arenivaga;
			break;
		case 24:
			id = R.drawable.incisitermes;
			break;
		case 25:
			id = R.drawable.parcoblatta;
			break;
		case 26:
			id = R.drawable.reticulitermes;
			break;
		case 27:
			id = R.drawable.zootermopsis;
			break;
		case 28:
			id = R.drawable.pholcus;
			break;
		case 29:
			id = R.drawable.stenopelmatus;
			break;
		case 30:
			id = R.drawable.gryllus;
			break;
		case 31:
			id = R.drawable.oncopeltus;
			break;
		}
		return id;
	}
}
