import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceApp_tc4 extends baseconfiguration {
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
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		Thread.sleep(4000);
		String PriceOne = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		double amount_1 = getamount(PriceOne);
		System.out.println("Price on 1st product" + amount_1);

		String PriceTwo = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
		double amount_2 = getamount(PriceTwo);
		System.out.println("Price on 1st product" + amount_2);

		
		//add price of both the products 
		int count = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sum = 0;
		for (int i = 0; i < count; i++) {
			String amount = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			double totalAmount = getamount(amount);
			sum += totalAmount;
		}
		System.out.println("total of the both the products" + sum);
		
		
		String totalAmountTobePaid = driver.findElementsById("com.androidsample.generalstore:id/totalAmountLbl").get(0)
				.getText().trim();
		double grandTotal = getamount(totalAmountTobePaid);

		System.out.println("Grand Total Amount to be paid ::" + grandTotal);
		Assert.assertEquals(sum, grandTotal);

	}

	private static double getamount(String text) {
		text = text.substring(1);
		double amount = Double.parseDouble(text);
		return amount;

	}
}
