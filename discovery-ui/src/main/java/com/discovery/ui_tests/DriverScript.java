package com.discovery.ui_tests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.discovery.constants.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverScript {
	public static WebDriver driver = null;
	public static Capabilities capabilities = null;
	public static Properties CONFIG = null;

	public static WebDriver getDriver() throws AutomationException {
		if (CONFIG == null) {
			CONFIG = new Properties();
			try {
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir")
								+ Constants.CONFIG_PROPERTIES);
				CONFIG.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String browser = CONFIG.getProperty("browser");
		String os = CONFIG.getProperty("os");
		if (driver == null) {

			try {

				if (browser.equals("firefox")) {
					/*ProfilesIni profile = new ProfilesIni();
					FirefoxProfile fireFox = profile.getProfile("selenium");
					driver = new FirefoxDriver(fireFox);*/

				} else if (browser.equals("chrome")) {

					if(os.equals("mac")){
						System.setProperty("webdriver.chrome.driver",
								Constants.chromeMacDriver);
					}else {
						System.setProperty("webdriver.chrome.driver",
								Constants.chromeWinDriver);
					}

					return driver = new ChromeDriver();

				} else {
					throw new AutomationException(
							"Invalid Browser; Only IE, Firefox & Chrome supported",
							false);
				}
			} catch (RuntimeException localRuntimeException) {
				localRuntimeException.printStackTrace();
				throw new AutomationException("Unable to locate the driver",
						false);
			}
		}

		return driver;
	}

	public static void goToURL(String paramString) throws AutomationException {
		driver.get(paramString);
		driver.manage().timeouts().implicitlyWait(180L, TimeUnit.SECONDS);
		Dimension d = new Dimension(1420,1080);
		//Resize current window to the set dimension
		driver.manage().window().setSize(d);

	}

	public static JavascriptExecutor getJavascriptExecutor() {
		JavascriptExecutor js = null;
		if (getDriver() instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) getDriver();
		}
		return js;
	}

	public void scrollToBottom() {
		JavascriptExecutor js = getJavascriptExecutor();
		String script = "window.scrollTo(0, document.body.scrollHeight)";
		js.executeScript(script);
	}

	public void scrollDownPage() {
		JavascriptExecutor js = getJavascriptExecutor();
		String script = "window.scrollTo(0, 2000)";
		js.executeScript(script);
	}

	public static boolean isPageLoaded() {
		boolean pageLoad = false;
		JavascriptExecutor js = getJavascriptExecutor();
		String pageState = (String) js.executeScript("return document.readyState;");
		if (pageState.equals("complete")) {
			pageLoad = true;
		}
		return pageLoad;
	}

	public static void waitForPageToLoad() throws AutomationException {

		RemoteWebElement oldBody = (RemoteWebElement) driver.findElement(By.xpath("//body"));
		try {
			new WebDriverWait(driver, 500).until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					RemoteWebElement newBody = (RemoteWebElement) driver.findElement(By.xpath("//body"));
					return isPageLoaded() && !oldBody.getId().equals(newBody.getId());
				}
			});
		} catch (Exception e) {
			throw new TimeoutException();
		}
	}

	public static void closeBrowser() {
		driver.quit();
		driver = null;
	}

	public void switchToParentWindow() {
		try {
			String[] windowHandles = getDriver().getWindowHandles().toArray(new String[0]);
			getDriver().switchTo().window(windowHandles[0]);
		} catch (NoSuchWindowException e) {
			System.out.println("Unable to perform switch to the first window due to " + e.getMessage());

		}
	}

	public void refreshAndWait()  {
		getDriver().navigate().refresh();
	}

	public void switchToLastWindow(boolean refresh) {
		String[] windowHandles = getDriver().getWindowHandles().toArray(new String[0]);
		getDriver().switchTo().window(windowHandles[windowHandles.length - 1]);
		if (refresh) {
			refreshAndWait();
		}
	}

	public void openLinkInNewWindow(String link) {
		JavascriptExecutor js = getJavascriptExecutor();
		String jsScript = String.format("window.open('%s')", link);
		js.executeScript(jsScript);
		switchToLastWindow(false);
	}


}
