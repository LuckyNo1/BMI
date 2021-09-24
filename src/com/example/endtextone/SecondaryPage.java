package com.example.endtextone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.widget.EditText;

public class SecondaryPage extends Activity{
	private Button secpagebtn;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_secondary);
        secpagebtn=(Button)findViewById(R.id.pagesec_one);
        secpagebtn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				// TODO Auto-generated method stub
				Intent intent=new Intent(SecondaryPage.this,MainPage.class);
				startActivityForResult(intent,0);
			}
		});
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}


