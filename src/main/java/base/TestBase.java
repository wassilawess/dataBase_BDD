package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
 public static WebDriver driver;

 //this is constructor! will use it later to inheritate it with login page?
 public TestBase() {
 
 }

 public static void initializeDriver() {

  System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().deleteAllCookies();
  driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  driver.get("https://techfios.com/billing/?ng=admin/");

 }


	  public static void takeScreenshotAtEndOfTest() throws IOException {
	  TakesScreenshot ts = ((TakesScreenshot) driver);
	  File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	  String currentDir = System.getProperty("user.dir");
	  FileUtils.copyFile(sourceFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	 }
}