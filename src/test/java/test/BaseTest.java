package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import utils.Action;

public class BaseTest {
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	private static WebDriverWait wait;
	private String browserToLaunch = "";
	private String url="";
	
	/**
	 * This function runs before each Test and launches browser and maximizes the window
	 * @author sandeep
	 * 
	 */

	@BeforeMethod
	public void launchURL() {
		String baseDir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "executables" + File.separator;
		String executablePath;

		Action.getActionClass();
		browserToLaunch = Action.getActionClass().readFromConfigProperties("browser");
		url=Action.getActionClass().readFromConfigProperties("url");
		System.out.println("got the url from datalist.json -->"+url);
				
		if (driver.get() == null) {
			if (browserToLaunch.equalsIgnoreCase("chrome")) {
				executablePath = baseDir + "chromedriver.exe";
				System.out.println(executablePath);
				System.setProperty("webdriver.chrome.driver", executablePath);
				driver.set(new ChromeDriver());
			} else if (browserToLaunch.equalsIgnoreCase("fireFox")) {
				executablePath = baseDir + "geckodriver.exe";
				System.out.println(executablePath);
				System.setProperty("webdriver.gecko.driver", executablePath);
				driver.set(new FirefoxDriver());
			} else if (browserToLaunch.equalsIgnoreCase("ie")) {
				executablePath = baseDir + "IEDriverServer.exe";
				System.out.println(executablePath);
				System.setProperty("webdriver.ie.driver", executablePath);
				driver.set(new InternetExplorerDriver());
			} else if (browserToLaunch.equalsIgnoreCase("edge")) {
				executablePath = baseDir + "msedgedriver.exe";
				System.out.println(executablePath);
				System.setProperty("webdriver.edge.driver", executablePath);
				driver.set(new EdgeDriver());
			}
		}

		if((url.equalsIgnoreCase("") || url==null)) {
			driver.get().get("");
		}else {
			driver.get().get(url);
		}
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("************Browser launched --> " + browserToLaunch + "**************");

	}

	/**
	 * This function runs after each Test and closes all the browsers
	 * @author sandeep
	 * 
	 */

	@AfterMethod
	public void tearDown() {
		System.out.println("************Calling TearDown*************");
			driver.get().quit();
			driver.set(null);
			System.out.println("============Test finished Browser Closed -->" + browserToLaunch + "=========");
	}

	/**
	 * This function runs sets the explicit wait
	 * @author sandeep
	 * @return WebDriverWait
	 * 
	 */
	public static WebDriverWait explicitWait(int waitTimeInSeconds) {
		wait = new WebDriverWait(driver.get(), waitTimeInSeconds);
		return wait;

	}
	
	/**
	 * This function runs sets the explicit wait
	 * @author sandeep
	 * @return WebDriverWait
	 * 
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}

}
