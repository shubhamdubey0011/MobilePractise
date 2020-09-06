import java.net.MalformedURLException;

import org.openqa.selenium.Capabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidUIAutomatorExample {
public static void main(String[] args) throws MalformedURLException {
	AndroidDriver<AndroidElement> driver = baseconfiguration.capabilities("Nexus");
	 // driver.findElementByAndroidUIAutomator("attribute("value")")
	
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	//code for checkking the properties of a button
	System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(false)").size());
	
	
	
}
}
