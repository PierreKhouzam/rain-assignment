package com.myapplication.engine;

import com.myapplication.pages.CenterPage;
import com.myapplication.utilities.Constants;
import com.myapplication.utilities.ExcelUtils;
import com.myapplication.utilities.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    public static AndroidDriver driver;
    public static SoftAssert softAssert = new SoftAssert();
    DesiredCapabilities caps = new DesiredCapabilities();

    public AppiumDriver<?> getDriver() {
        return driver;
    }

    @BeforeClass
    public void setup() throws MalformedURLException {
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app",
                Constants.workingDir + "/apps/Multi-action_Home_Button_base.apk");
        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("fullReset", "true");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        DriverScript.objectRepoLoad();
        ExcelUtils.setExcelFile(Constants.pathTestData + "MyApplicationTCs.xlsx");
    }

    @AfterMethod
    public void resetApp() {
        driver.resetApp();
    }

    @AfterClass
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
