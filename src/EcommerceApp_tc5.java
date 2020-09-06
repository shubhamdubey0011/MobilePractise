import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

import io.appium.java_client.touch.offset.ElementOption;

public class EcommerceApp_tc5 extends baseconfiguration {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities("Nexus");
		TouchAction touch = new TouchAction(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementById("android:id/text1").click();
		// AndroidElement country =
		// driver.findElementByXPath("//*[@text='Antarctica']");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));").click();
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Shubhamdubey0011");
		driver.hideKeyboard();
		driver.findElementByAndroidUIAutomator("text(\"Female\")").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		System.out
				.println("Page Title is :- " + driver.findElementByAndroidUIAutomator("text(\"Products\")").getText());

		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		Thread.sleep(4000);

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		
         //longPress on a link.
		AndroidElement termsAndConditionLink = driver.findElementById("com.androidsample.generalstore:id/termsButton");
		touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(termsAndConditionLink))
				.withDuration(Duration.ofSeconds(2))).release().perform();

		// AndroidElement popUpAlert =
		// driver.findElementByClassName("android:id/content");

		String popUpText = driver.findElementById("com.androidsample.generalstore:id/alertTitle").getText().trim();
		Assert.assertEquals(popUpText, "Terms Of Conditions");

		AndroidElement popUpAlert_CloseBtn = driver.findElementById("android:id/button1");
		popUpAlert_CloseBtn.click();

		AndroidElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		checkbox.click();

		// Tap action
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkbox))).perform();

		// AndroidElement popUpAlert =
		// driver.findElementByClassName("android:id/content");

	}

}
