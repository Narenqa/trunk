package com.discovery.ui_tests;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestReporting
{
  private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
  private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
  private static final SimpleDateFormat DATE_FORMAT_NOW = new SimpleDateFormat("yyyyMMddHHmmss");
  private static List<String> testCaseDescriptionList = new ArrayList();
  private static List<String> testCaseStartTimeList = new ArrayList();
  private static List<String> testCaseEndTimeList = new ArrayList();
  private static List<String> testCaseElapsedTimeList = new ArrayList();
  private static List<String> testCaseStatusList = new ArrayList();
  private static List<String> snapShotPathList = new ArrayList();
  public static long testCaseStartTime;
  public static long testCaseStopTime;
  public static long testCaseElapsedTime;
  public static String strCaseStartTime;
  public static String strCaseStopTime;
  private static List<String> testCaseNameList = new ArrayList();
  private static List<String> testCaseFileList = new ArrayList();
  private static List<String> stepList = new ArrayList();
  private static List<String> stepStatusList = new ArrayList();
  public static String suiteName;
  public static String TestName;
  private static Map<String, String> statusMap = new HashMap();
  public static File suiteFolder;
  private static File snapShotFolder;
  private static File testFolder;
  private static File suiteFile;
  private static String suiteFilePath;
  private static String testCaseReportsFolder = "Test";
  private static String snapShotsFolder = "Snapshots";
  private static File DataFolder;
  private static String testDataFolder = "TestData";
  private static long testStepTempTime;
  private static List<String> testStepElapsedTimeList = new ArrayList();


  private static void calculateElapsedTime()
  {
    testCaseElapsedTime = testCaseStopTime - testCaseStartTime;
    int i = 0;
    int j = (int)(testCaseElapsedTime / 1000L);
    String str = String.valueOf(j);
    if (j >= 60)
    {
      i = j / 60;
      j %= 60;
      str = String.valueOf(j);
    }
    if (j <= 9)
      str = "0" + String.valueOf(j);
    testCaseElapsedTimeList.add(String.valueOf(i) + ":" + str);
  }


  public static void captureSnapShot(WebDriver paramWebDriver)
  {
    try
    {
      File localFile = (File)((TakesScreenshot)paramWebDriver).getScreenshotAs(OutputType.FILE);
      String str1 = "SnapShot_" + DATE_FORMAT_NOW.format(new Date()) + ".png";
      String str2 = snapShotFolder + "/" + str1;
      FileUtils.copyFile(localFile, new File(str2));
      snapShotPathList.add(str1);

    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }



}
