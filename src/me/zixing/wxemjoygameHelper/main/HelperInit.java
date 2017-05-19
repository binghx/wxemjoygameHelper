package me.zixing.wxemjoygameHelper.main;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import me.nixing.wxemjoygamehelper.MainActivity;
import me.nixing.wxemjoygamehelper.config.ConfigUtils;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class HelperInit implements IXposedHookLoadPackage{
	private final String PACKAGE_NAME = "com.tencent.mm";
	private final String CLASS_NAME = "com.tencent.mm.sdk.platformtools.bf";
	private final String METHOD_NAME = "da";
	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		if(!PACKAGE_NAME.equals(lpparam.packageName)){
			return;
		}
		
		XposedBridge.log(HelperInit.class.getPackage().getName());
		XSharedPreferences preferences = new XSharedPreferences(MainActivity.class.getPackage().getName(), "config");
		
		final ConfigUtils configUtils = ConfigUtils.getInstance(preferences);
		
		findAndHookMethod(CLASS_NAME, lpparam.classLoader, METHOD_NAME, int.class,int.class, new XC_MethodHook() {
			
			@Override
			protected void afterHookedMethod(MethodHookParam param)
					throws Throwable {
				String gameType = param.args[0].toString();
				switch (gameType) {
				case "2":
					if(configUtils.getEnable()){		
						XposedBridge.log(configUtils.getJsb()+"");
						param.setResult(configUtils.getJsb());
					}
					break;
				case "5":
					if(configUtils.getEnable()){		
						XposedBridge.log(configUtils.getDice()+"");
						param.setResult(configUtils.getDice());
					}
					break;
					
				default:
					break;
				}
			}
			
		} );
	}

	
}
