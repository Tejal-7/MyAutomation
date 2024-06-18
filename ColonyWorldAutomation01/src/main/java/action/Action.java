package action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class Action {
	ExtentReports extent;
	static ExtentTest test;
	public static WebDriver driver;
	ExtentManager manager;
	ListenersClass ls;
Random random ;

	public static void implicitWait(WebDriver driver, int timeOut) {

		driver.manage().timeouts().implicitlyWait(timeOut,TimeUnit.SECONDS);
	}

	public void explicitWait(WebDriver driver, WebElement element, Duration timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	public static boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/ScreenShots/" + filename + "_" + dateName + ".png";

		Log.info("This is the Path of the Screenshhot : " + destination);

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}

		/* This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename
				+ "_" + dateName + ".png";*/
		return destination;

		// return newImageString;

	}
	public static boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);

			Log.info("Entered text........... :" + text);
			flag = true;
		} catch (Exception e) {
			Log.info("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				Log.info("Successfully entered value");
			} else {
				Log.info("Unable to enter value");
			}

		}
		return flag;
	}
	
	public static boolean JSClick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;

		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				Log.info("Click Action is performed");
			} else if (!flag) {
				Log.info("Click Action is not performed");
			}
		}
		return flag;
	}
	/*public String RandomStartDate() {
		// Create an instance of the Random class
	random = new Random();
		// Define a start date
		Calendar startDate = new GregorianCalendar(2024, Calendar.MAY, 20);
		// Calculate the difference in milliseconds between the start and end dates
		long startMillis = startDate.getTimeInMillis();
		// Generate a random number between 0 and the number of days in the range
		long randomMillis = startMillis
				+ (long) (random.nextDouble() * ((endDate.getTimeInMillis() - startMillis) + 1));
		// Create a Calendar instance with the random date
		Calendar randomDate = new GregorianCalendar();
		randomDate.setTimeInMillis(randomMillis);
		// Extract year, month, and day from the random date
		int year = randomDate.get(Calendar.YEAR);
		int month = randomDate.get(Calendar.MONTH) + 1; // Month is 0-based, so add 1
		int day = randomDate.get(Calendar.DAY_OF_MONTH);
		// Format the date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = String.format("%02d-%02d-%04d", day, month, year);
		return formattedDate;
	}
*/







}
