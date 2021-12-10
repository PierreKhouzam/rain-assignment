package com.myapplication.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.time.Duration;
import java.util.Base64;


public class VideoRecorder {
    static AndroidDriver driver;

    public static void startRecording(AndroidDriver usedDriver) {

        try {
            driver = usedDriver;
            driver.startRecordingScreen(new AndroidStartScreenRecordingOptions().withVideoSize("1280x720").withTimeLimit(Duration.ofSeconds(200)));
            Log.info("Started recording");
        } catch (Exception e) {
            Log.error("Failed to start recording" + e.getMessage());
        }
    }

    public static void stopRecording(AndroidDriver usedDriver, String fileName) {
        try {
            driver = usedDriver;
            String video = driver.stopRecordingScreen();
            byte[] decode = Base64.getDecoder().decode(video);
            FileUtils.writeByteArrayToFile(new File(Constants.workingDir + "/clips/" + fileName), decode);
            Log.info("Stopped recording and clip is downloaded");
        } catch (Exception e) {
            Log.error("Failed to stop recording" + e.getMessage());
        }
    }
}

