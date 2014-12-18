package com.example.localarthropodreference;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class DisplayList extends ListActivity {
	private ListView lv;
	private BugsDataSource datasource;
	private CustomAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_list);
		lv = (ListView) findViewById(android.R.id.list);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(DisplayList.this, Species.class);
				intent.putExtra("BugPos", position);
				startActivity(intent);
			}
		});
				
		datasource = new BugsDataSource(this);
		datasource.open();
		
		BugApplication.getInstance().allBugs = datasource.getAllBugs();
		
		adapter = new CustomAdapter(this, 
				R.layout.species_layout, R.id.common, BugApplication.getInstance().allBugs);
		setListAdapter(adapter);
		
		Intent receive = getIntent();
		String choiceString;
		int choice = receive.getIntExtra("which", 0);
		if(choice==1)
			showHabitat(receive.getStringExtra("string"));
		else if(choice==2)
			showTaxon(receive.getStringExtra("string"));
		
	}
	public void onClick(View view) {
		EditText search = (EditText) findViewById(R.id.search);
		String text = search.getText().toString();
		BugApplication.getInstance().allBugs = datasource.searchBy(text, 1);
		if(BugApplication.getInstance().allBugs.size() == 0) {
			Toast.makeText(this, "'" + text + "' not found.", Toast.LENGTH_LONG).show();
			BugApplication.getInstance().allBugs = datasource.getAllBugs();
		}
		adapter.swapBugs(BugApplication.getInstance().allBugs);
	
	}
	public void showHabitat(String habitat) {
		EditText search = (EditText) findViewById(R.id.search);
		String text = search.getText().toString();
		BugApplication.getInstance().allBugs = datasource.searchBy(habitat, 2);
		adapter.swapBugs(BugApplication.getInstance().allBugs);
	}
	public void showTaxon(String taxon) {
		EditText search = (EditText) findViewById(R.id.search);
		String text = search.getText().toString();
		BugApplication.getInstance().allBugs = datasource.searchBy(taxon, 3);
		adapter.swapBugs(BugApplication.getInstance().allBugs);
	}
}
