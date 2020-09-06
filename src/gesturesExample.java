import static io.appium.java_client.touch.TapOptions.tapOptions;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class gesturesExample {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = baseconfiguration.capabilities("emulator");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

		TouchAction touch = new TouchAction(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//To tap on a element 
		WebElement expandList = driver
				.findElementByXPath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]");
		touch.tap(tapOptions().withElement(element(expandList))).perform();
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		

		
		//to longpress on a element
		WebElement peopleNameEle = driver
				.findElementByXPath("//android.widget.TextView[@text=\"People Names\"]");

		touch.longPress(longPressOptions().withElement(element(peopleNameEle)).withDuration(Duration.ofSeconds(2)))
				.release().perform();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("android:id/title")).isDisplayed());

	}
}
