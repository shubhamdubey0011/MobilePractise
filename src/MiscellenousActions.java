import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.GsmCallActions;

public class MiscellenousActions {
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = baseconfiguration.capabilities("Nexus");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentPackage());
		System.out.println(driver.getAutomationName());
		// driver.rotate(ScreenOrientation.LANDSCAPE);
		// System.out.println(driver.getOrientation());
		// driver.rotate(ScreenOrientation.PORTRAIT);
		// System.out.println(driver.getOrientation());

		System.out.println(driver.currentActivity());
		System.out.println(driver.isDeviceLocked());

		Map<String, Object> caps = driver.getSessionDetails();
		System.out.println(caps);

//toggle wifi		
		//driver.toggleWifi();
		
		driver.makeGsmCall("5551234567", GsmCallActions.CALL);
		
		//String context = driver.getContext();
//		System.out.println("context"+context);
		
		
		Actions action = new Actions(driver);





		//LogEntries logEntries = driver.manage().logs().get("logcat");
		//System.out.println(logEntries);

	}
}
