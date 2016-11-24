package com.udacity.stockhawk.ui;

import android.os.Looper;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.udacity.stockhawk.R;
import com.udacity.stockhawk.data.Contract;

import java.io.IOException;
import java.util.List;

import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;

public class StockHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_stock_history);
        final TextView stockHistoryTextView = (TextView)findViewById(R.id.stockHistoryTextView);
        String stockSymbol = null;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                stockSymbol = extras.getString(StockAdapter.STOCK_SYMBOL);
            }
        }

        final String finalStockSymbol = stockSymbol;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                try {
                    //Looper.prepare();
                    List<HistoricalQuote> s = YahooFinance.get(finalStockSymbol).getHistory();
                    stockHistoryTextView.setText(s.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
