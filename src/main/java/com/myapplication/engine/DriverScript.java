package com.myapplication.engine;


import com.myapplication.utilities.Constants;
import com.myapplication.utilities.Log;

import java.io.FileInputStream;
import java.util.Properties;

public class DriverScript {

    public static Properties objectRepo;
    public static String path;

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


}
