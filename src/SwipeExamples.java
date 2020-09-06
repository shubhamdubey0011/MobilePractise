import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SwipeExamples {
public static void main(String[] args) throws MalformedURLException {
	AndroidDriver<AndroidElement> driver = baseconfiguration.capabilities("emulator");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
	driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
	//driver.findElementByAndroidUIAutomator("content-desc(\"9\")").click();
	driver.findElementByXPath("//*[@content-desc=\"9\"]").click();
	//*[@content-desc="9"]
	
	WebElement sourceElem = driver.findElementByXPath("//*[@content-desc='15']");
	WebElement destinElem = driver.findElementByXPath("//*[@content-desc=\"45\"]");
	
	TouchAction touch = new TouchAction(driver);
	//How to Swipe 
	//long press //on element// for 2 sec//  and move to another element and you release
	touch.longPress(longPressOptions().withElement(element(sourceElem)).withDuration(Duration.ofSeconds(5))).moveTo(element(destinElem)).release().perform();
	
	//touch.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
	
	
	
	
	
	
	
	
}
}
