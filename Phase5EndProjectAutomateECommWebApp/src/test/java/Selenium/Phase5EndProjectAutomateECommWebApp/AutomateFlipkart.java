package Selenium.Phase5EndProjectAutomateECommWebApp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateFlipkart {
	
	private WebDriver wd;
	private JavascriptExecutor js;
	static int i=0;
	
	@Parameters("browser")
	@BeforeClass
	public void init(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			wd=new ChromeDriver();
			i=1;
        }
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			wd=new EdgeDriver();
			i=2;
		}
		
		wd.manage().window().maximize();
		wd.get("https://flipkart.com");
	}
  @Test
  public void PageLoadTest() throws IOException {
		long startTime=System.currentTimeMillis();
		js=(JavascriptExecutor) wd;
		Long pageLoadTime = (Long)js.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		long endTime=System.currentTimeMillis();
		long loadTime=endTime-startTime;
		takeScreenShot(wd,"fk_Home");
		System.out.println("Page load time is: "+pageLoadTime+ "millisecond");
		System.out.println("Page load time is: "+loadTime+ "millisecond");
  }
  
  @Test
  public void testLoadingImgages() throws IOException {
	  WebElement we=wd.findElement(By.name("q"));
	  we.sendKeys("iPhone 13");
	  takeScreenShot(wd,"searching");
	  we.submit();
	  takeScreenShot(wd,"iPhone13Page");
	  
	  //Check if the images are loaded and visible till the screen height only
	  we=wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div/div/img"));
      Assert.assertEquals(isPictureWithInScreen(wd, we),"Image visible within Screen");
      we=wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div/div/a/div[1]/div[1]/div/div/img"));
      Assert.assertEquals(isPictureWithInScreen(wd, we),"Image extends beyond the screen height");  
      
      //Check if the page has a scroll feature
      Boolean VertscrollStatus = (Boolean) js.executeScript("return document. documentElement. scrollHeight>document. documentElement. clientHeight;");
      Assert.assertEquals(VertscrollStatus,(Boolean)true);     
  }
  
  public int findImageBottom(WebElement wef) {
//	  System.out.println(wef.getLocation().y+wef.getSize().height);
	  return wef.getLocation().y+wef.getSize().height;
  }
  public String isPictureWithInScreen(WebDriver wdf,WebElement wef) {
	  long screenHeight = (Long) ((JavascriptExecutor) wdf).executeScript("return window.innerHeight;");
//	  System.out.println(screenHeight);
	  if (findImageBottom(wef)<=screenHeight)return "Image visible within Screen";
	  else return "Image extends beyond the screen height";
  }
  
  @Test
  public void testPageNavigateToBottom() throws InterruptedException, IOException {
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  takeScreenShot(wd,"BottomOfPage");
	  Thread.sleep(1000);
  }
  
  @Test
  public void testLazyLoadingFeatures() throws InterruptedException, IOException {
	  SoftAssert sa=new SoftAssert();
//	  WebElement we=wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[7]/div/div/div/a/div[1]/div[1]/div/div/img"));
//	  sa.assertEquals(we.isDisplayed(), false);
	  WebElement we=wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[7]/div/div/div/a/div[1]/div[1]/div/div/img"));
	  js.executeScript("arguments[0].scrollIntoView();",we);
	  takeScreenShot(wd,"scrollToElement");
	  sa.assertEquals(we.isDisplayed(), true);
	  Thread.sleep(2000);
  }
  @AfterClass
  public void destroy() {
	  if(wd!=null) {
		  wd.quit();
	  }
  }
  public static void takeScreenShot(WebDriver wd,String fileName) throws IOException {
		//take the screenshot and store it as a file format
		File file=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		//copy the screen shot to the specified location
		if(i==1) {
		FileUtils.copyFile(file,new File("D:\\chromeSS\\"+fileName+".png"));
		}
		if(i==2) {
			FileUtils.copyFile(file,new File("D:\\edgeSS\\"+fileName+".png"));
		}
	}
}
