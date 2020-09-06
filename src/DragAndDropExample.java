import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragAndDropExample {
public static void main(String[] args) throws MalformedURLException {
		
	
		AndroidDriver<AndroidElement> driver = baseconfiguration.capabilities("emulator");
		TouchAction touch = new TouchAction(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		
		WebElement sourceElem = driver.findElementsByClassName("android.view.View").get(0); 
		WebElement destinElem = driver.findElementsByClassName("android.view.View").get(2);
		
		
		//How to drag and drop 
		//touch.longPress(longPressOptions().withElement(element(sourceElem))).moveTo(element(destinElem)).release().perform();
		//0r
		touch.longPress(element(sourceElem)).moveTo(element(destinElem)).release().perform();
		
	}

}
