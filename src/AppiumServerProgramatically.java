import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerProgramatically {
	static AppiumDriverLocalService appiumService;

	public static void main(String[] args) throws MalformedURLException {
		setUp();
	}
	
	
	  @BeforeClass
	    public static void startAppiumServer() {
	        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
	        // Use any port, in case the default 4723 is already taken (maybe by another Appium server)
	        serviceBuilder.usingAnyFreePort();
	        // Tell serviceBuilder where node is installed. Or set this path in an environment variable named NODE_PATH
	        serviceBuilder.usingDriverExecutable(new File("/Users/jonahss/.nvm/versions/node/v12.1.0/bin/node.exe"));
	        // Tell serviceBuilder where Appium is installed. Or set this path in an environment variable named APPIUM_PATH
	        serviceBuilder.withAppiumJS(new File("/Users/jonahss/.nvm/versions/node/v12.1.0/bin/appium.js"));
	        // The XCUITest driver requires that a path to the Carthage binary is in the PATH variable. I have this set for my shell, but the Java process does not see it. It can be inserted here.

	        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
	        appiumService.start();
	  }

	public static void setUp() throws MalformedURLException {

		File folder = new File("src");
		File fpath = new File(folder, "original.apk");
		
		System.out.println("apk file location " + fpath.getAbsoluteFile());
		
	
		
		

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
		cap.setCapability(MobileCapabilityType.APP, fpath.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability("noReset", true);
		cap.setCapability("fullReset", false);
		cap.setCapability("autoAcceptAlerts", true);
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("autoDismissAlerts", true);
		cap.setCapability("autoDismissAlerts", true);

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
}
