import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class baseconfiguration {

	public static AndroidDriver<AndroidElement> capabilities(String DeviceType) throws MalformedURLException {

		File folder = new File("src/test");
		File fpath = new File(folder, "original.apk");

		System.out.println("apk file location " + fpath.getAbsoluteFile());
		DesiredCapabilities cap = new DesiredCapabilities();
		if (DeviceType.equalsIgnoreCase("realDevice")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		} else
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability(MobileCapabilityType.APP, fpath.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability("noReset", false);
		cap.setCapability("fullReset", true);
		cap.setCapability("autoAcceptAlerts", true);
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("autoDismissAlerts", true);
		cap.setCapability("autoDismissAlerts", true);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		try {
			driver.switchTo().alert().accept();
			;
		} // try
		catch (NoAlertPresentException Ex) {
		} // catch
			// driver.launchApp();
		return driver;

	}
}
