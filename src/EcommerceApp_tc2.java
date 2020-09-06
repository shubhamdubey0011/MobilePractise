import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceApp_tc2 extends baseconfiguration {
	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities("Nexus");
		TouchAction touch = new TouchAction(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElementById("android:id/text1").click();
		//AndroidElement country = driver.findElementByXPath("//*[@text='Antarctica']");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));").click();
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));  
		//driver.findElementByAndroidUIAutomator("text(\"Female\")").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		
		
		
		//Toast message validations
		System.out.println("Toast Error message Displayed :- "+driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name"));
		
		

		
		
		
		

	}
}
