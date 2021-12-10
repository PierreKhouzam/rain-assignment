package com.myapplication.pages;

import com.myapplication.engine.BasePage;
import io.appium.java_client.AppiumDriver;

import java.util.List;

public class CenterPage extends BasePage {

    public CenterPage(AppiumDriver<?> driver) {
        super(driver);
    }

    public CenterPage touchAnyWhere() {
        waitVisibility("homeScreen");
        click("homeScreen");
        return this;
    }

    public Boolean dashboardIsDisplayed() {
        return isDisplayed("centerIcon");
    }

    public void pressActionOnClick() {
        waitVisibility("actionOnClickBtn");
        click("actionOnClickBtn");
    }


    public List<String> readListOfRadioButtons() {
        List<?> radioButtonsList = getList("radioList");
        return readList(radioButtonsList);
    }

    public CenterPage scrollTillShowNotificationIsVisible() {
        scrollTillVisible("showNotificationLbl");
        return this;
    }

    public void uncheckNotification() {
        waitVisibility("notificationCheckBox");
        click("notificationCheckBox");
    }

    public String getSelectedAttributeValue() {
        return getAttribute("notificationCheckBox", "selected");
    }

    public CenterPage scrollTillVibrationStrengthIsVisible() {
        scrollTillVisible("vibrationStrengthLbl");
        return this;
    }

    public CenterPage pressOnVibrationStrength() {
        waitVisibility("vibrationStrengthBtn");
        click("vibrationStrengthBtn");
        return this;
    }

    public CenterPage setVibrationStrengthTo100() {
        waitVisibility("seekBar");
        moveSeekBar("seekBar", 100);
        return this;
    }

    public CenterPage confirmVibrationStrength() {
        waitVisibility("okBtn");
        click("okBtn");
        return this;
    }

    public String getSeekBarValue() {
        waitVisibility("seekBarValue");
        return getAttribute("seekBarValue", "text");
    }
}
