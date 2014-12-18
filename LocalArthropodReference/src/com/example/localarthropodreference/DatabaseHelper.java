package com.example.localarthropodreference;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseHelper extends SQLiteAssetHelper{

	public static final String TABLE_BUGS = "arthropods";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_IMG = "img";
	public static final String COLUMN_COM = "common";
	public static final String COLUMN_SCI = "scientific";
	public static final String COLUMN_SIMILAR = "similarSp";
	public static final String COLUMN_DESCR = "description";
	public static final String COLUMN_HAB = "habitat";
	public static final String COLUMN_TAX = "taxon";
	
	private static final String DATABASE_NAME = "arthropod.db";
	private static final int DATABASE_VERSION = 1;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
