import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseconfiguration2 {
public static AndroidDriver<AndroidElement> capabilities(String DeviceType) throws MalformedURLException {
	
	
	DesiredCapabilities cap = new DesiredCapabilities();
	
	if (DeviceType.equalsIgnoreCase("realDevice")) {
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
	} else 
		
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
	cap.setCapability("appActivity","com.MainActivity");
	cap.setCapability("appPackage","com.androidsample.generalstore");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
	//cap.setCapability("autoAcceptAlerts", true);
	//cap.setCapability("autoGrantPermissions",true);
	AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	driver.switchTo().alert().accept();
	//driver.launchApp();
	return driver;
	
}
}
