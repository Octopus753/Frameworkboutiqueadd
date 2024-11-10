package pageobjectstestcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class base {
	protected static WebDriver driver;
	private static WebDriverWait wait;
	   //protected Actions actions;
	   
		 public static WebDriver getDriver() throws IOException {
	 		//use java properties  to implement any class or method globally
	 		
	 	        ChromeOptions options = new ChromeOptions();
	 	        options.addArguments("disable-notifications");
	 	        driver = new ChromeDriver(options);
	 	 wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	 		// Add other browser initializations if needed
	         driver.manage().window().maximize();
	      //   wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	        // actions = new Actions(driver);
	 		return driver;
	 	}
	 	

		//174. How to Create Screenshot Utility in Base Test class for catching Failed tests
	    public String takeScreenshot(String testcase) {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    String screenshotPath = "D:\\Automation Practice\\" + testcase + ".jpeg";
			try {
		        FileUtils.copyFile(src, new File(screenshotPath));
	            System.out.println("ScreenShot taken succesfully!");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return screenshotPath;
	    }
	    
	    //176. Integrating extent reports & 175. what are extent reports in section 22
		public static ExtentReports config() {
			String reportDirectory = "D:\\java\\Framework1boutique\\reports";
	        File reportDir = new File(reportDirectory);
			
			// Create the directory if it doesn't exist
	        if (!reportDir.exists()) {
	            reportDir.mkdirs(); // Create the directory and any necessary parent directories
	        }

	        String file = reportDirectory + "\\index.html"; // Set the report file path
			ExtentSparkReporter report=new ExtentSparkReporter(file);
			report.config().setReportName("Results");
			report.config().setDocumentTitle("Results");
			
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(report);
			extent.setSystemInfo("Tester", "Tester");
			return extent;
		}
		
		public WebElement waitforElementtoAppear(WebElement locator) {
			return wait.until(ExpectedConditions.visibilityOf(locator));
		}
	    
	    public  void click(WebElement locator) {
	    	waitforElementtoAppear(locator);
	    	 locator.click();
	    }
	    
	    public void sendKeys(WebElement locator, String keysToSend) {
	        waitforElementtoAppear(locator);
	        locator.clear();  // Clear the field before sending keys
	        locator.sendKeys(keysToSend);
	    }
	    
	    public String getElementText(WebElement locator) {
	        WebElement element = waitforElementtoAppear(locator);
	        return element.getText();
	    }

	  public void scrollToElement(WebElement locator) {
	        WebElement element = waitforElementtoAppear(locator);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    }
}
