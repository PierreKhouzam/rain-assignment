import com.myapplication.engine.BaseTest;
import com.myapplication.pages.CenterPage;
import com.myapplication.utilities.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({TestListener.class})
public class MyApplicationTest extends BaseTest {

    @Test(priority = 1)
    public void firstTest() {
        ExcelUtils.setExcelFile(Constants.pathTestData + "MyApplicationTCs.xlsx");
        String testCaseName = ExcelUtils.getCellData(1, Constants.colTestCaseName, "TCs");
        String testId = ExcelUtils.getCellData(1, Constants.colTestId, "TCs");
        Log.startTestCase(testCaseName);
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        VideoRecorder.startRecording(driver);
        CenterPage centerPage = new CenterPage(driver);
        centerPage.touchAnyWhere().dashboardIsDisplayed();
        Boolean dashboardIsDisplayed = centerPage.dashboardIsDisplayed();
        try {
            softAssert.assertTrue(dashboardIsDisplayed);
            softAssert.assertAll();
            //Extent and log
        } catch (Exception e) {
            //Extent and log
        }
        ScreenshotRobot.takeScreenShot(driver);
        VideoRecorder.stopRecording(driver, "TC1Clip.mp4");

    }

    @Test(priority = 2)
    public void secondTest() {
        String testCaseName = ExcelUtils.getCellData(2, Constants.colTestCaseName, "TCs");
        String testId = ExcelUtils.getCellData(2, Constants.colTestId, "TCs");
        Log.startTestCase(testCaseName);
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        VideoRecorder.startRecording(driver);
        CenterPage centerPage = new CenterPage(driver);
        centerPage.touchAnyWhere().pressActionOnClick();
        List<String> radioButtonsList = centerPage.readListOfRadioButtons();
        List<String> dataList = ExcelUtils.getAllColumCells(Constants.colRadioButtons, "RadioButtons");
        try {
            softAssert.assertEquals(radioButtonsList, dataList);
            softAssert.assertAll();
            //Extent and log
        } catch (Exception e) {
            //Extent and log
        }
        ScreenshotRobot.takeScreenShot(driver);
        VideoRecorder.stopRecording(driver, "TC2Clip.mp4");

    }

    @Test(priority = 3)
    public void thirdTest() {
        String testCaseName = ExcelUtils.getCellData(3, Constants.colTestCaseName, "TCs");
        String testId = ExcelUtils.getCellData(3, Constants.colTestId, "TCs");
        Log.startTestCase(testCaseName);
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        VideoRecorder.startRecording(driver);
        CenterPage centerPage = new CenterPage(driver);
        centerPage.touchAnyWhere().scrollTillShowNotificationIsVisible().uncheckNotification();
        String selectedAttributeValue = centerPage.getSelectedAttributeValue();
        try {
            softAssert.assertEquals(selectedAttributeValue, "false");
            softAssert.assertAll();
            //Extent and log
        } catch (Exception e) {
            //Extent and log
        }
        ScreenshotRobot.takeScreenShot(driver);
        VideoRecorder.stopRecording(driver, "TC3Clip.mp4");
    }

    @Test(priority = 4)
    public void fourthTest() {
        String testCaseName = ExcelUtils.getCellData(4, Constants.colTestCaseName, "TCs");
        String testId = ExcelUtils.getCellData(4, Constants.colTestId, "TCs");
        Log.startTestCase(testCaseName);
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        VideoRecorder.startRecording(driver);
        CenterPage centerPage = new CenterPage(driver);
        centerPage.touchAnyWhere().scrollTillVibrationStrengthIsVisible().pressOnVibrationStrength().setVibrationStrengthTo100().confirmVibrationStrength();
        String seekBarValue = centerPage.getSeekBarValue();
        try {
            softAssert.assertEquals(seekBarValue, "99");
            softAssert.assertAll();
            ScreenshotRobot.takeScreenShot(driver);
            //Extent and log
        } catch (Exception e) {
            //Extent and log
            ScreenshotRobot.takeScreenShot(driver);
        }
        VideoRecorder.stopRecording(driver, "TC4Clip.mp4");
    }

//    @Test(priority = 5)
//    public void FifthTest() {
//        String testCaseName = ExcelUtils.getCellData(5, Constants.colTestCaseName, "TCs");
//        String testId = ExcelUtils.getCellData(5, Constants.colTestId, "TCs");
//        Log.startTestCase(testCaseName);
//        ExtentTestManager.startTest(testId + ":" + testCaseName);
//        VideoRecorder.startRecording(driver);
//        CenterPage centerPage = new CenterPage(driver);
//        centerPage.touchAnyWhere().scrollTillShowNotificationIsVisible().uncheckNotification();
//        VideoRecorder.stopRecording(driver);
//
//    }


}


