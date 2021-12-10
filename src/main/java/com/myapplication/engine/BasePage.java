package com.myapplication.engine;


import com.myapplication.utilities.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static com.myapplication.engine.DriverScript.objectRepo;


public class BasePage {

    public static AppiumDriver<?> driver;
    WebDriverWait wait;


    //Constructor
    public BasePage(AppiumDriver<?> driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //Wait method
    public void waitVisibility(String object) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(objectRepo.getProperty(object))));
            Log.info("Waiting visibility of element for object: " + object);
        } catch (Exception e) {
            Log.error("Failed to find element for object: " + object + ", While error is: " + e);
        }
    }

    //Click method
    public void click(String object) {
        try {
            driver.findElement(By.id(objectRepo.getProperty(object))).click();
            Log.info("Clicking on element for object: " + object);
        } catch (Exception e) {
            Log.error("Failed to click on element for object: " + object + ", While error is: " + e);
        }
    }

    //Scroll till visible method
    public void scrollTillVisible(String object) {
        try {
            String element = objectRepo.getProperty(object);
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" + ".scrollIntoView(new UiSelector().text(\"" + element + "\").instance(0))"));
            Log.info("Scrolling till element is visible for object: " + object);
        } catch (Exception e) {
            Log.error("Failed to scroll till element is visible for object: " + object + ", While error is: " + e);
        }
    }

    //Get element attribute
    public String getAttribute(String object, String attribute) {
        try {
            String value = driver.findElement(By.id(objectRepo.getProperty(object))).getAttribute(attribute);
            Log.info("Getting " + attribute + " attribute for object: " + object);
            return value;
        } catch (Exception e) {
            Log.error("Failed to get element attribute for object: " + object + ", While error is: " + e);
            return null;
        }

    }

    //Check element is displayed
    public Boolean isDisplayed(String object) {
        try {
            driver.findElement(By.id(objectRepo.getProperty(object))).isDisplayed();
            Log.info("Element is displayed for object: " + object);
            return true;
        } catch (Exception e) {
            Log.error("Element is not displayed for object: " + object);
            return false;
        }
    }

    //Get list of elements method
    public List<?> getList(String object) {
        try {
            //Wait till class is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(objectRepo.getProperty(object))));
            //Get all elements and storing in to List
            List<?> list = driver.findElements(By.className(objectRepo.getProperty(object)));
            Log.info("Getting list of elements for object: " + object);
            return list;
        } catch (Exception e) {
            Log.error("Failed to get list of elements for object: " + object + ", while error is: " + e);
            return null;
        }
    }

    //Read text of array of objects
    public List<String> readList(List<?> list) {
        try {
            List<String> listOfElements = new ArrayList<>();
            for (Object obj : list) {
                WebElement element = (WebElement) obj;
                listOfElements.add(element.getText());
            }
            Log.info("Reading list of elements, list is: " + listOfElements);
            return listOfElements;
        } catch (Exception e) {
            Log.error("Failed to read list of elements, while error is: " + e);
            return null;
        }
    }

    public void moveSeekBar(String object, int percentage) {
        try {
            //Locate SeekBar element
            WebElement seekBar = driver.findElement(By.id(objectRepo.getProperty(object)));
            //Get start point of seekbar.
            int startX = seekBar.getLocation().getX();
            Log.info("Seekbar start point is: " + startX);
            //Get end point of seekbar.
            int endX = startX + seekBar.getSize().getWidth();
            Log.info("Seekbar end point is: " + endX);
            //Get vertical location of seekbar.
            int yAxis = seekBar.getLocation().getY();
            Log.info("Seekbar vertical location is: " + yAxis);
            //Set seekbar move to position.
            int moveToXDirectionAt = (int) (endX * ((float) percentage / 100));
            //Moving seekbar using TouchAction class.
            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point(startX, yAxis)).moveTo(PointOption.point(moveToXDirectionAt, yAxis)).release().perform();
            Log.info("Moving seek bar at " + moveToXDirectionAt + " In X direction for object: " + object);
        } catch (Exception e) {
            Log.error("Failed to move seek bar for object: " + object + ", While error is: " + e);
        }
    }


}


