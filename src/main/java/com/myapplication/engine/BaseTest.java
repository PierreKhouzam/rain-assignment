package com.myapplication.engine;

import com.myapplication.utilities.Constants;
import com.myapplication.utilities.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;



public class BaseTest {
    public static AndroidDriver<?> driver;
    public static SoftAssert softAssert = new SoftAssert();
    DesiredCapabilities caps = new DesiredCapabilities();
    DriverScript driverScript = new DriverScript();

    @BeforeClass
    public void setup(){
        //Set desired capabilities before test class
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app",
                Constants.workingDir + "/apps/Multi-action_Home_Button_base.apk");
        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("fullReset", "true");
        //Detect saved android emulator name and open it
        String myDeviceName = driverScript.detectEmulatorName();
        if (!myDeviceName.isEmpty()) caps.setCapability("avd", myDeviceName);
        driver = new AndroidDriver<>(driverScript.getServer(), caps);
        //Load object repository
        DriverScript.objectRepoLoad();
        //Set Excel file to be use across tests
        ExcelUtils.setExcelFile(Constants.pathTestData + "MyApplicationTCs.xlsx");
    }

    @AfterMethod
    public void resetApp() {
        //Restart app after each test method
        driver.resetApp();
    }

    @AfterClass
    public void tearDown() {
        //Tear down application after test class
        if (null != driver) {
            driver.quit();
        }
    }
}
