package TestBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass(groups={"Regression","Master","Sanity"})
	@Parameters("browser")
	public void setup(@Optional("FireFox") String br)
	{
		
		rb=ResourceBundle.getBundle("config");  // time 
		
		
		logger =LogManager.getLogger(this.getClass());  //To create the Log file
		
//		ChromeOptions options =new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});   // To hide the "Your browser using automation application" message in browser    
//		
//		WebDriverManager.chromedriver().setup();
		
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		
		
		driver.manage().deleteAllCookies();
		
		
		driver.get(rb.getString("appurl"));
		//https://demo.opencart.com/index.php?route=common/home&language=en-gb
		
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups={"Regression","Master","Sanity"})
	public void shutdownbrowser()
	{
		driver.quit();
	}
	
	
	public String randomString() {
		
		String generatedString =RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
		
	}
	
	public String randomGmail()
	{
		String generatedGmail = RandomStringUtils.randomAlphanumeric(7);
		return(generatedGmail+"@gmail.com");
	}
	
	public String randomAlphaNumeric()
	{
		String st = RandomStringUtils.randomAlphabetic(4);
		String num =RandomStringUtils.randomNumeric(3);
		
		return(st+"@"+num);
		
	}

	public String captureScreen(String tname){
		
		String timeStamp =new SimpleDateFormat("yyyyMmddhhmmss").format(new Date());
		TakesScreenshot takescreenshot =(TakesScreenshot) driver;
		File source =takescreenshot.getScreenshotAs(OutputType.FILE);
		String designation =System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		
		try {
			FileUtils.copyFile(source, new File(designation));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return designation;
	}
	
	
	
	}

