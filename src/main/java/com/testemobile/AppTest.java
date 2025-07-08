package com.testemobile;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppTest {
    public static void main(String[] args) {
        AndroidDriver driver = null;
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability("appPackage", "com.google.android.contacts"); // Atualizado para Pixel 9
            caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity"); // Atualizado para Pixel 9
            caps.setCapability("noReset", true);

            driver = new AndroidDriver(new URL("http://localhost:4723"), caps);

            Thread.sleep(5000);
            System.out.println("App de Contatos aberto com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}