package com.myapplication.engine;

import com.myapplication.utilities.Constants;
import com.myapplication.utilities.Log;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.Properties;


public class DriverScript {

    public static Properties objectRepo;
    public static String path;
    static Runtime rt = Runtime.getRuntime();
    public final AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
    public AppiumDriverLocalService server;
    public int port;

    //Constructor
    public DriverScript() {
        this.port = getAvailablePort();
        this.serviceBuilder.usingPort(port);
        this.server = AppiumDriverLocalService.buildService(serviceBuilder);
        this.server.start();
        this.server.clearOutPutStreams();
    }

    //Method to get available port to use later
    public static int getAvailablePort() {
        int port = 4723;

        try {
            ServerSocket serverSocket = new ServerSocket(0);
            port = serverSocket.getLocalPort();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return port;
    }

    //Method to load object repository
    public static void objectRepoLoad() {
        try {
            path = Constants.objectRepoPath;
            FileInputStream fs = new FileInputStream(path);
            objectRepo = new Properties(System.getProperties());
            objectRepo.load(fs);
            Log.info("Object repo loaded");
        } catch (Exception e) {
            Log.error("Couldn't load object Repo " + e.getMessage());
        }
    }

    //Method to get appium driver local server
    public AppiumDriverLocalService getServer() {
        return this.server;
    }


    //Method to detect if any emulator is currently opened (adb devices)
    public Boolean detectAdbDevices() {
        try {
            Process pr1 = rt.exec("adb devices");
            BufferedReader in = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
            String line;
            String result = "";
            while ((line = in.readLine()) != null) {
                if (line.equals("")) break;
                result = line;
            }
            return !result.isEmpty() && !result.equals("List of devices attached");
        } catch (Exception e) {
            return false;
        }
    }

    //Method to detect saved emulator to open it later (emulator -list-avds)
    public String detectEmulatorName() {

        try {
            if (!detectAdbDevices()) {
                Process pr2 = rt.exec("emulator -list-avds");
                BufferedReader in = new BufferedReader(new InputStreamReader(pr2.getInputStream()));
                StringBuilder result = new StringBuilder(80);
                String line = in.readLine();
                result.append(line);
                return result.toString();
            }
            return "";
        } catch (Exception e) {
            return "";
        }

    }
}


