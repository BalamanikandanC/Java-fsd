package Selenium.Phase5EndProjectAutomateECommWebApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	//register the webdriver =>browser vendor 
		WebDriverManager.chromedriver().setup();
		//creating an object to the object
		WebDriver wd=new ChromeDriver();
		//maximize the browser
		wd.manage().window().maximize();

		//webpage timebound 

		  //  wd.manage().timeouts().pageLoadTimeout(7000,TimeUnit.MILLISECONDS);

		//go to browser and open this url 
		wd.get("https://flipkart.com/");
		Thread.sleep(1000);
		wd.findElement(By.name("q")).sendKeys("iPhone 13");
		Thread.sleep(1000);
		wd.manage().timeouts().pageLoadTimeout(7000,TimeUnit.MILLISECONDS);
		wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/button")).click();
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor) wd;
		
		Boolean VertscrollStatus = (Boolean) js.executeScript("return document. documentElement. scrollHeight>document. documentElement. clientHeight;");
		//scroll down last of the page 
		if(VertscrollStatus) {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("has scroll");
		}
		else {
			System.out.println("no scroll");
		}
    }
}
