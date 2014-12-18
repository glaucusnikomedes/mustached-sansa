package com.example.localarthropodreference;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class BugsDataSource {

	private SQLiteDatabase database;
	private DatabaseHelper dbHelper;
	private String[] allColumns = { DatabaseHelper.COLUMN_ID,
			DatabaseHelper.COLUMN_IMG, DatabaseHelper.COLUMN_COM,
			DatabaseHelper.COLUMN_SCI, DatabaseHelper.COLUMN_SIMILAR,
			DatabaseHelper.COLUMN_DESCR, DatabaseHelper.COLUMN_HAB,
			DatabaseHelper.COLUMN_TAX};
	
	public BugsDataSource(Context context) {
		dbHelper = new DatabaseHelper(context);
	}
	
	public void open() throws SQLException {
		database = dbHelper.getReadableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	public List<Bug> getAllBugs() {
		List<Bug> bugs = new ArrayList<Bug>();
	
		Cursor cursor = database.query(DatabaseHelper.TABLE_BUGS,
				allColumns, null, null, null, null, null);
	
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Bug bug = cursorToBug(cursor);
			bugs.add(bug);
	  		cursor.moveToNext();
	  	}
	  	// make sure to close the cursor
	  	cursor.close();
	  	return bugs;
  	}
	
	public List<Bug> searchBy(String search, int column) {
		List<Bug> bugs = new ArrayList<Bug>();
		String columnName = "";
		switch(column) {
		case 1:
			columnName = DatabaseHelper.COLUMN_COM;
			break;
		case 2:
			columnName = DatabaseHelper.COLUMN_HAB;
			break;
		case 3:
			columnName = DatabaseHelper.COLUMN_TAX;
			break;
		}
		Cursor cursor = database.query(true, DatabaseHelper.TABLE_BUGS,
				allColumns, columnName + " LIKE '%" + 
				search + "%'", null, null, null, null, null);
		//cursor = database.ra
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Bug bug = cursorToBug(cursor);
			bugs.add(bug);
	  		cursor.moveToNext();
	  	}
	  	// make sure to close the cursor
	  	cursor.close();
	  	return bugs;
  	}

  	private Bug cursorToBug(Cursor cursor) {
  		Bug bug = new Bug();
  		bug.setId(cursor.getLong(0));
  		bug.setImg(cursor.getInt(1));
  		bug.setComName(cursor.getString(2));
  		bug.setSciName(cursor.getString(3));
  		bug.setSimilar(cursor.getString(4));
  		bug.setDescr(cursor.getString(5));
  		bug.setHabitat(Bug.convertStringToArray(cursor.getString(6)));
  		bug.setTaxon(cursor.getString(7));
  		return bug;
  	}

}
