package me.nixing.wxemjoygamehelper.config;

import de.robv.android.xposed.XSharedPreferences;
import android.content.SharedPreferences;

public class ConfigUtils {
	private static final String ENABLE = "enable";
	private static final String DICE = "dice";
	private static final String JSB = "jsb";
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	private static ConfigUtils configUtils;
	
	
	private ConfigUtils(SharedPreferences preferences) {
		super();
		this.preferences = preferences;
	}

	public static ConfigUtils getInstance(SharedPreferences preferences){
		
		configUtils = new ConfigUtils(preferences);
		return configUtils;
	}
	
	public  boolean getEnable(){
		((XSharedPreferences)preferences).reload();
		return preferences.getBoolean(ENABLE, true);
	}
	
	public  void setEnable(boolean flag){
		editor = preferences.edit();
		editor.putBoolean(ENABLE, flag);
		editor.commit();
	}
	
	public  int getDice(){
		((XSharedPreferences)preferences).reload();
		return preferences.getInt(DICE, 0);
	}
	
	public  void setDice(int dice){
		editor = preferences.edit();
		editor.putInt(DICE, dice);
		editor.commit();
	}
	
	public  int getJsb(){
		((XSharedPreferences)preferences).reload();
		return preferences.getInt(JSB, 0);
	}
	
	public  void setJsb(int jsb){
		editor = preferences.edit();
		editor.putInt(JSB, jsb);
		editor.commit();
	}
	
}
