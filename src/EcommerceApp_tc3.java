import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceApp_tc3 extends baseconfiguration {
	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities("nexus");
		TouchAction touch = new TouchAction(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementById("android:id/text1").click();
		//AndroidElement country = driver.findElementByXPath("//*[@text='Antarctica']");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));").click();
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));  
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Shubhamdubey0011");
		driver.hideKeyboard();
		driver.findElementByAndroidUIAutomator("text(\"Female\")").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		//System.out.println(driver.findElementByAndroidUIAutomator("text(\"Products\")").getText());
		//fetch the list of all prducts and scroll and search for required product(child)
		driver.findElementByAndroidUIAutomator
		("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");

		
		//get the list if all the product and verify by searching if product matches with the required product {search & select }
		List<AndroidElement> productnames = driver.findElementsById("com.androidsample.generalstore:id/productName");
		for (AndroidElement androidElement : productnames) {
			if (androidElement.getText().equalsIgnoreCase("Jordan 6 Rings")) {
				System.out.println(" Product selected ::"+androidElement.getText());
				driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
				break;
			}
		}
		
		String shoeName = productnames.get(0).getText();
		System.out.println(shoeName);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Assert.assertEquals(shoeName, driver.findElementById("com.androidsample.generalstore:id/productName").getText());
		
		
		
		

		
		


		
		

	}
}
