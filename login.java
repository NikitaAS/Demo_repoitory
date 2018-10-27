package LogIn;

import java.awt.Window;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class login {
	
	private static WebDriver driver;
	private static String baseUrl;
	 @Parameters("browser")
	 
	  @BeforeClass
	 
	  // Passing Browser parameter from TestNG xml
	 
	public void beforeTest(String browser)
	{
	 
	  // If the browser is Firefox, then do this
	 
	  if(browser.equalsIgnoreCase("firefox"))
	  {
		  driver = new FirefoxDriver();
	 
	  // If browser is IE, then do this	  
	 
	  }
	  else if (browser.equalsIgnoreCase("ie")) 
	  { 
	 
		  // Here I am setting up the path for my IEDriver
	 
		  System.setProperty("webdriver.ie.driver", "E://NIKITA//IEDriverServer_x64_3.14.0//IEDriverServer.exe");
		  driver = new InternetExplorerDriver();
	  }
	  else if (browser.equalsIgnoreCase("chrome")) 
	  {
		  System.setProperty("webdriver.chrome.driver" ,"E://NIKITA//chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  } 
	/*//@BeforeTest
	public static void preRequisites_login()
	{
		baseUrl = "http://e-procure.net.s3-website.ap-south-1.amazonaws.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}*/
	
	@Test
	public static void login() throws InterruptedException
	{
		
		// Tell Browser to open the URL
		
		baseUrl = "http://e-procure.net.s3-website.ap-south-1.amazonaws.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Scanner Input = new Scanner(System.in);
		Thread.sleep(2000);
		System.out.println("Enter Domain Name:");
		String domain = Input.nextLine();
		System.out.println("Enter Email:");
		String email = Input.nextLine();
		System.out.println("Enter Password:");
		String password = Input.nextLine();
		driver.findElement(By.xpath(".//*[@id='navbarSupportedContent']/form/div/a[1]/button/span")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[1]/div[1]/input")).sendKeys(domain);
		driver.findElement(By.xpath(".//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[1]/div[2]/input")).sendKeys(email);
		
		driver.findElement((By.xpath(".//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[1]/div[3]/input"))).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/button")).click();
		Thread.sleep(1700);
		driver.findElement(By.xpath(".//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div/div[1]/input")).sendKeys("1234");
		driver.findElement(By.xpath(".//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div/div[3]/button[1]")).click();
		Thread.sleep(1000);
		 
	}
	
	
}
