package com.example.endtextone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.widget.RadioGroup.OnCheckedChangeListener;



public class MainPage extends Activity{
	private Button count,btnexplain,btnexit;
	private EditText howcm,howkg;
	private float n1,n2,a;
	private RadioGroup sex;
	private RadioButton malebtn,femalebtn;
	private TextView textView;
	boolean b1=true;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_main);
        howcm = (EditText)findViewById(R.id.stature);
        howkg= (EditText)findViewById(R.id.bodyweight);
        btnexplain=(Button)findViewById(R.id.explain);
        btnexit=(Button)findViewById(R.id.exit);
        count = (Button)findViewById(R.id.compute);
        sex=(RadioGroup)findViewById(R.id.rgSex);
        malebtn=(RadioButton)findViewById(R.id.rdoMale);
        femalebtn=(RadioButton)findViewById(R.id.rdoFemale);
        textView= (TextView) findViewById(R.id.standardexplain);
        RadioGroupListener listener=new RadioGroupListener();
        sex.setOnCheckedChangeListener(listener);
        count.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View v) {
				// TODO Auto-generated method stub
				n1=Float.parseFloat(howcm.getText().toString());
				n2=Float.parseFloat(howkg.getText().toString());
				a=n2/n1/n1*10000;
				if(b1==true){
					if(a>0&&a<20){
						textView.setText("偏轻");
					}else if(a>=20&&a<25){
						textView.setText("正常");
					}else if(a>=25&&a<30){
						textView.setText("偏重");
					}else if(a>=30&&a<35){
						textView.setText("肥胖");
					}else{
						textView.setText("超肥胖");
					}
				}else{
					if(a>0&&a<19){
						textView.setText("偏轻");
					}else if(a>=19&&a<24){
						textView.setText("正常");
					}else if(a>=24&&a<29){
						textView.setText("偏重");
					}else if(a>=29&&a<34){
						textView.setText("肥胖");
					}else{
						textView.setText("超肥胖");
					}
				}
			}
		}); // 1、事件源添加事件监听
        btnexplain.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainPage.this,SecondaryPage.class);
				startActivityForResult(intent,0);
			}
		});
        btnexit.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
    }

	class RadioGroupListener implements OnCheckedChangeListener{
		@Override
		public void onCheckedChanged(RadioGroup group,int checkedId){
			if(group == sex){
				if(checkedId==R.id.rdoMale){
					b1=true;
				}else if(checkedId==R.id.rdoFemale){
					b1=false;	
				}
			}	
		}
	}
	
	
	
	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}


