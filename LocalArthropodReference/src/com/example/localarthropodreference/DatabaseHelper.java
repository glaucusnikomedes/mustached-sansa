package com.example.localarthropodreference;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{

	public static final String TABLE_BUGS = "bugs";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_COM = "com_name";
	public static final String COLUMN_SCI = "sci_name";
	public static final String COLUMN_IDENT = "ident";
	public static final String COLUMN_SIMILAR = "similar";
	public static final String COLUMN_SIZE = "size";
	public static final String COLUMN_HABITAT = "habitat";
	public static final String COLUMN_STATUS = "status";
	
	private static final String DATABASE_NAME = "arthropods.db";
	private static final int DATABASE_VERSION = 1;
	
	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_BUGS + "(" + COLUMN_ID
	      + " integer primary key autoincrement, " + COLUMN_COM
	      + " text not null, " + COLUMN_SCI
	      + " text not null, " + COLUMN_IDENT
	      + " text not null, " + COLUMN_SIMILAR
	      + " text not null, " + COLUMN_SIZE
	      + " text not null, " + COLUMN_HABITAT
	      + " text not null, " + COLUMN_STATUS
	      + " text not null);";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(),
			"Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUGS);
	    onCreate(db);
	}

}
