# rain-assignment
> Demo testcases on Multi-action_Home_Button_base.apk (Android) using: java, selenium, appium, testng, extent-report, screenshot-robot, excel-util and others.


**Prerequisites**
- Download and Install JDK 8 or later -> https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html then add the installed JDK’s bin folder location to path
- Download and install node.js -> https://nodejs.org/en/download/current/
- Install Appium -> npm install -g appium
- Download and install Android Studio -> https://developer.android.com/studio then add the installed SDK’s platform-tools folder location to path
- Configure AVD manager and create Android Emulator through Android Studio
- Download and install IntelliJ IDE https://www.jetbrains.com/idea/download


**How to setup**
> Finished installations? let’s clone our shared Automation project
- Open IntelliJ IDE
- Select “Get from Version Control”
- Add the project’s Repo URL https://github.com/PierreKhouzam/rain-assignment.git
- Click on “Clone”
- Once the project is cloned, make sure JDK 1.8 is added to your project’s structure and all Pom file’s dependencies are updated
- Add pom.xml as maven project
- Run maven clean install when its ready (You can let maven skips test while building from maven settings)


**How to run**
> In order to run the existing tests, you need to
Open MyApplicationTest test class and run using TestNG.


**TestScenarios**
- TC - 001 Complete all the steps when launching the app for the first time and navigate to the Dashboard
- TC - 002 Select Action on click under Actions and print all the elements in the radio selection list view
- TC - 003 Scroll down to the bottom and uncheck the show notification checkbox
- TC - 004 Select Vibration Strength under behavior and set the vibration strength to 100
- TC - 005 Select button color under appearance and select violet color

**Notes**
> Project is implemented to do the following
- initiate Appium server Automatically, in case Appium is installed
- Initiate Android Emulator Automatically, in case there is an existing Emulator on the device {Mac-OS}
