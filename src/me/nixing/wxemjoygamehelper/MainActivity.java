package me.nixing.wxemjoygamehelper;

import java.util.RandomAccess;

import me.nixing.wxemjoygamehelper.config.ConfigUtils;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener,Switch.OnCheckedChangeListener{
	private static RadioButton dice0;
	private RadioButton dice1;
	private RadioButton dice2;
	private RadioButton dice3;
	private RadioButton dice4;
	private RadioButton dice5;
	
	private RadioButton jsb0;
	private RadioButton jsb1;
	private RadioButton jsb2;
	ConfigUtils configUtils;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RadioGroup dice = (RadioGroup)findViewById(R.id.dice);
		RadioGroup jsb = (RadioGroup)findViewById(R.id.jsb);
		dice0 =  (RadioButton) findViewById(R.id.dice0);
		dice1 =  (RadioButton) findViewById(R.id.dice1);
		dice2 =  (RadioButton) findViewById(R.id.dice2);
		dice3 =  (RadioButton) findViewById(R.id.dice3);
		dice4 =  (RadioButton) findViewById(R.id.dice4);
		dice5 =  (RadioButton) findViewById(R.id.dice5);
		jsb0 =  (RadioButton) findViewById(R.id.jsb0);
		jsb1 =  (RadioButton) findViewById(R.id.jsb1);
		jsb2 =  (RadioButton) findViewById(R.id.jsb2);
		
		dice.setOnCheckedChangeListener(this);
		jsb.setOnCheckedChangeListener(this);
		
		Switch switchBtn = (Switch)findViewById(R.id.switch_btn);
		switchBtn.setChecked(true);
		switchBtn.setOnCheckedChangeListener(this);
		
		configUtils = ConfigUtils.getInstance(getSharedPreferences("config", MODE_WORLD_READABLE));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onCheckedChanged(RadioGroup group, int id) {
		
		switch (id) {
		case R.id.dice0:
			Toast.makeText(this, "dice0", 1).show();
			configUtils.setDice(0);
			break;
		case R.id.dice1:
			Toast.makeText(this, "dice1", 1).show();
			configUtils.setDice(1);
			break;
		case R.id.dice2:
			Toast.makeText(this, "dice2", 1).show();
			configUtils.setDice(2);
			break;
		case R.id.dice3:
			Toast.makeText(this, "dice3", 1).show();
			configUtils.setDice(3);
			break;
		case R.id.dice4:
			Toast.makeText(this, "dice4", 1).show();
			configUtils.setDice(4);
			break;
		case R.id.dice5:
			Toast.makeText(this, "dice5", 1).show();
			configUtils.setDice(5);
			break;
		case R.id.jsb0:
			Toast.makeText(this, "jsb0", 1).show();
			configUtils.setJsb(0);
			break;
		case R.id.jsb1:
			Toast.makeText(this, "jsb1", 1).show();
			configUtils.setJsb(1);
			break;
		case R.id.jsb2:
			Toast.makeText(this, "jsb2", 1).show();
			configUtils.setJsb(2);
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton btn, boolean flag) {
		// TODO Auto-generated method stub
		Toast.makeText(this, flag+"", 1).show();
		configUtils.setEnable(flag);
	}

}
