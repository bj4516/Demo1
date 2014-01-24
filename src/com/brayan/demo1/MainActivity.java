package com.brayan.demo1;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnSearch;
	Button btnOpenActivity;
	public static final String TAG = MainActivity.class.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch = (Button)findViewById(R.id.btn_search);
        btnOpenActivity = (Button)findViewById(R.id.btnOpenActivity);
        
        ButtonListener listener = new ButtonListener();
        btnSearch.setOnClickListener(listener);
        btnOpenActivity.setOnClickListener(listener);
    }

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    class ButtonListener implements android.view.View.OnClickListener{

		@Override
		public void onClick(View v) {
			EditText searchQuery = (EditText) findViewById(R.id.editTextSerachQuery);
			String searchQueryText = searchQuery.getText().toString();
			String url = "https://www.gooogle.com/?q=" + searchQueryText + "#q=" + searchQueryText;
			Intent intent = null;
			if (v.getId() == btnOpenActivity.getId()){
				intent = new Intent(getApplicationContext(),ShowSerchQueryActivity.class);
				intent.putExtra(ShowSerchQueryActivity.QUERY, searchQueryText);
			} else if (v.getId() == btnSearch.getId() ){
				intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));
			}
			startActivity(intent);
			
		}
	}
    	
  }
    	
    
    

