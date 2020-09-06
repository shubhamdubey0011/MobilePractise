import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserChromeTest {
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = baseconfigurationCHROME.capabilities("emulator");
				driver.get("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
	}

}
