import com.myapplication.engine.BaseTest;
import com.myapplication.pages.CenterPage;
import com.myapplication.utilities.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({TestListener.class})
public class MyApplicationTest extends BaseTest {

    @Test(priority = 1)
    public void firstTest() {
        String testCaseName = ExcelUtils.getCellData(1, Constants.colTestCaseName, "TCs");
        String testId = ExcelUtils.getCellData(1, Constants.colTestId, "TCs");
        Log.startTestCase(testCaseName);
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        CenterPage centerPage = new CenterPage();
        centerPage.touchAnyWhere();
        Boolean dashboardIsDisplayed = centerPage.dashboardIsDisplayed();
        softAssert.assertTrue(dashboardIsDisplayed, "Validate dashboard is displayed -->");
        softAssert.assertAll();
        //Report to extent in case assertion passed
        ExtentTestManager.getTest().log(LogStatus.PASS, "Dashboard is displayed as expected");
    }

    @Test(priority = 2)
    public void secondTest() {
        String testCaseName = ExcelUtils.getCellData(2, Constants.colTestCaseName, "TCs");
        String testId = ExcelUtils.getCellData(2, Constants.colTestId, "TCs");
        Log.startTestCase(testCaseName);
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        CenterPage centerPage = new CenterPage();
        centerPage.touchAnyWhere().pressActionOnClick();
        List<String> radioButtonsList = centerPage.readListOfRadioButtons();
        List<String> dataList = ExcelUtils.getAllColumCells(Constants.colRadioButtons, "RadioButtons");
        softAssert.assertEquals(radioButtonsList, dataList, "Validate radio buttons list matching data list -->");
        softAssert.assertAll();
        //Report to extent in case assertion passed
        ExtentTestManager.getTest().log(LogStatus.PASS, "Radio button list is matching data list as expected");

    }

    @Test(priority = 3)
    public void thirdTest() {
        String testCaseName = ExcelUtils.getCellData(3, Constants.colTestCaseName, "TCs");
        String testId = ExcelUtils.getCellData(3, Constants.colTestId, "TCs");
        Log.startTestCase(testCaseName);
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        CenterPage centerPage = new CenterPage();
        centerPage.touchAnyWhere().scrollTillShowNotificationIsVisible().uncheckNotification();
        String selectedAttributeValue = centerPage.getSelectedAttributeValue();
        softAssert.assertEquals(selectedAttributeValue, "false", "Validate notification check box 'selected' attribute is set to false -->");
        softAssert.assertAll();
        //Report to extent in case assertion passed
        ExtentTestManager.getTest().log(LogStatus.PASS, "Notification check box is unselected as expected");
    }

    @Test(priority = 4)
    public void fourthTest() {
        String testCaseName = ExcelUtils.getCellData(4, Constants.colTestCaseName, "TCs");
        String testId = ExcelUtils.getCellData(4, Constants.colTestId, "TCs");
        Log.startTestCase(testCaseName);
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        CenterPage centerPage = new CenterPage();
        centerPage.touchAnyWhere().scrollTillVibrationStrengthIsVisible().pressOnVibrationStrength().setVibrationStrengthTo100().confirmVibrationStrength();
        String seekBarValue = centerPage.getSeekBarValue();
        softAssert.assertEquals(seekBarValue, "100", "Validate seek bar value is 100 -->");
        softAssert.assertAll();
        //Report to extent in case assertion passed
        ExtentTestManager.getTest().log(LogStatus.PASS, "Seek bar value is 100 as expected");
    }

    @Test(priority = 5)
    public void fifthTest() {
        //Image color is not supported for native apps by appium!
        //Accessibility ID is required to identify colors
        //Violet color element existence assertion is implemented instead
        String testCaseName = ExcelUtils.getCellData(5, Constants.colTestCaseName, "TCs");
        String testId = ExcelUtils.getCellData(5, Constants.colTestId, "TCs");
        Log.startTestCase(testCaseName);
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        CenterPage centerPage = new CenterPage();
        centerPage.touchAnyWhere().pressOnButtonColor().setVioletColor();
        Boolean violetColorIsDisplayed = centerPage.violetColorIsDisplayed();
        softAssert.assertTrue(violetColorIsDisplayed, "Validate Violet color is selected -->");
        softAssert.assertAll();
        //Report to extent in case assertion passed
        ExtentTestManager.getTest().log(LogStatus.PASS, "Button color is violet as expected");
    }
}


