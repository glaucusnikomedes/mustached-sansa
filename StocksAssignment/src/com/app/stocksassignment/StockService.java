package com.app.stocksassignment;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;

public class StockService  extends Service{
	private Stock stock;
	private IBinder mBinder;
	public class StockBinder extends Binder {
		StockService getService() {
			return StockService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}
	public Stock updateStock(String comp){
        // get stock price using stock symbol
		Stock stock = new Stock("100","1,000,000","2%","1.3","0.5%");
        return stock;
	}
}
