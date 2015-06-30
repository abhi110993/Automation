package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.Wdm;

public class BasicComplete{
	
static WebDriver wd=new FirefoxDriver();

@BeforeClass
public void setUP() {
	wd.get("http://10.0.1.86/tatoc/basic/grid/gate");
	wd.manage().window().maximize();
}
	@Test
	public void m1() throws InterruptedException {

	Thread.sleep(3000);
	wd.findElement(By.xpath("//div[@onclick='passthru();']")).click();
	}
	@Test
	public void m2() throws InterruptedException {
	Thread.sleep(3000);
wd.switchTo().frame(wd.findElement(By.id("main")));
	
	while(true){
		Thread.sleep(2000);
		wd.switchTo().defaultContent();
		wd.switchTo().frame(wd.findElement(By.id("main")));
		String d=wd.findElement(By.id("answer")).getAttribute("class");
			
		wd.findElement(By.xpath("//a[@onclick='reloadChildFrame();']")).click();

		//wd.switchTo().defaultContent();
	wd.switchTo().frame(wd.findElement(By.id("child")));
	
	String e=wd.findElement(By.id("answer")).getAttribute("class");
		if(d.equals(e)){
		break;
	}
	}
	wd.switchTo().defaultContent();
	wd.switchTo().frame(wd.findElement(By.id("main")));
	wd.findElement(By.xpath("//a[@onclick='gonext();']")).click();
	}
	@Test
	public void m3() throws InterruptedException {

		WebElement From = wd.findElement(By.xpath("//div[@id='dragbox' and @class='ui-draggable']"));
	    WebElement To = wd.findElement(By.xpath("//div[@id='dropbox']"));
	    
	    Actions builder = new Actions(wd);
	    org.openqa.selenium.interactions.Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
	    dragAndDrop.perform();
	    wd.findElement(By.xpath("//a[@onclick='gonext();']")).click();

	}
	@Test
	public void m4() throws InterruptedException {

		String parentHandle = wd.getWindowHandle();
		wd.findElement(By.xpath("//a[@onclick='launchwindow();']")).click();
		Thread.sleep(1000);
		for (String winHandle : wd.getWindowHandles()) {
			wd.switchTo().window(winHandle);
		}
		wd.findElement(By.xpath("//input[@id='name']")).sendKeys("abc");
		Thread.sleep(1000);
		wd.findElement(By.xpath("//input[@id='submit' and @value='Submit']")).click();
		
		wd.switchTo().window(parentHandle);
		wd.findElement(By.xpath("//a[@onclick='gonext();']")).click();
	}
	@Test
	public void m5() throws InterruptedException {
		wd.findElement(By.xpath("//a[@onclick='generateToken();']")).click();
		String b= wd.findElement(By.xpath("//span[@id='token']")).getText();
		String c=b.substring(7,b.length());
		System.out.println(c); 
		
		Cookie coo	= new Cookie("Token",c);
		wd.manage().addCookie(coo);	
		wd.findElement(By.xpath("//a[@onclick='gonext();']")).click();
	}	
	@AfterSuite
	public void close(){
		wd.close();
	}
	
	
}

