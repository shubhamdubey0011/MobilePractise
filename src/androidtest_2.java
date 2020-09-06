import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class androidtest_2 extends baseconfiguration {
	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = baseconfiguration2.capabilities("emulator");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).getText());

		driver.findElement(By.className("android.widget.EditText")).sendKeys("DemoWIFI");

		driver.findElements(By.className("android.widget.Button")).get(1).click();

	}
}
