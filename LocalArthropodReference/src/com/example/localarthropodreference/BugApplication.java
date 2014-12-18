package com.example.localarthropodreference;

import java.util.List;

import android.app.Application;

public class BugApplication extends Application {
	private static BugApplication singleton;
	static List<Bug> allBugs;
	public static BugApplication getInstance() {
		return singleton;
	}
	public final void onCreate() {
        super.onCreate(); 
        singleton = this;
    }

}
