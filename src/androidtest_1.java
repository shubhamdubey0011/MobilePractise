import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class androidtest_1 extends baseconfiguration {
	static AndroidDriver<AndroidElement> driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		// Code to check device connected to the machine or not .
		Process p = Runtime.getRuntime().exec("adb devices");
		p.waitFor();
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println("line : " + line);
		}
		test1();
	}

	public static void test1() throws MalformedURLException {
		driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).getText());

		driver.findElement(By.className("android.widget.EditText")).sendKeys("DemoWIFI");

		driver.findElements(By.className("android.widget.Button")).get(1).click();
	}
}
