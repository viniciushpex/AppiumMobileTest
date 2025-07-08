package com.testemobile.support;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver iniciarDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability("appPackage", "com.google.android.contacts");
            
            // Atenção: alterar esta activity para a correta no seu emulador
            caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
            
            caps.setCapability("noReset", true);

            // Adicionando caminho correto para o servidor Appium
            driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
        }
        return driver;
    }

    public static void encerrarDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
